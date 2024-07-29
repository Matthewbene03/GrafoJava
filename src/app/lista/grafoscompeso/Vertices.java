package app.lista.grafoscompeso;

public class Vertices {
	Integer vertice;
	Integer peso;
	
	public Vertices (Integer vertice, Integer peso) {
		this.vertice = vertice;
		this.peso = peso;
	}

	public Integer getVertice() {
		return vertice;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	public String toString() {
		return "["+this.vertice+", "+this.peso+"]";
	}
}
