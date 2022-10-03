package practico4.objetos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico4.interfaces.IDibujo;
import practico4.interfaces.IFiguras;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Circulo extends Figura {

    protected int tamano;
    public Circulo(int posx, int posy, int tamano) {
        this.x = posx;
        this.y = posy;
        this.tamano=tamano;
        this.observado=new PropertyChangeSupport(this);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(this.x,this.y,this.tamano,this.tamano);
    }

    @Override
    public boolean estaDentroDeLaFigura(int x, int y) {
        double radio = (double)tamano / 2.0;
        double cx = (double)this.x + radio;
        double cy = (double)this.y + radio;

        double izq = ((double)x - cx)*((double)x - cx) + ((double)y - cy)*((double)y - cy);
        double der = radio * radio;
        return (izq < der);
    }

    @Override
    public void setSeleccionado(boolean s) {
    this.seleccionado=s;
    }

    @Override
    public boolean isSeleccionado() {
        return seleccionado;
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
    observado.addPropertyChangeListener(listener);
    }

    @Override
    public void moverA(int x, int y) {
        this.x = x-(tamano/2);
        this.y = y-(tamano/2);
        observado.firePropertyChange("Linea", false, true);
    }
}
