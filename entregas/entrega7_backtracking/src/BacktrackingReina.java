public class BacktrackingReina {
        static final int N = 4;
        static int[] reinas = new int[N];
        static int numSoluciones = 0;

        public static void main(String[] args) {
            resolverReinas(0);
            System.out.println("Total de soluciones:" + numSoluciones);
        }

        static void resolverReinas(int fila) {
            if (fila == N) {
                numSoluciones++;
                imprimirSolucion();
                return;
            }
            for (int col = 0; col < N; col++) {
                if (esSeguro(fila, col)) {
                    reinas[fila] = col;
                    resolverReinas(fila + 1);
                }
            }
        }

        static boolean esSeguro(int fila, int col) {
            for (int f = 0; f < fila; f++) {
                int c = reinas[f];
                if (c == col || Math.abs(f - fila) == Math.abs(c - col)) {
                    return false;
                }
            }
            return true;
        }

        static void imprimirSolucion() {
            System.out.println("Solucion " + numSoluciones);
            for (int fila = 0; fila < N; fila++) {
                for (int col = 0; col < N; col++) {
                    System.out.print(reinas[fila] == col ? " Q " : " . ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }