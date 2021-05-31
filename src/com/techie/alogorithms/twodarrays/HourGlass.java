package com.techie.alogorithms.twodarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a 2d 6x6 array, arr,
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 *
 * An hourglass in A is a subset of values with indices falling in this pattern in arr's graphical representation:
 * a  b  c
 *    d
 * e  f  g
 *
 * There are 16  hourglasses in arr. An hourglass sum is the sum of an hourglass' values.
 * Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.
 * The array will always be 6x6.
 *
 * The maximum hourglass sum in the above is 19.
 */
public class HourGlass{

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        Integer[] sums = new Integer[16];

        // traverse the array in the form of an hour glass

        int counter = 0;
        for(int i = 0; i < 4; i++){

            for (int j = 1; j <= 4; j++){
                Integer a = arr.get(i).get(j - 1);
                Integer b = arr.get(i).get(j);
                Integer c = arr.get(i).get(j + 1);

                Integer d = arr.get(i + 1).get(j);

                Integer e = arr.get(i + 2).get(j - 1);
                Integer f = arr.get(i + 2).get(j);
                Integer g = arr.get(i + 2).get(j + 1);

                sums[counter] = a + b + c + d + e + f + g;
                counter++;
            }
        }

        return Collections.max(Arrays.asList(sums));
    }

    public static void main(String[] args){
        List<Integer> row1 = Arrays.asList(1, 1, 1, 0, 0, 0);
        List<Integer> row2 = Arrays.asList(0, 1, 0, 0, 0, 0);
        List<Integer> row3 = Arrays.asList(1, 1, 1, 0, 0, 0);
        List<Integer> row4 = Arrays.asList(0, 0, 2, 4, 4, 0);
        List<Integer> row5 = Arrays.asList(0, 0, 0, 2, 0, 0);
        List<Integer> row6 = Arrays.asList(0, 0, 1, 2, 4, 0);

        List<List<Integer>> arr = Arrays.asList(row1,row2, row3, row4, row5, row6);

        System.out.println(String.format("Maximum sum of hour glass sum is: %d", hourglassSum(arr)));
    }
}