import java.util.Scanner;

class PalindromeChecker
{
    public static void main(String[] args)
	{
        String input = getInput();
        boolean isPalin = isPalindrome(input);
        displayResult(input, isPalin);
    	}

    static String getInput()
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    	}

    static boolean isPalindrome(String str)
	{
        int left = 0, right = str.length() - 1;
        while (left < right)
		{
            		if (str.charAt(left) != str.charAt(right)) return false;
            		left++;
            		right--;
        	}
        return true;
    	}

    static void displayResult(String original, boolean result)
	{
        	if (result)
		{
            		System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}
