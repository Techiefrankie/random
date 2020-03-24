package com.techie.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Binary {
    public int iterativeSearch(int arr[], int item)
    {
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

    int recursiveSearch(int arr[], int low, int high, int item)
    {
        if (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] == item)
                return mid;

            low = item > mid ? mid + 1 : low;
            high = item < mid ? mid - 1 : high;

            return recursiveSearch(arr, low, high, item);
        }
        return -1;
    }
}
