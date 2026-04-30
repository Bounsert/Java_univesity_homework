<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Приймальна комісія</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9;}
        h1, h2 { color: #333; }
        .container { display: flex; gap: 40px; }
        .form-section, .table-section { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        input, select, button { display: block; margin-bottom: 10px; padding: 8px; width: 100%; max-width: 300px;}
        button { background-color: #28a745; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #218838; }
        .process-btn { background-color: #007bff; }
        .process-btn:hover { background-color: #0056b3; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>

<h1>Система "Приймальна комісія"</h1>

<div class="container">
    <div class="form-section">
        <h2>Реєстрація абітурієнта</h2>
        <form action="/register" method="post">
            <label>ПІБ абітурієнта:</label>
            <input type="text" name="fullName" required>

            <label>Факультет:</label>
            <select name="facultyId" required>
                <#list faculties as faculty>
                    <option value="${faculty.id?c}">${faculty.name} (Бюджет: ${faculty.budgetPlaces}, Контракт: ${faculty.contractPlaces})</option>
                </#list>
            </select>

            <label>Бал з математики:</label>
            <input type="number" name="mathGrade" min="100" max="200" required>

            <label>Бал з української мови:</label>
            <input type="number" name="ukrainianGrade" min="100" max="200" required>

            <label>Бал з англійської мови:</label>
            <input type="number" name="englishGrade" min="100" max="200" required>

            <button type="submit">Подати заяву</button>
        </form>

        <hr>

        <h2>Підвести підсумки</h2>
        <form action="/process" method="post">
            <label>Оберіть факультет для зарахування:</label>
            <select name="facultyId" required>
                <#list faculties as faculty>
                    <option value="${faculty.id?c}">${faculty.name}</option>
                </#list>
            </select>
            <button type="submit" class="process-btn">Сформувати відомість</button>
        </form>
    </div>

    <div class="table-section">
        <h2>Відомість абітурієнтів</h2>
        <table>
            <tr>
                <th>ПІБ</th>
                <th>Факультет</th>
                <th>Сума балів</th>
                <th>Статус</th>
            </tr>
            <#list applicants as applicant>
            <tr>
                <td>${applicant.fullName}</td>
                <td>${applicant.faculty.name}</td>
                <td>${applicant.totalScore}</td>
                <td><strong>${applicant.admissionStatus}</strong></td>
            </tr>
            </#list>
        </table>
    </div>
</div>

</body>
</html>