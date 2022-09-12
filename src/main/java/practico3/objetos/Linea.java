package practico3.objetos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico3.interfaces.IDibujo;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Linea implements IDibujo {
    private int x;
    private int y;
    private int tamano;
    private PropertyChangeSupport observado;
    private boolean seleccionado;
    protected static final Logger logger = LogManager.getLogger();

    public Linea(int m, int n, int t) {
        x = m;
        y = n;
        tamano = t;
        observado = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    @Override
    public void dibujar(Graphics g) {
        logger.debug("se dibuja una linea");
        g.setColor(Color.green);
        g.drawLine(x, y+tamano/2, x + tamano, y+(tamano/2) );
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
        logger.debug("se mueve a POS X:"+ x +" POS Y:" +y);
        this.x = x-(tamano/2);
        this.y = y-(tamano/2);
        observado.firePropertyChange("CUADRADO", false, true);
    }
}
