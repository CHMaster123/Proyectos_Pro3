package practico5.ventana;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico5.graficos.DibujoArbol;
import practico5.lista_arbol.Arbol;
import practico5.lista_arbol.Lista;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ventanap5 extends javax.swing.JFrame {
    protected static final Logger logger = LogManager.getLogger();
    private Panelp5 panel;
    private Lista<String> links=new Lista<>();
    private Arbol<String> arbolnuevo= new Arbol<>();
    private int tamano=0;


    public Ventanap5() {
        logger.debug("Se generan todos los componentes de la ventana y el panel");
        DibujoArbol<String> modelo= inicializarArbol();
        this.panel= new Panelp5(modelo);
       initComponents();
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventanap5().setVisible(true);
            }
        });
    }
    private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if (!this.textoLinkweb.getText().matches("^https?:\\/\\/[\\w\\-]+(\\.[\\w\\-]+)+[/#?]?.*$"))
        {
            JOptionPane.showMessageDialog(null,"El link introducido no es compatible");
            logger.debug("No se dio un link correcto");
            return;
        }
        tamano = 0;
       this.arbolnuevo.anadir(this.textoLinkweb.getText(),""+tamano,null);
        logger.debug("Se genera la raiz del arbol con contenido" + this.textoLinkweb.getText());
       tamano++;
        String links = extraerEnlaces(this.arbolnuevo.getRaiz().getContenido());
        logger.debug("se extraen el codigo fuente del nodo : "+ arbolnuevo.getRaiz().getIdentificador());
        this.links = separarlinksNuevo(links);
        logger.debug("se separan los links vigentes");
        for (int i = 0; i < this.links.getTamano(); i++) {
            this.arbolnuevo.anadir(this.links.get(i),""+tamano,""+0);
            logger.debug("Se añade el link : " + this.links.get(i));
            tamano++;
        }
        this.panel.getModelo().setModelo(this.arbolnuevo);
        this.panel.repaint();
        logger.debug("Se repinta el Panel");
        this.areaContenido.setText(this.arbolnuevo.toString());
        System.out.println(this.links.get(0));
    }
    private void botonProtocoloActionPerformed(java.awt.event.ActionEvent evt) {
        if (arbolnuevo.getRaiz().buscar(this.textoIdentificador.getText())==null){
            JOptionPane.showMessageDialog(null,"No se encontro el Identificador");
            logger.error("No existe ningun nodo con el identificador "+ this.textoIdentificador.getText());
            return;
        }
        Arbol.Nodo<String> contenido = arbolnuevo.getRaiz().buscar(this.textoIdentificador.getText());
        logger.debug("se obtiene el nodo "+ contenido.getIdentificador());
        this.areaContenido.setText(contenido.getContenido());
    }


    private void botonExtenderArbolActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if (arbolnuevo.getRaiz().buscar(this.textoIdentificador.getText())==null){
            JOptionPane.showMessageDialog(null,"No se encontro el nodo a ampliar");
            logger.error("No existe el nodo con identificador "+this.textoIdentificador.getText());
            return;
        }
        Arbol.Nodo<String> nuevolink= arbolnuevo.getRaiz().buscar(this.textoIdentificador.getText());
        logger.debug("Se obtiene el nodo con identificador "+ nuevolink.getIdentificador());
        String contenidolink= nuevolink.getContenido();
        logger.debug("se extraen el codigo fuente del nodo : "+ arbolnuevo.getRaiz().getIdentificador());
        String links = extraerEnlaces(contenidolink);
        logger.debug("se separan los links vigentes");
        this.links = separarlinksNuevo(links);
        for (int i = 0; i < this.links.getTamano(); i++) {
            this.arbolnuevo.anadir(this.links.get(i),""+tamano,nuevolink.getIdentificador());
            tamano++;
        }
        this.panel.getModelo().setModelo(this.arbolnuevo);
        this.panel.repaint();
        logger.debug("se repinta el panel");
        this.areaContenido.setText(this.arbolnuevo.toString());
    }
    private void botonContenidoActionPerformed(java.awt.event.ActionEvent evt) {
        if (arbolnuevo.getRaiz().buscar(this.textoIdentificador.getText())==null)
        {
            JOptionPane.showMessageDialog(null,"No se encontro el nodo");
            logger.error("No existe el nodo con identificador "+this.textoIdentificador.getText());
            return;
        }
        Arbol.Nodo<String> contenido = arbolnuevo.getRaiz().buscar(this.textoIdentificador.getText());
        this.areaContenido.setText(contenido.toString());
    }
    public String obtenerTitulo(String Link){
        String url = Link;
        URL objUrl = null;
        try {
            objUrl = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        String server = objUrl.getHost();
        logger.debug("se obtiene el titulo del link : "+server);
    return server;
    }
    private Lista<String> separarlinksNuevo(String contenido) {
        Pattern pattern = Pattern.compile("(?i)HREF\\s*=\\s*\"(.*?)\"");
        Matcher matcher = pattern.matcher(contenido);
        Lista<String> links = new Lista<>();
        int aux = 0;
        while (matcher.find()&& aux < 5) {
            if (matcher.group(1).matches("^https?:\\/\\/[\\w\\-]+(\\.[\\w\\-]+)+[/#?]?.*$")) {
                links.adicionar(matcher.group(1));
                aux++;
            }
        }
        return links;
    }
    private static String extraerEnlaces(String urlString)
            throws MalformedURLException, IOException {
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String content = "";
        String linea = br.readLine();
        while (null != linea) {
            content += linea;
            linea = br.readLine();
        }
        logger.debug("se obtiene el codigo fuente");
        return content;
    }
    private DibujoArbol<String> inicializarArbol() {
        Arbol<String> a = new Arbol<>();
        a.anadir("A", "ARBOL", null);
        a.anadir("B", "DE", "ARBOL");
        a.anadir("C", "PRUEBA", "ARBOL");
        a.anadir("D", "IGNORAME", "ARBOL");
        a.anadir("E", "TALVEZ", "DE");
        a.anadir("F", "SANDIA", "DE");
        a.anadir("G", "MESSIRVE", "DE");
        a.anadir("H", "SI QUIERES", "IGNORAME");
        a.anadir("I", "QUE PAJA", "IGNORAME");
        a.anadir("J", "POR FIN", "SI QUIERES");
        a.anadir("K", "SALIO", "SI QUIERES");

        DibujoArbol<String> resultado = new DibujoArbol<>(a);
        return resultado;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        panelOpciones = new javax.swing.JPanel();
        botonGenerar = new javax.swing.JButton();
        textoLinkweb = new javax.swing.JTextField();
        tituloLinkweb = new javax.swing.JLabel();
        botonExtenderArbol = new javax.swing.JButton();
        textoIdentificador = new javax.swing.JTextField();
        tituloLinkweb1 = new javax.swing.JLabel();
        botonContenido = new javax.swing.JButton();
        botonProtocolo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaContenido = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelOpciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        panelOpciones.setPreferredSize(new java.awt.Dimension(1200, 100));

        botonGenerar.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        botonGenerar.setText("Generar Arbol");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    botonGenerarActionPerformed(evt);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,"El link introducido no es compatible");
                    logger.error("El link no es compatible o esta incorrecto");
                    throw new RuntimeException(e);
                }
            }
        });

        tituloLinkweb.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        tituloLinkweb.setText("Pagina web");

        botonExtenderArbol.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        botonExtenderArbol.setText("Extender Arbol");
        botonExtenderArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    botonExtenderArbolActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        tituloLinkweb1.setFont(new java.awt.Font("Unispace", 0, 11)); // NOI18N
        tituloLinkweb1.setText("Identificador de nodo");

        botonContenido.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        botonContenido.setText("Contenido");
        botonContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContenidoActionPerformed(evt);
            }
        });

        botonProtocolo.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        botonProtocolo.setText("Protocolo");
        botonProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProtocoloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
                panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(botonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(textoLinkweb, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(tituloLinkweb)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(botonExtenderArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tituloLinkweb1)
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(textoIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(botonContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(botonProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelOpcionesLayout.setVerticalGroup(
                panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(tituloLinkweb)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textoLinkweb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(botonGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(botonExtenderArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(tituloLinkweb1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textoIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelOpcionesLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(botonContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(botonProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        areaContenido.setColumns(20);
        areaContenido.setRows(5);
        jScrollPane1.setViewportView(areaContenido);

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



    private javax.swing.JTextArea areaContenido;
    private javax.swing.JButton botonContenido;
    private javax.swing.JButton botonExtenderArbol;
    private javax.swing.JButton botonGenerar;
    private javax.swing.JButton botonProtocolo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTextField textoIdentificador;
    private javax.swing.JTextField textoLinkweb;
    private javax.swing.JLabel tituloLinkweb;
    private javax.swing.JLabel tituloLinkweb1;

}