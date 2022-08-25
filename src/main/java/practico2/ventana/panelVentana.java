/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico2.ventana;

import practico2.recurrencia.Recurrencia;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author crist
 */
public class panelVentana extends JPanel implements PropertyChangeListener {

    private Recurrencia objeto;
    private static final long serialVersionUID = 1L;
    public panelVentana(Recurrencia objeto) {
        this.objeto=objeto;
        objeto.listenerAñadir(this);
        initComponents();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (objeto != null){
            objeto.dibujar(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }
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
