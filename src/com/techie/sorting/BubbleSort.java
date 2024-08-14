package com.techie.sorting;

import java.util.Arrays;

public class BubbleSort {
    private static int[] bubbleSort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap the indexes
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {25, 64, 34, 25, 12, 22, 11, 90};
        int[] sortedArr = bubbleSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}
