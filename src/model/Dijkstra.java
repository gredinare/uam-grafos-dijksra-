package model;

import java.util.*;

public class Dijkstra {
    private final Graph graph;
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

        while(unvisitedVertices.size() != 0) {
            Vertex currentVertex = getMinorVertex();
            List<Edge> listEdges = getAdj(currentVertex);

            evaluation(currentVertex, listEdges, shortestPath.get(currentVertex));

            unvisitedVertices.remove(currentVertex);
            printPaths();
        }

    }

    private void initialization(Vertex source) {
        for(Map.Entry<Vertex, List<Edge>> pair : graph.getVertices().entrySet()) {
            if(pair.getKey().getName().equals(source.getName())) {
                shortestPath.put(pair.getKey(), 0d);
            } else {
                shortestPath.put(pair.getKey(), Double.MAX_VALUE);
            }
            unvisitedVertices.add(pair.getKey());
        }
    }

    private void evaluation(Vertex fromVertex, List<Edge> toVertices, double currentWeight) {

        for(Edge edge : toVertices) {
            Vertex toVertex = edge.getVertex();
            double weight = currentWeight + edge.getWeight();

            if(shortestPath.get(toVertex) > weight) {
                shortestPath.remove(toVertex);
                toVertex.setDaddy(fromVertex);
                shortestPath.put(toVertex, weight);
            }
        }

    }

    private Vertex getMinorVertex() {
        double minor = Double.MAX_VALUE;
        Vertex out = null;
        boolean fullInfinite = true;

        for(Vertex v : shortestPath.keySet()) {
            if(unvisitedVertices.contains(v) && shortestPath.get(v) < minor) {
                out = v;
                minor = shortestPath.get(v);
                fullInfinite = false;
            }

            if(unvisitedVertices.contains(v) && fullInfinite) {
                out = v;
            }
        }

        return out;
    }

    private List<Edge> getAdj(Vertex vertex) {
        if(graph.getVertices().get(vertex) == null) {
            return new LinkedList<>();
        }
        return graph.getVertices().get(vertex);
    }

    public void printUnvisitedVertices() {
        System.out.print("UNVISITED VERTICES: ");
        for(Vertex v : unvisitedVertices) {
            System.out.print(v.getName() + ", ");
        }
        System.out.println();
    }

    public void printPaths() {
        for(Map.Entry<Vertex, Double> pair : shortestPath.entrySet()){
            System.out.printf("| %5s | %5s | %10s |%n", pair.getKey().getName(),getDaddy(pair.getKey()), pair.getValue());
        }
        System.out.println();
    }

    public String getDaddy(Vertex vertex) {
        String path = "";
        Vertex tempVertex = vertex;
        StringBuilder stringBuilder = new StringBuilder();

        while(tempVertex.getDaddy() != null) {
            path += tempVertex.getName();
            tempVertex = tempVertex.getDaddy();
        }


        return stringBuilder.append(path).reverse().toString();
    }
}
