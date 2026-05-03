package dominio;

public class Producto {

    int id;
    String nombre;
    int stock;

    public Producto(int id, String nombre, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', stock=" + stock + "}";
    }
}
