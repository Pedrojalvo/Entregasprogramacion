package Progra2;

import java.util.Arrays;

public class QuickSortEficiente {
    
    private long comparaciones;
    
    public void quickSortPrimerElemento(int[] arr) {
        comparaciones = 0;
        quickSortPrimerElemento(arr, 0, arr.length - 1);
    }
    
    private void quickSortPrimerElemento(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionPrimerElemento(arr, low, high);
            quickSortPrimerElemento(arr, low, pi - 1);
            quickSortPrimerElemento(arr, pi + 1, high);
        }
    }
    
    private int partitionPrimerElemento(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        
        for (int j = low + 1; j <= high; j++) {
            comparaciones++;
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        
        int temp = arr[low];
        arr[low] = arr[i - 1];
        arr[i - 1] = temp;
        
        return i - 1;
    }
    
    public void quickSortElementoCentral(int[] arr) {
        comparaciones = 0;
        quickSortElementoCentral(arr, 0, arr.length - 1);
    }
    
    private void quickSortElementoCentral(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionElementoCentral(arr, low, high);
            quickSortElementoCentral(arr, low, pi - 1);
            quickSortElementoCentral(arr, pi + 1, high);
        }
    }
    
    private int partitionElementoCentral(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];
        
        // Mover el pivote al inicio
        int temp = arr[mid];
        arr[mid] = arr[low];
        arr[low] = temp;
        
        int i = low + 1;
        
        for (int j = low + 1; j <= high; j++) {
            comparaciones++;
            if (arr[j] < pivot) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        
        temp = arr[low];
        arr[low] = arr[i - 1];
        arr[i - 1] = temp;
        
        return i - 1;
    }
    
    public long getComparaciones() {
        return comparaciones;
    }
    
    public static void main(String[] args) {
        QuickSortEficiente qs = new QuickSortEficiente();
        int[] tamanos = {100, 1000, 10000};
        
        System.out.println("=" .repeat(100));
        System.out.printf("%-10s %-25s %-25s %-25s%n", "N", "Primer Elemento (ns)", "Central (ns)", 
                         "Primer Elemento (comp)");
        System.out.println("=" .repeat(100));
        
        for (int n : tamanos) {
            int[] arrOrdenado = new int[n];
            for (int i = 0; i < n; i++) {
                arrOrdenado[i] = i;
            }
            
            int[] copia1 = Arrays.copyOf(arrOrdenado, arrOrdenado.length);
            long start = System.nanoTime();
            qs.quickSortPrimerElemento(copia1);
            long end = System.nanoTime();
            long compPrimer = qs.getComparaciones();
            
            int[] copia2 = Arrays.copyOf(arrOrdenado, arrOrdenado.length);
            start = System.nanoTime();
            qs.quickSortElementoCentral(copia2);
            end = System.nanoTime();
            
            System.out.printf("%-10d %-25d %-25d %-25d%n", n, (end - start), (end - start), compPrimer);
        }
        
        System.out.println("\nExplicación:");
        System.out.println("Con arrays ya ordenados, el pivote como primer elemento genera el peor caso O(n²)");
        System.out.println("mientras que el pivote central evita este problema manteniendo O(n log n) en promedio.");
    }
}