package practico4.objetos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Linea extends Figura {
    private int PosicionX;
    private int PosicionY;
    private int tamano;
    private PropertyChangeSupport observado;
    private boolean seleccionado;
    protected static final Logger logger = LogManager.getLogger();

    public Linea(int m, int n, int t) {
        PosicionX = m;
        PosicionY = n;
        tamano = t;
        observado = new PropertyChangeSupport(this);
    }
    @Override
    public void addListener(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    @Override
    public void dibujar(Graphics g) {
        logger.debug("se dibuja una linea");
        g.setColor(Color.green);
        g.drawLine(PosicionX, PosicionY, PosicionX + tamano, PosicionY);
    }
    @Override
    public int getPosicionX() {
        return PosicionX;
    }
    @Override
    public void setPosicionX(int posicionX) {
        this.PosicionX = posicionX;
    }
    @Override
    public int getPosicionY() {
        return PosicionY;
    }
    @Override
    public void setPosicionY(int posicionY) {
        this.PosicionY = posicionY;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    @Override
    public boolean isSeleccionado() {
        return seleccionado;
    }

    @Override
    public boolean estaDentroDeLaFigura(int x, int y) {
        return (x > getPosicionX() && x < (getPosicionX() + getTamano()) &&
                y > getPosicionY() && y < (getPosicionY() + getTamano()));
    }
    @Override
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void moverA(int x, int y) {
        logger.debug("se mueve a POS X:"+ x +" POS Y:" +y);
        this.PosicionX = x-(tamano/2);
        this.PosicionY = y;
        observado.firePropertyChange("Linea", false, true);
    }
}
