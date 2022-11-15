package pratico6.Grafia;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pratico6.Interfaces.IDibujarp6;
import pratico6.Lista_con_grafos.GrafoCompleto;
import pratico6.Lista_con_grafos.Listap6;

import java.awt.*;
import java.util.HashMap;

public class GraficoTablero<E> implements IDibujarp6 {

    protected static final Logger logger = LogManager.getLogger();
    private GrafoCompleto<E> modelo;
    private DibujoNodoTablero<E> raiz;

    public GrafoCompleto<E> getModelo() {
        return modelo;
    }

    public GraficoTablero(GrafoCompleto<E> src, Listap6<String> camino) {
        modelo = src;
        this.raiz = new DibujoNodoTablero<E>(modelo.getNodos(),camino);
    }
    @Override
    public void dibujar(int x, int y, Graphics g) {
      raiz.dibujar(x, y, g);
      logger.debug("Dibujando el tablero");
    }

    static class DibujoNodoTablero<E> {
        private HashMap<String, GrafoCompleto.Nodo<E>> modelo;
        private Listap6<String> camino;

        public Listap6<String> getCamino() {
            return camino;
        }

        public void setCamino(Listap6<String> camino) {
            this.camino = camino;
        }

        protected static final Logger logger = LogManager.getLogger();
        public DibujoNodoTablero(HashMap<String, GrafoCompleto.Nodo<E>> src, Listap6<String> camino) {
            this.modelo = src;
            this.camino = camino;
        }

        public void dibujar(int x, int y, Graphics g) {
            dibujarNodo(modelo, x, y, g);
        }

        private void dibujarNodo(HashMap<String, GrafoCompleto.Nodo<E>> Vnodo, int x, int y, Graphics g) {
            int AuxInicioX;
            int AuxFinalX;
            int AuxInicioY = y+50;
            int AuxFinalY;
            int Auxpeso= 0;
            int AuxPosicion = 1;
            for (int i = 1; i <= Vnodo.size(); i++) {
                logger.debug("Dibujando el nodo "+i);
               GrafoCompleto.Nodo<E> Nodo = Vnodo.get(String.valueOf(i));
               Listap6<GrafoCompleto.Arco<E>> Conexiones= Nodo.getSalientes();
               AuxInicioX =(Auxpeso*(AuxPosicion-1))+50;
                for (int j = 0; j < Conexiones.getTamano(); j++) {
                    GrafoCompleto.Arco<E> Arco = Conexiones.get(j);
                    Auxpeso = 5*20;
                    AuxFinalX = AuxInicioX + Auxpeso;
                    int Destino = Integer.parseInt(Arco.getHacia().getId());
                    logger.debug("Dibujando el arco "+i+"-"+j);
                    int Origen = Integer.parseInt(Arco.getDesde().getId());
                    if (Origen+1 == Destino){
                        g.drawLine(AuxInicioX, AuxInicioY, AuxFinalX, AuxInicioY);
                        g.setColor(Color.BLUE);
                        g.drawString(String.valueOf(Arco.getPeso()), (AuxInicioX+AuxFinalX)/2, AuxInicioY);
                        for (int k = 0; k < this.camino.getTamano(); k++) {
                            if (this.camino.get(k) == Nodo.getId()){
                                g.setColor(Color.RED);
                                g.fillOval(AuxInicioX-15, AuxInicioY-15, 30, 30);
                                logger.debug("Se Dibuja el nodo "+i+" en rojo por estar en el camino");
                            }else {
                                g.setColor(Color.BLACK);
                                g.drawOval(AuxInicioX-10, AuxInicioY-10, 20, 20);
                            }
                        }
                        g.setColor(Color.BLACK);
                        g.drawString(Nodo.getId(), AuxInicioX-10, AuxInicioY-10);
                    }else if (i<=30){
                        AuxFinalY = AuxInicioY + Auxpeso;
                        g.drawLine(AuxInicioX, AuxInicioY, AuxInicioX, AuxFinalY);
                        g.setColor(Color.BLACK);
                        g.drawString(Nodo.getId(), AuxInicioX-10, AuxInicioY-10);
                    }
                }
                AuxPosicion++;
                if (i == 10 || i == 20 || i == 30 || i == 40){
                    for (int k = 0; k < this.camino.getTamano(); k++) {
                        if (this.camino.get(k) == Nodo.getId()){
                            g.setColor(Color.RED);
                            g.fillOval(AuxInicioX-15, AuxInicioY-15, 30, 30);
                            logger.debug("Dibujando el nodo "+i+" en rojo por estar en el camino");
                        }else {
                            g.setColor(Color.RED);
                            g.drawOval(AuxInicioX-10, AuxInicioY-10, 20, 20);
                        }
                    }
                    AuxInicioY = AuxInicioY + Auxpeso;
                    AuxPosicion = 1;
                }
                if (i == 40){
                    g.setColor(Color.BLUE);
                    g.drawString(Nodo.getId(), AuxInicioX-10, (AuxInicioY-10)-Auxpeso);
                }
            }
        }
    }
}
