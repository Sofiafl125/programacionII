package dominio;

public class BST {

    private Nodo raiz;

    private static class Nodo {
        Producto producto;
        Nodo izq, der;

        Nodo(Producto p) {
            this.producto = p;
        }
    }

    // Insercion por ID
    public void insertar(Producto p) {
        raiz = insertarRec(raiz, p);
    }

    private Nodo insertarRec(Nodo nodo, Producto p) {
        if (nodo == null) return new Nodo(p);
        if (p.id < nodo.producto.id)
            nodo.izq = insertarRec(nodo.izq, p);
        else if (p.id > nodo.producto.id)
            nodo.der = insertarRec(nodo.der, p);
        return nodo;
    }

    // Busqueda por ID
    public Producto buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Producto buscarRec(Nodo nodo, int id) {
        if (nodo == null) return null;
        if (id == nodo.producto.id) return nodo.producto;
        if (id < nodo.producto.id) return buscarRec(nodo.izq, id);
        return buscarRec(nodo.der, id);
    }

    // Suma total del stock de todos los productos
    public int stockTotal() {
        return stockTotalRec(raiz);
    }

    private int stockTotalRec(Nodo nodo) {
        if (nodo == null) return 0;
        return nodo.producto.stock + stockTotalRec(nodo.izq) + stockTotalRec(nodo.der);
    }
}
