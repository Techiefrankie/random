package com.techie.datastructure.priorityqueue;

public class Student implements Comparable<Student> {
    int rank;
    String name;

    public Student(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        if (rank < student.rank){
            return -1;
        }
        else if (rank > student.rank){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).append(" : ").append(rank).toString();
    }
}
