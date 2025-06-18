import java.util.Scanner;

class ShortestLongestWord
{
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = customSplit(text);
        String[][] wordWithLength = getWordsWithLength(words);
        int[] result = findShortestAndLongest(wordWithLength);

        System.out.println("Shortest Word: " + wordWithLength[result[0]][0]);
        System.out.println("Longest Word: " + wordWithLength[result[1]][0]);
	}

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static String[] customSplit(String str) {
        int len = findLength(str);
        int spaceCount = 0;

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndexes = new int[spaceCount + 1];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[spaceCount] = len;

        String[] words = new String[spaceCount + 1];
        int start = 0;
        for (int i = 0; i <= spaceCount; i++) {
            int end = spaceIndexes[i];
            String word = "";
            for (int j = start; j < end; j++) {
                word += str.charAt(j);
            }
            words[i] = word;
            start = end + 1;
        }

        return words;
    }

    public static String[][] getWordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordWithLength) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int shortestLength = Integer.parseInt(wordWithLength[0][1]);
        int longestLength = Integer.parseInt(wordWithLength[0][1]);

        for (int i = 1; i < wordWithLength.length; i++) {
            int len = Integer.parseInt(wordWithLength[i][1]);
            if (len < shortestLength) {
                shortestLength = len;
                shortestIndex = i;
            }
            if (len > longestLength) {
                longestLength = len;
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
	}
}
