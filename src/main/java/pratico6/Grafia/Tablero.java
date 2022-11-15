package pratico6.Grafia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pratico6.Lista_con_grafos.GrafoCompleto;
import pratico6.Lista_con_grafos.Listap6;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Tablero {
    private GrafoCompleto modelo;
    private Listap6<String> camino;
    private Random numero = new Random();
    private GraficoTablero dibujador;
    private PropertyChangeSupport observado;
    protected static final Logger logger = LogManager.getLogger();

    public void setCamino(Listap6<String> camino) {
        this.camino = camino;
    }

    public GrafoCompleto getModelo() {
        return modelo;
    }

    public void setModelo(GrafoCompleto modelo) {
        this.modelo = modelo;
    }



    public Tablero(){
        observado = new PropertyChangeSupport(this);
         modelo = new GrafoCompleto();
         inicializarGrafo();
        dibujador = new GraficoTablero<>(modelo, this.camino);
    }
    public void addListener(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    public void cambio() {
        observado.firePropertyChange("Tabla", false, true);
    }


    private void inicializarGrafo() {
        modelo.anadirNodo("1","1");
        modelo.anadirNodo("2","2");
        modelo.anadirNodo("3","3");
        modelo.anadirNodo("4","4");
        modelo.anadirNodo("5","5");
        modelo.anadirNodo("6","6");
        modelo.anadirNodo("7","7");
        modelo.anadirNodo("8","8");
        modelo.anadirNodo("9","9");
        modelo.anadirNodo("10","10");
        modelo.anadirNodo("11","11");
        modelo.anadirNodo("12","12");
        modelo.anadirNodo("13","13");
        modelo.anadirNodo("14","14");
        modelo.anadirNodo("15","15");
        modelo.anadirNodo("16","16");
        modelo.anadirNodo("17","17");
        modelo.anadirNodo("18","18");
        modelo.anadirNodo("19","19");
        modelo.anadirNodo("20","20");
        modelo.anadirNodo("21","21");
        modelo.anadirNodo("22","22");
        modelo.anadirNodo("23","23");
        modelo.anadirNodo("24","24");
        modelo.anadirNodo("25","25");
        modelo.anadirNodo("26","26");
        modelo.anadirNodo("27","27");
        modelo.anadirNodo("28","28");
        modelo.anadirNodo("29","29");
        modelo.anadirNodo("30","30");
        modelo.anadirNodo("31","31");
        modelo.anadirNodo("32","32");
        modelo.anadirNodo("33","33");
        modelo.anadirNodo("34","34");
        modelo.anadirNodo("35","35");
        modelo.anadirNodo("36","36");
        modelo.anadirNodo("37","37");
        modelo.anadirNodo("38","38");
        modelo.anadirNodo("39","39");
        modelo.anadirNodo("40","40");

        modelo.conectar("1","2", 5,true);
        modelo.conectar("1","11",5,true);
        modelo.conectar("2","3",5,true);
        modelo.conectar("2","12",5,true);
        modelo.conectar("3","4",5,true);
        modelo.conectar("3","13",5,true);
        modelo.conectar("4","5",5,true);
        modelo.conectar("4","14",5,true);
        modelo.conectar("5","6",5,true);
        modelo.conectar("5","15",5,true);
        modelo.conectar("6","7",5,true);
        modelo.conectar("6","16",5,true);
        modelo.conectar("7","8",5,true);
        modelo.conectar("7","17",5,true);
        modelo.conectar("8","9",5,true);
        modelo.conectar("8","18",5,true);
        modelo.conectar("9","10",5,true);
        modelo.conectar("9","19",5,true);
        modelo.conectar("10","20",5,true);
        modelo.conectar("11","12",5,true);
        modelo.conectar("11","21",5,true);
        modelo.conectar("12","13",5,true);
        modelo.conectar("12","22",5,true);
        modelo.conectar("13","14",5,true);
        modelo.conectar("13","23",5,true);
        modelo.conectar("14","15",5,true);
        modelo.conectar("14","24",5,true);
        modelo.conectar("15","16",5,true);
        modelo.conectar("15","25",5,true);
        modelo.conectar("16","17",5,true);
        modelo.conectar("16","26",5,true);
        modelo.conectar("17","18",5,true);
        modelo.conectar("17","27",5,true);
        modelo.conectar("18","19",5,true);
        modelo.conectar("18","28",5,true);
        modelo.conectar("19","20",5,true);
        modelo.conectar("19","29",5,true);
        modelo.conectar("20","30",5,true);
        modelo.conectar("21","22",5,true);
        modelo.conectar("21","31",5,true);
        modelo.conectar("22","23",5,true);
        modelo.conectar("22","32",5,true);
        modelo.conectar("23","24",5,true);
        modelo.conectar("23","33",5,true);
        modelo.conectar("24","25",5,true);
        modelo.conectar("24","34",5,true);
        modelo.conectar("25","26",5,true);
        modelo.conectar("25","35",5,true);
        modelo.conectar("26","27",5,true);
        modelo.conectar("26","36",5,true);
        modelo.conectar("27","28",5,true);
        modelo.conectar("27","37",5,true);
        modelo.conectar("28","29",5,true);
        modelo.conectar("28","38",5,true);
        modelo.conectar("29","30",5,true);
        modelo.conectar("29","39",5,true);
        modelo.conectar("30","40",5,true);
        modelo.conectar("31","32",5,true);
        modelo.conectar("32","33",5,true);
        modelo.conectar("33","34",5,true);
        modelo.conectar("34","35",5,true);
        modelo.conectar("35","36",5,true);
        modelo.conectar("36","37",5,true);
        modelo.conectar("37","38",5,true);
        modelo.conectar("38","39",5,true);
        modelo.conectar("39","40",5,true);

        this.camino = modelo.dijkstra("1", "40");
    }
    private void inicializarGrafoTerremoto() {
        modelo.anadirNodo("1","1");
        modelo.anadirNodo("2","2");
        modelo.anadirNodo("3","3");
        modelo.anadirNodo("4","4");
        modelo.anadirNodo("5","5");
        modelo.anadirNodo("6","6");
        modelo.anadirNodo("7","7");
        modelo.anadirNodo("8","8");
        modelo.anadirNodo("9","9");
        modelo.anadirNodo("10","10");
        modelo.anadirNodo("11","11");
        modelo.anadirNodo("12","12");
        modelo.anadirNodo("13","13");
        modelo.anadirNodo("14","14");
        modelo.anadirNodo("15","15");
        modelo.anadirNodo("16","16");
        modelo.anadirNodo("17","17");
        modelo.anadirNodo("18","18");
        modelo.anadirNodo("19","19");
        modelo.anadirNodo("20","20");
        modelo.anadirNodo("21","21");
        modelo.anadirNodo("22","22");
        modelo.anadirNodo("23","23");
        modelo.anadirNodo("24","24");
        modelo.anadirNodo("25","25");
        modelo.anadirNodo("26","26");
        modelo.anadirNodo("27","27");
        modelo.anadirNodo("28","28");
        modelo.anadirNodo("29","29");
        modelo.anadirNodo("30","30");
        modelo.anadirNodo("31","31");
        modelo.anadirNodo("32","32");
        modelo.anadirNodo("33","33");
        modelo.anadirNodo("34","34");
        modelo.anadirNodo("35","35");
        modelo.anadirNodo("36","36");
        modelo.anadirNodo("37","37");
        modelo.anadirNodo("38","38");
        modelo.anadirNodo("39","39");
        modelo.anadirNodo("40","40");


        int i = 5;
        modelo.conectar("1","2", (int) (numero.nextDouble()* i),true);
        modelo.conectar("1","11", (int) (numero.nextDouble()* i),true);
        modelo.conectar("2","3", (int) (numero.nextDouble()* i),true);
        modelo.conectar("2","12", (int) (numero.nextDouble()* i),true);
        modelo.conectar("3","4", (int) (numero.nextDouble()* i),true);
        modelo.conectar("3","13", (int) (numero.nextDouble()* i),true);
        modelo.conectar("4","5", (int) (numero.nextDouble()* i),true);
        modelo.conectar("4","14", (int) (numero.nextDouble()* i),true);
        modelo.conectar("5","6", (int) (numero.nextDouble()* i),true);
        modelo.conectar("5","15", (int) (numero.nextDouble()* i),true);
        modelo.conectar("6","7", (int) (numero.nextDouble()* i),true);
        modelo.conectar("6","16", (int) (numero.nextDouble()* i),true);
        modelo.conectar("7","8", (int) (numero.nextDouble()* i),true);
        modelo.conectar("7","17", (int) (numero.nextDouble()* i),true);
        modelo.conectar("8","9", (int) (numero.nextDouble()* i),true);
        modelo.conectar("8","18", (int) (numero.nextDouble()* i),true);
        modelo.conectar("9","10", (int) (numero.nextDouble()* i),true);
        modelo.conectar("9","19", (int) (numero.nextDouble()* i),true);
        modelo.conectar("10","20", (int) (numero.nextDouble()* i),true);
        modelo.conectar("11","12", (int) (numero.nextDouble()* i),true);
        modelo.conectar("11","21", (int) (numero.nextDouble()* i),true);
        modelo.conectar("12","13", (int) (numero.nextDouble()* i),true);
        modelo.conectar("12","22", (int) (numero.nextDouble()* i),true);
        modelo.conectar("13","14", (int) (numero.nextDouble()* i),true);
        modelo.conectar("13","23", (int) (numero.nextDouble()* i),true);
        modelo.conectar("14","15", (int) (numero.nextDouble()* i),true);
        modelo.conectar("14","24", (int) (numero.nextDouble()* i),true);
        modelo.conectar("15","16", (int) (numero.nextDouble()* i),true);
        modelo.conectar("15","25", (int) (numero.nextDouble()* i),true);
        modelo.conectar("16","17", (int) (numero.nextDouble()* i),true);
        modelo.conectar("16","26", (int) (numero.nextDouble()* i),true);
        modelo.conectar("17","18", (int) (numero.nextDouble()* i),true);
        modelo.conectar("17","27", (int) (numero.nextDouble()* i),true);
        modelo.conectar("18","19", (int) (numero.nextDouble()* i),true);
        modelo.conectar("18","28", (int) (numero.nextDouble()* i),true);
        modelo.conectar("19","20", (int) (numero.nextDouble()* i),true);
        modelo.conectar("19","29", (int) (numero.nextDouble()* i),true);
        modelo.conectar("20","30", (int) (numero.nextDouble()* i),true);
        modelo.conectar("21","22", (int) (numero.nextDouble()* i),true);
        modelo.conectar("21","31", (int) (numero.nextDouble()* i),true);
        modelo.conectar("22","23", (int) (numero.nextDouble()* i),true);
        modelo.conectar("22","32", (int) (numero.nextDouble()* i),true);
        modelo.conectar("23","24", (int) (numero.nextDouble()* i),true);
        modelo.conectar("23","33", (int) (numero.nextDouble()* i),true);
        modelo.conectar("24","25", (int) (numero.nextDouble()* i),true);
        modelo.conectar("24","34", (int) (numero.nextDouble()* i),true);
        modelo.conectar("25","26", (int) (numero.nextDouble()* i),true);
        modelo.conectar("25","35", (int) (numero.nextDouble()* i),true);
        modelo.conectar("26","27", (int) (numero.nextDouble()* i),true);
        modelo.conectar("26","36", (int) (numero.nextDouble()* i),true);
        modelo.conectar("27","28", (int) (numero.nextDouble()* i),true);
        modelo.conectar("27","37", (int) (numero.nextDouble()* i),true);
        modelo.conectar("28","29", (int) (numero.nextDouble()* i),true);
        modelo.conectar("28","38", (int) (numero.nextDouble()* i),true);
        modelo.conectar("29","30", (int) (numero.nextDouble()* i),true);
        modelo.conectar("29","39", (int) (numero.nextDouble()* i),true);
        modelo.conectar("30","40", (int) (numero.nextDouble()* i),true);
        modelo.conectar("31","32", (int) (numero.nextDouble()* i),true);
        modelo.conectar("32","33", (int) (numero.nextDouble()* i),true);
        modelo.conectar("33","34", (int) (numero.nextDouble()* i),true);
        modelo.conectar("34","35", (int) (numero.nextDouble()* i),true);
        modelo.conectar("35","36", (int) (numero.nextDouble()* i),true);
        modelo.conectar("36","37", (int) (numero.nextDouble()* i),true);
        modelo.conectar("37","38", (int) (numero.nextDouble()* i),true);
        modelo.conectar("38","39", (int) (numero.nextDouble()*i),true);
        modelo.conectar("39","40", (int) (numero.nextDouble()*i),true);

        this.camino = modelo.dijkstra("1", "40");
    }

    public void dibujar(int i, int i1, Graphics g) {
        dibujador.dibujar(i, i1, g);
    }
    public void actualizarCamino() {
        dibujador.actualizarCamino(this.camino);
    }

    public void terremoto() {
        modelo = new GrafoCompleto();
        inicializarGrafoTerremoto();
        dibujador = new GraficoTablero<>(modelo, this.camino);
        cambio();
    }
}
