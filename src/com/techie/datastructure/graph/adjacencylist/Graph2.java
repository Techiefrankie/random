package com.techie.datastructure.graph.adjacencylist;

import java.util.LinkedList;

public class Graph2 {
    private int numVertices;
    LinkedList<Integer>[] adjListArray;

    public Graph2(int n) {
        this.numVertices = n;
        adjListArray = new LinkedList[this.numVertices];

        for (int i = 0; i < this.numVertices; i++){
            this.adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(Graph2 graph, int src, int dest){
        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }

    public void removeEdge(Graph2 graph, int src, int dest){
        graph.adjListArray[src].remove(dest);
        graph.adjListArray[dest].remove(src);
    }

    public void printGraph(Graph2 graph){
        System.out.println("Printing graph");
        for (int i = 0; i < graph.numVertices; i++){
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for(Integer j: graph.adjListArray[i]){
                System.out.print(" -> " + j);
            }
            System.out.println("\n");
        }
    }
}
