package dominio;

import java.util.LinkedList;
import java.util.List;

public class TablaHashSinonimos {

    private static final int capacidad = 16;
    private LinkedList<Entry>[] tabla;
    private int size;

    @SuppressWarnings("unchecked")
    public TablaHashSinonimos() {
        tabla = new LinkedList[capacidad];
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % capacidad;
    }

    public void put(String clave, List<String> sinonimos) {
        int indice = hash(clave);
        for (Entry e : tabla[indice]) {
            if (e.clave.equals(clave)) {
                e.sinonimos = sinonimos;
                return;
            }
        }
        tabla[indice].add(new Entry(clave, sinonimos));
        size++;
    }

    public List<String> get(String clave) {
        int indice = hash(clave);
        for (Entry e : tabla[indice]) {
            if (e.clave.equals(clave)) {
                return e.sinonimos;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private static class Entry {
        String clave;
        List<String> sinonimos;

        Entry(String clave, List<String> sinonimos) {
            this.clave = clave;
            this.sinonimos = sinonimos;
        }
    }
}
