package com.techie.datastructure.hashTable;

public class BasicHash<K, V> {
    private HashEntry[] data;
    private  int capacity;
    private  int size;

    public BasicHash(int capacity) {
        this.capacity = capacity;
        this.data = new HashEntry[capacity];
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public V get(K key){
        int hash = calculateHash(key);
        if (data[hash] == null)
            return null;
        return (V)data[hash].getValue();
    }

    public void put(K key, V value){
        if (size > capacity)
            throw new IllegalStateException("Hash table capacity exceeded");
        int hash = calculateHash(key);
        data[hash] = new HashEntry<>(key,value);
        size++;
    }

    public  V delete(K key){
        //get the value of the key so it can be return
        V value = get(key);

        //clear the hashtable slot for the key
        int hash = calculateHash(key);
        data[hash] = null;
        size--;
        hash = (hash + 1) % this.capacity;

        while (data[hash] != null){
            HashEntry he = data[hash];
            data[hash] = null;
            //reposition hash item
            put((K)(he.getKey()), (V)he.getValue());
            size--;
            hash = (hash + 1) % this.capacity;
        }

        return value;
    }

    public  boolean hasKey(K key){
        int hash = calculateHash(key);
        if (data[hash].getKey() == key)
            return  true;
        return  false;
    }

    public  boolean hasValue(V value){
        for (int i = 0; i < capacity ; i++){
            if (data[i].getValue() == value)
                return  true;
        }
        return  false;
    }

    private int calculateHash(K key){
        int hash = key.hashCode() % this.capacity;
        //this is necessary to avoid collision
        while (data[hash] != null && !data[hash].getKey().equals(key)){
            hash = (hash  + 1) % this.capacity;
        }
        return hash;
    }
}
