package Mundo;

import java.awt.Color;

/**
 *
 * @author Juan Pablo
 */
public class Cuadro {

    private Color color;
    private boolean seleccion;

    public Cuadro(Color color, boolean seleccion) {
        this.color = color;
        this.seleccion = seleccion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }
    
    
}
