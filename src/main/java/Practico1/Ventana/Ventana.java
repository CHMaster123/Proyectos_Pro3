package Practico1.Ventana;

import javax.swing.*;

public class Ventana extends JFrame {

    private JButton botonGenerar;
    private JButton botonOrdenar;
    private JLabel numerosBurbuja;
    private JLabel numerosInsercion;
    private JLabel numerosQuicksort;
    private JPanel panelBurbuja;
    private JPanel panelInsercion;
    private JPanel panelPrincipal;
    private JPanel panelQuicksort;
    private JTextField textoCantidad;
    private JLabel textoTiempo;
    private JLabel tituloBurbuja;
    private JLabel tituloCantidad;
    private JLabel tituloInsercion;
    private JLabel tituloQuicksort;
    private JLabel tituloTiempo;
    public Ventana(){

    componentes();

    }
    public void componentes(){
        panelPrincipal = new JPanel();
        botonGenerar = new JButton();
        textoCantidad = new JTextField();
        tituloCantidad = new JLabel();
        botonOrdenar = new JButton();
        tituloTiempo = new JLabel();
        textoTiempo = new JLabel();
        panelInsercion = new JPanel();
        numerosInsercion = new JLabel();
        panelBurbuja = new JPanel();
        numerosBurbuja = new JLabel();
        panelQuicksort = new JPanel();
        numerosQuicksort = new JLabel();
        tituloInsercion = new JLabel();
        tituloBurbuja = new JLabel();
        tituloQuicksort = new JLabel();


    }

}
