public class Tribonacci {

    private static long[] memoria;
    public static long tribonacci(int n) {
        memoria = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            memoria[i] = -1;
        }
        return trib(n);
    }

    private static long trib(int n) {
        if (n == 0 || n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        if (memoria[n] != -1){
            return memoria[n];
        }

        memoria[n] = trib(n-1) + trib(n-2) + trib(n-3);
        return memoria[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println("T(" + i + ")= " + tribonacci(i));
        }
    }
}