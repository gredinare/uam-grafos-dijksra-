package model;

import java.util.HashMap;
import java.util.List;

public class Graph {
    private boolean isDirected;
    private HashMap<Vertex, List<Edge>> vertexList;

    public void setDirected(boolean directed) {
        this.isDirected = directed;
    }

    public void setVertexList(HashMap<Vertex, List<Edge>> vertexList) {
        this.vertexList = vertexList;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public HashMap<Vertex, List<Edge>> getVertexList() {
        return this.vertexList;
    }

}
