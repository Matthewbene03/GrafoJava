package app.lista.grafossempeso;

public class GrafoDirecionado extends Grafo{

	public GrafoDirecionado(Integer numVertices) {
		super(numVertices);
	}

	@Override
	public int grauVertice(int vertice) {
        if(this.getListaAdjacencia() == null) return 0;
        if (vertice < 0 || vertice>=this.getNumVertices()) return 0;
        int grau = 0;
        if(this.getListaAdjacencia().get(vertice) != null) {
        	grau = this.getListaAdjacencia().get(vertice).size();
        }
        return grau;
	}

	@Override
	public boolean insertAresta(int vertice1, int vertice2) {
        if (this.getListaAdjacencia() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1>=this.getNumVertices() 
        		|| vertice2 >= this.getNumVertices()) return false;
       	this.getListaAdjacencia().get(vertice1).add(vertice2);
        this.incrNumArestas();
        return true;
	}

	@Override
	public boolean deletedAresta(int vertice1, int vertice2) {
        if(this.getListaAdjacencia() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1>=this.getNumVertices() 
        		|| vertice2 >= this.getNumVertices()) return false;
        if (this.getListaAdjacencia().get(vertice1) != null) {
        	int index = this.getListaAdjacencia().get(vertice1).indexOf(vertice2);
        	if(index != -1) {
        		this.getListaAdjacencia().get(vertice1).remove(index);
        		this.decrNumArestas();
        	}
        }
        return true;
	}

	@Override
	public boolean existeAresta(int vertice1, int vertice2) {
        if(this.getListaAdjacencia() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1>=this.getNumVertices() 
        		|| vertice2 >= this.getNumVertices()) return false;
        if (this.getListaAdjacencia().get(vertice1) != null) {
        	int index = this.getListaAdjacencia().get(vertice1).indexOf(vertice2);
        	if(index != -1) return true;
        	else return false;
        } else{
            return false;
        }
	}
}
