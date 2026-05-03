package aplicacionLab;

public class MainLaberinto {

    public static void main(String[] args){
        if(Laberinto.buscar( 1, 1)){
            Laberinto.mostrarlab();
        } else {
            System.out.println("No se ha encontrado la salida");
        }
    }
}
