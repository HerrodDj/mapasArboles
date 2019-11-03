package graphs;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Random;
import lists.Iterator;
import lists.List;
import lists.SimpleLinkedList;

public class Graph<V, E> {

    public Graph() {
        vertices = new SimpleLinkedList<>();
        edges = new SimpleLinkedList<>();
    }

    public GVertex<V> getVertex(V v) {
        GVertex<V> r = null;
        Iterator<GVertex<V>> i = vertices.getIterator();
        while (i.hasNext()) {
            GVertex<V> t = i.getNext();
            if (t.getInfo().equals(v)) {
                r = t;
                break;
            }
        }
        return r;
    }

    public List<GVertex<V>> getAdjacent(GVertex<V> v) {
        List<GVertex<V>> r = new SimpleLinkedList<>();
        Iterator<Edge<V, E>> i = edges.getIterator();
        while (i.hasNext()) {
            Edge<V, E> e = i.getNext();
            if (e.getHead().getInfo().equals(v.getInfo())) {
                r.addLast(e.getTail());
            }
            if (e.getTail().getInfo().equals(v.getInfo())) {
                r.addLast(e.getHead());
            }
        }
        return r;
    }

    public void add(V v, Point2D.Float position) {
        vertices.addLast(new GVertex<>(v, position));
    }

    public void add(V v) {
        vertices.addLast(new GVertex<>(v, new Point2D.Float(DX + df.x, DY + df.y)));

        if (px < MX) {
            df.x += DX;
            px++;
        } else {
            df.x = 0;
            df.y += DY;
            px = 0;
        }
    }

    public void add(GVertex<V> tail, GVertex<V> head, E w) {
        if ((tail == null) || (head == null)) {
            throw new NullPointerException("No existe el vértice.");
        }
        edges.addLast(new Edge<>(tail, head, w));
        tail.agregarArco(new Edge(tail, head, w));
        List<Edge> g = tail.getEdges();
        int p = g.count();
    }

    public void add(V t, V h, E w) {
        add(getVertex(t), getVertex(h), w);
    }

    public void addArc(V t, V h) {
        add(t, h, null);
    }

    public void addArc(V t, V h, E x) {
        add(t, h, x);
    }

    public void init() {
        init(vertices.getFirst());
    }

    public void init(GVertex<V> pathStart) {
        Random r = new Random();

        setActive(true);
        new Thread() {
            @Override
            public void run() {
                GVertex<V> v0 = pathStart;
                while (isActive()) {
                    List<GVertex<V>> vs = getAdjacent(v0);
                    p0 = v0.getPosition();

                    // Se define el criterio para seleccionar
                    // el siguiente vértice.
                    
                    Iterator<Edge<V, E>> i = edges.getIterator();
                    while (i.hasNext()) {
                        
                        while (i.getNext().getTail().getInfo().equals(v0.getInfo())) {
                            if (i.getNext().getInfo().equals(4.0)) {
                                GVertex<V> aux = i.getNext().getHead();
                                GVertex<V> v1= vs.get(aux);
                                p1 = v1.getPosition();
                            }
                        }
                    }
                    

                    System.out.printf("v(%s): %s%n", v0.getInfo(), p0);
//                    System.out.printf("v(%s): %s%n", v1.getInfo(), p1);

                    t = 0.0;
                    while (t <= 1.0) {
                        t += DT;
                        try {
                            Thread.sleep(MAX_WAIT);
                        } catch (InterruptedException ex) {
                        }
                    }
//                    v0 = v1;
                }
            }

        }.start();
    }

    @Override

    public String toString() {
        return String.format("G: (%n   V: %s,%n   E: %s%n)",
                vertices, edges);
    }

    public Rectangle getBounds() {
        float x0, x1, y0, y1;
        x0 = x1 = y0 = y1 = 0f;
        boolean f = false;

        Iterator<GVertex<V>> i = vertices.getIterator();
        while (i.hasNext()) {
            GVertex<V> v = i.getNext();

            if (!f) {
                x0 = x1 = v.getPosition().x;
                y0 = y1 = v.getPosition().y;
            }
            f = true;

            x0 = Math.min(x0, v.getPosition().x);
            x1 = Math.max(x1, v.getPosition().x);
            y0 = Math.min(y0, v.getPosition().y);
            y1 = Math.max(y1, v.getPosition().y);
        }

        if (!f) {
            throw new IllegalArgumentException();
        }

        Rectangle r = new Rectangle(
                (int) (x0), (int) (y0),
                (int) (x1 - x0), (int) (y1 - y0)
        );
        r.grow(S0 / 2, S0 / 2);
        return r;
    }

    public void paint(Graphics bg, Rectangle bounds) {
        Graphics2D g = (Graphics2D) bg;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(Color.DARK_GRAY);
        g.setStroke(TRAZO_GUIA);
        Rectangle b = getBounds();
        g.drawRect(b.x, b.y, b.width, b.height);

        g.setFont(TIPO_BASE);
        FontMetrics fm = g.getFontMetrics();

        Iterator<Edge<V, E>> i = edges.getIterator();
        while (i.hasNext()) {
            Edge<V, E> e = i.getNext();
            g.setStroke(TRAZO_BASE);
            g.setColor(Color.BLACK);

            g.drawLine(
                    (int) e.getTail().getPosition().x,
                    (int) e.getTail().getPosition().y,
                    (int) e.getHead().getPosition().x,
                    (int) e.getHead().getPosition().y
            );

            g.setStroke(new BasicStroke(2f, BasicStroke.CAP_SQUARE,
                    BasicStroke.CAP_SQUARE, 0f, DASHES, 0f));
            g.setColor(Color.WHITE);

            g.drawLine(
                    (int) e.getTail().getPosition().x,
                    (int) e.getTail().getPosition().y,
                    (int) e.getHead().getPosition().x,
                    (int) e.getHead().getPosition().y
            );
        }

        g.setStroke(TRAZO_VERTICE);
        Iterator<GVertex<V>> j = vertices.getIterator();
        while (j.hasNext()) {
            GVertex<V> v = j.getNext();

            g.setColor(Color.WHITE);
            g.fillOval((int) v.getPosition().x - S0 / 2,
                    (int) v.getPosition().y - S0 / 2,
                    S0, S0);
            g.setColor(Color.BLACK);
            g.drawOval((int) v.getPosition().x - S0 / 2,
                    (int) v.getPosition().y - S0 / 2,
                    S0, S0);

            String t = String.format("%s", v.getInfo());
            g.setColor(Color.GRAY);
            g.drawString(t,
                    v.getPosition().x - fm.stringWidth(t) / 2,
                    v.getPosition().y + fm.getAscent() / 2);
        }

        if (p0 != null) {
            g.setStroke(TRAZO_MARCADOR);
            g.setColor(Color.RED);
            g.drawOval(
                    (int) ((p0.x + t * (p1.x - p0.x)) - S1 / 2),
                    (int) ((p0.y + t * (p1.y - p0.y)) - S1 / 2),
                    S1, S1);
        }
    }

    public void update(Observable obs, Object evt) {
        throw new UnsupportedOperationException();
    }

    public String getAdjacencyInfo() {
        StringBuilder r = new StringBuilder();
        Iterator<GVertex<V>> i = vertices.getIterator();
        while (i.hasNext()) {
            GVertex<V> v = i.getNext();
            r.append(String.format("%s: ", v.getInfo()));
            Iterator<GVertex<V>> j = getAdjacent(v).getIterator();
            while (j.hasNext()) {
                r.append(String.format("%s, ", j.getNext().getInfo()));
            }
            r.append("\n");
        }
        return r.toString();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private static final float[] DASHES = {16f, 20f};
    private static final Stroke TRAZO_BASE
            = new BasicStroke(36f,
                    BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0f, null, 0f);
    private static final Stroke TRAZO_VERTICE = new BasicStroke(2f);
    private static final Stroke TRAZO_MARCADOR = new BasicStroke(8f);

    private static final Stroke TRAZO_GUIA
            = new BasicStroke(1.0f,
                    BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                    0f, DASHES, 0f);
    private static final Font TIPO_BASE
            = new Font(Font.SANS_SERIF, Font.PLAIN, 24);

    private static final int S0 = 48;
    private static final int S1 = 56;

    private static final int DX = 72;
    private static final int DY = 64;
    private static final int MX = 6;
    private int px = 0;
    private Point2D.Float df = new Point2D.Float(0, 0);

    private final List<GVertex<V>> vertices;
    private final List<Edge<V, E>> edges;

    private static final int MAX_WAIT = 100;
    private boolean active = false;
    private Point2D.Float p0;
    private Point2D.Float p1;
    private static final double DT = 0.035;
    private double t = 0.0;
}
