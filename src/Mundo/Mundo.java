package Mundo;

import Controlador.Controlador;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Pablo
 */
public class Mundo {

    private Controlador ctrl;
    private int contadorLineas = 0;
    private Cuadro[][] matrizCargar = new Cuadro[10][10];
    private ArrayList<String> valoresSeleccion = new ArrayList<>();
    private ArrayList<String> valoresColores = new ArrayList<>();
    private ArrayList<String> valoresTop = new ArrayList<String>();
    private ArrayList<String> valoresLeft = new ArrayList<String>();

    public Mundo(Controlador ctrl) {
        this.ctrl = ctrl;
    }

    public boolean isTrue(boolean opcion, int x, int y) {

        if (opcion == matrizCargar[y][x].isSeleccion()) {
            return true;
        }

        return false;
    }

    public void cargarValores() {

        try {
            File file = new File("src/Util/cargar.txt");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("")) {
                    contadorLineas++;
                } else if (contadorLineas == 0) {
                    valoresTop.add(line);
                } else if (contadorLineas == 1) {
                    valoresLeft.add(line);
                } else if (contadorLineas == 2) {
                    valoresSeleccion.add(line);
                } else if (contadorLineas == 3) {
                    valoresColores.add(line);
                }
            }

            llenarMatriz();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void llenarMatriz() {
        for (int i = 0; i < 10; i++) {
            String[] seleccion = valoresSeleccion.get(i).split(" ");
            String[] colores = valoresColores.get(i).split(" ");

            for (int j = 0; j < 10; j++) {
                Cuadro cuadro = new Cuadro(Color.decode("#" + colores[j]), (seleccion[j].equals("O")));
                matrizCargar[i][j] = cuadro;
            }
        }
    }

    public String[] getValores(boolean b) {

        String[] valoresTop = new String[30];
        String[] valoresLeft = new String[30];

        if (b) {

            for (int i = 0; i < 3; i++) {
                String valorTop[] = this.valoresTop.get(i).split(" ");

                for (int j = 10 * i; j < 10 + (10 * i); j++) {
                    valoresTop[j] = valorTop[j % 10];
                }
            }

            return valoresTop;
        }

        for (int i = 0; i < 3; i++) {
            String valorLeft[] = this.valoresLeft.get(i).split(" ");

            for (int j = 10 * i; j < 10 + (10 * i); j++) {
                valoresLeft[j] = valorLeft[j % 10];
            }
        }

        return valoresLeft;
    }

    public Cuadro[][] getMatrizCargar() {
        return matrizCargar;
    }

}
