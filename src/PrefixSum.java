import java.util.Arrays;
import java.util.Random;

public class PrefixSum {
    public static void main(String[] args) {
        int[] array = generateRandomArray(100000000, 9); // 100000000 elemanlı rastgele bir dizi oluştur (0 ile 9 arasında)
        
        long startTime = System.currentTimeMillis(); // Başlangıç zamanını al
        
        int[] prefixSum = calculatePrefixSum(array);
        
        long endTime = System.currentTimeMillis(); // Bitiş zamanını al
        long duration = endTime - startTime; // İşlem süresini hesapla
        
        // System.out.println("Array: " + Arrays.toString(array));
        // System.out.println("Prefix Sum: " + Arrays.toString(prefixSum));
        System.out.println("Gecen sure " + duration + " milisaniye."); // Süreyi ekrana yazdır
    }
    
    private static int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue + 1);
        }
        return array;
    }
    
    public static int[] calculatePrefixSum(int[] array) {
        int n = array.length;
        int[] prefixSum = new int[n];
        
        prefixSum[0] = array[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i];
        }
        
        return prefixSum;
    }
}
