package app.matriz.grafoscompeso;

import app.Cor;

public abstract class GrafoPonderado {

    private Integer numVertices;
    private Integer numArestas;
    private Integer[][] matrizAdjacencia = null;
    private Integer[] peso;
    private final Integer numInvalido = -1;
    private Integer tempo = 0;

    public GrafoPonderado (Integer numVertice){
        this.matrizAdjacencia = this.inicializaGrafo(numVertice);
        this.numArestas = 0;
    }

    private Integer[][]  inicializaGrafo(Integer numVertices){
        if(numVertices < 1) return null;

        Integer[][] matrizAux = new Integer[numVertices][numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrizAux[i][j] = numInvalido;
            }
            peso[i] = -1;
        }
        return matrizAux;
    }

    public void imprimeGrafo(){
        if(this.matrizAdjacencia != null){
            System.out.println("A matriz adjacente: \nNúmero de vertices: "
            + this.numVertices + " - Número de arestas: " + this.numArestas);
            for (int i = 0; i < this.numVertices; i++) {
                System.out.print("\tv"+i);
            }
            System.out.println("");
            for (int i = 0; i < this.numVertices; i++) {
                System.out.print("v"+i);
                for (int j = 0; j < this.numVertices; j++) {
                    if(this.matrizAdjacencia[i][j] == this.numInvalido) System.out.print("\t");
                    else System.out.print("\t" + this.matrizAdjacencia[i][j]);
                }
                System.out.println("");
            }
        }
    }

    public boolean existeVizinho(int vertice){
        if(this.matrizAdjacencia == null) return false;
        if (vertice < 0 || vertice>=this.numVertices) return false;
        int vizinho = this.grauVertice(vertice);
        if (vizinho>0) {
            return true;
        } else{
            return false;
        }
    }
    
    public boolean listaAdjVazia(int u) {
    	for(int v = 0; v < numVertices; v++) {
    		if(matrizAdjacencia[u][v] != numInvalido) return false;
    	}
    	return true;
    }
    
    public Aresta primeiroListaAdj(int v) {
    	this.peso[v] = -1;
    	return this.proxAdj (v);
    }
    
    public Aresta proxAdj (Integer v) {
    	this.peso[v]++;
    	
    	while ((this.peso[v] < numVertices) && this.matrizAdjacencia[v][peso[v]] == numInvalido) {
    		peso[v]++;
    	}
    	
    	if (peso[v] == numVertices) return null;
    	else return new Aresta(v, peso[v], matrizAdjacencia[v][peso[v]]);
    }

    public void DFS() {
    	Cor[] cor = new Cor[this.numVertices];
    	Integer[] pi = new Integer[this.numVertices];
    	
    	for(int i = 0; i < this.numVertices; i++) {
    		cor[i] = Cor.BRANCO;
    		pi[i] = null;
    	}
    	
    	for (int u = 0; u < this.numVertices; u++) {// O "u" significa a nossa linha da matriz (u,v)
    		if(cor[u] == Cor.BRANCO) {
    			DFSVisit(u, cor, pi);
    			System.out.println(u);
    		}
    	}
    }
    
    private void DFSVisit(Integer u, Cor[] cor, Integer[] pi){
    	cor[u] = Cor.CINZA;
    	this.tempo +=1;
   
    	for(int v = 0; v < this.numVertices; v++) {// O "v" significa cada coluna da linha u da matriz (u,v)
    		if(this.matrizAdjacencia[u][v] == 1) {
    			if (cor[v] == Cor.BRANCO) {
    				pi[v] = u;
    				DFSVisit(v, cor, pi);
        			System.out.println(v);
    			}
    		}
    	}
    	cor[u] = Cor.PRETO;
    }
    
    public int getNumeroVertice(){
        return this.numVertices;
    }

    public int getNumeroArestas(){
        return this.numArestas;
    }

    protected  void incrNumArestas (){
        this.numArestas++;
    }

    protected void decrNumArestas(){
        this.numArestas--;
    }

    protected Integer[][] getMatriz(){
        return this.matrizAdjacencia;
    }

    public Integer getNumInvalido(){
        return this.numInvalido;
    }

    public void clearGrafo (){
        if(this.matrizAdjacencia != null) {
            this.matrizAdjacencia = null;
            this.numVertices = 0;
            this.numArestas = 0;
        }
    }

    public abstract int grauVertice (int vertice);
    public abstract boolean insertAresta(int vertice1, int vertice2, int peso);
    public abstract boolean deletedAresta(int vertice1, int vertice2);
    public abstract boolean existeAresta(int vertice1, int vertice2);
}
