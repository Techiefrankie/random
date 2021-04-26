package com.techie.datastructure.priorityqueue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Driver {
    public static void main(String[] args){
        // java implementation of PriorityQueue
        PriorityQueue studentQueue = new PriorityQueue<>();

        studentQueue.add(new Student(2,"Jewel"));
        studentQueue.add(new Student(1,"Endless"));
        studentQueue.add(new Student(3,"Beco"));

        Iterator<Student> iterator = studentQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        PriorityQueue studentQueue2 = new PriorityQueue<>();
        studentQueue2.add(new Student2(50, "John",3.75));
        studentQueue2.add(new Student2(24, "Mark",3.8));
        studentQueue2.add(new Student2(35, "Samiha",3.7));
        studentQueue2.poll();
        studentQueue2.poll();
        studentQueue2.add(new Student2(36, "Samiha",3.85));
        studentQueue2.poll();
        studentQueue2.add(new Student2(42, "Ashley",3.9));
        studentQueue2.add(new Student2(46, "Maria",3.6));
        studentQueue2.add(new Student2(49, "Anik",3.95));
        studentQueue2.add(new Student2(50, "Dan",3.95));
        studentQueue2.poll();

        Iterator<Student> iterator2 = studentQueue2.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

    }
}
