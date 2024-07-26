package app.grafossempeso;


public class GrafoCDirecao extends GrafoNotPeso{

    public GrafoCDirecao(Integer numVertices){
        super(numVertices);
    }

    public boolean insertAresta(int vertice1, int vertice2){
        if (this.getMatriz() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1>=this.getNumeroVertice() || vertice2 >= this.getNumeroVertice()) return false;
        if(this.getMatriz()[vertice1][vertice2] == 0){
            this.getMatriz()[vertice1][vertice2] = 1;
            this.incrNumArestas();
        }
        return true;
    }

    public boolean deletedAresta(int vertice1, int vertice2){
        if(this.getMatriz() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1>=this.getNumeroVertice() || vertice2 >= this.getNumeroVertice()) return false;
        if (this.getMatriz()[vertice1][vertice2] == 1) {
            this.getMatriz()[vertice1][vertice2] = 0;
            this.decrNumArestas();
        }
        return true;
    }

    public boolean existeAresta(int vertice1, int vertice2){
        if(this.getMatriz() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1>=this.getNumeroVertice() || vertice2 >= this.getNumeroVertice()) return false;
        if (this.getMatriz()[vertice1][vertice2] == 1) return true;
        else return false;
    }

    public int grauVertice(int vertice){
        if(this.getMatriz() == null) return 0;
        if (vertice < 0 || vertice>=this.getNumeroVertice()) return 0;
        int grau = 0;
        for(int j = 0; j<this.getNumeroVertice(); j++){
            if (this.getMatriz()[vertice][j] == 1) {
                grau++;
            } else if (this.getMatriz()[j][vertice] == 1) {
                grau++;
            }
        }
        return grau;
    }
}
