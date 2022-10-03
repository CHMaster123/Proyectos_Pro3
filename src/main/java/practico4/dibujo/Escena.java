package practico4.dibujo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico4.interfaces.IDibujo;
import practico4.interfaces.IFiguras;
import practico4.objetos.*;
import practico4.vista.Panel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Escena implements IDibujo {
    private Imagen imagen;
    private ArrayList<Figura> objetos;
    private PropertyChangeSupport observado;
    protected static final Logger logger = LogManager.getLogger();

    public Escena() {
        imagen = new Imagen(1214, 690);
        objetos = new ArrayList<>();
        observado = new PropertyChangeSupport(this);
    }

    @Override
    public void dibujar(Graphics g) {

        if (imagen != null) {
            BufferedImage rsm = new BufferedImage(
                    imagen.getAncho(), imagen.getAlto(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = rsm.createGraphics();

            imagen.dibujar(g2d);
            g.drawImage(rsm, 0, 0, null);
        }

        for (IFiguras c : objetos) {
            c.dibujar(g);
        }
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public void addFigura(Figura c) {
        objetos.add(c);
        observado.firePropertyChange("ESCENA", true, false);
    }


    public void addListener(Panel panel) {
        observado.addPropertyChangeListener(panel);
        this.imagen.addListener(panel);
        for (IFiguras c:
                objetos) {
            c.addListener(panel);
        }
    }
    public IFiguras getObjetoSeleccionado() {
        for (IFiguras c:
                objetos) {
            if (c.isSeleccionado()) return c;
        }
        return null;
    }

    public void soltarObjeto() {
        for (IFiguras c:
                objetos) {
            c.setSeleccionado(false);
        }
    }

    public void seleccionarObjeto(int x, int y) {
        for (IFiguras c:
                objetos) {
            if (c.estaDentroDeLaFigura(x, y))
                c.setSeleccionado(true);
        }
    }
}
