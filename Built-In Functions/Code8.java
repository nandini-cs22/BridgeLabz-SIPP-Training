import java.util.Scanner;

class FibonacciGenerator
{
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();

        generateFibonacci(terms);
    	}

    static void generateFibonacci(int n)
	{
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
