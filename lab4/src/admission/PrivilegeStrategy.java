package admission;

import java.util.Map;

public class PrivilegeStrategy implements CalculationStrategy {
    @Override
    public double calculateTotalScore(Map<String, Integer> grades) {
        double baseSum = grades.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        return baseSum * 1.10;
    }
}