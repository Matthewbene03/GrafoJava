package app.prim;

import app.matriz.grafoscompeso.Aresta;
import app.matriz.grafoscompeso.GrafoPonderado;

public class Prim {
	
	private int [] antecessor;
	private double[] p;
	private GrafoPonderado grafo;
	
	public Prim(GrafoPonderado grafo) {
		this.grafo = grafo;
	}
	
	public void obterAgmPrim(int raiz) throws Exception {
		int n = grafo.getNumeroVertice();
		p = new double[n]; //Peso dos vértices
		int[] vs = new int[n+1]; // vértices
		boolean[] itensHeap = new boolean[n];
		antecessor = new int[n];
		
		for(int u = 0; u < n; u++) {
			antecessor[u] = -1;
			p[u] = Double.MAX_VALUE; //Infinito
			vs[u+1] = u; //Heap indireto a ser construido
			itensHeap[u] = true;
		}
		
		p[raiz] = 0;
		FPHeapMinIndireto heap = new FPHeapMinIndireto(p, vs);
		heap.constroi();
		
		while (!heap.vazio()) {
			int u = heap.retiraMin();
			itensHeap[u] = false;
			if(!this.grafo.listaAdjVazia(u)) {
				Aresta adj = grafo.primeiroListaAdj(u);
				while (adj != null) {
					int v = adj.getV2();
					if (itensHeap[v] && (adj.getPeso() < this.peso (v))) {
						antecessor[v] = u;
						heap.diminuiChave(v, adj.getPeso());
					}
					adj = grafo.proxAdj(u);
				}
			}
		}	
	}
	
	public int antecessor (int u) {
		return antecessor[u];
	}
	
	public double peso (int u) {
		return p[u];
	}
	
	public void imprime () {
		for (int u = 0; u < p.length; u++) {
			if(antecessor[u] != -1) System.out.println("(" + antecessor[u] + ", " + u + ") --p: " + peso(u));
		}
	}
}
