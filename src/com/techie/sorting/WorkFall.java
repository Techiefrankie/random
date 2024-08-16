package com.techie.sorting;

import java.util.Arrays;

public class WorkFall {

    public static void main(String[] args) {
        int[] input = {9,2,4,0,27,1,13,7,11,18};
        int sum = 58;

        //find possibility of 5 numbers summing up 42 ...

        System.out.println("Find sum: " + findSum(5, sum, input));


        // second approach
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Sample array
        int sum2 = 34; // Sample sum
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Sum: " + sum2);
        System.out.println("Has combination: " + hasCombination(array, sum2, 5));
    }


    static boolean findSum(int n, int sum, int[] arr) {

        if (arr.length == 0) {
            return  false;
        }

        int total = 0;

        for(int i = 0; i < arr.length;) {
            int counter = 0;

            for (int j = i; j < arr.length && counter < n; j++) {
                total = total + arr[j];
                counter++;
            }

            if (total == sum) {
                return true;
            } else {
                total = 0;
                i++;
            }
        }

        return false;
    }

    public static boolean hasCombination(int[] array, int sum, int n) {
        return hasCombination(array, sum, 0, n);
    }

    private static boolean hasCombination(int[] array, int sum, int startIndex, int itemCount) {
        if (itemCount == 0) {
            return sum == 0;
        }

        for (int i = startIndex; i < array.length; i++) {
            if (hasCombination(array, sum - array[i], i + 1, itemCount - 1)) {
                return true;
            }
        }
        return false;
    }
}
