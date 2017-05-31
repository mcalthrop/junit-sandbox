import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void evaluatesExpressionWithOneNumber() {
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("99");
        assertEquals(99, sum);
    }
    @Test
    public void evaluatesExpressionWithThreeNumbers() {
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("1+2+3");
        assertEquals(6, sum);
    }
}
