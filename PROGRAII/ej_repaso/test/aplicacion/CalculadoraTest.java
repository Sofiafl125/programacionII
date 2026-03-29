package aplicacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void deberiaSumarDosNumeros() {
        assertEquals(5, calculadora.sumar(2, 3));
    }

    @Test
    void deberiaRestarDosNumeros() {
        assertEquals(3, calculadora.restar(5, 2));
    }
}
