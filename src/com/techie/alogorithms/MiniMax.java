package com.techie.alogorithms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MiniMax {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        List<BigInteger> list = new ArrayList<>(arr.stream().map(BigInteger::valueOf).collect(Collectors.toUnmodifiableList()));
        System.out.println("Before sorting " + arr);
        Collections.sort(list);

        System.out.println("After sorting " + arr);
        BigInteger total = BigInteger.valueOf(0);

        for (BigInteger i : list) {
            total = total.add(i);
        }

        System.out.println("Total " + total);

        BigInteger max = total.subtract(list.get(0));
        BigInteger min = total.subtract(list.get(list.size() - 1));


        System.out.printf("%d %d", min, max);
    }

    public static void main(String[] arg) {
        List<Integer> list = Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625);
        miniMaxSum(list);

        int[] arr = new int[5];
        System.out.println("\nArr[0]= "+ arr[0]);
    }
}
