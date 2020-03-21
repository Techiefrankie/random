package com.techie.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Searching {
    public int binarySearch(int[] items, int item, int low, int high){
        int index = -1;
        //sort array
        Arrays.sort(items);
        int size = items.length;
        int mid = size / 2;

        if (item == items[mid])
            return  mid;

        while (size/2 > 0){
            if (item < mid){
                high = mid - 1;
                if (item == items[high])
                    return high;
            }
            else  if (item > mid){
                low = mid + 1;
                if (item == items[low])
                    return low;
            }
            size--;
            return binarySearch(items, item, low, high);
        }
        return index;
    }
}
