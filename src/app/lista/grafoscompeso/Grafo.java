package app.lista.grafoscompeso;

import java.util.ArrayList;
import java.util.List;

public abstract class Grafo {
    private Integer numVertices;
    private Integer numArestas;
    private List <List<Vertices>> listaAdjacencia = null;
	
    public Grafo (Integer numVertices) {
    	this.inicializaGrafo(numVertices);
    }

    private void inicializaGrafo(Integer numVertices) {
    	List<List<Vertices>> aux = new ArrayList<>();
    	
    	if(this.listaAdjacencia == null) {
    		for(int i = 0; i < numVertices; i++) {
    			aux.add(i, new ArrayList<Vertices>());
    		}
    		this.numVertices = numVertices;
    		this.numArestas = 0;
    		this.listaAdjacencia = aux;
    	}
    }
    
    public void imprimeGrafo(){
        if(this.listaAdjacencia != null){
            System.out.println("A lista adjacente: \nNúmero de vertices: "
            + this.numVertices + " - Número de arestas: " + this.numArestas);
//            for (int i = 0; i < this.numInteger; i++) {
//                System.out.print("\tv"+i);
//            }
//            System.out.println(");
            for (int i = 0; i < this.numVertices; i++) {
                System.out.print("["+i+"]->");
                for (int j = 0; j < listaAdjacencia.get(i).size(); j++) {
                    System.out.print("\t" + this.listaAdjacencia.get(i).get(j) + " ->");
                }
                System.out.print("\t null");
                System.out.println("");
            }
        }
    }
    
    public boolean existeVizinho(Integer vertice){
        if(this.listaAdjacencia == null) return false;
        if (vertice < 0 || vertice >= this.numVertices) return false;
        int vizinho = this.grauVertice(vertice);
        if (vizinho>0) {
            return true;
        } else{
            return false;
        }
    }
    
    public void clearGrafo (){
        if(this.listaAdjacencia != null) {
            this.listaAdjacencia = null;
            this.numVertices = 0;
            this.numArestas = 0;
        }
    }

    protected  void incrNumArestas (){
        this.numArestas++;
    }

    protected void decrNumArestas(){
        this.numArestas--;
    }
    
    public abstract int grauVertice (Integer vertice);
    public abstract boolean insertAresta(Integer vertice1, Integer vertice2, Integer peso);
    public abstract boolean deletedAresta(Integer vertice1, Integer vertice2);
    public abstract boolean existeAresta(Integer vertice1, Integer vertice2);
    
	public Integer getNumVertices() {
		return numVertices;
	}

	public Integer getNumArestas() {
		return numArestas;
	}

	public List<List<Vertices>> getListaAdjacencia() {
		return listaAdjacencia;
	}    
}