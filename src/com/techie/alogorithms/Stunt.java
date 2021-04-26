package com.techie.alogorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Stunt {
    /*
    Algorithm to return the index of two numbers in an array that add up to a target
     */

    public static int[] findTwoSum(int[] arr, int target){
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] + arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] findTwoSum2(int[] arr, int target){
        HashMap<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int currentValue = store.get(arr[i]);

            if (currentValue >= 0){
                return new int[]{currentValue, i};
            }
            else{
                int numToFind = target - arr[i];
                store.put(numToFind, i);
            }
        }
        return null;
    }

    /*Given a non-empty array N, of non-negative integers , the degree of this array is defined as the maximum frequency
    of any one of its elements. Your task is to find the smallest possible length of a (contiguous) subarray of N,
    that has the same degree as N. For example, in the array [1 2 2 3 1], integer 2 occurs maximum of twice.
    Hence the degree is 2.
    */

    public static String arrayDegree(String inputData){
        String[] input = inputData.split("\\n");
        System.out.println(input[0]);
        System.out.println(input[1]);

        int[] arr = new int[]{};
        int temp = arr[0];
        int counter = 0;
        int[] degrees = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            int index = arr[i];
            if (index == temp){
                counter++;
            }
            else{
                degrees[i] = counter;
                counter = 1;
            }
            // set temp to the current item
            temp = index;
        }

        return String.valueOf(Arrays.stream(degrees).max().getAsInt());
    }
}
