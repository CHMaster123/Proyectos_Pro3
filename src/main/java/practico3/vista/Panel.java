package practico3.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico3.dibujo.Escena;
import practico3.objetos.Cuadrado;
import practico3.objetos.Letras;
import practico3.objetos.Linea;
import practico3.objetos.Redondo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Panel extends JPanel implements PropertyChangeListener, MouseListener, MouseMotionListener {

    private Escena modelo;
    protected static final Logger logger = LogManager.getLogger();

    public Panel(Escena escena) {
        modelo = escena;
        modelo.addListener(this);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(modelo.getImagen().getAncho(),
                modelo.getImagen().getAlto());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo == null)
            return;

        modelo.dibujar(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logger.debug("se detecto un cambio, se repinta el panel");
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        logger.debug("click boiiii");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        modelo.seleccionarObjeto(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        modelo.soltarObjeto();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    // no es necesario
    }

    @Override
    public void mouseExited(MouseEvent e) {
    // no es necesario
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Cuadrado cuadrado = modelo.getCuadradoSeleccionado();
        Redondo redondo = modelo.getRedondoSeleccionado();
        Linea linea = modelo.getLineaSeleccionada();
        Letras letras = modelo.getLetrasSeleccionada();
        if (cuadrado != null) {
            cuadrado.moverA(e.getX(), e.getY());
        }
        if (redondo != null) {
            redondo.moverA(e.getX(), e.getY());
        }
        if (linea != null) {
            linea.moverA(e.getX(), e.getY());
        }
        if (letras != null) {
            letras.moverA(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    // no es necesario
    }
}
