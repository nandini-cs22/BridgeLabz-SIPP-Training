import java.util.Scanner;

public class CharArrayComparison
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        char[] customArray = getCharacters(text);
        char[] builtInArray = text.toCharArray();

        boolean isEqual = compareArrays(customArray, builtInArray);

        System.out.print("Custom Array: ");
        printArray(customArray);

        System.out.print("Built-in Array: ");
        printArray(builtInArray);

        System.out.println("Are both arrays equal? " + isEqual);
    }

    public static char[] getCharacters(String s) {
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
        }
        return result;
    }

    public static boolean compareArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length) {
            return false;
        }

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void printArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
