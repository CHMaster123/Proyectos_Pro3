package practico4.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico4.dibujo.Escena;
import practico4.interfaces.IFiguras;
import practico4.objetos.Cuadrado;
import practico4.objetos.Letras;
import practico4.objetos.Linea;
import practico4.objetos.Circulo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Panel extends JPanel implements PropertyChangeListener, MouseListener, MouseMotionListener {

    private Escena modelo;
    private int numero_de_panel;

    public int getNumero_de_panel() {
        return numero_de_panel;
    }

    public void setNumero_de_panel(int numero_de_panel) {
        this.numero_de_panel = numero_de_panel;
    }

    public void setModelo(Escena modelo) {
        this.modelo = modelo;
    }

    public Escena getModelo() {
        return modelo;
    }

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
        logger.debug("click boiiii "+numero_de_panel);
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
        IFiguras m = modelo.getObjetoSeleccionado();
        if (m != null) {
            m.moverA(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    // no es necesario
    }
}
