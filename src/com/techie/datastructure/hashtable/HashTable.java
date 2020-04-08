package com.techie.datastructure.hashtable;

public class HashTable<K, V> {

    class HashData<K, V>{
        K key;
        V value;

        public HashData(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    HashData<K, V>[] table;
    int capacity;
    int size = 0;

    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new HashData[capacity];
    }

    int getSize(){
        return this.size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    void  put(K key, V value){
        if (size == capacity)
            throw new IllegalStateException("The capacity of the table is exhausted");
        int hash = getHashCode(key);
        table[hash] = new HashData(key, value);
        size++;
    }

    V get(K key){
        int hash = getHashCode(key);
        return table[hash].getValue();
    }

    void remove(K key){
        int hash = getHashCode(key);
        table[hash] = null;
        size--;
    }

    boolean hasKey(K key){
        return table[getHashCode(key)].getKey() == key;
    }

    boolean hasValue(V value){
        for (int i = 0; i < table.length; i++){
            if (table[i].getValue() == value)
                return  true;
        }
        return  false;
    }

    int getHashCode(K key){
        int hash = Math.abs(key.hashCode() % this.capacity);
        //to avoid collision
        while (table[hash] != null && table[hash].getKey() != key){
            hash = (hash + 1 ) % this.capacity;
        }
        return hash;
    }

    void printTable(){
        for (int i = 0; i < table.length; i++){
            if (table[i] != null)
                System.out.println(i + ": key = " + table[i].getKey() + ", value = " + table[i].getValue());
        }
    }

    public static void main(String[] arg){
        HashTable<String, String> ht = new HashTable<>(5);
        ht.put("Amazon", "Amazon Web Service");
        ht.put("Microsoft", "Azure Cloud");
        ht.put("Databricks", "Delta Lake");
        ht.put("Apache", "Apache Spark");
        ht.put("Yahoo", "Hadoop");
        System.out.println("Size: " + ht.getSize());
        ht.printTable();
        ht.remove("Yahoo");
        System.out.println("Size: " + ht.getSize());
        ht.printTable();
        ht.put("Yahoo", "Hadoop");
        System.out.println("Size: " + ht.getSize());
        ht.printTable();
        System.out.println("Has key Databricks: " + ht.hasKey("Databricks"));
        System.out.println("Has value Hadoop: " + ht.hasValue("Hadoop"));
    }
}
