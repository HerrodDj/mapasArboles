package proyecto2;

import graphs.Graph;
import graphs.view.GraphPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


public class VentanaEjemplo extends JFrame {

    public VentanaEjemplo(String titulo, Graph<Integer, Double> g)
            throws HeadlessException {
        super(titulo);
        this.g = g;
        configurar();
    }

    private void configurar() {
        ajustarComponentes(getContentPane());
        setResizable(true);
        setSize(800, 600);
        setMinimumSize(new Dimension(640, 480));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                g.setActive(false);
                System.exit(0);
            }

        });
    }

    private void ajustarComponentes(Container c) {
        c.setLayout(new BorderLayout());
        c.add(BorderLayout.CENTER, panelPrincipal = new GraphPanel(g));
    }

    public void init() {
        setVisible(true);
        panelPrincipal.init();
        g.init();
    }

    private GraphPanel panelPrincipal;
    private final Graph<Integer, Double> g;
    //Declaracion de variables del modelo

    //fin de la declaracion de variables del modelo
    /* Graph<Object, Object> */
}
