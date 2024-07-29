package app.lista.grafossempeso;

import java.util.ArrayList;
import java.util.List;

public abstract class Grafo {

    private Integer numVertices;
    private Integer numArestas;
    private List <List<Integer>> listaAdjacencia = null;
	
    public Grafo (Integer numVertices) {
    	this.inicializaGrafo(numVertices);
    }

    private void inicializaGrafo(Integer numVertices) {
    	List<List<Integer>> aux = new ArrayList<>();
    	
    	if(this.listaAdjacencia == null) {
    		for(int i = 0; i < numVertices; i++) {
    			aux.add(i, new ArrayList<Integer>());
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
//            for (int i = 0; i < this.numVertices; i++) {
//                System.out.print("\tv"+i);
//            }
//            System.out.println(");
            for (int i = 0; i < this.numVertices; i++) {
                System.out.print("["+i+"]->");
                for (int j = 0; j < listaAdjacencia.get(i).size(); j++) {
                    System.out.print("\t[" + this.listaAdjacencia.get(i).get(j) + "] ->");
                }
                System.out.print("\t null");
                System.out.println("");
            }
        }
    }
    
    public boolean existeVizinho(int vertice){
        if(this.listaAdjacencia == null) return false;
        if (vertice < 0 || vertice>=this.numVertices) return false;
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
    
    public abstract int grauVertice (int vertice);
    public abstract boolean insertAresta(int vertice1, int vertice2);
    public abstract boolean deletedAresta(int vertice1, int vertice2);
    public abstract boolean existeAresta(int vertice1, int vertice2);
    
	public Integer getNumVertices() {
		return numVertices;
	}

	public Integer getNumArestas() {
		return numArestas;
	}

	public List<List<Integer>> getListaAdjacencia() {
		return listaAdjacencia;
	}    
}