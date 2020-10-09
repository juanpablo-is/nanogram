package Interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Juan Pablo
 */
public class PanelVida extends JPanel {

    private JPanel pnlVidas, pnlTotal;
    private JLabel vida1, vida2, vida3;
    private int vida = 3;
    private BufferedImage scaleImage;

    public PanelVida() {

        try {
            pnlVidas = new JPanel(new GridLayout(1, 3));

            scaleImage = ImageIO.read(this.getClass().getResource("../Util/icon-sin-vida.png"));
            BufferedImage scaleImage = ImageIO.read(this.getClass().getResource("../Util/icon-vida.png"));

            vida1 = new JLabel(new ImageIcon(scaleImage));
            vida1.setBackground(Color.white);
            vida1.setOpaque(true);

            vida2 = new JLabel(new ImageIcon(scaleImage));
            vida2.setBackground(Color.white);
            vida2.setOpaque(true);

            vida3 = new JLabel(new ImageIcon(scaleImage));
            vida3.setBackground(Color.white);
            vida3.setOpaque(true);

            pnlVidas.add(vida1);
            pnlVidas.add(vida2);
            pnlVidas.add(vida3);

            add(pnlVidas);

        } catch (IOException ex) {
            Logger.getLogger(PanelVida.class.getName()).log(Level.SEVERE, null, ex);
        }

        setBackground(Color.white);
        setOpaque(true);
    }

    public void modificarVida() {
        vida--;
        if (vida == 2) {
            vida3.setIcon(new ImageIcon(scaleImage));
        } else if (vida == 1) {
            vida2.setIcon(new ImageIcon(scaleImage));
        } else if (vida == 0) {
            vida1.setIcon(new ImageIcon(scaleImage));
            System.out.println("GAME OVER");
        }
    }
}
