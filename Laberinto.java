public class ExploradorLaberinto {
    
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static final char PARED = '#';
    private static final char CAMINO = ' ';
    private static final char ENTRADA = 'E';
    private static final char SALIDA = 'S';
    private static final char MARCA = '.';

    public static boolean resolverLaberinto(char[][] laberinto) {
        if (laberinto == null || laberinto.length == 0) {
            System.out.println("Error: Laberinto inválido");
            return false;
        }
        
        int[] entrada = encontrarEntrada(laberinto);
        if (entrada == null) {
            System.out.println("Error: No se encontró la entrada (E)");
            return false;
        }
        
        imprimirLaberinto(laberinto);
        boolean[][] visitados = new boolean[laberinto.length][laberinto[0].length];
        boolean encontrado = buscarCamino(laberinto, entrada[0], entrada[1], visitados);
        
        if (encontrado) {
            System.out.println("CAMINO ENCONTRADO");
            imprimirLaberinto(laberinto);
        } else {
            System.out.println("No hay camino disponible a la salida");
        }
        
        return encontrado;
    }
    
    private static int[] encontrarEntrada(char[][] laberinto) {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                if (laberinto[i][j] == ENTRADA) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    private static boolean buscarCamino(char[][] laberinto, int x, int y, boolean[][] visitados) {

        if (x < 0 || x >= laberinto.length || y < 0 || y >= laberinto[0].length) {
            return false;
        }
        
        if (laberinto[x][y] == PARED || visitados[x][y]) {
            return false;
        }
        
        if (laberinto[x][y] == SALIDA) {
            return true;
        }
        
        visitados[x][y] = true;
        
        if (laberinto[x][y] != ENTRADA) {
            laberinto[x][y] = MARCA;
        }
        
        int[][] direcciones = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (int[] dir : direcciones) {
            if (buscarCamino(laberinto, x + dir[0], y + dir[1], visitados)) {
                return true;
            }
        }
        
        if (laberinto[x][y] != ENTRADA) {
            laberinto[x][y] = CAMINO;
        }
        
        return false;
    }
    
    private static void imprimirLaberinto(char[][] laberinto) {
        System.out.println("+" + "-".repeat(laberinto[0].length * 2 + 1) + "+");
        for (char[] fila : laberinto) {
            System.out.print("| ");
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println("|");
        }
        System.out.println("+" + "-".repeat(laberinto[0].length * 2 + 1) + "+");
    }
    
    public static void main(String[] args) {
        // Laberinto de ejemplo
        char[][] laberinto = {
            {'E', ' ', '#', ' ', ' ', ' ', '#', ' '},
            {'#', ' ', '#', ' ', '#', ' ', '#', ' '},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' '},
            {'#', '#', '#', ' ', '#', ' ', '#', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', '#', 'S'}
        };
        
        resolverLaberinto(laberinto);
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        char[][] laberintoSinSalida = {
            {'E', ' ', '#', ' ', ' '},
            {'#', ' ', '#', ' ', '#'},
            {'#', '#', '#', ' ', '#'},
            {' ', ' ', ' ', ' ', ' '},
            {'#', '#', '#', '#', 'S'}
        };
        
        resolverLaberinto(laberintoSinSalida);
    }
}