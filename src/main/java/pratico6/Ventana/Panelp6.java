package pratico6.Ventana;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pratico6.Grafia.Tablero;
import pratico6.Lista_con_grafos.GrafoCompleto;
import pratico6.Lista_con_grafos.Listap6;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Panelp6 extends JPanel implements PropertyChangeListener {
    private Tablero modelo;
    public Tablero getModelo() {
        return modelo;
    }
    protected static final Logger logger = LogManager.getLogger();

    public void setModelo(Tablero  modelo) {
        this.modelo = modelo;
    }

    public Panelp6(Tablero src) {
        modelo = src;
        modelo.addListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        modelo.dibujar(0,0, g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
        logger.debug("Repintando el panel");
    }

    public void djikstra(String text, String text1) {
        logger.debug("Calculando el camino mas corto de "+text+" a "+text1);
        modelo.djikstra(text, text1);
    }

    public void generarCamino(Listap6<String> camino, GrafoCompleto grafo) {
        Tablero tablero = new Tablero();
        tablero.setGrafo(grafo);
        this.setModelo(tablero);
    }
}
