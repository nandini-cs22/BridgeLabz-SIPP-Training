public class Main {
    public static void main(String[] args) {
        int[] counts = {1000, 10000, 1000000};

        for (int n : counts) {
            System.out.println("Operations Count: " + n);

            long start = System.currentTimeMillis();
            String s = "";
            for (int i = 0; i < n; i++) {
                s += "a";
            }
            long timeString = System.currentTimeMillis() - start;
            System.out.println("String: " + timeString + " ms");

            start = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
            long timeBuilder = System.currentTimeMillis() - start;
            System.out.println("StringBuilder: " + timeBuilder + " ms");

            start = System.currentTimeMillis();
            StringBuffer sbuf = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sbuf.append("a");
            }
            long timeBuffer = System.currentTimeMillis() - start;
            System.out.println("StringBuffer: " + timeBuffer + " ms\n");
        }
    }
}
