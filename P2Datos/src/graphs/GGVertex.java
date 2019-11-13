package graphs;

public class GGVertex<V> {

    public GGVertex(GVertex<V> origen, GVertex<V> info, GVertex<V> optimo, boolean visitado, int peso) {
        this.origen = origen;
        this.info = info;
        this.optimo = optimo;
        this.visitado = visitado;
        this.peso = peso;
    }

    public GGVertex(GVertex<V> origen, int peso) {
        this.origen = origen;
        this.visitado = false;
        this.peso = peso;
    }

    public GGVertex() {
        this.origen = null;
        this.peso = 0;
        this.visitado = false;
    }

    public GVertex<V> getOrigen() {
        return origen;
    }

    public void setOrigen(GVertex<V> origen) {
        this.origen = origen;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public GVertex<V> getInfo() {
        return this.info;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public void setOptimo(GVertex<V> optimo){
        this.optimo=optimo;
    }

    @Override
    public String toString() {
        return String.format("origen %s , %peso: %d", origen.toString(), peso);
    }
    public GVertex<V> getOptimo(){
        return this.optimo;
    }
    
    public int getVertexWeigth(GVertex<V> destino) {
        int valor = 0;
        for (int i = 0; i < info.getEdges().count(); i++) {
            if (info.getEdges().get(i).getHead().getInfo() == destino.getInfo()) {
                valor = info.getEdges().get(i).getInfo();
                break;
            }
        }
        return valor;
    }

    private GVertex<V> origen;
    private GVertex<V> info;
    private GVertex<V> optimo;
    private boolean visitado;
    private int peso;
}
