package aplicacion;

import dominio.BST;
import dominio.Producto;

public class Main12 {

    public static void main(String[] args) {
        BST inventario = new BST();

        inventario.insertar(new Producto(10, "Teclado",     50));
        inventario.insertar(new Producto(5,  "Raton",       30));
        inventario.insertar(new Producto(15, "Monitor",     10));
        inventario.insertar(new Producto(3,  "Cable USB",  200));
        inventario.insertar(new Producto(7,  "Auriculares", 25));

        System.out.println("Buscando id=7:  " + inventario.buscar(7));
        System.out.println("Buscando id=99: " + inventario.buscar(99));
        System.out.println("Stock total:    " + inventario.stockTotal());
    }
}
