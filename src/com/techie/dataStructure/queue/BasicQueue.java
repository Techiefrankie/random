package com.techie.dataStructure.queue;

public class BasicQueue<T> {
    private  T[] data;
    private int front;
    private int end;

    public BasicQueue() {
        this(100);
    }

    public BasicQueue(int size) {
        this.data = (T[]) new Object[size];
        front = -1;
        end = -1;
    }

    public int size(){
        if (front == end)
            return 0;
        return end - front + 1;
    }

    public void enqueue(T item){
        if ((end + 1) % data.length == front)
            throw new IllegalStateException("Queue is full");
        //first item
        if (size() == 0) {
            front++;
            end++;
            data[end] = item;
        }
        else {
            //subsequent items
            data[++end] = item;
        }
    }

    public T dequeue(){
        T item = null;
        if (size() == 0)
            throw new IllegalStateException("Queue is empty");
        //if its the last item
        if (end == front){
            //reset pointers
            item = data[front];
            data[front] = null;
            front = end = -1;
        }
        else {
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }

    public boolean contains(T item){
        for (T element : data){
            if (element == item)
                return  true;
        }
        return false;
    }

    public T access(int position){
        if (size() == 0 || position > size() || position < 0)
            throw new IllegalStateException("Queue empty or position out of bound");
        for (int i = front; i < end; i++){
            if (i == position)
                return data[i];
        }
        return null;
    }
}
