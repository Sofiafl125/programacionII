package dominio;
import java.util.stream.IntStream;

public class Mates{
    //EJERCICIO 1
    public static int sumarEnteros(int n){
        if (n>= 0){
            return IntStream.range(1,n+1).sum();
        } else {
            return IntStream.range(n,0).sum();
        }
    }

    //EJERCICIO 2

    public static double mediaArmonica(double[] lista){
        return 1.0;
    }
}