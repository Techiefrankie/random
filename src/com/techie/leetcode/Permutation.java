package com.techie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        permute(numsList, 0, numsList.size());

        return result;
    }

    public void permute(List<Integer> numsList, int start, int end) {
        if (start == end) {
            result.add(numsList);
        } else {
            for (int i = start; i < end; i++){
                List<Integer> newList = new ArrayList<>(numsList);
                Collections.swap(newList, start, i);
                permute(newList, start + 1, end);
            }
        }
    }
}
