package app.lista.grafoscompeso;

import java.util.List;

public class GrafoNaoDirecionado extends Grafo{

	public GrafoNaoDirecionado(Integer numVertices) {
		super(numVertices);
	}

	@Override
	public boolean insertAresta(Integer vertice1, Integer vertice2, Integer peso) {
        if (this.getListaAdjacencia() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 || vertice1 >= this.getNumVertices()
        		|| vertice2 >= this.getNumVertices()) return false;
       	this.getListaAdjacencia().get(vertice1).add(new Vertices(vertice2, peso));
       	this.getListaAdjacencia().get(vertice2).add(new Vertices(vertice1, peso));
        this.incrNumArestas();
        return true;
	}

	@Override
	public int grauVertice(Integer vertice) {
        if(this.getListaAdjacencia() == null) return 0;
        if (vertice < 0 || vertice>=this.getNumVertices()) return 0;
        int grau = 0;
        if(this.getListaAdjacencia().get(vertice) != null) {
        	grau = this.getListaAdjacencia().get(vertice).size();
        }
        return grau;
	}

	@Override
	public boolean deletedAresta(Integer vertice1, Integer vertice2) {
        if(this.getListaAdjacencia() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 
        		|| vertice1>=this.getNumVertices() || vertice2 >= this.getNumVertices()) return false;
        if (this.getListaAdjacencia().get(vertice1) != null) {
        	
        	int index = this.getListaAdjacencia().get(vertice1).indexOf(verticeAux(this.getListaAdjacencia().get(vertice1), vertice2));
        	if(index != -1)	this.getListaAdjacencia().get(vertice1).remove(index);
        	else return false;
        	index = this.getListaAdjacencia().get(vertice2).indexOf(verticeAux(this.getListaAdjacencia().get(vertice2), vertice1));
        	if(index != -1) this.getListaAdjacencia().get(vertice2).remove(index);
        	else return false;
            this.decrNumArestas();
        }
        return true;
	}
	
	private Vertices verticeAux(List<Vertices> aux, Integer vertice) {
		Vertices auxV = null;
    	for(Vertices v:aux) {
    		if(v.getVertice() == vertice) {
    			auxV = v;
    		}
    	}
    	return auxV;
	}

	@Override
	public boolean existeAresta(Integer vertice1, Integer vertice2) {
        if(this.getListaAdjacencia() == null) return false;
        if (vertice1 < 0 || vertice2 < 0 || vertice1 == vertice2 
        		|| vertice1>=this.getNumVertices() || vertice2 >= this.getNumVertices()) return false;
        if (this.getListaAdjacencia().get(vertice1) != null) {
        	int index = this.getListaAdjacencia().get(vertice1).indexOf(verticeAux(this.getListaAdjacencia().get(vertice1), vertice2));
        	if(index != -1) return true;
        	else return false;
        } else{
            return false;
        }
	}

}
