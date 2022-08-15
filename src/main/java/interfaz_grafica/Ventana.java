/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz_grafica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * @author crist
 */
public class Ventana extends javax.swing.JFrame {
    protected static final Logger logger = LogManager.getLogger();

    int[] numerosPrincipal;
    int[] numerosInsercion;
    int[] numerosBurbuja;
    int[] numerosQuicksort;

    public Ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        botonGenerar = new javax.swing.JButton();
        textoCantidad = new javax.swing.JTextField();
        tituloCantidad = new javax.swing.JLabel();
        botonOrdenar = new javax.swing.JButton();
        panelInsercion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInsercion = new javax.swing.JTextArea();
        panelBurbuja = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBurbuja = new javax.swing.JTextArea();
        panelQuicksort = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaQuicksort = new javax.swing.JTextArea();
        tituloInsercion = new javax.swing.JLabel();
        tituloBurbuja = new javax.swing.JLabel();
        tituloQuicksort = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTextPane();
        tituloDetalles = new javax.swing.JLabel();
        botonInsercion = new javax.swing.JButton();
        botonBurbuja = new javax.swing.JButton();
        botonQuicksort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        botonGenerar.setText("Generar");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarActionPerformed(evt);
            }
        });

        tituloCantidad.setText("Cantidad de numeros");

        botonOrdenar.setText("Ordenar");
        botonOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOrdenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
                panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tituloCantidad)
                                        .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(botonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(botonOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
        );
        panelPrincipalLayout.setVerticalGroup(
                panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(tituloCantidad)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 39, Short.MAX_VALUE))
                                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(botonOrdenar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(botonGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );

        panelInsercion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaInsercion.setColumns(20);
        tablaInsercion.setRows(5);
        jScrollPane2.setViewportView(tablaInsercion);

        javax.swing.GroupLayout panelInsercionLayout = new javax.swing.GroupLayout(panelInsercion);
        panelInsercion.setLayout(panelInsercionLayout);
        panelInsercionLayout.setHorizontalGroup(
                panelInsercionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInsercionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelInsercionLayout.setVerticalGroup(
                panelInsercionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInsercionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)
                                .addContainerGap())
        );

        panelBurbuja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaBurbuja.setColumns(20);
        tablaBurbuja.setRows(5);
        jScrollPane1.setViewportView(tablaBurbuja);

        javax.swing.GroupLayout panelBurbujaLayout = new javax.swing.GroupLayout(panelBurbuja);
        panelBurbuja.setLayout(panelBurbujaLayout);
        panelBurbujaLayout.setHorizontalGroup(
                panelBurbujaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBurbujaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );
        panelBurbujaLayout.setVerticalGroup(
                panelBurbujaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBurbujaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                .addContainerGap())
        );

        panelQuicksort.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaQuicksort.setColumns(20);
        tablaQuicksort.setRows(5);
        jScrollPane3.setViewportView(tablaQuicksort);

        javax.swing.GroupLayout panelQuicksortLayout = new javax.swing.GroupLayout(panelQuicksort);
        panelQuicksort.setLayout(panelQuicksortLayout);
        panelQuicksortLayout.setHorizontalGroup(
                panelQuicksortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelQuicksortLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelQuicksortLayout.setVerticalGroup(
                panelQuicksortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuicksortLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3)
                                .addContainerGap())
        );

        tituloInsercion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tituloInsercion.setText("Insercion");

        tituloBurbuja.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tituloBurbuja.setText("Burbuja");

        tituloQuicksort.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tituloQuicksort.setText("QuickSort");

        tablaDetalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaDetalle.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jScrollPane4.setViewportView(tablaDetalle);

        tituloDetalles.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        tituloDetalles.setText("Ver a detalle");

        botonInsercion.setText("Insercion a detallle");
        botonInsercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsercionActionPerformed(evt);
            }
        });

        botonBurbuja.setText("Burbuja a detalle");
        botonBurbuja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBurbujaActionPerformed(evt);
            }
        });

        botonQuicksort.setText("Quicksort a detalle");
        botonQuicksort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuicksortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(panelInsercion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(panelBurbuja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(panelQuicksort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(tituloInsercion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tituloBurbuja)
                                .addGap(190, 190, 190)
                                .addComponent(tituloQuicksort)
                                .addGap(112, 112, 112))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(botonInsercion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(tituloDetalles)
                                                .addGap(346, 346, 346))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(botonBurbuja)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botonQuicksort)
                                                .addGap(66, 66, 66))))
        );
        logger.debug("Se genera todos los paneles, Botones y titulos de la aplicacion");
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tituloInsercion)
                                        .addComponent(tituloBurbuja)
                                        .addComponent(tituloQuicksort))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelBurbuja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelQuicksort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelInsercion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonInsercion)
                                        .addComponent(botonBurbuja)
                                        .addComponent(botonQuicksort))
                                .addGap(8, 8, 8)
                                .addComponent(tituloDetalles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        this.logger.debug("Se genero toda la interfaz grafica");
        pack();
    }

    private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {
        logger.debug("Comienza el metodo y se empieza a grabar el tiempo");
        logger.info("Se asigna la cantidad maxima en el arreglo");
        long tiempoInicio = System.nanoTime();
        String cantidadSinRevisar = textoCantidad.getText();
        int cantidad;
        Random r = new Random();
        if (cantidadSinRevisar.matches("[0-9]+")) {
            cantidad = Integer.parseInt(cantidadSinRevisar);
            logger.debug("se obtiene la cantidad de numeros a realizar");
        } else {
            JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
            logger.error("en esta seccion solo se permite usar numeros por lo cual el metodo se cierra ");
            return;
        }
        if (cantidad > 1000000) {
            JOptionPane.showMessageDialog(null, "la cantidad no puede ser mayor a 1.000.000");
            logger.error("en esta seccion solo se permite la cantidad maxima de 1.000.000 de numeros por lo cual el metodo se cierra ");
            return;
        }
        this.numerosPrincipal = new int[cantidad];
        logger.debug("se obtiene la cantidad de numeros a realizar definitiva");
        logger.debug("Se empieza a rellenar el arreglo de numeros generados aleatoriamente");
        for (int i = 0; i < numerosPrincipal.length; i++) {
            numerosPrincipal[i] = (int) (r.nextDouble() * 100000);

        }

        int insercion = 0;
        int burbuja = 0;
        int quicksort = 0;
        logger.debug("se obtiene la cantidad de numeros por arreglo a realizar");
        for (int i = 0; i < numerosPrincipal.length; i++) {
            if (numerosPrincipal[i] <= 33000) {
                insercion++;
            }
            if (numerosPrincipal[i] >= 33001 && numerosPrincipal[i] <= 66000) {
                burbuja++;
            }
            if (numerosPrincipal[i] >= 66001) {
                quicksort++;
            }
        }

        this.numerosInsercion = new int[insercion];
        this.numerosBurbuja = new int[burbuja];
        this.numerosQuicksort = new int[quicksort];
        logger.debug("se empieza a rellenar cada arreglo con sus respectivos numeros");
        logger.debug("se rellena el arrelo de insercion");
        for (int i = 0; i < numerosPrincipal.length; i++) {
            if (numerosPrincipal[i] <= 33000) {
                for (int j = 0; j < numerosInsercion.length; j++) {
                    if (numerosInsercion[j] == 0) {
                        numerosInsercion[j] = numerosPrincipal[i];
                        break;
                    }
                }
            }
        }
        logger.debug("se rellena el arreglo de Burbuja");
        for (int i = 0; i < numerosPrincipal.length; i++) {
            if (numerosPrincipal[i] >= 33001 && numerosPrincipal[i] <= 66000) {
                for (int j = 0; j < numerosBurbuja.length; j++) {
                    if (numerosBurbuja[j] == 0) {
                        numerosBurbuja[j] = numerosPrincipal[i];
                        break;
                    }
                }
            }
        }
        logger.debug("se rellena el arreglo de quicksort");
        for (int i = 0; i < numerosPrincipal.length; i++) {
            if (numerosPrincipal[i] >= 66001) {
                for (int j = 0; j < numerosQuicksort.length; j++) {
                    if (numerosQuicksort[j] == 0) {
                        numerosQuicksort[j] = numerosPrincipal[i];
                        break;
                    }
                }
            }
        }
        logger.debug("se empieza a crear los strings que se mostraran en los Texts");
        StringBuilder auxInsercion = new StringBuilder();
        StringBuilder auxBurbuja = new StringBuilder();
        StringBuilder auxQuicksort = new StringBuilder();
        String espacio = " - ";
        logger.debug("se rellena los numeros a mostrar de insercion");
        for (int i = 0; i < numerosInsercion.length; i++) {
            auxInsercion.append(numerosInsercion[i] + espacio);
        }
        logger.debug("se rellena los numeros a mostrar de Burbuja");
        for (int i = 0; i < numerosBurbuja.length; i++) {
            auxBurbuja.append(numerosBurbuja[i] + espacio);
        }
        logger.debug("se rellena los numeros a mostrar de Quicksort");
        for (int i = 0; i < numerosQuicksort.length; i++) {
            auxQuicksort.append(numerosQuicksort[i] + espacio);
        }
        logger.debug("IF super importante, Quicksort entra en Stackoverflow caso superior a los 60.000");
        if (numerosPrincipal.length > 60000) {
            auxQuicksort = new StringBuilder("Este arreglo no puede completarse");
        }
        logger.debug("se rellena cada tabla con sus debidos numeros");
        this.tablaInsercion.setText(String.valueOf(auxInsercion));
        this.tablaBurbuja.setText(String.valueOf(auxBurbuja));
        this.tablaQuicksort.setText(String.valueOf(auxQuicksort));
        long tiempoFinal = System.nanoTime();
        long tiempoTotal = tiempoFinal - tiempoInicio;
        logger.debug("se calcula el tiempo y se muestra al operador");
        JOptionPane.showMessageDialog(null, "El Sistema tardo " + tiempoTotal / 1000000 + " milisegundo en Generar");
    }

    private void botonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOrdenarActionPerformed
        logger.debug("se empieza a calcular el tiempo que tomara el metodo");
        long tiempoInicio = System.nanoTime();
        Ordenar ordenador = new Ordenar();
        logger.debug("Se ordena por modo insercion");
        ordenador.ordenarInsercion(this.numerosInsercion);
        logger.debug("Se ordena por modo Burbuja");
        ordenador.ordenarBurbuja(this.numerosBurbuja);
        if (numerosPrincipal.length <= 60000) {
            logger.debug("Se ordena por modo Quicksort");
            ordenador.ordenarQuicksort(this.numerosQuicksort);
        } else {
            JOptionPane.showMessageDialog(null, "El ordenamiento por Quicksort solo puede ordenar un maximo de 60.000, Por lo que no se ordenara este arreglo");
        }
        StringBuilder auxInsercion = new StringBuilder();
        StringBuilder auxBurbuja = new StringBuilder();
        StringBuilder auxQuicksort = new StringBuilder();
        String espacio = " - ";
        logger.debug("se rellena los numeros a mostrar de insercion ordenados");
        for (int i = 0; i < numerosInsercion.length; i++) {
            auxInsercion.append(numerosInsercion[i] + espacio);
        }
        logger.debug("se rellena los numeros a mostrar de burbuja ordenados");
        for (int i = 0; i < numerosBurbuja.length; i++) {
            auxBurbuja.append(numerosBurbuja[i] + espacio);
        }
        logger.debug("se rellena los numeros a mostrar de Quicksort ordenados");
        for (int i = 0; i < numerosQuicksort.length; i++) {
            auxQuicksort.append(numerosQuicksort[i] + espacio);
        }
        if (numerosPrincipal.length > 60000) {
            auxQuicksort = new StringBuilder("Este arreglo no puede completarse");
        }
        logger.debug("se rellena cada tabla con sus debidos numeros");
        this.tablaInsercion.setText(String.valueOf(auxInsercion));
        this.tablaBurbuja.setText(String.valueOf(auxBurbuja));
        this.tablaQuicksort.setText(String.valueOf(auxQuicksort));


        long tiempoFinal = System.nanoTime();
        long tiempoTotal = tiempoFinal - tiempoInicio;
        logger.debug("se calcula el tiempo y se muestra al operador");
        JOptionPane.showMessageDialog(null, "El Sistema tardo " + tiempoTotal / 1000000 + " milisegundo en ordenar");

    }

    private void botonInsercionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsercionActionPerformed
        StringBuilder auxInsercion = new StringBuilder();
        String espacio = " - ";
        for (int i = 0; i < numerosInsercion.length; i++) {
            auxInsercion.append(numerosInsercion[i] + espacio);
        }
        logger.debug("se muestran los resultados en detalle");
        this.tablaDetalle.setText(String.valueOf(auxInsercion));
    }

    private void botonBurbujaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBurbujaActionPerformed
        StringBuilder auxBurbuja = new StringBuilder();
        String espacio = " - ";
        for (int i = 0; i < numerosInsercion.length; i++) {
            auxBurbuja.append(numerosInsercion[i] + espacio);
        }
        logger.debug("se muestran los resultados en detalle");
        this.tablaDetalle.setText(String.valueOf(auxBurbuja));
    }

    private void botonQuicksortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuicksortActionPerformed
        StringBuilder auxQuicksort = new StringBuilder();
        String espacio = " - ";
        for (int i = 0; i < numerosInsercion.length; i++) {
            auxQuicksort.append(numerosInsercion[i] + espacio);
        }
        if (numerosPrincipal.length > 60000) {
            auxQuicksort = new StringBuilder("Este arreglo no puede completarse");
        }
        logger.debug("se muestran los resultados en detalle");
        this.tablaDetalle.setText(String.valueOf(auxQuicksort));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }


    private javax.swing.JButton botonBurbuja;
    private javax.swing.JButton botonGenerar;
    private javax.swing.JButton botonInsercion;
    private javax.swing.JButton botonOrdenar;
    private javax.swing.JButton botonQuicksort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panelBurbuja;
    private javax.swing.JPanel panelInsercion;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelQuicksort;
    private javax.swing.JTextArea tablaBurbuja;
    private javax.swing.JTextPane tablaDetalle;
    private javax.swing.JTextArea tablaInsercion;
    private javax.swing.JTextArea tablaQuicksort;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JLabel tituloBurbuja;
    private javax.swing.JLabel tituloCantidad;
    private javax.swing.JLabel tituloDetalles;
    private javax.swing.JLabel tituloInsercion;
    private javax.swing.JLabel tituloQuicksort;

}
