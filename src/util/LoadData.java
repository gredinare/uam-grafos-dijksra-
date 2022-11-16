package util;

import model.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
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
            int numberOfVertex = Integer.parseInt(mList.get(1));

            // Qual o nome dos vértices?
            int toIndex = 2 + numberOfVertex;


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mGraph;
    }
}
