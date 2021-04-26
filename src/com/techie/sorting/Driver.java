package com.techie.sorting;

import java.util.Arrays;

public class Driver {
    public static void main(String[] arg){
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        int[] arr = {3,2,5,6,7,8,9,1,0};
        //mergeSort.sort(arr, 0, 8);
        quickSort.sort(arr, 0, 8);

        System.out.println(Arrays.toString(arr));
    }
}
