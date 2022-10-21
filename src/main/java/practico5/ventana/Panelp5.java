package practico5.ventana;

import practico5.graficos.DibujoArbol;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Panelp5 extends JPanel implements PropertyChangeListener {
    private DibujoArbol<String> modelo;

    public DibujoArbol<String> getModelo() {
        return modelo;
    }

    public void setModelo(DibujoArbol<String> modelo) {
        this.modelo = modelo;
    }

    public Panelp5(DibujoArbol<String> src) {
        modelo = src;
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
    }
}
