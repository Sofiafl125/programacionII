package aplicacion;

public class Main {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        System.out.println("2 + 3 = " + c.sumar(2, 3));
        System.out.println("5 - 2 = " + c.restar(5, 2));
    }
}
