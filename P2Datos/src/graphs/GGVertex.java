package graphs;


public class GGVertex {

    public GGVertex(GVertex vertice, boolean visitado, int peso) {
        this.vertice = vertice;
        this.visitado = visitado;
        this.peso = peso;
    }
    
    
    public GGVertex(GVertex vertice,  int peso) {
        this.vertice = vertice;
        this.visitado = false;
        this.peso = peso;
    }
    
    public GGVertex(){
        this.vertice =null;
        this.peso =0;
        this.visitado=false;
    
    }
 
    public GVertex getVertice() {
        return vertice;
    }

    public void setVertice(GVertex vertice) {
        this.vertice = vertice;
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
 
    private GVertex vertice;
    private boolean visitado;
    private int peso;
    
    
}