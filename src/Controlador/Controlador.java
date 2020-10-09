package Controlador;

import Interfaz.PanelDerecho;
import Interfaz.PanelTop;
import Interfaz.PanelVida;
import Mundo.Mundo;
import interfaz.PanelGrilla;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Pablo
 */
public class Controlador {

    private boolean modo;
    private PanelDerecho pnlDerecho;
    private PanelTop pnlTop;
    private PanelVida pnlVida;
    private PanelGrilla pnlGrilla;
    private Mundo mundo;
    private int contadorDeCasillas = 0;

    public Controlador() {
        mundo = new Mundo(this);
    }

    public void conectar(PanelDerecho pnlDerecho, PanelTop pnlTop, PanelVida pnlVida, PanelGrilla pnlGrilla) {
        this.pnlDerecho = pnlDerecho;
        this.pnlTop = pnlTop;
        this.pnlVida = pnlVida;
        this.pnlGrilla = pnlGrilla;
    }

    public void cambiarModo() {
        modo = !modo;
    }

    public boolean getModo() {
        return modo;
    }

    public void cargarValores() {
        mundo.cargarValores();
    }

    public boolean verificarValor(boolean opcion, int x, int y) {
        return mundo.isTrue(opcion, x, y);
    }

    public void cambiarVida() {
        pnlVida.modificarVida();
    }

    public int[] getValorTop(int x) {
        return pnlTop.getValorTop(x);
    }

    public int[] getValorLeft(int y) {
        return pnlDerecho.getValorLeft(y);
    }

    public void correctaTop(int x) {
        pnlTop.correctaTop(x);
    }

    public String[] getValores(boolean b) {
        return mundo.getValores(b);
    }

    public void terminarJuego() {
        JOptionPane.showMessageDialog(null, "EXCELENTE, GANASTE!");
        pnlGrilla.terminarJuego(mundo.getMatrizCargar());
    }

    public int contadorDeCasillas() {
        return ++contadorDeCasillas;
    }
}
