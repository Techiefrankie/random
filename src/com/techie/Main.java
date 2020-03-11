package com.techie;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Here we come!");
	    int[] arr1 = {0,2,3,4,5};
	    int[] arr2 = {1,7,3,2,0,5,9,7,6,8};

	    System.out.println(Arrays.toString(arr1) + " is a subset of " + Arrays.toString(arr2) + ": " + isSubset(arr1, arr2));

	    System.out.println("Selection Sort: " + Arrays.toString(selectionSort(new int[]{8, 1, 2, 3, 4, 5, 6, 7, 9})));
    }

    private  static  boolean isSubset(int[] arrx, int[]arry){
        for (int index : arrx){
            if (!isInArray(index, arry))
                return  false;
        }
        return true;
    }

    private  static  boolean isInArray(int element, int[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] == element)
                return true;
        }
        return false;
    }

    private static int[] sortArray(int[] array){
        int[] sorted = new int[array.length];
        for (int i = 0; i < array.length; i++){
            sorted[i] = returnLesser(array[i], array);
        }

        return sorted;
    }

    private static  int returnLesser(int index, int[] array){
        for (int element : array){
            if (element < index)
                return element;
        }
        return  index;
    }

    private  static int binSearch (int element, int[] array, int low, int high){
       if (high >= low){
           int mid = (low + high) / 2;

           if (element == mid)
               return mid;
           if (element < mid)
               return binSearch(element,array, low, mid - 1);
           if (element > mid)
               return binSearch(element,array, mid + 1, high);
       }
        return  -1;
    }

    private static int[] selectionSort(int[] arr){
        int size = arr.length;
        for (int i = 0; i < size - 1; i++){

            int minIndex = 0;
            for (int j = i + 1; j < size; j ++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return  arr;
    }
}
