package admission;

import java.util.Map;

public interface CalculationStrategy {
    double calculateTotalScore(Map<String, Integer> grades);
}