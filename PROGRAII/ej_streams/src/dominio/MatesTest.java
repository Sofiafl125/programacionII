package dominio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MatesTest {
    //EJERCICIO 1

    @Test
    public void testSuma_1(){
        assertEquals(Mates.sumarEnteros(1), 1);
    }

    @Test
    public void testSuma_2(){
        assertEquals(Mates.sumarEnteros(5), 15);
    }

    @Test
    public void testSuma_0(){
        assertEquals(Mates.sumarEnteros(0), 0);
    }

    @Test
    public void testSuma_neg5(){
        assertEquals(Mates.sumarEnteros(-5), -15);
    }

    //EJERCICIO 2

    @Test
    public void testMediaArmonica_1() {
        assertTrue(Math.abs(Mates.mediaArmonica(new double[]{1.0}), -1.0) < 0.0001);
    }
}
