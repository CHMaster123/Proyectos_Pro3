package practico4.objetos;
import java.awt.*;
import java.beans.PropertyChangeSupport;


public class Cuadrado extends Figura {

    protected int tamano;

    public Cuadrado(int posx,int posy,int tamano) {
       this.x = posx;
       this.y = posy;
       this.tamano = tamano;
       observado = new PropertyChangeSupport(this);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(this.x,this.y,this.tamano,this.tamano);
    }

    @Override
    public boolean estaDentroDeLaFigura(int x, int y) {
        return (x > getX() && x < (getX() + getTamano()) &&
                y > getY() && y < (getY() + getTamano()));
    }

    @Override
    public void moverA(int x, int y) {
        this.x = x-(tamano/2);
        this.y = y-(tamano/2);
        observado.firePropertyChange("Linea", false, true);
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}
