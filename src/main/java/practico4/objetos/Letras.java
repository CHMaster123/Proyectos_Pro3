package practico4.objetos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Letras extends Figura {
    private int x;
    private int y;
    private int tamano;
    private String texto;
    private PropertyChangeSupport observado;
    private boolean seleccionado;
    protected static final Logger logger = LogManager.getLogger();

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
        logger.debug("se dibuja unas letras");
        g.setColor(Color.RED);
        g.drawString(texto, x, y);
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

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    @Override
    public boolean estaDentroDeLaFigura(int x, int y) {
        return (x > getPosicionX() && x < (getPosicionX() + getTamano()) &&
                y > getPosicionY() && y < (getPosicionY() + getTamano()));
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void moverA(int x, int y) {
        logger.debug("se mueve a POS X:"+ x +" POS Y:" +y);
        this.x = x;
        this.y = y;
        observado.firePropertyChange("CUADRADO", false, true);
    }
}
