package com.techie.datastructure.graph.adjacencylist;

import java.util.LinkedList;
public class Graph2<T>{
    LinkedList[] adjacencyList;
    int numVertices;

    public Graph2(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new  LinkedList[numVertices];

        //initialize array with empty list
        for (int i = 0; i < numVertices; i++){
            adjacencyList[i] = new LinkedList();
        }
    }

    void addEdge(int edge1, int edge2){
        this.adjacencyList[edge1].add(edge2);
        this.adjacencyList[edge2].add(edge1);
    }

    void removeEdge(int edge1, int edge2){
        this.adjacencyList[edge1].remove(edge2);
        this.adjacencyList[edge2].remove(edge1);
    }

    public void print(){
        System.out.println("Printing graph");
        for (int i = 0; i < this.numVertices; i++){
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for(Object j: this.adjacencyList[i]){
                System.out.print(" -> " + j);
            }
            System.out.println("\n");
        }
    }

   public static void main(String[] arg){
        Graph2 graph = new Graph2(5);
        graph.addEdge(1,2);
        graph.addEdge(3,2);
        graph.addEdge(4,2);
        graph.addEdge(4,3);

        graph.print();
    }
}