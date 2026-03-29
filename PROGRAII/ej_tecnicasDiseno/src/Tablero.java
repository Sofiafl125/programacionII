public class Tablero {

    static final int N = 8;
    static int[] movX = {2, 1, -1, -2, -2, -1,  1,  2};
    static int[] movY = {1, 2,  2,  1, -1, -2, -2, -1};
    static int[][] tablero = new int[N][N];

    public static void main(String[] args) {
        inicializar();
        tablero[0][0] = 1; // el caballo empieza en (0,0)

        if (ensayar(0, 0, 1)) {
            imprimirTablero();
        } else {
            System.out.println("Sin solución");
        }
    }

    static boolean ensayar(int x, int y, int paso) {

        //Caso base
        if (paso == N * N) return true;

        for (int i = 0; i < 8; i++) {
            int nuevoX = x + movX[i];
            int nuevoY = y + movY[i];

            if (viable(nuevoX, nuevoY)) {        // 1. ¿Es candidato válido?
                anotar(nuevoX, nuevoY, paso + 1); // 2. Anotar/aplicar

                if (ensayar(nuevoX, nuevoY, paso + 1)) // 3. Ensayar recursivo
                    return true;

                borrar(nuevoX, nuevoY);           // 4. Borrar/deshacer
            }
        }

        return false; // ningún candidato funcionó
    }

    // Comprueba si la casilla es válida y no visitada
    static boolean viable(int x, int y) {
        return x >= 0 && x < N
                && y >= 0 && y < N
                && tablero[x][y] == 0;
    }

    // Marca la casilla con el número de paso
    static void anotar(int x, int y, int paso) {
        tablero[x][y] = paso;
    }

    // Desmarca la casilla (el backtrack real)
    static void borrar(int x, int y) {
        tablero[x][y] = 0;
    }

    static void inicializar() {
        for (int[] fila : tablero)
            java.util.Arrays.fill(fila, 0);
    }

    static void imprimirTablero() {
        for (int[] fila : tablero) {
            for (int val : fila)
                System.out.printf("%3d", val);
            System.out.println();
        }
    }
}
