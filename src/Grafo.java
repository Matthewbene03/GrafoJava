

public class Grafo {

    private Integer numVertices;
    private Integer numArestas;
    //private boolean statusGrafo;
    private Integer[][] matrizAdjacencia = null;

    public Grafo(Integer numVertices){
        this.matrizAdjacencia = this.inicializaGrafo(numVertices);
        this.numArestas = 0;
    }

    private Integer[][] inicializaGrafo(Integer numVertices){
        if(numVertices < 1) return null;

        this.numVertices = numVertices;
        Integer[][] matrizAux = new Integer[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                //System.out.println("["+i+"]["+j+"]");
                matrizAux[i][j] = 0;
            }
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
                    System.out.print("\t" + this.matrizAdjacencia[i][j]);
                }
                System.out.println("");
            }
        }
    }

    public boolean insertAresta(int vertice1, int vertice2){
        if (this.matrizAdjacencia == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 || vertice1>=this.numVertices || vertice2 >= this.numVertices) return false;
        if(this.matrizAdjacencia[vertice1][vertice2] == 0){
            this.matrizAdjacencia[vertice1][vertice2] = 1;
            this.matrizAdjacencia[vertice2][vertice1] = 1;
            this.numArestas++;
        }
        return true;
    }

    public boolean deletedAresta(int vertice1, int vertice2){
        if(this.matrizAdjacencia == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 || vertice1>=this.numVertices || vertice2 >= this.numVertices) return false;
        if (this.matrizAdjacencia[vertice1][vertice2] == 1) {
            this.matrizAdjacencia[vertice1][vertice2] = 0;
            this.matrizAdjacencia[vertice2][vertice1] = 0;
            this.numArestas--;
        }
        return true;
    }

    public boolean existeAresta(int vertice1, int vertice2){
        if(this.matrizAdjacencia == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 || vertice1>=this.numVertices || vertice2 >= this.numVertices) return false;
        if (this.matrizAdjacencia[vertice1][vertice2] == 1) {
            return true;
        } else{
            return false;
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

    public int grauVertice(int vertice){
        if(this.matrizAdjacencia == null) return 0;
        if (vertice < 0 || vertice>=this.numVertices) return 0;
        int grau = 0;
        for(int j = 0; j<this.numVertices; j++){
            if (this.matrizAdjacencia[vertice][j] == 1) {
                grau++;
            }
        }
        return grau;
    }

    public int getNumeroVertice(){
        return this.numVertices;
    }

    public int getNumeroArestas(){
        return this.numArestas;
    }

    public void clearGrafo (){
        if(this.matrizAdjacencia != null) {
            this.matrizAdjacencia = null;
            this.numVertices = 0;
            this.numArestas = 0;
        }
    }

}