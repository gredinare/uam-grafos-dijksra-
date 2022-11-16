package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    private Graph graph;
    private List<Vertex> unvisitedVertices;
    private HashMap<Vertex, Double> shortestPath;

    public Graph getGraph() {
        return this.graph;
    }

    public Dijkstra(Graph graph) {
        this.graph = graph;
        this.unvisitedVertices = new LinkedList<>();
        this.shortestPath = new HashMap<>();
    }

    public void calculateShortestPath(Vertex source) {
        this.initialization(source);

    }

    private void initialization(Vertex source) {
        for(Map.Entry<Vertex, List<Edge>> pair : graph.getVertices().entrySet()) {
            if(pair.getKey().getName().equals(source.getName())) {
                shortestPath.put(pair.getKey(), Double.MIN_VALUE);
            } else {
                shortestPath.put(pair.getKey(), Double.MAX_VALUE);
            }
            this.unvisitedVertices.add(pair.getKey());
        }
    }

    private Vertex getMinValueVertex() {

    }
}
