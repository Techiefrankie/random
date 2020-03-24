package com.techie.searching;

public class Driver {

    public static void main(String[] args){
        Binary binarySearch = new Binary();
        int index = recurse(new int[]{1,2,3,4,5,6,7,8,9},1,9, 8);
        //int index = binarySearch.recursiveSearch(new int[]{1,2,3,4,5,6,7,8,9}, 1,9,5);
        System.out.println(index);
    }

    static int search(int[] arr, int item){
        int low = arr[0], high = arr[arr.length - 1];

        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] == item)
                return mid;

            low = item > mid ? mid + 1 : low;
            high = item < mid ? mid - 1 : high;
        }
        return -1;
    }

    static int recurse(int[] arr, int low, int high, int item){
        if (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] == item)
                return mid;

            low = item > mid ? mid + 1 : low;
            high = item < mid ? mid - 1 : high;

            return recurse(arr, low, high, item);
        }
        return -1;
    }
}
