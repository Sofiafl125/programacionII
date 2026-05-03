package aplicacion;

import dominio.TablaHashSinonimos;
import java.util.ArrayList;
import java.util.List;

public class Main11 {

    public static void main(String[] args) {
        TablaHashSinonimos diccionario = new TablaHashSinonimos();

        diccionario.put("feliz",   List.of("contento", "alegre", "dichoso"));
        diccionario.put("triste",  List.of("melancolico", "apenado", "afligido"));
        diccionario.put("rapido",  List.of("veloz", "agil", "ligero"));
        diccionario.put("grande",  List.of("enorme", "gigante", "inmenso"));

        // Buscar con tabla hash
        long inicio = System.nanoTime();
        List<String> resultado = diccionario.get("rapido");
        long tiempoHash = System.nanoTime() - inicio;
        System.out.println("Sinonimos de 'rapido': " + resultado);
        System.out.println("Tiempo TablaHash:  " + tiempoHash + " ns");

        // Comparar con ArrayList (busqueda lineal)
        List<String[]> lista = new ArrayList<>();
        lista.add(new String[]{"feliz",  "contento", "alegre",    "dichoso"});
        lista.add(new String[]{"triste", "melancolico", "apenado"});
        lista.add(new String[]{"rapido", "veloz",    "agil",      "ligero"});
        lista.add(new String[]{"grande", "enorme",   "gigante"});

        inicio = System.nanoTime();
        for (String[] entrada : lista) {
            if (entrada[0].equals("rapido")) break;
        }
        long tiempoLista = System.nanoTime() - inicio;
        System.out.println("Tiempo ArrayList: " + tiempoLista + " ns");
    }
}
