import java.util.Scanner;

class FactorTasks
{
	public static int[] findFactors(int num)
	{
        int count = 0;
        for (int i = 1; i <= num; i++)
            if (num % i == 0) count++;

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++)
            if (num % i == 0) factors[index++] = i;

        return factors;
    	}

    public static int findGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int i = 1; i < factors.length; i++)
            if (factors[i] > max) max = factors[i];
        return max;
    }

    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int val : factors)
            sum += val;
        return sum;
    }

    public static int findProductOfFactors(int[] factors) {
        int product = 1;
        for (int val : factors)
            product *= val;
        return product;
    }

    public static double findProductOfCubes(int[] factors) {
        double product = 1;
        for (int val : factors)
            product *= Math.pow(val, 3);
        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] factors = findFactors(num);

	System.out.println("Greatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + findSumOfFactors(factors));
        System.out.println("Product of Factors: " + findProductOfFactors(factors));
        System.out.println("Product of Cubes of Factors: " + findProductOfCubes(factors));
    }
}
