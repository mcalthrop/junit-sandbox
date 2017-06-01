public class Factorial {
    private int start = 0;

    private int factorial(int n) {
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
