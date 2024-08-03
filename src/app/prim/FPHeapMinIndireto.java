package app.prim;

public class FPHeapMinIndireto {

	private double p[];
	private int n, pos[], fp[];
	
	public FPHeapMinIndireto(double p[], int v[]) {
		this.p = p;
		this.fp = v;
		this.n = this.fp.length-1;
		this.pos = new int[n];
		for(int u = 0; u < n; u++) {
			this.pos[u] = u+1;
		}
	}
	
	public void refaz (int esq, int dir) {
		int j = esq*2;
		int x = fp[esq];
		
		while (j <= dir) {
			if ((j < dir) && (p[fp[j]] > p[fp[j + 1]])) j++;
			if (p[x] <= p[fp[j]]) break;
			fp[esq] = fp[j];
			pos[fp[j]] = esq;
			esq = j;
			j = esq*2;
		}
		fp[esq] = x;
		pos[x] = esq;
	}
	
	public void constroi() {
		int esq = (n/2) + 1;
		while (esq > 1){
			esq--;
			this.refaz(esq, this.n);
		}
	}
	
	public int retiraMin() throws Exception{
		int minimo;
		if (n < 1) throw new Exception("Erro: Heap vazio");
		else {
			minimo = fp[1]; 
			fp[1] = fp[n];
			pos[fp[n--]] = 1;
			this.refaz(1, n);
		}
		return minimo;
	}
	
	public void diminuiChave(int i, double chaveNova) throws Exception{
		i = pos[i];
		int x = fp[i];
		
		if(chaveNova < 0) throw new Exception("Erro: chaveNova com valor incorreto");
		p[x] = chaveNova;
		
		while((i > 1) && (p[x] <= p[fp[1/2]])) {
			fp[i] = fp[i/2];
			pos[fp[i/2]] = i;
			i /= 2; 
		}
		fp[i] = x;
		pos[x] = i;
	}
	
	boolean vazio () {
		return n == 0;
	}
}
