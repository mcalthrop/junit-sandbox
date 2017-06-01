public class Factorial {
    private int start = 0;

    private int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorials are defined only on non-negative integers.");
        }

        int result = n;

        if (result > 1) {
            result = n * factorial(n - 1);
        }

        return result;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int calculate() {
        return factorial(start);
    }
}
