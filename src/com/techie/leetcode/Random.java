package com.techie.leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class Random {
    public int[] moveZeroes(int[] array){
        int size = array.length - 1;

        for (int i = 0; i < size; i++){
            if (array[i] == 0){
                int swapIndex = i;
                for (int j = size; j > -1; j--){
                    if (array[j] != 0){
                        //found a non-zero item, grab index
                        swapIndex = j;
                    }
                }
                //swap items
                int temp = array[i];
                int swapItem = array[swapIndex];
                array[i] = swapItem;
                array[swapIndex] = temp;
            }
        }
        return array;
    }

    public boolean containsDuplicate(int[] array){
        int size = array.length;
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j < size; j++){
                if (array[i] == array[j])
                    return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] array){
        int size = array.length;
        Arrays.sort(array);
        for (int i = 0; i < size - 1; ++i){
            if (array[i] == array[i + 1])
                return true;
        }
        return false;
    }

    public ArrayList<String> popularNToys(int numToys, int topToys, List<String> toys, int numQuotes, List<String> quotes){

        ArrayList<String> nTop = new ArrayList<>();

        Map<String, Integer> result = getToysFromQuotes(toys, quotes);
        int i = 0;

        List<Map.Entry<String, Integer>> entryList= new ArrayList<>(result.entrySet());

        Collections.sort(entryList, (a, b) -> (b.getValue() - a.getValue()) != 0 ? (b.getValue() - a.getValue()) : a.getKey().compareTo(b.getKey()));
        while (i < entryList.size() && topToys > 0) {
            topToys--;
            nTop.add(entryList.get(i).getKey());
            i++;
        }

        return nTop;
    }

    private Map<String, Integer> getToysFromQuotes(List<String> toys, List<String> quotes){
        HashMap<String, Integer>  quotesAndCount = new HashMap<>();
        String[] toysArray = toys.stream().toArray(String[]::new);
        String[] quotesAray = quotes.stream().toArray(String[]::new);
        for (int i = 0; i < toysArray.length; i++){
            int count = 0;
            String toy = toysArray[i].toLowerCase();
            for (int j = 0; j < quotesAray.length; j++){
                String quote = quotesAray[j].toLowerCase();
                if (quote.contains(toy))
                    count++;
            }
            quotesAndCount.put(toy, count);
        }
        return quotesAndCount;
    }

    public int getGCD(int num, int[] arr)
    {
        int output = arr[0];
        for(int i = 1; i < arr.length; i++){
            output = gcd(arr[i], output);
            if(output == 1)
                return 1;
        }
        return output;
    }

    private int gcd(int a, int b){
        if (a == 0){
            return b;
        }
        return gcd(b % a, a);
    }

    public List<Integer> cellCompete(int[] cell, int day)
    {
        List<Integer> output = new ArrayList<>();
        int numCells = 8;
        //First create an array with an extra 2 cells (these represent the empty cells on either end)
        int[] temp = new int[cell.length + 2];

        //Copy the cell array into the new input array leaving the value of the first and last indexes as zero (empty cells)
        temp[0] = 0;
        for (int i = 1; i < numCells; i++){
            temp[i] = cell[i];
        }
        temp[temp.length - 1] = 0;
        //This is cool I stole this from the guy above! (cheers mate), this decrements the day count while checking that we are still above zero.
        while (day-- > 0)
        {
            int oldCellValue = 0;

            //In this section we loop through the array starting at the first real cell and going to the last real cell
            //(we are not including the empty cells at the ends which are always inactive/0)

            for (int i = 1; i < temp.length - 1; i++)
            {
                //if the cells below and above our current index are the same == then the target cell will be inactive/0
                //otherwise if they are different then the target cell will be set to active/1
                //NOTE: before we change the index value to active/inactive state we are saving the cells oldvalue to a variable so that
                //we can use that to do the next "cell competition" comparison (this fulfills the requirement to update the values at the same time)

                if (oldCellValue == temp[i + 1])
                {
                    oldCellValue = temp[i];
                    temp[i] = 0;
                }
                else
                {
                    oldCellValue = temp[i];
                    temp[i] = 1;
                }
            }
        }

        //Finally we create a new output array that doesn't include the empty cells on each end
        //copy the input array to the output array and Bob's yer uncle ;)...(comments are lies)

        for(int k = 0; k < numCells; k++){
            output.add(temp[k]);
        }
        return output;
    }

    int minimumDays(int rows, int columns, List<List<Integer> > grid)
    {
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        return -1;
    }

    public void reorderList(ListNode head) {
        if(head == null)return;
        ListNode tail = reorderList(head, getListLength(head));
        System.out.println(tail);
    }

    private ListNode reorderList(ListNode head, int size){
        if(size == 0)return null;
        if(size == 1)return head;
        if(size == 2)return head.next;

        ListNode tail = reorderList(head.next,size - 2);
        //swap nodes
        ListNode temp = tail.next;
        tail.next = tail.next.next;
        temp.next = head.next;
        head.next = temp;
        return tail;
    }

    private int getListLength(ListNode head){
        int size=0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }

    public int factorial(int n){
        int fact = 1;
        if (n == 1)
            return 1;
        if (n == 0)
            return  -1;
        while (n > 1){
            fact += fact * (n - 1);
            n--;
        }
        return fact;
    }

    public int factorial2(int n){
        if (n == 1)
            return 1;
        if (n == 0)
            return  -1;
        return n * factorial(n - 1);
    }

    public HashMap permutation(String shorter, String longer){
        HashMap hm = new HashMap();
        char first = shorter.charAt(0);
        for (int i = 0; i < longer.length(); i++){
            char compare = longer.charAt(i);
            if (first == compare){
                if (getWindowFrom(i, longer, shorter.length()).equals(shorter)){
                    hm.put(i, populate(i, shorter.length()));
                }
            }
        }
        return hm;
    }

    private String getWindowFrom(int i, String longer, int lenShorter) {
        String perm = "";
        int limit = i + lenShorter;
        for (int j = i; j < limit && limit <= longer.length(); j++){
            perm += longer.charAt(j);
        }
        return perm;
    }

    private List<Integer> populate(int i, int lenShorter) {
        List<Integer> list = new ArrayList<>();
        for (int j = i; j < i + lenShorter; j++){
            list.add(j);
        }
        return list;
    }

    public HashMap permutation2(String shorter, String longer){
        HashMap list = new HashMap();
        for (int i = 0; i < longer.length(); i++){
            String compare = "";
            int limit = i + shorter.length();
            for (int j = i; j < limit && limit <= longer.length(); j++){
                compare += longer.charAt(j);
            }
            if (compare.equals(shorter))
                list.put(i, compare);
        }
        return list;
    }

    public  boolean uniqueString(String str){
        for (int i = 0; i < str.length(); i++){
            for (int j = i + 1; j < str.length(); j++){
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public String runLengthCompression(String str){
        StringBuilder sb = new StringBuilder();
        if (str == null || str.length() == 0)
            return "";
        int count = 0;
        char temp = str.charAt(0);

        for (int i = 0; i < str.length(); i++){
            char index = str.charAt(i);
            if (temp == index){
                count++;
            }
            else {
                sb.append(count).append(temp);
                count = 1;
            }
            temp = index;
        }
        //append the last char
        sb.append(count).append(temp);
        return sb.toString();
    }

    public int add(int x, int y){
        // Iterate till there is no carry
        while (y != 0)
        {
            // carry now contains common set bits of x and y
            int carry = x & y;

            // Sum of bits of x and  y where at least one of the bits is not set
            x = x ^ y;

            // Carry is shifted by  one so that adding it  to x gives the required sum
            y = carry << 1;
        }
        return x;
    }


    // Returns count of n length binary
    // strings with consecutive 1's
    public int countStrings(int n)
    {
        // Count binary strings without consecutive 1's.
        // See the approach discussed on be
        // ( http://goo.gl/p8A3sW )
        int a[] = new int[n], b[] = new int[n];
        a[0] = b[0] = 1;

        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        // Subtract a[n-1]+b[n-1] from 2^n
        return (1 << n) - a[n - 1] - b[n - 1];
    }
}
