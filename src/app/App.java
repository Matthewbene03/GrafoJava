package app;

import app.lista.grafossempeso.Grafo;
import app.lista.grafossempeso.GrafoNaoDirecionado;

public class App {
    public static void main(String[] args) throws Exception {
    	Grafo grafo = new GrafoNaoDirecionado(5);
        grafo.insertAresta(0, 1);
        grafo.insertAresta(0, 2);
        grafo.insertAresta(1, 2);
        grafo.insertAresta(2, 4);
        grafo.insertAresta(4, 3);        

        System.out.println("Grafo adicionado. Vamos imprimir: ");
        System.out.println("------------------------------------------------------------------------");
        grafo.imprimeGrafo();
        System.out.println("------------------------------------------------------------------------");


        grafo.deletedAresta(0,1);
        grafo.deletedAresta(2,0);
        System.out.println("Duas arestas removidas. Vamos imprimir: ");
        System.out.println("------------------------------------------------------------------------");
        grafo.imprimeGrafo();
        
        System.out.println("Existe a aresta (0,1): " + grafo.existeAresta(0,1));
        System.out.println("Existe a aresta (2,0): " + grafo.existeAresta(2,0));
        System.out.println("Existe a aresta (1,2): " + grafo.existeAresta(1,2));

  
        System.out.println("Numero de vertice: " + grafo.getNumVertices());
        System.out.println("Numero de arestas: " + grafo.getNumArestas());
        
        System.out.println("Existe vizinhos 0: " + grafo.existeVizinho(0));
        System.out.println("Existe vizinhos 1: " + grafo.existeVizinho(1));
        System.out.println("Existe vizinhos 2: " + grafo.existeVizinho(2));
        System.out.println("Existe vizinhos 3: " + grafo.existeVizinho(3));
        System.out.println("Existe vizinhos 4: " + grafo.existeVizinho(4));
        
        System.out.println("Grau do vertice 0: " + grafo.grauVertice(0));
        System.out.println("Grau do vertice 1: " + grafo.grauVertice(1));
        System.out.println("Grau do vertice 2: " + grafo.grauVertice(2));
        System.out.println("Grau do vertice 3: " + grafo.grauVertice(3));
        System.out.println("Grau do vertice 4: " + grafo.grauVertice(4));
    }
}