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
public class PanelDerecho extends JPanel {

    private JLabel lblMundo[];
    private String[] valores;

    public PanelDerecho(String valores[]) {
        this.valores = valores;

//        setBackground(Color.yellow);
        setLayout(new GridLayout(10, 3));

        lblMundo = new JLabel[valores.length];

        int valorCuadro = 9;
        int valorCuadro2 = 9;

        for (int i = 0; i < valores.length; i++) {

            if (i % 3 == 0) {
                valorCuadro = valorCuadro2--;
            }

            lblMundo[i] = new JLabel((valores[valorCuadro].equals("0")) ? "" : valores[valorCuadro]);
            valorCuadro += 10;
            lblMundo[i].setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
            lblMundo[i].setHorizontalAlignment(JLabel.CENTER);
            lblMundo[i].setVerticalAlignment(JLabel.CENTER);
            add(lblMundo[i]);

        }
    }

    public int[] getValorLeft(int y) {
        int[] valoresGet = new int[2];
        if (!valores[y].equals(" ")) {
            valoresGet[0] = Integer.parseInt(valores[y]);
        }

        valoresGet[1] = Integer.parseInt(valores[y + 10]);
        return valoresGet;
    }
}
