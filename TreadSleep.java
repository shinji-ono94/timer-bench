import java.io.FileNotFoundException;
import java.io.PrintWriter;

class TreadSleep {
    private static PrintWriter pw;

    public static void main(String[] args) {
        // init
        PrintInit();

        // 1ms
        for (int i = 0; i < 1000; i++) {
            ThreadSleep(1);
        }

        // 10ms
        for (int i = 0; i < 1000; i++) {
            ThreadSleep(10);
        }

        // 100ms
        for (int i = 0; i < 1000; i++) {
            ThreadSleep(100);
        }

        // 1000ms
        for (int i = 0; i < 1000; i++) {
            ThreadSleep(1000);
        }

        PrintClose();
    }

    public static void ThreadSleep(int msec) {
        try {
            long start = System.nanoTime();
            Thread.sleep(msec);
            long finish = System.nanoTime();
            // System.out.println((finish - start));
            Print((finish - start));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void PrintInit() {
        try {
            pw = new PrintWriter("log.csv");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void Print(Long value) {
        pw.println(String.valueOf(value));
        pw.flush();
    }

    public static void PrintClose() {
        pw.close();
    }
}
