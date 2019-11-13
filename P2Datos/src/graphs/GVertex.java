package graphs;

import java.awt.geom.Point2D;
import lists.List;
import lists.SimpleLinkedList;

public class GVertex<V> {

    public GVertex(V info, Point2D.Float position) {
        this.info = info;
        this.position = position;
        ed = new SimpleLinkedList<>();
        this.etiqueta = false;
    }

    public GVertex(V info) {
        this(info, new Point2D.Float(0f, 0f));
    }

    public V getInfo() {
        return info;
    }

    public Point2D.Float getPosition() {
        return position;
    }

    public void setPosition(Point2D.Float position) {
        this.position = position;
    }

    public List<Edge> getEdges() {
        return ed;
    }

    public void setEdges(List<Edge> edges) {
        this.ed = edges;
    }

    public boolean isEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(boolean etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void agregarArco(Edge g) {
        this.getEdges().addLast(g);
    }

    @Override
    public String toString() {
        return String.format("{%s, (%4.2f, %4.2f)}",
                getInfo(), getPosition().getX(), getPosition().getY());
    }

    public Edge menor() {
        Edge menor = ed.getFirst();
        for (int i = 0; i < ed.count(); i++) {
            if (menor.getInfo() < ed.get(i).getInfo()) {
                menor = ed.get(i);
            }
        }
        return menor;
    }

    public int getVertexWeigth(GVertex<V> destino) {
        if (destino != this) {
            int valor = 0;
            for (int i = 0; i < ed.count(); i++) {
                if (ed.get(i).getHead().getInfo() == destino.getInfo()) {
                    valor = ed.get(i).getInfo();
                    break;
                }
            }
            return valor;
        }
        return -1;
    }

    private final V info;
    private Point2D.Float position;
    private List<Edge> ed;
    private boolean etiqueta;

}
