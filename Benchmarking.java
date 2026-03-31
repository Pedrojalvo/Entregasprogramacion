package Progra2;
import java.util.Arrays;
import java.util.Random;

public class Analizador {
    
    public static void main(String[] args) {
        int[] tamanos = {100, 1000, 10000};
        Analizador analizador = new Analizador();
        
        System.out.println("=" .repeat(80));
        System.out.printf("%-10s %-20s %-20s %-20s%n", "N", "Algoritmo", "Tiempo (ns)", "Comparaciones");
        System.out.println("=" .repeat(80));
        
        for (int n : tamanos) {
            int[] arr = analizador.generarArrayAleatorio(n);
            
            int[] copia1 = Arrays.copyOf(arr, arr.length);
            long start = System.nanoTime();
            long compBurbuja = analizador.burbuja(copia1);
            long end = System.nanoTime();
            System.out.printf("%-10d %-20s %-20d %-20d%n", n, "Burbuja", (end - start), compBurbuja);
            
            int[] copia2 = Arrays.copyOf(arr, arr.length);
            start = System.nanoTime();
            long compSeleccion = analizador.seleccion(copia2);
            end = System.nanoTime();
            System.out.printf("%-10d %-20s %-20d %-20d%n", n, "Selección", (end - start), compSeleccion);
            
            long teoricoBurbuja = (long) n * (n - 1) / 2;
            long teoricoSeleccion = (long) n * (n - 1) / 2;
            System.out.printf("%-10s %-20s %-20s %-20d%n", "", "Teórico Burbuja", "", teoricoBurbuja);
            System.out.printf("%-10s %-20s %-20s %-20d%n", "", "Teórico Selección", "", teoricoSeleccion);
            System.out.println("-" .repeat(80));
        }
    }
    
    public int[] generarArrayAleatorio(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }
    
    public long burbuja(int[] arr) {
        long comparaciones = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return comparaciones;
    }
    
    public long seleccion(int[] arr) {
        long comparaciones = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        return comparaciones;
    }
}