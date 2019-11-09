package graphs;

public class Edge<V> {

    public Edge(GVertex<V> tail, GVertex<V> head, int info) {
        this.tail = tail;
        this.head = head;
        this.info = info;
    }

    public GVertex<V> getTail() {
        return tail;
    }

    public GVertex<V> getHead() {
        return head;
    }

    public int getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return String.format("{(%s, %s), %d}", getTail(), getHead(), getInfo());
    }

    private final GVertex<V> tail;
    private final GVertex<V> head;
    private final int info;

   
    
}
