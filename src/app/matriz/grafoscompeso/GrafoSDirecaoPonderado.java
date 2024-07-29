package app.matriz.grafoscompeso;

public class GrafoSDirecaoPonderado extends GrafoPonderado{

    public GrafoSDirecaoPonderado (Integer numVertice){
        super(numVertice);
    }

    @Override
    public int grauVertice(int vertice) {
        if(this.getMatriz() == null) return 0;
        if (vertice < 0 || vertice>=this.getNumeroVertice()) return 0;
        int grau = 0;
        for(int j = 0; j<this.getNumeroVertice(); j++){
            if (this.getMatriz()[vertice][j] != getNumInvalido()) {
                grau++;
            }
        }
        return grau;    }

    @Override
    public boolean insertAresta(int vertice1, int vertice2, int peso) {
        if (this.getMatriz() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 || vertice1>=this.getNumeroVertice() || vertice2 >= this.getNumeroVertice()) return false;
        if(this.getMatriz()[vertice1][vertice2] == this.getNumInvalido()){
            this.getMatriz()[vertice1][vertice2] = peso;
            this.getMatriz()[vertice2][vertice1] = peso;
            this.incrNumArestas();
        }
        return true;
    }

    @Override
    public boolean deletedAresta(int vertice1, int vertice2) {
        if(this.getMatriz() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 
        || vertice1>=this.getNumeroVertice() || vertice2 >= this.getNumeroVertice() 
        || this.getMatriz()[vertice1][vertice2] == this.getNumInvalido()) return false;
        if (this.getMatriz()[vertice1][vertice2] != this.getNumInvalido()) {
            this.getMatriz()[vertice1][vertice2] = this.getNumInvalido();
            this.getMatriz()[vertice2][vertice1] = this.getNumInvalido();
            this.decrNumArestas();
        }
        return true;
    }

    @Override
    public boolean existeAresta(int vertice1, int vertice2) {
        if(this.getMatriz() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 || vertice1>=this.getNumeroVertice() 
        || vertice2 >= this.getNumeroVertice() || this.getMatriz()[vertice1][vertice2] == this.getNumInvalido()) return false;
        if (this.getMatriz()[vertice1][vertice2] != this.getNumInvalido()) {
            return true;
        } else{
            return false;
        }
    }

}
