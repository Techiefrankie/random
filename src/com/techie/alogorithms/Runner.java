package com.techie.alogorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {
        List<String> repository = new ArrayList(Arrays.asList("mobile", "mouse", "moneypot","monitor", "mousepad"));
        String customerQuery = "mouse";

        final List<List<String>> lists = Stunt.searchSuggestions(repository, customerQuery);

        int[] arr = new int[]{1, 3, 7, 9, 2};
        System.out.println(Arrays.toString(Stunt.findTwoSum(arr, 11)));

        // Degree of an array

        String inputData = "";
//        String thisLine = null;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        while ((thisLine = br.readLine()) != null) {
//            inputData += thisLine + "\n";
//        }
        // Output the solution to the console
        System.out.println(Stunt.arrayDegree(inputData));

        int[] arr2 = new int[]{1 ,2, 2, 3, 1};
    }
}
