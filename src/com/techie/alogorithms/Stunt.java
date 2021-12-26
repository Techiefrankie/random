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

    /**
     * Amazon Fresh is running a promotion in which
     * customers receive prizes for purchasing a secret
     * combination of fruits. The combination will change
     * each day, and the team running the promotion
     * wants to use a code list to make it easy to change
     * the combination. The code list contains groups of
     * fruits. Both the order of the groups within the code
     * list and the order of the fruits within the groups
     * matter. However, between the groups of fruits, any
     * number, and type of fruit is allowable. The term
     * "anything" is used to allow for any type of fruit to
     * appear in that location within the group.
     * Consider the following secret code list: [[apple,
     * apple], [banana, anything, banana]]
     * Based on the above secret code list, a customer
     * who made either of the following purchases would
     * win the prize:
     * orange, apple, apple, banana, orange, banana
     * apple, apple, orange, orange, banana, apple,
     * banana, banana
     * Write an algorithm to output 1 if the customer is a
     * winner else output 0,
     * @param codeList
     * @param shoppingCart
     * @return
     */
    public static int winsPromo(List<String> codeList, List<String> shoppingCart) {
        if ( !codeList.contains("anything") ) {
            String code = convertListToString(codeList);
            String cart = convertListToString(shoppingCart);

            return cart.contains(code) ? 1 : 0;
        }
        else {
             final int codeListSize = codeList.size();
             final int cartSize = shoppingCart.size();

             for (int i = 0; i < cartSize; i++) {
                if (codeListSize <= cartSize) {

                    List<String> subCart = shoppingCart.subList(i, codeListSize + i);
                    final boolean b = isEqualLists(codeList, subCart);

                    if (b) {
                        return 1;
                    }
                }
                else {
                    return 0;
                }
            }
        }

        return 0;
    }

    private static boolean isEqualLists(List<String> aGroup, List<String> subCart) {
        for (int i = 0; i < aGroup.size(); i++) {
            if (!aGroup.get(i).equalsIgnoreCase(subCart.get(i)) && !aGroup.get(i).equalsIgnoreCase("anything"))
                return false;
        }

        return true;
    }

    private static String convertListToString(List<String> list) {
        return String.join(",", list);
    }

    /**
     * Huffman coding assigns variable length codewords to fixed length input characters based on their frequencies.
     * More frequent characters are assigned shorter codewords and less frequent characters are assigned longer codewords.
     * All edges along the path to a character contain a code digit. If they are on the left side of the tree,
     * they will be a 0 (zero). If on the right, they'll be a 1 (one). Only the leaves will contain a letter and its frequency count.
     * All other nodes will contain a null instead of a character, and the count of the frequency of all of it and its descendant characters.
     *
     * For instance, consider the string ABRACADABRA. There are a total of  characters in the string.
     * This number should match the count in the ultimately determined root of the tree. Our frequencies are  and .
     * The two smallest frequencies are for  and , both equal to , so we'll create a tree with them.
     * The root node will contain the sum of the counts of its descendants, in this case .
     * The left node will be the first character encountered, , and the right will contain .
     * Next we have  items with a character count of : the tree we just created, the character  and the character .
     * The tree came first, so it will go on the left of our new root node.  will go on the right.
     * Repeat until the tree is complete, then fill in the 's and 's for the edges. The finished graph looks like:
     * @param s
     * @param root
     */

    void decode(String s, Node root) {
        String result = "";
        Node current = root;
        Node node = null;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                node = current.left;

                if (node.left == null && node.right == null) {
                    result = result.concat(String.valueOf(node.data));
                    current = root;
                }
                else {
                    current = node;
                }
            }
            else if (c == '1') {
                node = current.right;

                if (node.left == null && node.right == null) {
                    result = result.concat(String.valueOf(node.data));
                    current = root;
                }
                else {
                    current = node;
                }
            }
        }

        System.out.println(result);
    }

    abstract class Node implements Comparable<Node> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right;

    public Node(int freq) {
      frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
}

}
