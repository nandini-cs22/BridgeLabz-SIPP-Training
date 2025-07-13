import java.util.*;

public class Main {
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        int target = -1;

        for (int n : sizes) {
            int[] dataset = new int[n];
            Random rand = new Random();

            for (int i = 0; i < n; i++) {
                dataset[i] = rand.nextInt(n * 2);
            }

            long start = System.nanoTime();
            linearSearch(dataset, target);
            long linearTime = System.nanoTime() - start;

            Arrays.sort(dataset);
            start = System.nanoTime();
            binarySearch(dataset, target);
            long binaryTime = System.nanoTime() - start;

            System.out.printf("Dataset Size: %,d | Linear: %.3f ms | Binary: %.3f ms%n",
                    n, linearTime / 1e6, binaryTime / 1e6);
        }
    }
}
