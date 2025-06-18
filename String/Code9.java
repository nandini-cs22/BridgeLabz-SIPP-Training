import java.util.Scanner;

public class UpperCaseCompare
{
	 public static String convertToUpperCase(String text)
	{
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String builtInUpper = input.toUpperCase();
        String manualUpper = convertToUpperCase(input);
        boolean isEqual = compareStrings(builtInUpper, manualUpper);
        System.out.println("Original Text: " + input);
        System.out.println("Built-in Uppercase: " + builtInUpper);
        System.out.println("Manual Uppercase: " + manualUpper);
        System.out.println("Are both conversions equal? " + isEqual);
	}
}
