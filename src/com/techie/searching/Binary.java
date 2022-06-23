package com.techie.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Binary {

    public boolean iterativeBinSearch(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (( high - low) / 2);

            if (arr[mid] == k) {
                return true;
            } else if (k > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }


    public boolean recursiveSearch(int[] arr, int key, int left, int right){
        if (left > right) {
            return false;
        }
        int mid = left + ((right - left) / 2);

        if (key == arr[mid]) {
            return true;
        } else if (key < arr[mid]) {
            return recursiveSearch(arr, key, left, mid - 1);
        } else {
            return recursiveSearch(arr, key, mid + 1, right);
        }
    }
}
