package com.techie.alogorithms.arrayrotation;

import java.util.Arrays;
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

    public static void main(String[] args){
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(rotateLeft(array, 4));
    }
}
