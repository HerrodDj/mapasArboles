package proyecto2;

import graphs.GVertex;
import graphs.Graph;
import java.awt.geom.Point2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import lists.Iterator;

public class Ejemplo {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }

        new Ejemplo().init();
    }

    public void init() {
        Graph<Integer, Double> g2b = new Graph<>();

        int mx = 64;
        int my = 64;
        int sx = 72;
        int sy = 96;

        g2b.add(1, new Point2D.Float(400, 100));
        g2b.add(2, new Point2D.Float(250, 250));
        g2b.add(3, new Point2D.Float(550, 250));
        g2b.add(4, new Point2D.Float(250, 400));
        g2b.add(5, new Point2D.Float(350, 350));
        g2b.add(6, new Point2D.Float(600, 450));

        g2b.addArc(1, 3, 5.0);
        g2b.addArc(1, 2);
        g2b.addArc(2, 5);
        g2b.addArc(5, 3);
        g2b.addArc(2, 4);
        g2b.addArc(4, 5);
        g2b.addArc(5, 6);
        g2b.addArc(6, 3);

        System.out.printf("%s%n%n", g2b);
        System.out.println();
        System.out.println(g2b.getAdjacencyInfo());
        System.out.println();

        SwingUtilities.invokeLater(() -> {
            new VentanaEjemplo("Proyecto 2", g2b).init();
        });

//        Graph<Integer, Double> g2b = new Graph<>();
//
//        int mx = 64;
//        int my = 64;
//        int sx = 72;
//        int sy = 96;
//
//        g2b.add(1, new Point2D.Float(getRandom(2, 800), getRandom(2, 800)));
//        g2b.add(2, new Point2D.Float(getRandom(2, 800), getRandom(2, 800)));
//        g2b.add(3, new Point2D.Float(getRandom(2, 800), getRandom(2, 800)));
//        g2b.add(4, new Point2D.Float(getRandom(2, 800), getRandom(2, 800)));
//        g2b.add(5, new Point2D.Float(getRandom(2, 800), getRandom(2, 800)));
//        g2b.add(6, new Point2D.Float(getRandom(2, 800), getRandom(2, 800)));
//
//        g2b.add(1, 3);
//        g2b.add(1, 2);
//        g2b.add(2, 5);
//        g2b.add(5, 3);
//        g2b.add(2, 4);
//        g2b.add(4, 5);
//        g2b.add(5, 6);
//        g2b.add(6, 3);
//
//        System.out.printf("%s%n%n", g2b);
//        System.out.println();
//        System.out.println(g2b.getAdjacencyInfo());
//        System.out.println();
//
//        SwingUtilities.invokeLater(() -> {
//            new VentanaEjemplo("Ejemplo G2B", g2b).init();
//        });
    }

    public static int getRandom(int from, int to) {
        if (from < to) {
            return from + new Random().nextInt(Math.abs(to - from));
        }
        return from - new Random().nextInt(Math.abs(to - from));
    }

}
