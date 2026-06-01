import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // --- 3 Test cases chuẩn xác (Sẽ Passed) ---
    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    // --- 2 Test cases cố tình làm sai ---
    //@Test
    void testDivideFail() {
        assertEquals(5, calculator.divide(6, 3));
    }

    //@Test
    void testAddFail() {
        assertEquals(10, calculator.add(2, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
    }
    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "10, 5, 15",
            "-2, 2, 0"
    })
    void testAddParameterized(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }
}
