package aplicacion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FiltradoSensores {
    static class LecturaSensor {
        int id;
        double valor;
        String tipo;
        LocalDateTime timestamp;

        public LecturaSensor(int id, double valor, String tipo, LocalDateTime timestamp) {
            this.id = id;
            this.valor = valor;
            this.tipo = tipo;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {
        LocalDateTime ahora = LocalDateTime.now();

        //lista de lecturas de ejemplo (chatpgt)
        List<LecturaSensor> lecturas = new ArrayList<>();
        lecturas.add(new LecturaSensor(1, 23.5, "temperatura", ahora.minusHours(1)));
        lecturas.add(new LecturaSensor(2, 80.0, "humedad",     ahora.minusHours(2)));
        lecturas.add(new LecturaSensor(3, 19.2, "temperatura", ahora.minusHours(5)));
        lecturas.add(new LecturaSensor(4, 95.3, "humedad",     ahora.minusHours(10)));
        lecturas.add(new LecturaSensor(5, 30.1, "temperatura", ahora.minusHours(20)));
        lecturas.add(new LecturaSensor(6, 45.7, "presion",     ahora.minusHours(3)));
        lecturas.add(new LecturaSensor(7, 12.0, "temperatura", ahora.minusHours(30)));


        String tipoBuscado = "temperatura";

        List<LecturaSensor> filtradas = lecturas.stream()
                .filter(x -> x.tipo.equalsIgnoreCase(tipoBuscado))
                .toList();

        System.out.println("lecturas de tipo '" + tipoBuscado);
        for (LecturaSensor x : filtradas) {
            System.out.println("  ID: " + x.id + " | Valor: " + x.valor + " | Hora: " + x.timestamp);
        }

        //Promedio de las últimas 24h
        LocalDateTime hace24h = ahora.minusHours(24);

        double promedio = lecturas.stream()
                .filter(x -> x.timestamp.isAfter(hace24h))
                .mapToDouble(x -> x.valor)
                .average()
                .orElse(0);

        System.out.println("Promedio últimas 24h" + promedio);

        //Lectura con valor máximo
        LecturaSensor maxima = lecturas.stream()
                .max((x, y) -> Double.compare(x.valor, y.valor))
                .orElse(null);
        
        if (maxima != null) {
            System.out.println("  ID: " + maxima.id + " Tipo: " + maxima.tipo + " Valor: " + maxima.valor);
        }
    }
}
