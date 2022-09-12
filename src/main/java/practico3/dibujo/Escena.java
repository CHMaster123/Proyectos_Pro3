package practico3.dibujo;


import practico3.interfaces.IDibujo;
import practico3.objetos.Cuadrado;
import practico3.objetos.Letras;
import practico3.objetos.Linea;
import practico3.objetos.Redondo;
import practico3.vista.Panel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Escena implements IDibujo {
    private Imagen imagen;
    private ArrayList<Cuadrado> cuadrado;
    private ArrayList<Redondo> redondos;
    private ArrayList<Linea> lineas;
    private ArrayList<Letras> letras;
    private PropertyChangeSupport observado;

    public Escena() {
        imagen = new Imagen(1214, 690);
        cuadrado = new ArrayList<>();
        redondos = new ArrayList<>();
        lineas = new ArrayList<>();
        letras = new ArrayList<>();
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

        for (Cuadrado c : cuadrado) {
            c.dibujar(g);
        }
        for (Redondo c : redondos) {
            c.dibujar(g);
        }
        for (Linea c : lineas) {
            c.dibujar(g);
        }
        for (Letras c : letras) {
            c.dibujar(g);
        }
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public void addCuadrado(Cuadrado c) {
        cuadrado.add(c);
        observado.firePropertyChange("ESCENA", true, false);
    }

    public void addRedondo(Redondo c) {
        redondos.add(c);
        observado.firePropertyChange("ESCENA", true, false);
    }

    public void addLineas(Linea c) {
        lineas.add(c);
        observado.firePropertyChange("ESCENA", true, false);
    }

    public void addLetras(Letras c) {
        letras.add(c);
        observado.firePropertyChange("ESCENA", true, false);
    }


    public void addListener(Panel panel) {
        observado.addPropertyChangeListener(panel);
        this.imagen.addListener(panel);
        for (Cuadrado c :
                cuadrado) {
            c.addListener(panel);
        }
        for (Linea c :
                lineas) {
            c.addListener(panel);
        }
        for (Redondo c :
                redondos) {
            c.addListener(panel);
        }
        for (Letras c :
                letras) {
            c.addListener(panel);
        }
    }

    public Cuadrado getCuadradoSeleccionado() {
        for (Cuadrado c :
                cuadrado) {
            if (c.isSeleccionado()) return c;
        }
        return null;
    }

    public Redondo getRedondoSeleccionado() {
        for (Redondo c :
                redondos) {
            if (c.isSeleccionado()) return c;
        }
        return null;
    }

    public Linea getLineaSeleccionada() {
        for (Linea c :
                lineas) {
            if (c.isSeleccionado()) return c;
        }
        return null;
    }

    public Letras getLetrasSeleccionada() {
        for (Letras c :
                letras) {
            if (c.isSeleccionado()) return c;
        }
        return null;
    }

    public void soltarObjeto() {
        for (Cuadrado c :
                cuadrado) {
            c.setSeleccionado(false);
        }
        for (Redondo c :
                redondos) {
            c.setSeleccionado(false);
        }
        for (Linea c :
                lineas) {
            c.setSeleccionado(false);
        }
        for (Letras c :
                letras) {
            c.setSeleccionado(false);
        }
    }

    public void seleccionarObjeto(int x, int y) {
        for (Cuadrado c :
                cuadrado) {
            if (x > c.getX() && x < (c.getX() + c.getTamano()) &&
                    y > c.getY() && y < (c.getY() + c.getTamano())) {
                c.setSeleccionado(true);
            }
        }

        for (Linea c :
                lineas) {
            if (x > c.getX() && x < (c.getX() + c.getTamano()) &&
                    y > c.getY() && y < (c.getY() + c.getTamano())) {
                c.setSeleccionado(true);
            }
        }

        for (Redondo c :
                redondos) {
            if (x > c.getX() && x < (c.getX() + c.getTamano()) &&
                    y > c.getY() && y < (c.getY() + c.getTamano())) {
                c.setSeleccionado(true);
            }
        }

        for (Letras c :
                letras) {
            if (x > c.getX() && x < (c.getX() + c.getTamano()) &&
                    y > c.getY() && y < (c.getY() + c.getTamano())) {
                c.setSeleccionado(true);
            }
        }
    }
}
