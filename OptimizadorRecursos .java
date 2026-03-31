package Progra2;

import java.util.*;

public class OptimizadorRecursos {
    
    public static class Tribonacci {
        private Map<Integer, Long> memo = new HashMap<>();
        
        public long tribonacci(int n) {
            if (n == 0) return 0;
            if (n == 1) return 0;
            if (n == 2) return 1;
            
            if (memo.containsKey(n)) {
                return memo.get(n);
            }
            
            long result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
            memo.put(n, result);
            return result;
        }
        
        public void imprimirSerie(int n) {
            System.out.println("Serie Tribonacci (primeros " + n + " términos):");
            for (int i = 0; i < n; i++) {
                System.out.print(tribonacci(i) + " ");
            }
            System.out.println();
        }
    }
    
    public static class NReinas {
        private int n;
        private List<List<String>> soluciones;
        
        public NReinas(int n) {
            this.n = n;
            this.soluciones = new ArrayList<>();
        }
        
        public List<List<String>> resolver() {
            soluciones.clear();
            int[] tablero = new int[n];
            Arrays.fill(tablero, -1);
            backtracking(tablero, 0);
            return soluciones;
        }
        
        private void backtracking(int[] tablero, int fila) {
            if (fila == n) {
                soluciones.add(construirSolucion(tablero));
                return;
            }
            
            for (int col = 0; col < n; col++) {
                if (esSeguro(tablero, fila, col)) {
                    tablero[fila] = col;
                    backtracking(tablero, fila + 1);
                    tablero[fila] = -1; // backtrack
                }
            }
        }
        
        private boolean esSeguro(int[] tablero, int fila, int col) {
            for (int i = 0; i < fila; i++) {
                // Misma columna o misma diagonal
                if (tablero[i] == col || Math.abs(tablero[i] - col) == Math.abs(i - fila)) {
                    return false;
                }
            }
            return true;
        }
        
        private List<String> construirSolucion(int[] tablero) {
            List<String> solucion = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] fila = new char[n];
                Arrays.fill(fila, '.');
                fila[tablero[i]] = 'Q';
                solucion.add(new String(fila));
            }
            return solucion;
        }
        
        public void imprimirSoluciones() {
            List<List<String>> sols = resolver();
            System.out.println("Total de soluciones para tablero " + n + "x" + n + ": " + sols.size());
            for (int i = 0; i < sols.size(); i++) {
                System.out.println("\nSolución " + (i + 1) + ":");
                for (String fila : sols.get(i)) {
                    System.out.println(fila);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Tribonacci trib = new Tribonacci();
        trib.imprimirSerie(15);
        
        System.out.println("\n" + "=" .repeat(50));
        NReinas reinas = new NReinas(4);
        reinas.imprimirSoluciones();
    }
}