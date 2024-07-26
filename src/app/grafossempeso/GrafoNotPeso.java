package app.grafosSemPeso;

public abstract class GrafoNotPeso {

    private Integer numVertices;
    private Integer numArestas;
    //private boolean statusGrafo;
    private Integer[][] matrizAdjacencia = null;

    public GrafoNotPeso (Integer numVertice){
        this.matrizAdjacencia = this.inicializaGrafo(numVertice);
        this.numArestas = 0;
    }

    private Integer[][]  inicializaGrafo(Integer numVertices){
        if(numVertices < 1) return null;

        Integer[][] matrizAux = new Integer[numVertices][numVertices];
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                //System.out.println("["+i+"]["+j+"]");
                matrizAux[i][j] = 0;
            }
        }
        return matrizAux;
    }

    public boolean inicializaGrafo (Integer numVertices, Integer numInvalido){
        if(numVertices < 1) return false;

        this.numVertices = numVertices;
        Integer[][] matrizAux = new Integer[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                //System.out.println("["+i+"]["+j+"]");
                matrizAux[i][j] = numInvalido;
            }
        }
        return true;
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
                    System.out.print("\t" + this.matrizAdjacencia[i][j]);
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

    public void clearGrafo (){
        if(this.matrizAdjacencia != null) {
            this.matrizAdjacencia = null;
            this.numVertices = 0;
            this.numArestas = 0;
        }
    }

    public abstract int grauVertice (int vertice);
    public abstract boolean insertAresta(int vertice1, int vertice2);
    public abstract boolean deletedAresta(int vertice1, int vertice2);
    public abstract boolean existeAresta(int vertice1, int vertice2);
}
