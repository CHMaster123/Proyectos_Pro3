package practico2.recurrencia;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Recurrencia implements InterfaceDibujo {
    public int profundidad;
    public PropertyChangeSupport objeto;

    public Recurrencia(int profundidad) {
        objeto = new PropertyChangeSupport(this);
        this.profundidad = profundidad;
    }


    public void listenerAñadir(PropertyChangeListener listener) {
        objeto.addPropertyChangeListener(listener);
    }

    public void cambioDetectado() {
        objeto.firePropertyChange("Recurrencia", false, true);
    }

    @Override
    public void dibujar(Graphics g) {
       for (int i = 1; i <=this.profundidad; i++){
           hacerRecurrencia(400, 100, 100, 100, i, g);
       }

    }

    public void hacerRecurrencia(int x1, int y1, int ancho, int alto, int n, Graphics gc) {
        int pAncho = ancho / 2;
        int vAncho = pAncho / 2;
        int pAlto = alto / 2;
        int vAlto = pAlto / 2;
        if (n == 1) {
            gc.drawRect(x1, y1, ancho, alto);
        } else {
            hacerRecurrencia(x1 + vAncho, y1 - pAlto, pAncho, pAlto, n - 1, gc);
            hacerRecurrencia(x1 - pAncho, y1 + vAlto, pAncho, pAlto, n - 1, gc);
            hacerRecurrencia(x1 + 2 * pAncho, y1 + vAlto, pAncho, pAlto, n - 1, gc);
            hacerRecurrencia(x1 + vAncho, y1 + 2 * pAlto, pAncho, pAlto, n - 1, gc);
        }

    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

}
