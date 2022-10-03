package practico4.interfaces;

import java.beans.PropertyChangeListener;

public interface IFiguras extends IDibujo {
    public boolean estaDentroDeLaFigura(int x, int y);
    public void setSeleccionado(boolean s);
    public boolean isSeleccionado();
    public void addListener(PropertyChangeListener listener);
    public void moverA(int x, int y);
}
