package Interfaz;

import Controlador.Controlador;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author Juan Pablo
 */
public class InterfazApp extends JFrame {

    private Controlador ctrl;
    private interfaz.PanelGrilla pnlGrilla;
    private PanelVida pnlVida;
    private PanelTop pnlTop;
    private PanelDerecho pnlDerecho;

    public InterfazApp(Controlador ctrl) {
        this.ctrl = ctrl;

        ctrl.cargarValores();

        pnlGrilla = new interfaz.PanelGrilla(ctrl);
        pnlGrilla.setBounds(110, 200, 420, 300);

        pnlVida = new PanelVida();
        pnlVida.setBounds(125, 10, 280, 90);

        pnlTop = new PanelTop(ctrl.getValores(true));
        pnlTop.setBounds(110, 120, 420, 80);

        pnlDerecho = new PanelDerecho(ctrl.getValores(false));
        pnlDerecho.setBounds(30, 200, 80, 300);

        getContentPane().add(pnlGrilla);
        getContentPane().add(pnlVida);
        getContentPane().add(pnlTop);
        getContentPane().add(pnlDerecho);

        ctrl.conectar(pnlDerecho, pnlTop, pnlVida, pnlGrilla);
        setTitle("Nanogram");
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.white);

        setSize(550, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if (ke.getKeyChar() == 'z') {
                    ctrl.cambiarModo();
                }
            }
        });
    }

    public static void main(String[] args) {

        InterfazApp app = new InterfazApp(new Controlador());
        app.setVisible(true);
        app.setLocationRelativeTo(null);

    }

}
