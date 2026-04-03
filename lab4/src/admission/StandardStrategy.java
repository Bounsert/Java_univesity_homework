package admission;

import java.util.Map;

public class StandardStrategy implements CalculationStrategy {
    @Override
    public double calculateTotalScore(Map<String, Integer> grades) {
        return grades.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}