
package practico3.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico2.ventana.panelVentana;
import practico3.dibujo.Escena;
import practico3.interfaces.IDibujo;
import practico3.objetos.Cuadrado;
import practico3.objetos.Letras;
import practico3.objetos.Linea;
import practico3.objetos.Redondo;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Constructor;

public class Ventana extends javax.swing.JFrame {

    private Escena modelo = new Escena();
    private Panel panel;
    protected static final Logger logger = LogManager.getLogger();




    public Ventana() {
        initComponents();
    }

    private void botonAñadirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirImagenActionPerformed
        subirImagen();
    }

    private void botonCrearFigurasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearFigurasActionPerformed
        if (this.botonCuadrado.isSelected() == true) {
            crearCuadrado();
        }
        if (this.botonLinea.isSelected() == true) {
            crearLineas();
        }
        if (this.botonCirculo.isSelected() == true) {
            crearRedondo();
        }
    }

    private void botonLetrasActionPerformed(java.awt.event.ActionEvent evt) {
        crearLetras(this.textoLetras.getText());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

  /*
    private void mnuTranformacion_X(String transformacion) {
        ITransformacion objTransofrmacion = null;
        try {
            Class c = Class.forName("nur.p3.imagenes.transformaciones." + transformacion);
            Constructor constructor = c.getDeclaredConstructor();
            objTransofrmacion = (ITransformacion)constructor.newInstance();
            objTransofrmacion.transformar(modelo.getImagen());
        }
        catch(Exception q) {

        }
    }
    */

    private void crearCuadrado() {
        if (this.textoTamaño.getText().matches("\\d+")) {
            int tamaño = Integer.parseInt(this.textoTamaño.getText());
            if (tamaño <= 300) {
                logger.debug("Se da un nuevo tamaño, el controlador avisa de que hay cambios");
                Cuadrado c = new Cuadrado(50, 50, tamaño);
                c.addListener(panel);
                modelo.addCuadrado(c);
            } else {
                JOptionPane.showMessageDialog(null, "solo se aceptan tamaños menor/iguales a 100");
                logger.debug("solo se aceptan tamaños menor/iguales a 100");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
            logger.error("en esta seccion se da la condicion de solo usar numeros por lo cual el metodo se cierra ");
            return;
        }

    }

    private void crearRedondo() {
        if (this.textoTamaño.getText().matches("\\d+")) {
            int tamaño = Integer.parseInt(this.textoTamaño.getText());
            if (tamaño <= 300) {
                logger.debug("Se da un nuevo tamaño, el controlador avisa de que hay cambios");
                Redondo c = new Redondo(50, 50, tamaño);
                c.addListener(panel);
                modelo.addRedondo(c);
            } else {
                JOptionPane.showMessageDialog(null, "solo se aceptan tamaños menor/iguales a 100");
                logger.debug("solo se aceptan tamaños menor/iguales a 100");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
            logger.error("en esta seccion se da la condicion de solo usar numeros por lo cual el metodo se cierra ");
            return;
        }

    }

    private void crearLineas() {
        if (this.textoTamaño.getText().matches("\\d+")) {
            int tamaño = Integer.parseInt(this.textoTamaño.getText());
            if (tamaño <= 300) {
                logger.debug("Se da un nuevo tamaño, el controlador avisa de que hay cambios");
                Linea c = new Linea(50, 50, tamaño);
                c.addListener(panel);
                modelo.addLineas(c);
            } else {
                JOptionPane.showMessageDialog(null, "solo se aceptan tamaños menor/iguales a 100");
                logger.debug("solo se aceptan tamaños menor/iguales a 100");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
            logger.error("en esta seccion se da la condicion de solo usar numeros por lo cual el metodo se cierra ");
            return;
        }

    }

    private void crearLetras(String texto) {
        if (this.textoLetras.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "solo se aceptan letras");
            logger.debug("solo se aceptan letras");
            return;
        } else {
            logger.debug("Se escribe la letra en el panel");

            Letras c = new Letras(50, 50, texto);
            c.addListener(panel);
            modelo.addLetras(c);

        }
    }

    private void subirImagen() {
        String lastDir = "C:\\Users\\crist\\IdeaProjects\\Imagenes";
        JFileChooser inputFile = new JFileChooser();
        if (!lastDir.equals(""))
            inputFile.setCurrentDirectory(new File(lastDir));

        inputFile.showOpenDialog(this);

        if (inputFile.getSelectedFile() == null) {
            JOptionPane.showMessageDialog(this, "You must choose an image");
            return;
        }


        File archivoConImagen = inputFile.getSelectedFile();
        modelo.getImagen().cargarImagen(archivoConImagen);
    }

    private void initComponents() {


        grupoFiguras = new javax.swing.ButtonGroup();
        grupoTransformaciones = new javax.swing.ButtonGroup();
        panelFiguras = new javax.swing.JPanel();
        textoTamaño = new javax.swing.JTextField();
        botonLinea = new javax.swing.JRadioButton();
        botonCuadrado = new javax.swing.JRadioButton();
        botonCirculo = new javax.swing.JRadioButton();
        tituloTamaño = new javax.swing.JLabel();
        tituloFiguras = new javax.swing.JLabel();
        botonCrearFiguras = new javax.swing.JButton();
        panelOpciones = new javax.swing.JPanel();
        botonAñadirImagen = new javax.swing.JButton();
        botonLetras = new javax.swing.JButton();
        textoLetras = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFiguras.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        panelFiguras.setPreferredSize(new java.awt.Dimension(1200, 100));

        grupoFiguras.add(botonLinea);
        botonLinea.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        botonLinea.setText("Linea");

        grupoFiguras.add(botonCuadrado);
        botonCuadrado.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        botonCuadrado.setText("Cuadrado");

        grupoFiguras.add(botonCirculo);
        botonCirculo.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        botonCirculo.setText("Circulo");

        tituloTamaño.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        tituloTamaño.setText("Tamaño de Figuras");

        tituloFiguras.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        tituloFiguras.setText("Tipo de figuras");

        botonCrearFiguras.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        botonCrearFiguras.setText("Crear Figura");
        botonCrearFiguras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearFigurasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFigurasLayout = new javax.swing.GroupLayout(panelFiguras);
        panelFiguras.setLayout(panelFigurasLayout);
        panelFigurasLayout.setHorizontalGroup(
                panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFigurasLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFigurasLayout.createSequentialGroup()
                                                .addComponent(tituloTamaño)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textoTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(tituloFiguras)
                                                .addGap(18, 18, 18)
                                                .addGroup(panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(botonLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botonCirculo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(botonCuadrado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonCrearFiguras, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166))
        );
        panelFigurasLayout.setVerticalGroup(
                panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFigurasLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelFigurasLayout.createSequentialGroup()
                                                .addComponent(botonCuadrado)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(botonCirculo)
                                                        .addComponent(tituloTamaño)
                                                        .addComponent(textoTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tituloFiguras))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botonLinea)
                                                .addGap(0, 2, Short.MAX_VALUE))
                                        .addComponent(botonCrearFiguras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        panelOpciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        panelOpciones.setPreferredSize(new java.awt.Dimension(1200, 100));

        botonAñadirImagen.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        botonAñadirImagen.setText("Seleccionar Imagen");
        botonAñadirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirImagenActionPerformed(evt);
            }
        });

        botonLetras.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        botonLetras.setText("Letras");
        botonLetras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLetrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
                panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(botonAñadirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(botonLetras)
                                .addGap(18, 18, 18)
                                .addComponent(textoLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelOpcionesLayout.setVerticalGroup(
                panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonAñadirImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                        .addComponent(botonLetras)
                                        .addComponent(textoLetras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelFiguras, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelFiguras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 700, Short.MAX_VALUE))
        );
        this.panel = new Panel(modelo);
        this.getContentPane().add(panel);
        this.panel.setBounds(3, 102, 1214, 690);
        pack();
    }

    private javax.swing.JButton botonAñadirImagen;
    private javax.swing.JRadioButton botonCirculo;
    private javax.swing.JButton botonCrearFiguras;
    private javax.swing.JRadioButton botonCuadrado;
    private javax.swing.JButton botonLetras;
    private javax.swing.JRadioButton botonLinea;
    private javax.swing.ButtonGroup grupoFiguras;
    private javax.swing.ButtonGroup grupoTransformaciones;
    private javax.swing.JPanel panelFiguras;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTextField textoLetras;
    private javax.swing.JTextField textoTamaño;
    private javax.swing.JLabel tituloFiguras;
    private javax.swing.JLabel tituloTamaño;


}
