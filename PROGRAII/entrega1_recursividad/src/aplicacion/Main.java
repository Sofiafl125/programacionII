package aplicacion;

public class Main {

    // Función recursiva para contar cuántas veces aparece un dígito
    public static int contarDigito(int numero, int digito) {
        // Caso base: si el número es 0, terminamos
        if (numero == 0) {
            return 0;
        }

        // Obtenemos el último dígito del número
        int ultimoDigito = numero % 10;

        // Contamos 1 si coincide con el dígito buscado, 0 si no
        int cuenta;
        if (ultimoDigito == digito) {
            cuenta = 1;
        } else {
            cuenta = 0;
        }


        // Llamada recursiva con el número sin el último dígito
        return cuenta + contarDigito(numero / 10, digito);
    }

    public static void main(String[] args) {
        int numero = 123321;
        int digito = 2;

        System.out.println("El dígito " + digito + " aparece " +
                contarDigito(numero, digito) + " veces");
        // Salida: El dígito 2 aparece 2 veces
    }
}