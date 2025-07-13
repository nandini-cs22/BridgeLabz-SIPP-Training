public class Main {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] tests = {10, 30, 50};

        for (int n : tests) {
            System.out.println("Fibonacci(" + n + ")");

            if (n <= 30) {
                long start = System.currentTimeMillis();
                int resRec = fibonacciRecursive(n);
                long timeRec = System.currentTimeMillis() - start;
                System.out.println("Recursive: " + timeRec + " ms (Result: " + resRec + ")");
            } else {
                System.out.println("Recursive: Skipped (Too slow)");
            }

            long start = System.nanoTime();
            int resItr = fibonacciIterative(n);
            long timeItr = System.nanoTime() - start;
            System.out.println("Iterative: " + (timeItr / 1e6) + " ms (Result: " + resItr + ")\n");
        }
    }
}
