package proyecto2;

import data.XMLReader;
import graphs.Graph;
import graphs.view.Modelo;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Ejemplo {

    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Configuracion UI ">
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        //</editor-fold> 
        new Ejemplo().init();
    }

    public void init() {
        try {
            Graph<Integer, Double> g2b = new Graph<>();
            XMLReader reader = new XMLReader();
            reader.read(PATH, g2b);
            System.out.printf("%s%n%n", g2b);
            System.out.println();
            System.out.println(g2b.getAdjacencyInfo());
            System.out.println();

            SwingUtilities.invokeLater(() -> {
                new VentanaAplicacion("Proyecto 2", new Modelo(), g2b).init();
            });

        } catch (Exception ex) {
            Logger.getLogger(Ejemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getRandom(int from, int to) {
        if (from < to) {
            return from + new Random().nextInt(Math.abs(to - from));
        }
        return from - new Random().nextInt(Math.abs(to - from));
    }

    private final String PATH = "DatosGraph.xml";
}
