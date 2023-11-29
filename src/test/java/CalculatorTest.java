import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.example.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Main calculator;

    @Before
    public void setup() {
        calculator = new Main();
    }

    @Test
    public void test_add_positive() {
        double a = 1;
        double b = 2;
        double expectedResult = 3;
        Assert.assertEquals(expectedResult, calculator.add(a, b), 0.001);
    }
    
    @Test
    public void test_add_negative() {
        double a = 1;
        double b = 2;
        double expectedResult = 0;
        Assert.assertNotEquals(expectedResult, calculator.add(a, b), 0.001);
    }

    @Test
    public void test_multiply() {
        double a = 1;
        double b = 2;
        double expectedResult = 2;
        Assert.assertEquals(expectedResult, calculator.multiply(a, b), 0.001);
    }

    @Test
    public void test_divide() {
        double result = calculator.divide(10.0, 2.0);
        assertEquals(5.0, result, 0.0001);

        assertThrows(ArithmeticException.class, () -> calculator.divide(10.0, 0.0));
    }
}
