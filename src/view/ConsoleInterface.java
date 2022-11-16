package view;

import model.Dijkstra;
import model.Edge;
import model.Graph;
import model.Vertex;

import java.util.ArrayList;
import java.util.List;

public class ConsoleInterface {
    private Graph graph;

    public ConsoleInterface(Graph graph) {
        this.graph = graph;
    }

    public void printTableGraph() {
        List<Vertex> mList = new ArrayList<>(graph.getVertices().keySet());;

        // Imprimir colunas com o nome dos vértices
        printFirstLine(mList);

        // Imprimir linhas restantes do grafo

        for(Vertex vertex : mList) {
            printLine(vertex, mList, graph.getVertices().get(vertex));
            System.out.println();
        }

        System.out.println();

    }

    public void runDijkstra() {
        System.out.println("=== Dijkstra ===");
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.calculateShortestPath(graph.getVertex("A"));
    }

    private void printFirstLine(List<Vertex> listVertices) {
        printCell("");
        for (Vertex vertex : listVertices) {
            printCell(vertex.getName());
        }
        System.out.println();
    }

    private void printLine(Vertex vertex, List<Vertex> listVertices, List<Edge> listEdges) {
        printCell(vertex.getName());

        for(Vertex vertexEdge: listVertices) {
            double out = 0;
            for(Edge edge : listEdges) {
                if(vertexEdge.equals(edge.getVertex())) {
                    out = edge.getWeight();
                }
            }
            printCell("" + out);
        }
    }

    private void printCell(String str) {
        String pattern = "%5s |";
        System.out.printf(pattern, str);
    }
}
