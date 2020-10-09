package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Juan Pablo
 */
public class PanelTop extends JPanel {

    private JLabel lblMundo[];
    private String[] valores;

    public PanelTop(String[] valores) {

        this.valores = valores;

//        setBackground(Color.yellow);
        setLayout(new GridLayout(3, 10));

        lblMundo = new JLabel[valores.length];

        for (int i = 0; i < 30; i++) {
            lblMundo[i] = new JLabel(valores[i].equals("0") ? "" : valores[i]);
            lblMundo[i].setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
            lblMundo[i].setHorizontalAlignment(JLabel.CENTER);
            lblMundo[i].setVerticalAlignment(JLabel.CENTER);
            add(lblMundo[i]);
        }
    }

    public int[] getValorTop(int x) {
        int[] valoresGet = new int[2];
        if (!lblMundo[x].isEnabled()) {
            valoresGet[0] = 0;
        } else if (!valores[x].equals(" ")) {
            valoresGet[0] = Integer.parseInt(valores[x]);
        }

        valoresGet[1] = Integer.parseInt(valores[x + 10]);
        return valoresGet;
    }

    public void correctaTop(int x) {

        if (valores[x].equals(" ")) {
            lblMundo[x + 10].setEnabled(false);
        }
        if (!lblMundo[x].isEnabled()) {
            lblMundo[x + 10].setEnabled(false);
        }
        lblMundo[x].setEnabled(false);
    }
}
