package com.techie.searching;

public class Driver {

    public static void main(String[] args) {
        Binary binarySearch = new Binary();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(binarySearch.iterativeBinSearch(arr, 1));
        System.out.println(binarySearch.recursiveSearch(arr, 0, 8, 1));
    }
}
