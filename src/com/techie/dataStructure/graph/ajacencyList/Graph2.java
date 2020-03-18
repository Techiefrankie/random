package com.techie.dataStructure.graph.ajacencyList;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph2 {
    private int numVertices;
    LinkedList<Integer>[] ajacencyListArray;

    public Graph2(int n) {
        this.numVertices = n;
        ajacencyListArray = new LinkedList[this.numVertices];

        for (int i = 0; i < this.numVertices; i++){
            this.ajacencyListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(Graph2 graph, int src, int dest){
        graph.ajacencyListArray[src].add(dest);
        graph.ajacencyListArray[dest].add(src);
    }

    public void printGraph(Graph2 graph){
        System.out.println("Printing graph");
        for (int i = 0; i < graph.numVertices; i++){
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for(Integer j: graph.ajacencyListArray[i]){
                System.out.print(" -> " + j);
            }
            System.out.println("\n");
        }
    }
}
