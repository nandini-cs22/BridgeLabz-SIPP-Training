import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("largefile.txt");

        long start = System.currentTimeMillis();
        FileReader fr = new FileReader(file);
        while (fr.read() != -1) {}
        fr.close();
        long fileReaderTime = System.currentTimeMillis() - start;
        System.out.println("FileReader Time: " + fileReaderTime + " ms");

        start = System.currentTimeMillis();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        while (isr.read() != -1) {}
        isr.close();
        long inputStreamReaderTime = System.currentTimeMillis() - start;
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");
    }
}
