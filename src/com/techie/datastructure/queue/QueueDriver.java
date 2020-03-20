package com.techie.datastructure.queue;

import java.util.PriorityQueue;

public class QueueDriver {
    public static void main(String args[]){
        BasicQueue<Integer> basicQueue = new BasicQueue<>(10);
        System.out.println(basicQueue.size());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        System.out.println("PQ: " + priorityQueue.size());
        //priorityQueue.remove();
        System.out.println(priorityQueue.contains(0));
        basicQueue.enqueue(1);
        System.out.println(basicQueue.size());
//        basicQueue.dequeue();
//        System.out.println(basicQueue.size());
    }
}
