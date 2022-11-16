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

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mGraph;
    }
}
