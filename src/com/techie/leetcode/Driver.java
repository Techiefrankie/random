package com.techie.leetcode;

import java.beans.PropertyChangeSupport;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Driver {
    public static  void main(String[] args){

        Random random = new Random();
        System.out.println("Longest substring of abccccabcbb = " + random.lengthOfLongestSubstring2("abccccabcbb"));

        Permutation permutation = new Permutation();

        System.out.println(random.countStrings(5));

        System.out.println(permutation.permute(new int[]{1,2,3}));

        System.out.println(random.add(3,5));

        System.out.println(" Run length compression of aabccccdeeeaajk = " + random.runLengthCompression("aabccccdeeeaajk"));

        System.out.println("B".compareTo("b"));
        System.out.println(Arrays.toString(random.moveZeroes(new int[]{0,9,0,6,0,7,0,8,0,3})));
        System.out.println(random.containsDuplicate2(new int[]{1,2,3,4,5,1}));

        int numToys = 6;
        int topToys = 2;
        List<String> toys = new ArrayList(Arrays.asList("elmo","elsa","legos","drone","tablet","warcraft","23280666003629"));
        int numQuotes = 6;
        List<String> quotes = new ArrayList<>(Arrays.asList("Elmo is the hottest toy of the season"
        ,"Elmo would be on every kid's wishlist"
        ,"The new Elmo dolls are super high quality"
        ,"Expect the Elsa dolls to be very popular this year"
        ,"Elmo and Elsa are the dolls!"));

        List<Integer> result = new ArrayList<>();
        System.out.println(random.popularNToys(numToys,topToys,toys,numQuotes,quotes));

    }
}



