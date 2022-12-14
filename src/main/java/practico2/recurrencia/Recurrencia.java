package practico2.recurrencia;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Recurrencia implements InterfaceDibujo {
    private int profundidad;
    private PropertyChangeSupport objeto;
    private Random ramdom = new Random();
    private int pos = 0;
    private int[] colores = new int[8];

    protected static final Logger logger = LogManager.getLogger();

    //Constructor de Recurrencia, se le da la profundidad y se declara que este sera el objeto a observar
    public Recurrencia(int profundidad) {
        logger.debug("se crea la clase recurrencia con su profundidad. Se declara que este es el modelo");
        objeto = new PropertyChangeSupport(this);
        this.profundidad = profundidad;
    }

    // se añade el metodo para declarar al controlador
    public void listenerAñadir(PropertyChangeListener listener) {
        logger.debug("se añade el controlador");
        objeto.addPropertyChangeListener(listener);
    }

    // el siguiente metodo avisa que se detecto un cambio
    public void cambioDetectado() {
        logger.debug("Cambio detectado, se dispara el aviso de cambio");
        objeto.firePropertyChange("Recurrencia", false, true);
    }

    // en este metodo se da la grafica de la recurrencia del 1 al n profundidad, ademas genera N colores diferentes
    // dependiendo de la profundidad para crear patrones de colores
    @Override
    public void dibujar(Graphics g) {
        logger.debug("se empieza a graficar la recurrencia con profundidad de : " + this.profundidad);
        for (int i = 1; i <= this.profundidad; i++) {
            int R = (int) (ramdom.nextDouble() * 255);
            int G = (int) (ramdom.nextDouble() * 255);
            int B = (int) (ramdom.nextDouble() * 255);
            int color = B | (G << 8) | (R << 16);
            this.colores[pos] = color;
            logger.debug("se genera un color aleatorio para la profundidad " + i);
            logger.debug("SE GRAFICA LA PROFUNDIDAD DE:  " + i);
            hacerRecurrencia(500, 200, 200, 200, i, g, this.colores[pos]);
            this.pos = i - 1;
        }
        this.pos = 0;

    }

    //este metodo grafica la recurrencia y pinta cada cuadro con su respectivo color
    public void hacerRecurrencia(int x1, int y1, int ancho, int alto, int n, Graphics g, int color) {
        int pAncho = ancho / 2;
        int vAncho = pAncho / 2;
        int pAlto = alto / 2;
        int vAlto = pAlto / 2;

        if (n == 1) {
            g.setColor(new Color(color));
            g.drawRect(x1, y1, ancho, alto);
            g.fillRect(x1, y1, ancho, alto);
            logger.debug("Se grafica el cuadrado en las posiciones (" + x1 + "," + y1 + ") con el ancho y alto de (" + pAncho + "," + pAlto + ")");
        } else {
            // si desean quitar el for para poder graficar todos los cuadrados, se aumenta esta linea de codigo y se cambia
            // el for mencionado en el metodo dibujar
            //  hacerRecurrencia(x1,y1,ancho,alto,n-1,g,color);
            hacerRecurrencia(x1 + vAncho, y1 - pAlto, pAncho, pAlto, n - 1, g, color); // pos 1
            hacerRecurrencia(x1 - pAncho, y1 + vAlto, pAncho, pAlto, n - 1, g, color); // pos 2
            hacerRecurrencia(x1 + 2 * pAncho, y1 + vAlto, pAncho, pAlto, n - 1, g, color); // pos 3
            hacerRecurrencia(x1 + vAncho, y1 + 2 * pAlto, pAncho, pAlto, n - 1, g, color);// pos 4
        }

    }

    public int getProfundidad() {
        return profundidad;
    }

    // Se configura la profundidad de la recursividad
    public void setProfundidad(int profundidad) {
        logger.debug("se da la profundidad de " + profundidad);
        this.profundidad = profundidad;
    }

}
