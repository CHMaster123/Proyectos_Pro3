/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico2.ventana;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico2.recurrencia.Recurrencia;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author crist
 */
public class panelVentana extends JPanel implements PropertyChangeListener {

    private Recurrencia objeto;


    protected static final Logger logger = LogManager.getLogger();

    // Se Crea la clase de Panel, Se lo declara como la clase Vista
    public panelVentana(Recurrencia objeto) {
        this.objeto = objeto;
        objeto.listenerAñadir(this);
        initComponents();
        logger.debug("Se crea el Panel como clase Vista");
    }

    //este metodo solo declara que se graficara en el case que el objeto de modelo no sea nulo
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (objeto != null) {
            objeto.dibujar(g);
        }

    }

    // se declara que cuando el controlador detecte un cambio en el modelo, Vista se actualizara
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logger.debug("Se detecto un cambio, se Actualiza la vista, el Panel");
        this.repaint();
    }

    // solo se declara los componentes del panel
    @SuppressWarnings("unchecked")
    private void initComponents() {

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 642, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 337, Short.MAX_VALUE)
        );
    }

}
