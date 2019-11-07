package graphs.view;

import graphs.Graph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GraphPanel<V, E> extends JPanel {

    public GraphPanel(Graph<V, E> g) {
        this.g = g;
        this.modelo = null;
        configurar();
    }

    public GraphPanel(Modelo modelo) {
        g = null;
        this.modelo = modelo;
        configurar();
    }

    public GraphPanel(Modelo modelo, Graph<V, E> g) {
        this.g = g;
        this.modelo = modelo;
        configurar();
    }

    private void configurar() {
        setBackground(Color.LIGHT_GRAY);
        try {
            bkgnd = ImageIO.read(getClass().getResourceAsStream("trees.jpg"));
        } catch (IOException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void init() {
        runner = new Thread() {
            @Override
            public void run() {
                while (runner == Thread.currentThread()) {
                    repaint();
                    try {
                        Thread.sleep(MAX_WAIT);
                    } catch (InterruptedException ex) {
                    }
                }
            }

        };
        runner.start();
    }

    public void init1() {
        runner1 = new Thread() {
            @Override
            public void run() {
                while (runner1 == Thread.currentThread()) {
                    repaint();
                    try {
                        Thread.sleep(MAX_WAIT);
                    } catch (InterruptedException ex) {
                    }
                }
            }

        };
        runner1.start();
    }

    @Override
    public void paintComponent(Graphics bg) {
        super.paintComponent(bg);
        if (bkgnd != null) {
            bg.drawImage(bkgnd, 0, 0, this);
        }
        g.paint(bg, getBounds());
    }

    private static final int MAX_WAIT = 100;
    private Thread runner;
    private Thread runner1;
    private Graph<V, E> g;
    private Image bkgnd = null;
    private final Modelo modelo;
}
