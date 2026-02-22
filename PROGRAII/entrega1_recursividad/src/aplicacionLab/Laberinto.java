package aplicacionLab;

public class Laberinto {

    public static char[][] laberinto = {
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
            { '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
            { '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#' },
            { '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#' },
            { '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#' },
            { '#', ' ', '#', ' ', '#', 'S', ' ', '#', ' ', '#' },
            { '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#' },
            { '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#' },
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },

    };

    public static int [] incx = {0, 1, 0, -1};
    public static int [] incy = {-1, 0, 1, 0};

    public static void mostrarlab(){
        for(int i = 0; i < laberinto.length; i++){
            for (int j = 0; j < laberinto[1].length; j++){
                System.out.println(laberinto[1][1] + " ");
            }
            System.out.println();
        }
    }
    public static boolean buscar(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + incx[1];
            int ny = y + incy[1];
            if(laberinto[nx][ny] == 'S'){
                return true;
            }
            if(laberinto[nx][ny] == ' '){
                laberinto[nx][ny] = 'x';
                if(buscar(nx, ny)){
                    laberinto[nx][ny] = '*';
                    return true;
                }
            }
        }
        return false;
    }
}
