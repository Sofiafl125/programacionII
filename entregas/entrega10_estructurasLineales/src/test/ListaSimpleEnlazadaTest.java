package test;

import dominio.ListaSimpleEnlazada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ListaSimpleEnlazadaTest {

    private ListaSimpleEnlazada<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaSimpleEnlazada<>();
    }

    @Test
    void testAddUnElemento() {
        lista.add(10);
        assertEquals(1, lista.size());
    }

    @Test
    void testAddVariosElementos() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertEquals(3, lista.size());
    }

    @Test
    void testAddMantieneOrden() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        Iterator<Integer> it = lista.iterator();
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
    }

    @Test
    void testRemovePrimerElemento() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.remove(0);
        assertEquals(2, lista.size());
        assertEquals(2, lista.iterator().next());
    }

    @Test
    void testRemoveUltimoElemento() {
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.remove(2);
        assertEquals(2, lista.size());
    }

    @Test
    void testRemoveElementoIntermedio() {
        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.remove(1);
        Iterator<Integer> it = lista.iterator();
        assertEquals(10, it.next());
        assertEquals(30, it.next());
    }

    @Test
    void testRemoveIndiceNegativoLanzaExcepcion() {
        lista.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(-1));
    }

    @Test
    void testRemoveIndiceExcesivoLanzaExcepcion() {
        lista.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(5));
    }

    @Test
    void testRemoveListaVaciaLanzaExcepcion() {
        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(0));
    }

    @Test
    void testIteradorListaVacia() {
        assertFalse(lista.iterator().hasNext());
    }

    @Test
    void testForEachRecorreTodosLosElementos() {
        lista.add(5);
        lista.add(10);
        lista.add(15);
        int suma = 0;
        for (int v : lista) suma += v;
        assertEquals(30, suma);
    }

    @Test
    void testIteradorNextSinElementosLanzaExcepcion() {
        assertThrows(NoSuchElementException.class, () -> lista.iterator().next());
    }

    @Test
    void testListaDeStrings() {
        ListaSimpleEnlazada<String> listaStr = new ListaSimpleEnlazada<>();
        listaStr.add("hola");
        listaStr.add("mundo");
        Iterator<String> it = listaStr.iterator();
        assertEquals("hola", it.next());
        assertEquals("mundo", it.next());
    }

    @Test
    void testSizeListaVacia() {
        assertEquals(0, lista.size());
    }

    @Test
    void testSizeTrasAddYRemove() {
        lista.add(1);
        lista.add(2);
        lista.remove(0);
        assertEquals(1, lista.size());
    }
}