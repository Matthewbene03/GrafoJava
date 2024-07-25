
public class App {
    public static void main(String[] args) throws Exception {
        Grafo grafo = new Grafo(7);
        grafo.insertAresta(1, 2);
        grafo.insertAresta(1, 5);
        grafo.insertAresta(2, 1);
        grafo.insertAresta(2, 3);
        grafo.insertAresta(2, 5);
        grafo.insertAresta(3, 2);
        grafo.insertAresta(3, 4);
        grafo.insertAresta(4, 3);
        grafo.insertAresta(4, 5);
        grafo.insertAresta(4, 6);
        grafo.insertAresta(5, 1);
        grafo.insertAresta(5, 2);
        grafo.insertAresta(5, 4);
        grafo.insertAresta(6, 4);

        System.out.println("Grafo adicionado. Vamos imprimir: ");
        System.out.println("------------------------------------------------------------------------");
        grafo.imprimeGrafo();
        System.out.println("------------------------------------------------------------------------");



        grafo.deletedAresta(4, 3);
        grafo.deletedAresta(4, 6);
        grafo.deletedAresta(5, 1);
        System.out.println("Três arestas removidas. Vamos imprimir: ");
        System.out.println("------------------------------------------------------------------------");
        grafo.imprimeGrafo();

        System.out.println("Existe a aresta (1,2): " + grafo.existeAresta(1, 2));
        System.out.println("Existe a aresta (4,3): " + grafo.existeAresta(4, 3));
        System.out.println("Numero de vertice: " + grafo.getNumeroVertice());
        System.out.println("Numero de arestas: " + grafo.getNumeroArestas());
        System.out.println("Existe vizinhos: " + grafo.existeVizinho(0));
        System.out.println("Existe vizinhos: " + grafo.existeVizinho(1));
        System.out.println("Grau do vertice 0: " + grafo.grauVertice(0));
        System.out.println("Grau do vertice 1: " + grafo.grauVertice(1));
        System.out.println("Grau do vertice 2: " + grafo.grauVertice(2));
        System.out.println("Grau do vertice 3: " + grafo.grauVertice(3));
        System.out.println("Grau do vertice 4: " + grafo.grauVertice(4));
        System.out.println("Grau do vertice 5: " + grafo.grauVertice(5));
        System.out.println("Grau do vertice 6: " + grafo.grauVertice(6));
    }
}
