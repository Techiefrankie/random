package com.techie.dataStructure.stack;

public class BasicStack<T> {
    private  T[] data;
    private  int stackPointer;

    public BasicStack(){
        this.stackPointer = 0;
        this.data = (T[]) new Object[52];
    }

    public void  push(T item){
        data[stackPointer++] = item;
    }

    public T pop(){
        if (stackPointer > 0)
            return data[--stackPointer];
        return null;
    }

    public  int size(){
        return stackPointer;
    }

    public boolean contains(T item){
        for (T element : data){
            if (item == element)
                return  true;
        }
        return false;
    }

    public T access(T item){
        while (stackPointer > 0){
            T tmp = pop();
            if (item == tmp)
                return  item;
        }
        return  null;
    }
}
