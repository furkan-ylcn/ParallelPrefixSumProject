import java.util.Random;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

class PrefixSumTask extends RecursiveAction {
    private static final int THRESHOLD = 50000000; // Eşik değeri
    private int[] array;
    private int start;
    private int end;

    public PrefixSumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            calculatePrefixSum();
        } else {
            int step = (end - start) / 10;
            PrefixSumTask[] tasks = new PrefixSumTask[10];
        
            for (int i = 0; i < 9; i++) {
                tasks[i] = new PrefixSumTask(array, start + i * step, start + (i + 1) * step);
            }

        tasks[9] = new PrefixSumTask(array, start + 9 * step, end);

        invokeAll(tasks);
        }
    }

    private void calculatePrefixSum() {
        for (int i = start + 1; i < end; i++) {
            array[i] += array[i - 1];
        }
    }
}

public class ParallelPrefixSum {
    public static void main(String[] args) {
        int[] array = generateRandomArray(100000000, 9); // 100000000 elemanlı 0-9 arası rastgele dizi
        // System.out.println("Array: " + java.util.Arrays.toString(array));

        long startTime = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        PrefixSumTask task = new PrefixSumTask(array, 0, array.length);
        pool.invoke(task);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        // System.out.println("Prefix Sum: " + java.util.Arrays.toString(array));
        System.out.println("Gecen sure " + elapsedTime + " milisaniye.");
    }

    private static int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue + 1);
        }
        return array;
    }
}
