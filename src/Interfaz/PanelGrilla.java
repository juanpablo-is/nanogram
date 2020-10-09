package interfaz;

import java.awt.event.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.*;
import Controlador.Controlador;
import Mundo.Cuadro;

public class PanelGrilla extends JPanel {

    private static final String BLOCK = "Images/icon-vida.png";
    private static JLabel lblMundo[][];
    private LabelClicMouse labelClicMouse;
    private final Controlador controlador;
    protected boolean booleanListener = true;

    public PanelGrilla(Controlador controlador) {
        // ..............................................( T, L, B, R ).............................................
        setLayout(new GridLayout(10, 10));
        setBackground(Color.white);

        // Enlaza el Controlador y el Panle de Simulación
        this.controlador = controlador;

        // Instancia atributos de la clase   
        lblMundo = new JLabel[10][10];

        // Agrega los atributos al panel   
        int contadorDeCasillas = 0;
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                lblMundo[i][j] = new JLabel("");
                lblMundo[i][j].setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
                lblMundo[i][j].setHorizontalAlignment(JLabel.CENTER);
                lblMundo[i][j].setVerticalAlignment(JLabel.CENTER);
                lblMundo[i][j].setOpaque(true);
                lblMundo[i][j].setBackground(Color.white);
                lblMundo[i][j].addMouseListener(new LabelClicMouse(i, j, lblMundo[i][j], controlador, this));

                add(lblMundo[i][j]);
            }
        }

    }

    public void terminarJuego(Cuadro[][] matrizCargar) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                lblMundo[i][j].setBorder(null);
                lblMundo[i][j].setText("");
                lblMundo[i][j].setBackground(matrizCargar[i][j].getColor());
            }
        }
    }
}

/**
 * Controlador de eventos del Mouse
 *
 * @author Giovanni Fajardo Utria
 */
class LabelClicMouse extends MouseAdapter {

    private static final String BLOCK = "../Images/icon-vida.png";

    private JLabel label;
    private Controlador ctrl;
    private int x, y;
    private ImageIcon imgCell;
    private Color color;
    private PanelGrilla pnlMundo;

    public LabelClicMouse(int x, int y, JLabel label, Controlador ctrl, PanelGrilla pnlMundo) {
        this.label = label;
        this.ctrl = ctrl;
        this.x = x;
        this.y = y;
        this.color = Color.black;
        this.imgCell = new ImageIcon(BLOCK);
        this.pnlMundo = pnlMundo;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        if (label.isEnabled()) {
            label.setBackground(Color.white);
            label.setText("");

            if (ctrl.getModo()) {
                if (!ctrl.verificarValor(true, y, x)) {
                    ctrl.cambiarVida();
                    label.setText("X");
                    label.setEnabled(false);
                } else {
                    label.setBackground(color);
                    label.setEnabled(false);
                }
            } else {
                if (!ctrl.verificarValor(false, y, x)) {
                    ctrl.cambiarVida();
                    label.setBackground(color);
                    label.setEnabled(false);
                } else {
                    label.setText("X");
                    label.setEnabled(false);
                }
            }


            if ( ctrl.contadorDeCasillas() == 100) {
                ctrl.terminarJuego();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (label.isEnabled()) {
            if (ctrl.getModo()) {
                label.setBackground(color);
            } else {
                label.setText("X");
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (label.isEnabled()) {
            label.setBackground(Color.white);
            label.setText("");
        }
    }

}
