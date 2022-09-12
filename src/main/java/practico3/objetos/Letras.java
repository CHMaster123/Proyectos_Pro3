package practico3.objetos;

import practico3.interfaces.IDibujo;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Letras implements IDibujo {
    private int x;
    private int y;
    private int tamano;
    private String texto;
    private PropertyChangeSupport observado;
    private boolean seleccionado;

    public Letras(int m, int n, String texto) {
        x = m;
        y = n;
        this.texto = texto;
        observado = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.RED);
        g.drawString(texto, x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void moverA(int x, int y) {
        this.x = x;
        this.y = y;
        observado.firePropertyChange("CUADRADO", false, true);
    }
}
