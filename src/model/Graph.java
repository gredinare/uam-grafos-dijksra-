package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private boolean isDirected;
    private HashMap<Vertex, List<Edge>> vertices = new HashMap<>();;

    public void setDirected(boolean directed) {
        this.isDirected = directed;
    }

    public void setVertices(HashMap<Vertex, List<Edge>> vertices) {
        this.vertices = vertices;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public HashMap<Vertex, List<Edge>> getVertices() {
        return this.vertices;
    }

    public Vertex getVertex(String name) {
        List<Vertex> list = new ArrayList<>(this.getVertices().keySet());
        for(Vertex vertex : list) {
            if(vertex.getName().equals(name)) {
                return vertex;
            }
        }
        return null;
    }

    public void addVertex(Vertex vertex) {
        vertices.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex vertexFrom, Vertex vertexTo, double weight) {
        vertices.get(vertexFrom).add(new Edge(vertexTo, weight));

        if(!isDirected) {
            vertices.get(vertexTo).add(new Edge(vertexFrom, weight));
        }
    }
}
