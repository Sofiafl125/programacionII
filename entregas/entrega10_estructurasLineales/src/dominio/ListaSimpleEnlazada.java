package dominio;

import java.util.Iterator;
import java.util.NoSuchElementException;

    public class ListaSimpleEnlazada<T> implements Iterable<T> {

        // Nodo interno
        private static class Nodo<T> {
            T dato;
            Nodo<T> siguiente;

            Nodo(T dato) {
                this.dato = dato;
                this.siguiente = null;
            }
        }

        private Nodo<T> cabeza;
        private int tamaño;

        public ListaSimpleEnlazada() {
            cabeza = null;
            tamaño = 0;
        }

        // Añade al final de la lista
        public void add(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Nodo<T> actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
            tamaño++;
        }

        // Elimina el nodo en la posición indicada (0-based)
        public void remove(int index) {
            if (index < 0 || index >= tamaño) {
                throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
            }
            if (index == 0) {
                cabeza = cabeza.siguiente;
            } else {
                Nodo<T> actual = cabeza;
                for (int i = 0; i < index - 1; i++) {
                    actual = actual.siguiente;
                }
                actual.siguiente = actual.siguiente.siguiente;
            }
            tamaño--;
        }

        public int size() {
            return tamaño;
        }

        // Implementación de Iterable<T> → permite usar for-each
        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private Nodo<T> actual = cabeza;

                @Override
                public boolean hasNext() {
                    return actual != null;
                }

                @Override
                public T next() {
                    if (!hasNext()) throw new NoSuchElementException();
                    T dato = actual.dato;
                    actual = actual.siguiente;
                    return dato;
                }
            };
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Nodo<T> actual = cabeza;
            while (actual != null) {
                sb.append(actual.dato);
                if (actual.siguiente != null) sb.append(" -> ");
                actual = actual.siguiente;
            }
            sb.append("]");
            return sb.toString();
        }
    }


