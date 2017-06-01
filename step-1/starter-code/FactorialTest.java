import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FactorialTest {
    private Factorial factorial;

    @Before
    public void setUp() {
        factorial = new Factorial();
    }

    @Test
    public void calculate_default() {
        int expectedResult = 0;
        int actualResult = factorial.calculate();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculate_setStart_1() {
        int testStartValue = 1;
        int expectedResult = 1;

        factorial.setStart(testStartValue);
        assertEquals(expectedResult, factorial.calculate());
    }
}
