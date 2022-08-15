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
    // Componentes de la ventana
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        botonGenerar = new javax.swing.JButton();
        textoCantidad = new javax.swing.JTextField();
        tituloCantidad = new javax.swing.JLabel();
        botonOrdenar = new javax.swing.JButton();
        panelInsercion = new javax.swing.JPanel();
        tablaInsercion = new javax.swing.JTextField();
        panelBurbuja = new javax.swing.JPanel();
        tablaBurbuja = new javax.swing.JTextField();
        panelQuicksort = new javax.swing.JPanel();
        tablaQuicksort = new javax.swing.JTextField();
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
        setBackground(new java.awt.Color(102, 102, 102));

        panelPrincipal.setBackground(new java.awt.Color(51, 51, 51));
        panelPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        botonGenerar.setFont(new java.awt.Font("Unispace", 0, 24)); // NOI18N
        botonGenerar.setText("Generar");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarActionPerformed(evt);
            }
        });

        tituloCantidad.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        tituloCantidad.setForeground(new java.awt.Color(255, 255, 255));
        tituloCantidad.setText("Cantidad de numeros");

        botonOrdenar.setFont(new java.awt.Font("Unispace", 0, 24)); // NOI18N
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
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tituloCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textoCantidad))
                                .addGap(46, 46, 46)
                                .addComponent(botonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                                .addGap(0, 64, Short.MAX_VALUE))
                                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(botonGenerar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(botonOrdenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );

        panelInsercion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout panelInsercionLayout = new javax.swing.GroupLayout(panelInsercion);
        panelInsercion.setLayout(panelInsercionLayout);
        panelInsercionLayout.setHorizontalGroup(
                panelInsercionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInsercionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tablaInsercion, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelInsercionLayout.setVerticalGroup(
                panelInsercionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInsercionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tablaInsercion, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addContainerGap())
        );

        panelBurbuja.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout panelBurbujaLayout = new javax.swing.GroupLayout(panelBurbuja);
        panelBurbuja.setLayout(panelBurbujaLayout);
        panelBurbujaLayout.setHorizontalGroup(
                panelBurbujaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBurbujaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tablaBurbuja, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelBurbujaLayout.setVerticalGroup(
                panelBurbujaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBurbujaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tablaBurbuja)
                                .addContainerGap())
        );

        panelQuicksort.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        panelQuicksort.setToolTipText("");

        javax.swing.GroupLayout panelQuicksortLayout = new javax.swing.GroupLayout(panelQuicksort);
        panelQuicksort.setLayout(panelQuicksortLayout);
        panelQuicksortLayout.setHorizontalGroup(
                panelQuicksortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelQuicksortLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tablaQuicksort, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelQuicksortLayout.setVerticalGroup(
                panelQuicksortLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelQuicksortLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tablaQuicksort, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addContainerGap())
        );

        tituloInsercion.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        tituloInsercion.setText("Insercion");

        tituloBurbuja.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        tituloBurbuja.setText("Burbuja");

        tituloQuicksort.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        tituloQuicksort.setText("QuickSort");

        tablaDetalle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        tablaDetalle.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jScrollPane4.setViewportView(tablaDetalle);

        tituloDetalles.setFont(new java.awt.Font("Unispace", 0, 24)); // NOI18N
        tituloDetalles.setText("Ver a detalle");

        botonInsercion.setFont(new java.awt.Font("Unispace", 0, 10)); // NOI18N
        botonInsercion.setText("Insercion a detallle");
        botonInsercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsercionActionPerformed(evt);
            }
        });

        botonBurbuja.setFont(new java.awt.Font("Unispace", 0, 10)); // NOI18N
        botonBurbuja.setText("Burbuja a detalle");
        botonBurbuja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBurbujaActionPerformed(evt);
            }
        });

        botonQuicksort.setFont(new java.awt.Font("Unispace", 0, 10)); // NOI18N
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
                                                .addComponent(panelBurbuja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(panelQuicksort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(tituloInsercion)
                                .addGap(209, 209, 209)
                                .addComponent(tituloBurbuja)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tituloQuicksort)
                                .addGap(95, 95, 95))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(botonInsercion)
                                                .addGap(157, 157, 157)
                                                .addComponent(botonBurbuja, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(193, 193, 193)
                                                .addComponent(botonQuicksort))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(369, 369, 369)
                                                .addComponent(tituloDetalles)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tituloInsercion)
                                        .addComponent(tituloBurbuja)
                                        .addComponent(tituloQuicksort))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelQuicksort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelBurbuja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelInsercion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonInsercion)
                                        .addComponent(botonBurbuja)
                                        .addComponent(botonQuicksort))
                                .addGap(13, 13, 13)
                                .addComponent(tituloDetalles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }
// fin de componentes de la ventana

    // Metodo de generador de los 3 arreglos con numeros aleatorios
    private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {
        logger.debug("Comienza el metodo y se empieza a grabar el tiempo");
        logger.info("Se asigna la cantidad maxima en el arreglo");
        long tiempoInicio = System.nanoTime();
        String cantidadSinRevisar = textoCantidad.getText();
        int cantidad;
        Random r = new Random();

        // se revisa que todos los caracteres sean solo numeros

        if (cantidadSinRevisar.matches("[0-9]+")) {
            cantidad = Integer.parseInt(cantidadSinRevisar);
            logger.debug("se obtiene la cantidad de numeros a realizar solo si son numeros");
        } else {
            JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
            logger.error("en esta seccion se da la condicion de solo usar numeros por lo cual el metodo se cierra ");
            return;
        }

        // se revisa que la cantidad de numeros no sea mayor a 1.000.000

        if (cantidad > 1000000) {
            JOptionPane.showMessageDialog(null, "la cantidad no puede ser mayor a 1.000.000");
            logger.error("en esta seccion solo se permite la cantidad maxima de 1.000.000 de numeros por lo cual el metodo se cierra ");
            return;
        }

        // se procede a colocar el tamaño del arreglo principal

        this.numerosPrincipal = new int[cantidad];
        logger.debug("se obtiene la cantidad de numeros a realizar definitiva");
        logger.debug("Se empieza a rellenar el arreglo de numeros generados aleatoriamente");

        // se genera en cada espacio del arreglo un numero aleatorio

        for (int i = 0; i < numerosPrincipal.length; i++) {
            numerosPrincipal[i] = (int) (r.nextDouble() * 100000);
        }

        // se procede a obtener del arreglo principal el tamaño de los 3 sub arreglos de cada modo de ordenamiento

        int insercion = 0;
        int burbuja = 0;
        int quicksort = 0;
        logger.debug("se obtiene la cantidad de numeros por arreglo especifico a realizar");
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
        logger.debug("se especifica la cantidad de cada arreglo");
        this.numerosInsercion = new int[insercion];
        logger.debug("Cantidad insercion: " + insercion);
        this.numerosBurbuja = new int[burbuja];
        logger.debug("Cantidad burbuja: " + burbuja);
        this.numerosQuicksort = new int[quicksort];
        logger.debug("Cantidad quicksort: " + quicksort);
        logger.debug("se empieza a rellenar cada arreglo con sus respectivos numeros");
        logger.debug("se rellena el arreglo de Insercion por espacios vacios");

        // se procede a rellenar cada arreglo con su debida condicion, ocupando los espacios vacios
        //Arreglo de insercion

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

        // Arreglo de burbuja

        logger.debug("se rellena el arreglo de Burbuja por espacios vacios");
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

        //Arreglo de Quicksort, se pone la condicion de no superar los 60.000 para no caer en un StackOverFlow

        if (numerosPrincipal.length > 60000) {
            logger.debug("el arreglo supera el limite por lo que se omite el rellenado del arreglo quicksort");
        } else {
            logger.debug("se rellena el arreglo de quicksort por espacios vacios");
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
        }

        //Se crean los strings que obtendran los datos de cada arreglo para mostrarlos en los cuadros de texto

        logger.debug("se empieza a crear los strings que se mostraran en los Texts");
        StringBuilder auxInsercion = new StringBuilder();
        StringBuilder auxBurbuja = new StringBuilder();
        StringBuilder auxQuicksort = new StringBuilder();
        String espacio = " - ";

        //Arreglo de insercion, burbuja y quicksort con su condicion

        logger.debug("se juntan los numeros a mostrar de insercion");
        for (int i = 0; i < numerosInsercion.length; i++) {
            auxInsercion.append(numerosInsercion[i] + espacio);
        }
        logger.debug("se juntan los numeros a mostrar de Burbuja");
        for (int i = 0; i < numerosBurbuja.length; i++) {
            auxBurbuja.append(numerosBurbuja[i] + espacio);
        }
        logger.debug("se verifica la cantidad de numeros, Quicksort entra en Stackoverflow caso superior a los 60.000");
        if (numerosPrincipal.length > 60000) {
            logger.debug("la cantidad de numeros supera el limite por lo que se omite el traspaso de numeros de quicksort");
            auxQuicksort = new StringBuilder("Este arreglo no puede completarse");
        } else {
            logger.debug("se juntan los numeros a mostrar de Quicksort");
            for (int i = 0; i < numerosQuicksort.length; i++) {
                auxQuicksort.append(numerosQuicksort[i] + espacio);
            }
        }

        // se rellenan a los cuadros

        logger.debug("se rellena cada tabla con sus debidos numeros");
        logger.debug("se rellena tabla insercion");
        this.tablaInsercion.setText(String.valueOf(auxInsercion));
        logger.debug("se rellena tabla burbuja");
        this.tablaBurbuja.setText(String.valueOf(auxBurbuja));
        logger.debug("se rellena tabla quicksort");
        this.tablaQuicksort.setText(String.valueOf(auxQuicksort));
        long tiempoFinal = System.nanoTime();
        long tiempoTotal = tiempoFinal - tiempoInicio;
        logger.debug("se calcula el tiempo y se muestra al operador");
        JOptionPane.showMessageDialog(null, "El Sistema tardo " + tiempoTotal / 1000000 + " milisegundo en Generar");
    }

    // Metodo de Ordenamiento de los arreglos
    private void botonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {
        logger.debug("se empieza a calcular el tiempo que tomara el metodo");
        long tiempoInicio = System.nanoTime();
        Ordenar ordenador = new Ordenar();

        //Se procede a utilizar la clase ordenador, llamando a los metodos para que ordenen con cada forma de ordenamiento

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

        // Se vuelve a generar un nuevo texto para que contenga los numeros del arreglo ordenado

        StringBuilder auxInsercion = new StringBuilder();
        StringBuilder auxBurbuja = new StringBuilder();
        StringBuilder auxQuicksort = new StringBuilder();
        String espacio = " - ";


        logger.debug("se juntanlos numeros a mostrar de insercion ordenados");
        for (int i = 0; i < numerosInsercion.length; i++) {
            auxInsercion.append(numerosInsercion[i] + espacio);
        }
        logger.debug("se juntan los numeros a mostrar de burbuja ordenados");
        for (int i = 0; i < numerosBurbuja.length; i++) {
            auxBurbuja.append(numerosBurbuja[i] + espacio);
        }
        logger.debug("se juntan los numeros a mostrar de Quicksort ordenados");
        for (int i = 0; i < numerosQuicksort.length; i++) {
            auxQuicksort.append(numerosQuicksort[i] + espacio);
        }
        if (numerosPrincipal.length > 60000) {
            auxQuicksort = new StringBuilder("Este arreglo no puede completarse");
        }

        //Se vuelve a rellenar los cuadros con sus debidos numeros

        logger.debug("se rellena cada tabla con sus debidos numeros");
        logger.debug("se rellena tabla insercion");
        this.tablaInsercion.setText(String.valueOf(auxInsercion));
        logger.debug("se rellena tabla burbuja");
        this.tablaBurbuja.setText(String.valueOf(auxBurbuja));
        logger.debug("se rellena tabla quicksort");
        this.tablaQuicksort.setText(String.valueOf(auxQuicksort));


        long tiempoFinal = System.nanoTime();
        long tiempoTotal = tiempoFinal - tiempoInicio;
        logger.debug("se calcula el tiempo y se muestra al operador");
        JOptionPane.showMessageDialog(null, "El Sistema tardo " + tiempoTotal / 1000000 + " milisegundo en ordenar");

    }

    private void botonInsercionActionPerformed(java.awt.event.ActionEvent evt) {
        long tiempoInicio = System.nanoTime();

        this.tablaDetalle.setText(this.tablaInsercion.getText());
        logger.debug("se muestran los resultados en detalle de insercion");

        long tiempoFinal = System.nanoTime();
        long tiempoTotal = tiempoFinal - tiempoInicio;
        logger.debug("se calcula el tiempo y se muestra al operador");
        JOptionPane.showMessageDialog(null, "El Sistema tardo " + tiempoTotal / 1000000 + " milisegundo en dar detalle");
    }

    private void botonBurbujaActionPerformed(java.awt.event.ActionEvent evt) {
        long tiempoInicio = System.nanoTime();

        this.tablaDetalle.setText(this.tablaBurbuja.getText());
        logger.debug("se muestran los resultados en detalle de burbuja");

        long tiempoFinal = System.nanoTime();
        long tiempoTotal = tiempoFinal - tiempoInicio;
        logger.debug("se calcula el tiempo y se muestra al operador");
        JOptionPane.showMessageDialog(null, "El Sistema tardo " + tiempoTotal / 1000000 + " milisegundo en dar detalle");
    }

    private void botonQuicksortActionPerformed(java.awt.event.ActionEvent evt) {
        long tiempoInicio = System.nanoTime();

        if (numerosPrincipal.length > 60000) {
            this.tablaDetalle.setText("Este arreglo no puede completarse por ser superior a 60.000 la cantidad de numeros");
        } else {
            this.tablaDetalle.setText(this.tablaQuicksort.getText());
        }
        logger.debug("se muestran los resultados en detalle de quicksort");

        long tiempoFinal = System.nanoTime();
        long tiempoTotal = tiempoFinal - tiempoInicio;
        logger.debug("se calcula el tiempo y se muestra al operador");
        JOptionPane.showMessageDialog(null, "El Sistema tardo " + tiempoTotal / 1000000 + " milisegundo en dar detalle");
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panelBurbuja;
    private javax.swing.JPanel panelInsercion;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelQuicksort;
    private javax.swing.JTextField tablaBurbuja;
    private javax.swing.JTextPane tablaDetalle;
    private javax.swing.JTextField tablaInsercion;
    private javax.swing.JTextField tablaQuicksort;
    private javax.swing.JTextField textoCantidad;
    private javax.swing.JLabel tituloBurbuja;
    private javax.swing.JLabel tituloCantidad;
    private javax.swing.JLabel tituloDetalles;
    private javax.swing.JLabel tituloInsercion;
    private javax.swing.JLabel tituloQuicksort;

}
