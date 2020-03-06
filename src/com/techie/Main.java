package com.techie;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Here we come!");
	    int[] arr1 = {0,2,3,4,5};
	    int[] arr2 = {1,2,3,4,0,5,6,7,8,9};

	    System.out.println(Arrays.toString(arr1) + " is a subset of " + Arrays.toString(arr2) + ": " + isSubset(arr1, arr2));
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
}
