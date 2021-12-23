package com.techie.alogorithms.arrayrotation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayRotation {
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        Integer[] rotatedArray = a.toArray(new Integer[a.size()]);

        for (int  i = 0; i < d; i++){
            rotatedArray = rotateArray(rotatedArray);
        }
        return Arrays.asList(rotatedArray);
    }

    private static Integer[] rotateArray(Integer[] arr){
        Integer[] rotatedArray = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++){
            int j = i + 1; // to make up for array index starting at 0
            int newIndex = i - 1 < 0 ? arr.length - j : i - 1;
            rotatedArray[newIndex] = arr[i];
        }
        return rotatedArray;
    }

    static List<Integer> rotateLeft(List<Integer> a, int d) {
        Integer[] rotatedArray = a.toArray(new Integer[a.size()]);
        for (int s = d, t = 0; t < a.size(); s++, t++) {
            // t is target position; s is source position
            rotatedArray[t] = a.get(s % a.size());
        }
        return Arrays.asList(rotatedArray);
    }

    static List<Integer> rotateLeft1(List<Integer> a, int d) {
        Integer[] rotatedArray = a.toArray(new Integer[a.size()]);
        for (int s = d, t = 0; t < a.size(); s++, t++) {
            int j = t + 1; // to make up for array index starting at 0
            int newIndex = t - 1 < 0 ? rotatedArray.length - j : t - 1;
            rotatedArray[newIndex] = a.get(t);
        }
        return Arrays.asList(rotatedArray);
    }

    public static void main(String[] args){
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(rotateLeft(array, 4));
    }

    public static List<Integer> encryptionValidity(int instructionCount, int validityPeriod, List<Integer> keys) {
        // Write your code here
        //convert the keys list param to an array for easier array indexing operations
        Integer[] encrytionValidity  = keys.toArray(new Integer[keys.size()]);

        //compute the number of times a hacker could try
        int retries = instructionCount * validityPeriod;

        // create an array to hold the degrees of divisibility of the elements
        Integer[] divisibility = new Integer[encrytionValidity.length];

        // iterate through the keys array and compute the divisibility degrees

        for(int i = 0; i < encrytionValidity.length; i++){
            //create an inner loop to for inner comparison with other elements
            for (int j = 0; j < encrytionValidity.length; j++){
                if(encrytionValidity[i] % encrytionValidity[j] == 0){
                    //elements are divisible, increment count
                    //counter++;
                }
            }
        }

        int max = Collections.max(Arrays.asList(divisibility));
        int ec = (int) (max *  Math.pow(2,3));
        return Arrays.asList(1, ec);
    }
}
