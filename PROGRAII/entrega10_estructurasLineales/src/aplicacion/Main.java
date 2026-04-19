package aplicacion;
import dominio.ListaSimpleEnlazada;

public class Main {
    public static void main(String[] args) {
        // Lista de enteros
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);

        System.out.println("Lista inicial: " + lista);

        System.out.print("Recorrido for-each: ");
        for (int v : lista) {
            System.out.print(v + " ");
        }
        System.out.println();

        // remove
        lista.remove(1);  // elimina el 20
        System.out.println("Tras remove(1): " + lista);

        lista.remove(0);  // elimina el 10
        System.out.println("Tras remove(0): " + lista);

        // Lista genérica con String
        ListaSimpleEnlazada<String> palabras = new ListaSimpleEnlazada<>();
        palabras.add("Java");
        palabras.add("es");
        palabras.add("genérico");

        System.out.print("Lista de Strings: ");
        for (String s : palabras) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
