package app.grafossempeso;


public class GrafoSDirecao extends GrafoNotPeso{

    public GrafoSDirecao(Integer numVertices){
        super(numVertices);
    }

    @Override
    public boolean insertAresta(int vertice1, int vertice2){
        if (this.getMatriz() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 || vertice1>=this.getNumeroVertice() || vertice2 >= this.getNumeroVertice()) return false;
        if(this.getMatriz()[vertice1][vertice2] == 0){
            this.getMatriz()[vertice1][vertice2] = 1;
            this.getMatriz()[vertice2][vertice1] = 1;
            this.incrNumArestas();
        }
        return true;
    }

    @Override
    public boolean deletedAresta(int vertice1, int vertice2){
        if(this.getMatriz() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 || vertice1>=this.getNumeroVertice() || vertice2 >= this.getNumeroVertice()) return false;
        if (this.getMatriz()[vertice1][vertice2] == 1) {
            this.getMatriz()[vertice1][vertice2] = 0;
            this.getMatriz()[vertice2][vertice1] = 0;
            this.decrNumArestas();
        }
        return true;
    }

    @Override
    public boolean existeAresta(int vertice1, int vertice2){
        if(this.getMatriz() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 || vertice1>=this.getNumeroVertice() || vertice2 >= this.getNumeroVertice()) return false;
        if (this.getMatriz()[vertice1][vertice2] == 1) {
            return true;
        } else{
            return false;
        }
    }

    @Override
    public int grauVertice(int vertice){
        if(this.getMatriz() == null) return 0;
        if (vertice < 0 || vertice>=this.getNumeroVertice()) return 0;
        int grau = 0;
        for(int j = 0; j<this.getNumeroVertice(); j++){
            if (this.getMatriz()[vertice][j] == 1) {
                grau++;
            }
        }
        return grau;
    }
}