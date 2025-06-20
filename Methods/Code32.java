import java.util.Scanner;

class NumberChecker
{

    public static int countDigits(int num)
	{
        int count = 0;
        int n = num;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    public static int[] getDigits(int num)
	{
        int count = countDigits(num);
        int[] digits = new int[count];
        int index = count - 1;
        while (num > 0) {
            digits[index--] = num % 10;
            num /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++)
            if (digits[i] == 0)
                return true;
        return false;
    }

    public static boolean isArmstrongNumber(int num, int[] digits) {
        int power = digits.length;
        int sum = 0;
        for (int digit : digits)
            sum += Math.pow(digit, power);
        return sum == num;
    }

    public static void findLargestAndSecondLargest(int[] digits) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int val : digits) {
            if (val > first) {
                second = first;
                first = val;
            } else if (val > second && val != first) {
                second = val;
            }
        }
        System.out.println("Largest: " + first);
        System.out.println("Second Largest: " + (second == Integer.MIN_VALUE ? "N/A" : second));
    }

    public static void findSmallestAndSecondSmallest(int[] digits) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int val : digits) {
            if (val < first) {
                second = first;
                first = val;
            } else if (val < second && val != first) {
                second = val;
            }
        }
        System.out.println("Smallest: " + first);
        System.out.println("Second Smallest: " + (second == Integer.MAX_VALUE ? "N/A" : second));
    }

    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] digits = getDigits(num);

        System.out.println("Count of Digits: " + countDigits(num));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(num, digits));
        findLargestAndSecondLargest(digits);
        findSmallestAndSecondSmallest(digits);
    	}
}
