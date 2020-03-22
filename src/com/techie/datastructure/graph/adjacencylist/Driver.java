package com.techie.datastructure.graph.adjacencylist;

import java.util.*;

public class Driver {
    public static void main(String[] args){
        Graph2 graph2 = new Graph2(5);
        graph2.addEdge(graph2, 0, 1);
        graph2.addEdge(graph2, 0, 4);
        graph2.addEdge(graph2, 1, 2);
        graph2.addEdge(graph2, 1, 3);
        graph2.addEdge(graph2, 1, 4);
        graph2.addEdge(graph2, 2, 3);
        graph2.addEdge(graph2, 3, 4);

        graph2.printGraph(graph2);
        graph2.removeEdge(graph2, 1,2);
        graph2.printGraph(graph2);

        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        graph.getAdjVertices();
        Set<String> item = DFS(graph, "Bob");
        System.out.println(item);
    }

    private static Set<String> DFS(Graph graph, String root){
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()){
            String vertex = stack.pop();
            if (!visited.contains(vertex)){
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)){
                    stack.push(v.getLabel());
                }
            }
        }
        return visited;
    }

    private static Set<String> BFS(Graph graph, String root){
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()){
            String vertex = queue.poll();
            if (!visited.contains(vertex)){
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)){
                    queue.add(v.getLabel());
                }
            }
        }
        return visited;
    }
}