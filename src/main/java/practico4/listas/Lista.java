package practico4.listas;

import java.util.Iterator;

public class Lista<E> implements Iterable<E> {

    protected Nodo<E> raiz;
    protected int tamano;

    public Lista() {
        this.raiz = null;
        this.tamano = 0;
    }

    public void insertar(E contenido) {
        Nodo<E> nuevo_nodo = new Nodo<>(contenido);
        nuevo_nodo.setSiguiente(this.raiz);
        this.raiz = nuevo_nodo;
        tamano++;
    }

    public void adicionar(E contenido) {
        if (tamano == 0) {
            insertar(contenido);
            return;
        }
        Nodo<E> nuevo_nodo = new Nodo<>(contenido);
        Nodo<E> actual = raiz;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo_nodo);
        tamano++;
    }

    public void eliminar(int posicion) {
        if (posicion == 0) {
            this.raiz = raiz.getSiguiente();
            tamano--;
            return;
        }
        int aux = 0;
        Nodo<E> actual = raiz;
        while (aux < posicion - 1) {
            actual = actual.getSiguiente();
            aux++;
        }
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        tamano--;
    }

    public E buscar(E contenido) {
        Nodo<E> actual = raiz;
        while (actual != null) {
            if (actual.getContenido() == contenido) {
                break;
            }
            actual = actual.getSiguiente();
        }
        if (actual != null) {
            return actual.getContenido();
        }
        return null;
    }

    //No es necesario pero se añade para futuros proyectos
    @Override
    public String toString() {
        if (raiz == null)
            return "[VACIA]";

        StringBuilder resultado = new StringBuilder();
        Nodo<E> actual = raiz;
        String conector = "";
        while (actual != null) {
            resultado.append(conector).append(actual.getContenido());
            conector = " -> ";
            actual = actual.getSiguiente();
        }

        return resultado.toString();
    }

    public E contenidoPos(int posicion) {
        if (posicion == 0) {
            return raiz.getContenido();
        }
        Nodo<E> actual = raiz;
        int aux = 0;
        while (aux < posicion) {
            posicion++;
            actual = actual.getSiguiente();
        }
        return actual.getContenido();
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }

    public int getTamano() {
        return tamano;
    }


    class Nodo<E> {

        private E contenido;
        private Nodo<E> siguiente;

        public Nodo(E contenido) {
            this.contenido = contenido;
            this.siguiente = null;
        }

        public E getContenido() {
            return contenido;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }
    }

    class IteradorLista<E> implements Iterator<E> {

        private Nodo<E> siguiente;

        public IteradorLista(Nodo<E> actual) {
            this.siguiente = actual;
        }


        @Override
        public boolean hasNext() {
            return siguiente != null;
        }

        @Override
        public E next() {
            E c = siguiente.getContenido();
            siguiente = siguiente.getSiguiente();
            return c;
        }
        /*
        @Override
        public void remove() {

        }
         */
    }

    @Override
    public Iterator iterator() {
        return new IteradorLista<>(raiz);
    }
}
