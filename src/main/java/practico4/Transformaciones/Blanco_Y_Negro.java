package practico4.Transformaciones;

import practico4.dibujo.Imagen;
import practico4.interfaces.ITransformacion;

public class Blanco_Y_Negro implements ITransformacion {
    @Override
    public Imagen transformarImagen(Imagen imagen) {
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int color = imagen.get(i,j);

                // xxxx xxxx | rrrr rrrr | gggg gggg | bbbb bbbb
                int b = color & 0x000000ff;
                int g = (color & 0x0000ff00) >> 8;
                int r = (color & 0x00ff0000) >> 16;
                // 68, 154, 98
                // Transformar a gris:
                // mayor
                int gris = (b > g && b > r) ? b : (g > b && g > r) ? g : r;
                // menor
                // NO int gris = (b < g && b < r) ? b : (g < b && g < r) ? g : r;
                // promedio
                // +- int gris = (r+g+b) / 3;
                imagen.setColor(i,j, gris, gris, gris);
            }
        }
        imagen.cambiosRealizados();
        return imagen;
    }
}
