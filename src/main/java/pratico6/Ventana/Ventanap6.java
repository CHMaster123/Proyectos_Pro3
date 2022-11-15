package pratico6.Ventana;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico4.objetos.Cuadrado;
import practico5.graficos.DibujoArbol;
import practico5.lista_arbol.Arbol;
import pratico6.Grafia.Tablero;
import pratico6.Lista_con_grafos.GrafoCompleto;
import pratico6.Lista_con_grafos.Listap6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;


public class Ventanap6 extends JFrame {
    protected static final Logger logger = LogManager.getLogger();
    private Panelp6 panel;


    public Ventanap6() {
        logger.debug("Se generan todos los componentes de la ventana y el panel");
        Tablero modelo = new Tablero();
        this.panel= new Panelp6(modelo);
       initComponents();
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventanap6().setVisible(true);
            }
        });
    }
    private void botonCaminoActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.textoInicio.getText().matches("\\d+") && this.textoFinal.getText().matches("\\d+")) {
            int tamañoinicio = Integer.parseInt(this.textoInicio.getText());
            int tamañofinal = Integer.parseInt(this.textoFinal.getText());
            if (tamañoinicio <= 40 && tamañoinicio >=1 && tamañofinal <= 40 && tamañofinal >=1) {
                logger.debug("Se genera un camino aleatorio desde el nodo "+ tamañoinicio + " hasta el nodo " + tamañofinal);
                this.panel.djikstra(String.valueOf(tamañoinicio), String.valueOf(tamañofinal));
            } else {
                JOptionPane.showMessageDialog(null, "Porfavor elija un numero del 1 al 40 con el nodo correspondiente");
                logger.debug("Solo se puede elegir un numero del 1 al 40");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
            logger.error("en esta seccion se da la condicion de solo usar numeros por lo cual el metodo se cierra ");
            return;
        }
    }

    private void botonTerremotoActionPerformed(ActionEvent evt) {
        panel.getModelo().terremoto();
    }



    @SuppressWarnings("unchecked")
    private void initComponents() {
        grupoFiguras = new javax.swing.ButtonGroup();
        grupoTransformaciones = new javax.swing.ButtonGroup();
        panelOpciones = new javax.swing.JPanel();
        botonCamino = new javax.swing.JButton();
        textoInicio = new javax.swing.JTextField();
        botonTerremoto = new javax.swing.JButton();
        textoFinal = new javax.swing.JTextField();
        tituloFinal = new javax.swing.JLabel();
        tituloInicio = new javax.swing.JLabel();
        LineaSeparadora = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoLOGS = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelOpciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        panelOpciones.setPreferredSize(new java.awt.Dimension(1200, 100));

        botonCamino.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        botonCamino.setText("Cambiar Camino");
        botonCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCaminoActionPerformed(evt);
            }
        });

        botonTerremoto.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        botonTerremoto.setText("Terremoto");
        botonTerremoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerremotoActionPerformed(evt);
            }
        });

        tituloFinal.setFont(new java.awt.Font("Unispace", 0, 24)); // NOI18N
        tituloFinal.setText("FINAL");

        tituloInicio.setFont(new java.awt.Font("Unispace", 0, 24)); // NOI18N
        tituloInicio.setText("INICIO");

        LineaSeparadora.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
                panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(botonCamino, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(tituloInicio)
                                .addGap(36, 36, 36)
                                .addComponent(textoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                                .addComponent(tituloFinal)
                                .addGap(42, 42, 42)
                                .addComponent(textoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addComponent(LineaSeparadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(botonTerremoto, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
        );
        panelOpcionesLayout.setVerticalGroup(
                panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonCamino, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tituloInicio)
                                        .addComponent(textoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tituloFinal)
                                        .addComponent(textoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonTerremoto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(LineaSeparadora)
        );

        textoLOGS.setColumns(20);
        textoLOGS.setRows(5);
        jScrollPane1.setViewportView(textoLOGS);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 1315, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                                .addContainerGap())
        );
        this.getContentPane().add(panel);
        this.panel.setBounds(3, 102, 1000, 680);
        pack();
    }



    private javax.swing.JSeparator LineaSeparadora;
    private javax.swing.JButton botonCamino;
    private javax.swing.JButton botonTerremoto;
    private javax.swing.ButtonGroup grupoFiguras;
    private javax.swing.ButtonGroup grupoTransformaciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTextField textoFinal;
    private javax.swing.JTextField textoInicio;
    private javax.swing.JTextArea textoLOGS;
    private javax.swing.JLabel tituloFinal;
    private javax.swing.JLabel tituloInicio;

}