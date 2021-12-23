package com.techie.alogorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

    /**
     * Amazon is building a way to help customers
     * search reviews quicker by providing real-time
     * suggestions to search terms when the customer
     * starts typing. When given a minimum of two
     * characters into the search field the system will
     * suggest at most three keywords from the review
     * word repository. As the customer continues to
     * type in the reviews search bar thè relevant
     * keyword suggestions will update automatically.
     * Write an algorithm that will output a maximum of
     * three keyword suggestions after each character is
     * typed by the customer in the search field.
     * If there are more than three acceptable keywords,
     * return the keywords that are first in alphabetical
     * order.
     * Only return keyword suggestions after the
     * customer has entered two characters.
     * Keyword suggestions must start with the
     * characters already typed
     * Both the repository and the customerQuery
     * should be compared in a case-insensitive way.
     * @param repository
     * @param customerQuery
     * @return list
     * Example
     * Input:
     * repository = [ "mobile", "mouse", "moneypot","monitor", "mousepad" ], customerQuery = "mouse"
     * Output:
     * ["mobile", "moneypot", "monitor"]
     * ["mouse", "mousepad"]
     * ["mouse", "mousepad"]
     * ["mouse", "mousepad"]
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
    // Write your code here
        List<List<String>> result = new ArrayList<>();
        String search = "";

            for (int i = 0; i < customerQuery.length(); i++) {
                search = search.concat(String.valueOf(customerQuery.charAt(i)));

                if (search.length() >= 2) {
                    List<String> keywords = new ArrayList<>();
                    for(String repString : repository) {

                        if ( repString.toLowerCase().contains(search.toLowerCase())) {
                            keywords.add(repString.toLowerCase());
                        }
                    }

                    Collections.sort(keywords);
                    if (!keywords.isEmpty() && keywords.size() > 3) {
                        result.add(keywords.subList(0, 3));
                    }
                    else if (keywords.size() > 0) {
                        result.add(keywords);
                    }
                }

            }

        return result;
    }

}
