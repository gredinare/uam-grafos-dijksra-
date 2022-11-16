package view;

import model.Edge;
import model.Graph;
import model.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsoleInterface {
    private Graph graph;
    private String pattern = "%10s |";

    public ConsoleInterface(Graph graph) {
        this.graph = graph;
    }

    public void printTableGraph() {
        List<Vertex> mList = new ArrayList<Vertex>(graph.getVertexList().keySet());

        // Imprimir colunas com o nome dos vértices
        printFirstLine(mList);

        // Imprimir linhas restantes do grafo

        for(Vertex vertex : mList) {
            printLine(vertex, mList, graph.getVertexList().get(vertex));
            System.out.println();
        }

    }

    private void printFirstLine(List<Vertex> listVertices) {
        System.out.print(String.format(pattern, ""));
        for (Vertex vertex : listVertices) {
            System.out.print(String.format(pattern, vertex.getName()));
        }
        System.out.println();
    }

    private void printLine(Vertex vertex, List<Vertex> listVertices, List<Edge> listEdges) {
        System.out.print(String.format(pattern, vertex.getName()));

        for(Vertex vertexEdge: listVertices) {
            double out = 0;
            for(Edge edge : listEdges) {
                if(vertexEdge.equals(edge.getVertex())) {
                    out = edge.getWeight();
                }
            }
            System.out.print(String.format(pattern, out));
        }
    }
}
