package com.techie.datastructure.graph.adjacencylist;

import java.util.*;

public class Graph<T>{

    static class Vertex<T>{
        private T data;
        private double weight;

        public Vertex(T data) {
            this.data = data;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    HashMap<Vertex, List<Vertex>> adjVertexHMap;

    public Graph() {
        this.adjVertexHMap = new HashMap<>();
    }

    void addVertex(Vertex vertex){
        //add a new adjacency vertex in the hash table and set value to an arraylist
        this.adjVertexHMap.putIfAbsent(vertex, new ArrayList<>());
    }

    void removeVertex(Vertex vertex){
        //get this adjacency vertex from the graph
        List<Vertex> vertexList = this.adjVertexHMap.get(vertex);
        //remove any value in the vertex
        this.adjVertexHMap.values().stream().forEach(e -> e.remove(vertex));
        //remove the vertex
        this.adjVertexHMap.remove(vertex);
    }

    void addEdge(Vertex v1, Vertex v2){
        this.adjVertexHMap.get(v1).add(v2);
        this.adjVertexHMap.get(v2).add(v1);
    }

    void removeEdge(Vertex v1, Vertex v2){
        this.adjVertexHMap.get(v1).remove(v2);
        this.adjVertexHMap.get(v2).remove(v1);
    }

    List<Vertex> getAdjVertices(Vertex vertex){
        return this.adjVertexHMap.get(vertex);
    }

    Set<T> BFS(Vertex root){
        //create a set to hold unique visited nodes
        Set<T> visited = new LinkedHashSet<>();
        //a queue to gold adjacent vertices to be explored
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            //get the item at the front of the queue
            Vertex vertex = queue.poll();
            //if this node has not been visited previously, visit it
            if (!visited.contains(vertex.data)){
                visited.add((T) vertex.data);
                //explore the node
                for (Vertex v : getAdjVertices(vertex)){
                    queue.add(v);
                }
            }
        }
        return visited;
    }

    Set<T> DFS(Vertex root){
        //set to hold unique visited nodes
        Set<T> visited = new LinkedHashSet<>();
        //stack to hold adjacent nodes to be visited
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()){
            Vertex vertex = stack.pop();
            if (!visited.contains(vertex.data)){
                visited.add((T) vertex.data);
                for (Vertex v : getAdjVertices(vertex)){
                    stack.push(v);
                }
            }
        }
        return visited;
    }

    int maximumPathSum(Vertex root){
        //implementation using DFS
        //set to hold unique visited nodes
        Set<T> visited = new LinkedHashSet<>();
        //stack to hold adjacent nodes to be visited
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        Vertex previous = root;
        Vertex next = null;
        Set<Integer> result = new LinkedHashSet<>();

        while (!stack.empty()){
            Vertex vertex = stack.pop();
            previous = vertex;
            if (!visited.contains(vertex.data)){
                visited.add((T) vertex.data);
                for (Vertex v : this.adjVertexHMap.get(vertex)){
                    stack.push(v);
                    next = v;
                    result.add((int)previous.data + (int)next.data);
                }
            }
        }
        int size = result.size();
        return Collections.min(result);
    }

    void print(){
        StringBuilder sb = new StringBuilder();
        ArrayList<Map.Entry<Vertex, List<Vertex>>> entries = new ArrayList<>(this.adjVertexHMap.entrySet());

        for (int i = 0; i < entries.size(); i++){
            Map.Entry<Vertex, List<Vertex>> vertexEdges = entries.get(i);
            List<Vertex> list = vertexEdges.getValue();
            T head = (T) entries.get(i).getKey().data;

            sb.append(head + " -> ");
            int size = list.size();
            for (Vertex vertex : list){

                if (size > 0){
                    sb.append(head);
                    sb.append("-");
                    sb.append(vertex.data);

                    size--;
                    if (size > 0)
                        sb.append(", ");
                }
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    void print(Set<T> visited){
        //print to console the traversal path
        StringBuilder sb = new StringBuilder();
        int size = visited.size();
        for (T node : visited){
            sb.append(node);
            size--;
            if (size > 0)
                sb.append(" -> ");
        }
        System.out.println(sb.toString());
    }

    public static int clip(String str){
        ArrayList<String> result = new ArrayList(Collections.singleton(str.split("")));

        for (int i = 0, j = str.length() - 1; i < str.length() && j >= 0; i++, j--){
            char a = str.charAt(i);
            char b = str.charAt(j);

            if ((a == '0' && b == '1') || (a == '1' && b == '0')){
                result.remove(a);
                result.remove(b);
            }
        }

        return result.size();
    }

    public static void main(String[] arg){
        String str = "000*111";
        System.out.println(clip(str));

        Graph<String> graph = new Graph<>();
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

        graph.print(graph.BFS(A));
        graph.print(graph.DFS(A));
        graph.print(graph.BFS(B));
        graph.print(graph.DFS(B));

        System.out.println(System.lineSeparator());

        graph.removeVertex(C);
        graph.print();

        graph.removeEdge(A, B);
        graph.print();

    }
}