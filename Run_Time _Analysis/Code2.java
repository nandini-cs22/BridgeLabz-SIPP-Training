import java.util.*;

public class Main {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int l = 0; l < temp.length; l++) arr[left + l] = temp[l];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000}; // skip 1,000,000 for Bubble due to time
        Random rand = new Random();

        for (int n : sizes) {
            int[] base = rand.ints(n, 1, n * 10).toArray();

            int[] bubble = Arrays.copyOf(base, base.length);
            int[] merge = Arrays.copyOf(base, base.length);
            int[] quick = Arrays.copyOf(base, base.length);

            System.out.printf("Dataset Size: %,d\n", n);

            long start = System.currentTimeMillis();
            bubbleSort(bubble);
            long bubbleTime = System.currentTimeMillis() - start;
            System.out.printf("Bubble Sort: %d ms\n", bubbleTime);

            start = System.currentTimeMillis();
            mergeSort(merge, 0, merge.length - 1);
            long mergeTime = System.currentTimeMillis() - start;
            System.out.printf("Merge Sort: %d ms\n", mergeTime);

            start = System.currentTimeMillis();
            quickSort(quick, 0, quick.length - 1);
            long quickTime = System.currentTimeMillis() - start;
            System.out.printf("Quick Sort: %d ms\n\n", quickTime);
        }

        int n = 1_000_000;
        int[] base = rand.ints(n, 1, n * 10).toArray();
        int[] merge = Arrays.copyOf(base, base.length);
        int[] quick = Arrays.copyOf(base, base.length);

        System.out.printf("Dataset Size: %,d\n", n);

        long start = System.currentTimeMillis();
        mergeSort(merge, 0, merge.length - 1);
        long mergeTime = System.currentTimeMillis() - start;
        System.out.printf("Merge Sort: %d ms\n", mergeTime);

        start = System.currentTimeMillis();
        quickSort(quick, 0, quick.length - 1);
        long quickTime = System.currentTimeMillis() - start;
        System.out.printf("Quick Sort: %d ms\n", quickTime);
    }
}
