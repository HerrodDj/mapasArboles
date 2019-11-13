package graphs;


public class GGVertex<V> {
    
    public GGVertex(GVertex<V> origen, boolean visitado, int peso) {
        this.origen = origen;
        this.visitado = visitado;
        this.peso = peso;
    }
        
    public GGVertex(GVertex<V> origen,  int peso) {
        this.origen = origen;
        this.visitado = false;
        this.peso = peso;
    }
    
    
    public GGVertex(){
        this.origen =null;
        this.peso =0;
        this.visitado=false;
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

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("origen %s , %peso: %d", origen.toString(), peso);
    }
    
    

    private GVertex<V> origen;
    private boolean visitado;
    private int peso;
    
    
}