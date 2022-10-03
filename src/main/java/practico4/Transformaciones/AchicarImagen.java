package practico4.Transformaciones;

import practico4.dibujo.Imagen;
import practico4.interfaces.ITransformacion;

public class AchicarImagen implements ITransformacion {

    @Override
    public Imagen transformarImagen(Imagen imagen) {
        Imagen original = new Imagen(imagen);
        int nuevoAncho = original.getAncho() / 2 + 1;
        int nuevoAlto = original.getAlto() / 2 + 1;
        int[][] nuevosPixeles = new int[nuevoAncho][nuevoAlto];
        for (int i = 0; i < imagen.getAncho(); i+=2) {
            for (int j = 0; j < imagen.getAlto(); j+=2) {
                nuevosPixeles[i/2][j/2] = imagen.get(i,j);
            }
        }

        imagen.setPixeles(nuevosPixeles, nuevoAncho, nuevoAlto);

        return imagen;
    }
}
