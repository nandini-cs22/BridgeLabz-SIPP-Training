import java.util.Scanner;

class TrimStringCharAt
{
	public static int[] findTrimIndices(String str)
	{
        int start = 0;
        int end = str.length() - 1;

        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
        }

    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
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

        int[] indices = findTrimIndices(input);
        String trimmedByMethod = customSubstring(input, indices[0], indices[1]);
        String trimmedByBuiltIn = input.trim();

        boolean isSame = compareStrings(trimmedByMethod, trimmedByBuiltIn);

        System.out.println("Trimmed using method: '" + trimmedByMethod + "'");
        System.out.println("Trimmed using built-in: '" + trimmedByBuiltIn + "'");
        System.out.println("Are both equal? " + isSame);
	}
}
