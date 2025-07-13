import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random rand = new Random();

        for (int n : sizes) {
            System.out.println("Dataset Size: " + n);
            int target = -1;

            int[] array = rand.ints(n, 1, n * 2).toArray();
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int num : array) {
                hashSet.add(num);
                treeSet.add(num);
            }

            long start = System.currentTimeMillis();
            boolean foundArray = false;
            for (int val : array) {
                if (val == target) {
                    foundArray = true;
                    break;
                }
            }
            long timeArray = System.currentTimeMillis() - start;
            System.out.println("Array Search: " + timeArray + " ms");

            start = System.nanoTime();
            boolean foundHash = hashSet.contains(target);
            long timeHash = System.nanoTime() - start;
            System.out.println("HashSet Search: " + (timeHash / 1e6) + " ms");

            start = System.nanoTime();
            boolean foundTree = treeSet.contains(target);
            long timeTree = System.nanoTime() - start;
            System.out.println("TreeSet Search: " + (timeTree / 1e6) + " ms\n");
        }
    }
}
