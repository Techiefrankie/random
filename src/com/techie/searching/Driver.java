package com.techie.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Driver {

    public static void main(String[] args){
        Searching searching = new Searching();
        //int index = searching.binarySearch(new int[]{5,7,9,0,3}, 3, 0, 6);
        HashMap permutation = searching.permutation2("abbc", "abbcbbcabcbcbaaabbcbcaacbabbc");
        System.out.println();
    }
}
