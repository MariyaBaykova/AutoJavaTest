import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaCalculatorTest {


    @ParameterizedTest
    @DisplayName("Позитивный тест для проверки вычисляемой площади")
    @CsvSource({"5, 8, 10, 19.81003533565753"})
    public void positiveTriangleAreaCalculationTest(int a, int b, int c, double expected) {
        assertDoesNotThrow(() -> assertEquals(expected, TriangleAreaCalculator.calculateArea(a, b, c)));
    }


    @ParameterizedTest
    @DisplayName("Негативный тест с одной из сторон равной нулю")
    @CsvSource({"5, 0, 10"})
    public void oneSideIsZeroTest(int a, int b, int c) {
        assertThrows(IncorrectSideSizeException.class, () -> TriangleAreaCalculator.calculateArea(a,b,c));
    }

    @ParameterizedTest
    @DisplayName("Негативный тест с одной из сторон имеющей отрицательный размер")
    @CsvSource({"5, 8, -10"})
    public void oneSideIsNegativeTest(int a, int b, int c) {
        assertThrows(IncorrectSideSizeException.class, () -> TriangleAreaCalculator.calculateArea(a,b,c));
    }


    @ParameterizedTest
    @DisplayName("Негативный тест с размерами сторон, при которых треугольник не может существовать")
    @CsvSource({"5, 8, 100"})
    public void notExistTriangleTest(int a, int b, int c) {
        assertThrows(NotExistsException.class, () -> TriangleAreaCalculator.calculateArea(a,b,c));
    }
}
