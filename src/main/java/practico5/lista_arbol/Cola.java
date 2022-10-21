package practico5.lista_arbol;

public class Cola<E> extends Lista<E>{
    public Cola() {
        super();
    }

    public void push(E o) {
        adicionar(o);
    }

    public E pull() {
        E result = raiz.getContenido();
        raiz = raiz.getSiguiente();
        tamano--;

        return result;
    }
}
