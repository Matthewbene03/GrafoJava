package app;

import app.lista.grafossempeso.Grafo;
import app.lista.grafossempeso.GrafoDirecionado;

public class App {
    public static void main(String[] args) throws Exception {

    	Grafo grafo = new GrafoDirecionado(6);
    	grafo.insertAresta(0,1);
    	grafo.insertAresta(1, 4);
    	grafo.insertAresta(4, 3);
    	grafo.insertAresta(3, 1);
    	grafo.insertAresta(0, 3);
    	grafo.insertAresta(2, 4);
    	grafo.insertAresta(2, 5);
    	grafo.insertAresta(5, 5);


        System.out.println("Grafo adicionado. Vamos imprimir: ");
        System.out.println("------------------------------------------------------------------------");
        grafo.imprimeGrafo();
        System.out.println("------------------------------------------------------------------------");
        
        grafo.DFS();
       

    }
}
