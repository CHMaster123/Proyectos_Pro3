package nur.p3.qa;

import nur.p3.grafos.GrafoCompleto;
import nur.p3.listas.Lista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrafoCompletoTest {
    @Test
    void construirGrafoCompletoCon2Nodos() {
        GrafoCompleto<String> g = new GrafoCompleto<>();
        g.anadirNodo("A", "Nodo A");
        g.anadirNodo("B", "Nodo B");
        g.conectar("A", "B");

        String resultado = g.toString();

        Assertions.assertEquals("A-1->B\n", resultado);
    }

    @Test
    void construirGrafoCompletoCon2ComponentesConexas() {
        GrafoCompleto<String> g = new GrafoCompleto<>();
        g.anadirNodo("1","1");
        g.anadirNodo("2","2");
        g.anadirNodo("3","3");
        g.anadirNodo("4","4");
        g.anadirNodo("5","5");
        g.anadirNodo("6","6");
        g.anadirNodo("7","7");
        g.anadirNodo("8","8");
        g.anadirNodo("9","9");
        g.anadirNodo("10","10");
        g.anadirNodo("11","11");
        g.anadirNodo("12","12");
        g.anadirNodo("13","13");
        g.anadirNodo("14","14");
        g.anadirNodo("15","15");
        g.anadirNodo("16","16");
        g.anadirNodo("17","17");
        g.anadirNodo("18","18");
        g.anadirNodo("19","19");
        g.anadirNodo("20","20");
        g.anadirNodo("21","21");
        g.anadirNodo("22","22");
        g.anadirNodo("23","23");
        g.anadirNodo("24","24");
        g.anadirNodo("25","25");
        g.anadirNodo("26","26");
        g.anadirNodo("27","27");
        g.anadirNodo("28","28");
        g.anadirNodo("29","29");
        g.anadirNodo("30","30");
        g.anadirNodo("31","31");
        g.anadirNodo("32","32");
        g.anadirNodo("33","33");
        g.anadirNodo("34","34");
        g.anadirNodo("35","35");
        g.anadirNodo("36","36");
        g.anadirNodo("37","37");
        g.anadirNodo("38","38");
        g.anadirNodo("39","39");
        g.anadirNodo("40","40");

        g.conectar("1","2",2,true);
        g.conectar("2","3",4,true);
        g.conectar("3","4",2,true);
        g.conectar("4","5",6,true);
        g.conectar("5","6",10,true);
        g.conectar("6","7",2,true);
        g.conectar("7","8",15,true);
        g.conectar("8","9",8,true);
        g.conectar("9","10",10,true);
        g.conectar("1","11",4,true);
        g.conectar("11","12",2,true);
        g.conectar("2","12",2,true);
        g.conectar("12","13",2,true);
        g.conectar("3","13",2,true);
        g.conectar("13","14",2,true);
        g.conectar("4","14",2,true);
        g.conectar("14","15",2,true);
        g.conectar("5","15",2,true);
        g.conectar("15","16",2,true);
        g.conectar("6","16",2,true);
        g.conectar("16","17",2,true);
        g.conectar("7","17",2,true);
        g.conectar("17","18",2,true);
        g.conectar("8","18",2,true);
        g.conectar("18","19",2,true);
        g.conectar("9","19",2,true);
        g.conectar("19","20",2,true);
        g.conectar("10","20",2,true);
        g.conectar("11","21",2,true);
        g.conectar("21","22",2,true);
        g.conectar("12","22",2,true);
        g.conectar("22","23",2,true);
        g.conectar("13","23",2,true);
        g.conectar("23","24",2,true);
        g.conectar("14","24",2,true);
        g.conectar("24","25",2,true);
        g.conectar("15","25",2,true);
        g.conectar("25","26",2,true);
        g.conectar("16","26",2,true);
        g.conectar("26","27",2,true);
        g.conectar("17","27",2,true);
        g.conectar("27","28",2,true);
        g.conectar("18","28",2,true);
        g.conectar("28","29",2,true);
        g.conectar("19","29",2,true);
        g.conectar("29","30",2,true);
        g.conectar("20","30",2,true);
        g.conectar("21","31",2,true);
        g.conectar("31","32",2,true);
        g.conectar("22","32",2,true);
        g.conectar("32","33",2,true);
        g.conectar("23","33",2,true);
        g.conectar("33","34",2,true);
        g.conectar("24","34",2,true);
        g.conectar("34","35",2,true);
        g.conectar("25","35",2,true);
        g.conectar("35","36",2,true);
        g.conectar("26","36",2,true);
        g.conectar("36","37",2,true);
        g.conectar("27","37",2,true);
        g.conectar("37","38",2,true);
        g.conectar("28","38",2,true);
        g.conectar("38","39",2,true);
        g.conectar("29","39",2,true);
        g.conectar("39","40",2,true);
        g.conectar("30","40",2,true);


        String resultado = g.toString();

        Assertions.assertEquals("A-1->I\nB-1->U\nR-3->X\nS-1->R\nX-5->B\nX-2->U\nI-4->A\nM-3->S\nM-2->B\nM-1->U\nM-1->X\n", resultado);
    }

    @Test
    void dijkstraGrafoCompleto() {
        GrafoCompleto<String> g = new GrafoCompleto<>();
        g.anadirNodo("A", "Nodo A");
        g.anadirNodo("B", "Nodo B");
        g.anadirNodo("C", "Nodo C");
        g.anadirNodo("D", "Nodo D");
        g.anadirNodo("E", "Nodo E");
        g.anadirNodo("F", "Nodo F");
        g.anadirNodo("G", "Nodo G");

        g.conectar("A", "B", 8, true);
        g.conectar("A", "C", 5, true);
        g.conectar("B", "D", 3, true);
        g.conectar("B", "E", 8, true);
        g.conectar("C", "D", 7, true);
        g.conectar("C", "F", 10, true);
        g.conectar("D", "E", 4, true);
        g.conectar("D", "F", 3, true);
        g.conectar("E", "G", 6, true);
        g.conectar("F", "G", 6, true);

        String resultado = g.toString();

        Lista<String> camino = g.dijkstra("A", "G");

        Assertions.assertEquals("A -> B -> D -> F -> G", camino.toString());
    }
}
