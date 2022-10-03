package practico4.objetos;

import practico4.interfaces.IFiguras;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Figura implements IFiguras {

    protected int x;
    protected int y;
    protected PropertyChangeSupport observado;
    protected boolean seleccionado;

    @Override
    public void setSeleccionado(boolean s) {
        seleccionado = s;
    }

    @Override
    public boolean isSeleccionado() {
        return seleccionado;
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    public int getPosicionX() {
        return x;
    }

    public void setPosicionX(int posicionX) {
        this.x = posicionX;
    }

    public int getPosicionY() {
        return y;
    }

    public void setPosicionY(int posicionY) {
        this.y = posicionY;
    }
}
