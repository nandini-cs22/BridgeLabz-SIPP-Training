import java.util.Scanner;

class UniqueCharacters
{
	public static int getStringLength(String str)
	{
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
           
        }
        return count;
       }

    public static char[] findUniqueChars(String str) {
        int length = getStringLength(str);
        char[] unique = new char[length];
        int index = 0;

        for (int i = 0; i < length; i++) {
            char current = str.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[index] = current;
                index++;
            }
        }

        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char[] uniqueChars = findUniqueChars(input);

        System.out.print("Unique characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
    }
}
