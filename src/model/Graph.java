package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private boolean isDirected;
    private HashMap<Vertex, List<Edge>> vertexList = new HashMap<>();;

    public void setDirected(boolean directed) {
        this.isDirected = directed;
    }

    public void setVertexList(HashMap<Vertex, List<Edge>> vertexList) {
        this.vertexList = vertexList;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public HashMap<Vertex, List<Edge>> getVertexList() {
        return this.vertexList;
    }


    public void addVertex(Vertex vertex) {
        vertexList.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex vertexFrom, Vertex vertexTo, double weight) {
        vertexList.get(vertexFrom).add(new Edge(vertexTo, weight));

        if(!isDirected) {
            vertexList.get(vertexTo).add(new Edge(vertexFrom, weight));
        }
    }
}
