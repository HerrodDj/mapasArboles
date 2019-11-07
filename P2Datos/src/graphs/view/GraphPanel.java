package graphs.view;

import graphs.GVertex;
import graphs.Graph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import lists.List;
import proyecto2.VentanaAplicacion;

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
        initListeners();
    }
    
    public void setPadre(VentanaAplicacion padre){
        if(this.padre==null){
            this.padre = padre;
        }
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

    private void initListeners() {
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev) {
                if (ev.getClickCount() == 1
                        && ev.getModifiers() == java.awt.event.InputEvent.BUTTON1_MASK) {
                    GVertex<Integer> seleccionado = seleccionarNodo(ev.getX(), ev.getY());
                    if (seleccionado != null) {
                        padre.setValorInicioField(String.valueOf(seleccionado.getInfo()));
                    }
                }
                if (ev.getClickCount() == 1
                        && ev.getModifiers() == java.awt.event.InputEvent.BUTTON3_MASK) {
                    GVertex<Integer> seleccionado = seleccionarNodo(ev.getX(), ev.getY());
                    if (seleccionado != null) {
                        padre.setValorDestinoField(String.valueOf(seleccionado.getInfo()));
                    }
                }
            }

        });
    }

    private GVertex<Integer> seleccionarNodo(int x, int y) {
        //ocupo hacer una lista de todos los nodos en el graph para recorrelos
        //y preguntar si estas cordenadas estan dentro de algun nodo..
        List<GVertex<V>> list = g.getAllGVertex();
        GVertex<Integer> gvert = null;
        for (int i = 0; i < g.getAllGVertex().count(); i++) {
            gvert = (GVertex<Integer>) list.get(i);
            if ((new Ellipse2D.Double(gvert.getPosition().getX() - 24,
                    gvert.getPosition().getY() - 24, 48, 48)).contains(x, y)) {
                return gvert;
            }
            
        }
        return null;
    }

    private static final int MAX_WAIT = 100;
    private VentanaAplicacion padre;
    private Thread runner;
    private Thread runner1;
    private Graph<V, E> g;
    private Image bkgnd = null;
    private final Modelo modelo;
}
