/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico2.ventana;

import practico2.recurrencia.Recurrencia;

import javax.swing.*;

/**
 *
 * @author crist
 */
public class Ventana extends JFrame {
    private static final long serialVersionUID = 1L;
    private panelVentana panel;
    private Recurrencia modelo;
    public Ventana() {
        this.setTitle("Recurrencia con cuadraditos");
        this.modelo = new Recurrencia(2);
       this.initComponents();
       this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        NotaPanel = new javax.swing.JPanel();
        botonEmpezarRecurrencia = new javax.swing.JButton();
        profundidadTexto = new javax.swing.JTextField();
        tituloProfundidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NotaPanel.setBackground(new java.awt.Color(153, 153, 153));
        NotaPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        NotaPanel.setPreferredSize(new java.awt.Dimension(875, 82));

        botonEmpezarRecurrencia.setFont(new java.awt.Font("Unispace", 0, 24)); // NOI18N
        botonEmpezarRecurrencia.setText("EMPEZAR RECURRENCIA");
        botonEmpezarRecurrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmpezarRecurrenciaActionPerformed(evt);
            }
        });

        tituloProfundidad.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        tituloProfundidad.setText("Profundidad de la recurrencia");

        javax.swing.GroupLayout NotaPanelLayout = new javax.swing.GroupLayout(NotaPanel);
        NotaPanel.setLayout(NotaPanelLayout);
        NotaPanelLayout.setHorizontalGroup(
            NotaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NotaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NotaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloProfundidad)
                    .addGroup(NotaPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(profundidadTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonEmpezarRecurrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        NotaPanelLayout.setVerticalGroup(
            NotaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloProfundidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profundidadTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(NotaPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(botonEmpezarRecurrencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NotaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NotaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        panel = new panelVentana(modelo);
        this.getContentPane().add(panel);
        this.panel.setBounds(2, 92, 900, 300);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEmpezarRecurrenciaActionPerformed(java.awt.event.ActionEvent evt) {
       JOptionPane.showMessageDialog(null,"Se empieza a graficar la recurrencia con la profundidad de "+ this.profundidadTexto.getText());
       modelo.setProfundidad(Integer.parseInt((this.profundidadTexto.getText())));
       modelo.cambioDetectado();
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }


    private javax.swing.JPanel NotaPanel;
    private javax.swing.JButton botonEmpezarRecurrencia;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField profundidadTexto;
    private javax.swing.JLabel tituloProfundidad;

}
