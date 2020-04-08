package com.techie.datastructure.graph.adjmatrix;

import java.util.ArrayList;

public class Graph<T> {

    static class Vertex<T> {
        T data;
        double weight;

        public Vertex(T data) {
            this.data = data;
        }
    }

    boolean[][] adjMatrix;
    int numVertices;
    ArrayList<Vertex> vertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
        vertices = new ArrayList<>();
    }

    void addVertex(Vertex vertex){
        vertices.add(vertex);
    }

    void removeVertex(Vertex vertex){
        vertices.remove(vertex);
    }

    void addEdge(Vertex v1, Vertex v2){
        adjMatrix[vertices.indexOf(v1)][vertices.indexOf(v2)] = true;
        adjMatrix[vertices.indexOf(v2)][vertices.indexOf(v1)] = true;
    }

    void removeEdge(Vertex v1, Vertex v2){
        adjMatrix[vertices.indexOf(v1)][vertices.indexOf(v2)] = false;
        adjMatrix[vertices.indexOf(v2)][vertices.indexOf(v1)] = false;
    }

    boolean isEdge(Vertex v1, Vertex v2){
        return adjMatrix[vertices.indexOf(v1)][vertices.indexOf(v2)];
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (Vertex vertex : vertices){
            sb.append(vertex.data).append(" ");
        }
        sb.append(System.lineSeparator());

        for (int i = 0; i < numVertices; i++) {
            sb.append(vertices.get(i).data + "  ");
            for (boolean j : adjMatrix[i]) {
                sb.append((j ? 1 : 0)+ " ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] arg){
        Graph<String> graph = new Graph(5);
        Vertex A = new Vertex<>("A");
        Vertex B = new Vertex<>("B");
        Vertex C = new Vertex<>("C");
        Vertex D = new Vertex<>("D");
        Vertex E = new Vertex<>("E");

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);

        graph.addEdge(A, B);
        graph.addEdge(A, C);
        graph.addEdge(A, D);
        graph.addEdge(B, D);
        graph.addEdge(D, E);
        graph.addEdge(C, E);

        graph.print();
    }
}
