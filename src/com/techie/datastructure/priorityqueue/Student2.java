package com.techie.datastructure.priorityqueue;

public class Student2 implements Comparable<Student2>{
    int id;
    String name;
    double cgpa;

    public Student2(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getCgpa(){
        return this.cgpa;
    }

    @Override
    public int compareTo(Student2 student) {
        if(cgpa < student.getCgpa()){
            return -1;
        }
        else if(cgpa == student.getCgpa()){
            return name.compareTo(student.getName());
        }
        else if(cgpa == student.getCgpa() && name.equals(student.getName())){
            if(id < student.getId()){
                return -1;
            }
            return 1;
        }
        return 0;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(name).toString();
    }
}
