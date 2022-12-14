
package practico4.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico4.dibujo.Escena;
import practico4.interfaces.ITransformacion;
import practico4.objetos.*;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Constructor;


public class Ventana extends JFrame {
    private JTabbedPane paneles;

    protected static final Logger logger = LogManager.getLogger();
    private Panel panel;
    private Escena modelo = new Escena();
    private final String  mensaje = "Cree una escena primero";
    private final String  mensaje2 = "se necesita una escena para subir imagen";
    public Ventana() {
        logger.debug("Se generan todos los componentes de la ventana y el panel");
        initComponents();
    }
    private void botonTransformarActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.paneles.getSelectedComponent() == null){
            JOptionPane.showMessageDialog(null,mensaje);
            logger.debug("se necesita una escena");
            return;
        }
        this.panel = (Panel) this.paneles.getSelectedComponent();
        this.modelo = panel.getModelo();
        if (this.botonBlanco_y_negro.isSelected()==true){
        TransformarImagen("Blanco_Y_Negro");
            logger.debug("se transforma la imagen a blanco y negro del panel "+  panel.getNumero_de_panel());
        }

        if (this.botonAchicar.isSelected()==true){
            TransformarImagen("AchicarImagen");
            logger.debug("se achica la imagen del panel "+ panel.getNumero_de_panel());
        }
    }
    private void botonCrearEscenasActionPerformed(java.awt.event.ActionEvent evt) {
        StringBuilder nombre_de_pestaña;
        if(checkPordefecto.isSelected()){
            nombre_de_pestaña = new StringBuilder("Escena nro " + (paneles.getTabCount()+1));
        }else{
            nombre_de_pestaña = new StringBuilder(JOptionPane.showInputDialog(null, "Escriba el nombre de la Escena"));
        }

        Escena nueva_pestaña = new Escena();
        logger.debug("se crea una escena");
        Panel nuevo_panel = new Panel(nueva_pestaña);
        logger.debug("se añade a un panel");
        nuevo_panel.setNumero_de_panel((paneles.getTabCount()+1));
        this.paneles.add(String.valueOf(nombre_de_pestaña),nuevo_panel);
    }
    private void botonBorrarEscenaActionPerformed(java.awt.event.ActionEvent evt) {

        if(this.paneles.getSelectedComponent()==null){
            JOptionPane.showMessageDialog(null,"No hay escenas Seleccionadas o Disponibles");
            logger.debug("no hay escenas creadas");
            return;
        }
        this.panel = (Panel) this.paneles.getSelectedComponent();
        this.modelo = panel.getModelo();
        paneles.remove(paneles.getSelectedComponent());
        logger.debug("Se elimina el panel Numero "+ panel.getNumero_de_panel());
    }


    private void botonAñadirImagenActionPerformed(java.awt.event.ActionEvent evt) {
        if (paneles.getSelectedComponent()==null){
            JOptionPane.showMessageDialog(null,mensaje);
            logger.debug(mensaje2);
            return;
        }
        this.panel = (Panel) this.paneles.getSelectedComponent();
        this.modelo = panel.getModelo();
        logger.debug("Se sube una imagen al panel "+ panel.getNumero_de_panel());
        subirImagen();
    }

    private void botonCrearFigurasActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.paneles.getSelectedComponent() == null){
            JOptionPane.showMessageDialog(null,mensaje);
            logger.debug("se necesita una escena para crear figuras");
            return;
        }

        this.panel = (Panel) this.paneles.getSelectedComponent();
        this.modelo = panel.getModelo();
        if (this.botonCuadrado.isSelected() == true) {
            crearCuadrado();
            logger.debug("Se crea una figura de tipo Cuadrado al panel "+ panel.getNumero_de_panel());
        }
        if (this.botonLinea.isSelected() == true) {
            crearLineas();
            logger.debug("Se crea una figura de tipo linea al panel "+ panel.getNumero_de_panel());
        }
        if (this.botonCirculo.isSelected() == true) {
            crearRedondo();
            logger.debug("se crea una figura de tipo redondo al panel "+ panel.getNumero_de_panel());
        }

    }

    private void botonLetrasActionPerformed(java.awt.event.ActionEvent evt) {
        crearLetras(this.textoLetras.getText());
        logger.debug("se crean letras al panel "+ panel.getNumero_de_panel());
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    private void TransformarImagen(String transformacion) {
        ITransformacion objTransofrmacion = null;
        try {
            Class c = Class.forName("practico4.Transformaciones." + transformacion);
            Constructor constructor = c.getDeclaredConstructor();
            objTransofrmacion = (ITransformacion)constructor.newInstance();
            objTransofrmacion.transformarImagen(modelo.getImagen());
        }
        catch(Exception q) {

        }
    }
    private void crearCuadrado() {
        if (this.paneles.getSelectedComponent() == null){
            JOptionPane.showMessageDialog(null,mensaje);
            logger.debug("se necesita una escena para crear cuadrados");
            return;
        }

        this.panel = (Panel) this.paneles.getSelectedComponent();
        this.modelo = panel.getModelo();
        logger.debug("se verifica que el tamaño este en numeros");
        if (this.textoTamaño.getText().matches("\\d+")) {
            int tamaño = Integer.parseInt(this.textoTamaño.getText());
            if (tamaño <= 600 && tamaño >=1) {
                logger.debug("Se da un nuevo tamaño,se crea el cuadrado");
                Cuadrado c = new Cuadrado(200, 50, tamaño);
                c.addListener(panel);
                modelo.addFigura(c);
            } else {
                JOptionPane.showMessageDialog(null, "solo se aceptan tamaños menor/iguales a 600 y mayores de 0");
                logger.debug("solo se aceptan tamaños menor/iguales a 600 y mayores de 0");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
            logger.error("en esta seccion se da la condicion de solo usar numeros por lo cual el metodo se cierra ");
            return;
        }

    }

    private void crearRedondo() {
        if (this.paneles.getSelectedComponent() == null){
            JOptionPane.showMessageDialog(null,mensaje);
            logger.debug("se necesita una escena para crear redondos");
            return;
        }
        this.panel = (Panel) this.paneles.getSelectedComponent();
        this.modelo = panel.getModelo();
        if (this.textoTamaño.getText().matches("\\d+")) {
            int tamaño = Integer.parseInt(this.textoTamaño.getText());
            if (tamaño <= 600 && tamaño >=1) {
                logger.debug("Se da un nuevo tamaño, se crea el redondo");
                Circulo c = new Circulo(50, 50, tamaño);
                c.addListener(panel);
                modelo.addFigura(c);
            } else {
                JOptionPane.showMessageDialog(null, "solo se aceptan tamaños menor/iguales a 600 y mayores de 0");
                logger.debug("solo se aceptan tamaños menor/iguales a 600 y mayores de 0");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
            logger.error("en esta seccion se da la condicion de solo usar numeros por lo cual el metodo se cierra ");
            return;
        }

    }

    private void crearLineas() {
        if (this.paneles.getSelectedComponent() == null){
            JOptionPane.showMessageDialog(null,mensaje);
            logger.debug("se necesita una escena para crear lineas");
            return;
        }
        this.panel = (Panel) this.paneles.getSelectedComponent();
        this.modelo = panel.getModelo();
        if (this.textoTamaño.getText().matches("\\d+")) {
            int tamaño = Integer.parseInt(this.textoTamaño.getText());
            if (tamaño <= 600 && tamaño >=1) {
                logger.debug("Se da un nuevo tamaño,se crea la linea");
                Linea c = new Linea(50, 50, tamaño);
                c.addListener(panel);
                modelo.addFigura(c);
            } else {
                JOptionPane.showMessageDialog(null, "solo se aceptan tamaños menor/iguales a 600 y mayores de 0");
                logger.debug("solo se aceptan tamaños menor/iguales a 600 y mayores de 0");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se admiten numeros");
            logger.error("en esta seccion se da la condicion de solo usar numeros por lo cual el metodo se cierra ");
            return;
        }

    }

    private void crearLetras(String texto) {
        if (this.paneles.getSelectedComponent() == null){
            JOptionPane.showMessageDialog(null,mensaje);
            logger.debug(mensaje2);
            return;
        }
        this.panel = (Panel) this.paneles.getSelectedComponent();
        this.modelo = panel.getModelo();
        logger.debug("se verifica que sean solo letras");
        if (this.textoLetras.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "solo se aceptan letras");
            logger.debug("solo se aceptan letras");
            return;
        } else {
            logger.debug("Se escribe la letra en el panel");
            Letras c = new Letras(50, 50, texto);
            c.addListener(panel);
            modelo.addFigura(c);

        }
    }

    private void subirImagen() {
        if (this.paneles.getSelectedComponent() == null){
            JOptionPane.showMessageDialog(null,mensaje);
            logger.debug(mensaje2);
            return;
        }
        this.panel = (Panel) this.paneles.getSelectedComponent();
        this.modelo = panel.getModelo();
        logger.debug("Se inicia la subida de la imagen");
        String lastDir = "C:\\Users\\crist\\IdeaProjects\\Imagenes";
        JFileChooser inputFile = new JFileChooser();
        if (!lastDir.equals(""))
            inputFile.setCurrentDirectory(new File(lastDir));

        inputFile.showOpenDialog(this);

        if (inputFile.getSelectedFile() == null) {
            JOptionPane.showMessageDialog(this, "Se debe elejir una imagen");
            return;
        }


        File archivoConImagen = inputFile.getSelectedFile();
        logger.debug("Imagen Subida, Se pasa al Escenario para poder graficarla");
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
        botonLetras = new javax.swing.JButton();
        textoLetras = new javax.swing.JTextField();
        panelOpciones = new javax.swing.JPanel();
        botonAñadirImagen = new javax.swing.JButton();
        botonTransformar = new javax.swing.JButton();
        botonBlanco_y_negro = new javax.swing.JRadioButton();
        botonAchicar = new javax.swing.JRadioButton();
        botonCrearEscenas = new javax.swing.JButton();
        botonBorrarEscena = new javax.swing.JButton();
        checkPordefecto = new javax.swing.JCheckBox();

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

        botonLetras.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        botonLetras.setText("Letras");
        botonLetras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLetrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFigurasLayout = new javax.swing.GroupLayout(panelFiguras);
        panelFiguras.setLayout(panelFigurasLayout);
        panelFigurasLayout.setHorizontalGroup(
                panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFigurasLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelFigurasLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(tituloTamaño))
                                        .addGroup(panelFigurasLayout.createSequentialGroup()
                                                .addComponent(botonLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelFigurasLayout.createSequentialGroup()
                                                .addComponent(textoTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(tituloFiguras)
                                                .addGap(18, 18, 18)
                                                .addGroup(panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(botonLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botonCirculo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(panelFigurasLayout.createSequentialGroup()
                                                .addComponent(textoLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62)
                                                .addComponent(botonCuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                                .addGroup(panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(botonCuadrado)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(botonLetras)
                                                                .addComponent(textoLetras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelFigurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(botonCirculo)
                                                        .addComponent(tituloTamaño)
                                                        .addComponent(textoTamaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tituloFiguras))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botonLinea)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(botonCrearFiguras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        panelOpciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        panelOpciones.setPreferredSize(new java.awt.Dimension(1200, 100));

        botonAñadirImagen.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        botonAñadirImagen.setText("Subir imagen");
        botonAñadirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirImagenActionPerformed(evt);
            }
        });

        botonTransformar.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        botonTransformar.setText("Transformar");
        botonTransformar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTransformarActionPerformed(evt);
            }
        });

        grupoTransformaciones.add(botonBlanco_y_negro);
        botonBlanco_y_negro.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        botonBlanco_y_negro.setText("Blanco y negro");

        grupoTransformaciones.add(botonAchicar);
        botonAchicar.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        botonAchicar.setText("Achicar imagen");

        botonCrearEscenas.setFont(new java.awt.Font("Unispace", 0, 12)); // NOI18N
        botonCrearEscenas.setText("Crear Escenas");
        botonCrearEscenas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearEscenasActionPerformed(evt);
            }
        });

        botonBorrarEscena.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        botonBorrarEscena.setText("Borrar Escena Actual");
        botonBorrarEscena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarEscenaActionPerformed(evt);
            }
        });

        checkPordefecto.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        checkPordefecto.setText("Usar nombres por defecto");

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
                panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(botonAñadirImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonCrearEscenas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addComponent(botonBorrarEscena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(botonTransformar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(botonBlanco_y_negro))
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addComponent(checkPordefecto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(botonAchicar)))
                                .addGap(74, 74, 74))
        );
        panelOpcionesLayout.setVerticalGroup(
                panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(botonAñadirImagen)
                                                        .addComponent(botonBlanco_y_negro))
                                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(botonAchicar))
                                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(botonCrearEscenas))))
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(botonTransformar)
                                                        .addComponent(botonBorrarEscena))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(checkPordefecto)))
                                .addContainerGap(8, Short.MAX_VALUE))
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
                                .addGap(0, 694, Short.MAX_VALUE))
        );
        this.panel = new Panel(modelo);
        this.paneles = new JTabbedPane();
        this.getContentPane().add(paneles);
        this.paneles.setBounds(3, 102, 1214, 690);
        pack();
    }

    private javax.swing.JRadioButton botonAchicar;
    private javax.swing.JButton botonAñadirImagen;
    private javax.swing.JRadioButton botonBlanco_y_negro;
    private javax.swing.JButton botonBorrarEscena;
    private javax.swing.JRadioButton botonCirculo;
    private javax.swing.JButton botonCrearEscenas;
    private javax.swing.JButton botonCrearFiguras;
    private javax.swing.JRadioButton botonCuadrado;
    private javax.swing.JButton botonLetras;
    private javax.swing.JRadioButton botonLinea;
    private javax.swing.JButton botonTransformar;
    private javax.swing.JCheckBox checkPordefecto;
    private javax.swing.ButtonGroup grupoFiguras;
    private javax.swing.ButtonGroup grupoTransformaciones;
    private javax.swing.JPanel panelFiguras;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTextField textoLetras;
    private javax.swing.JTextField textoTamaño;
    private javax.swing.JLabel tituloFiguras;
    private javax.swing.JLabel tituloTamaño;

}
