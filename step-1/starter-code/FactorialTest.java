import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FactorialTest {
    @Test
    public void calculate_default() {
        Factorial factorial = new Factorial();
        int expectedResult = 0;
        int actualResult = factorial.calculate();

        assertEquals(expectedResult, actualResult);
    }
}
