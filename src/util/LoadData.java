package util;

import model.Graph;
import model.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoadData {
    public static Graph loadFile(String filePath) {
        Graph mGraph = new Graph();

        try {
            BufferedReader mBuffer = new BufferedReader(new FileReader(filePath));
            List<String> mList = mBuffer.lines().toList();

            // O grafo é direcionado?
            boolean isDirected = mList.get(0).contains("S");
            mGraph.setDirected(isDirected);

            // Qual a quantidade de vértices do grafo?
            int lastVertex = Integer.parseInt(mList.get(1)) + 2;

            // Qual o nome dos vértices?
            List<String> vertices = mList.subList(2, lastVertex);
            for(String vertexName : vertices) {
                mGraph.addVertex(new Vertex(vertexName));
            }

            // Quais as arestas e os seus pesos?
            List<String[]> edges = generateEdges(mList.subList(lastVertex, mList.size()));
            for(String[] edgesAndWeight : edges) {
                mGraph.addEdge(new Vertex(edgesAndWeight[0]), new Vertex(edgesAndWeight[1]), Double.parseDouble(edgesAndWeight[2]));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mGraph;
    }

    private static List<String[]> generateEdges(List<String> edgesAndWeights) {
        List<String[]> edgeList = new ArrayList<>();

        for (String edgesAndWeight : edgesAndWeights) {
            String[] edge = edgesAndWeight.split(",");
            edgeList.add(edge);
        }

        return edgeList;
    }
}
