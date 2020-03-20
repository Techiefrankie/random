package com.techie.datastructure.graph.adjacencylist;

import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<Vertex, List<Vertex>>();
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public  void addVertex(String label){
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label){
        Vertex vertex = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(vertex));
        adjVertices.remove(new Vertex(label));
    }

    public void addEdge(String label1, String label2){
        Vertex vertex1 = new Vertex(label1);
        Vertex vertex2 = new Vertex(label2);
        getAdjVertices(label1).add(vertex2);
        getAdjVertices(label2).add(vertex1);
    }

    public void removeEdge(String label1, String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Vertex> ev1 = adjVertices.get(v1);
        List<Vertex> ev2 = adjVertices.get(v2);

        if (ev1 != null)
            adjVertices.remove(v2);
        if (ev2 != null)
            adjVertices.remove(v1);
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }
}
