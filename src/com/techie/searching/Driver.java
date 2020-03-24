package com.techie.searching;

public class Driver {

    public static void main(String[] args){
        Binary binarySearch = new Binary();
        int index = binarySearch.iterativeSearch(new int[]{5,7,9,0,3}, 3);
        System.out.println(index);
    }
}
