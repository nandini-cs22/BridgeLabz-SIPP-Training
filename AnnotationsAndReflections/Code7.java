import java.lang.reflect.*;

class Worker {
    public void process() throws InterruptedException {
        Thread.sleep(500);
    }
}

public class ExecutionTiming {
    public static void main(String[] args) throws Exception {
        Worker worker = new Worker();
        Method method = Worker.class.getDeclaredMethod("process");
        long start = System.nanoTime();
        method.invoke(worker);
        long end = System.nanoTime();
        System.out.println("Execution time: " + (end - start) / 1_000_000 + " ms");
    }
}
