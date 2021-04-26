package com.techie.alogorithms;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FluidTalTest {
        public static void main(String args[] ) throws Exception {
            String inputData = "";
            String thisLine = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while ((thisLine = br.readLine()) != null) {
                inputData += thisLine + "\n";
            }
            // Output the solution to the console
            System.out.println(codeHere(inputData));
        }

        public static String codeHere(String inputData) {
            // Use this function to write your solution;

            // parse the values for the computation from the input
            String[] lines = inputData.split("\\n");
            String firstLine = lines[0];
            String[] firstLineArr = firstLine.split(" ");
            int n = Integer.parseInt(firstLineArr[0]), m = Integer.parseInt(firstLineArr[1]);
            StringBuilder sb = new StringBuilder();

            // for N >= 1 number of cards
            if(n >= 1){
                // loop through the number of moves to be made, start at 1 since values at index
                // 0 are for N and M

                // create a stack of cards N cards
                int[] stack = new int[n];

                // fill up the stack with cards values, topmost card has value 1 and bottom has value N
                int count = 1;
                for(int k = 0; k < n; k++){
                    stack[k] = count;
                    count++;
                }

                for (int i = 1; i < lines.length && m <= 100000; i++) {
                    String moves = lines[1].replaceAll("\\s+", "");

                    // perform the shuffling operation
                    // take out A cards
                    int Ai = Integer.parseInt(String.valueOf(moves.charAt(0)));
                    int Bi = Integer.parseInt(String.valueOf(moves.charAt(1)));
                    int Ci = Integer.parseInt(String.valueOf(moves.charAt(2)));

                    int[] tempA = new int[Ai];
                    int[] tempB = new int[Ai];
                    int[] tempC = new int[Ai];

                    // Take deck A
                    for(int j = 0; j < Ai; j++){
                        tempA[j] = stack[j];
                        stack[j] = 0; // replace the value with 0 to show empty slot
                    }

                    int lastZeroIndex = getLastZeroIndex(stack);

                    // Take deck B
                    for (int j = 0; j < Bi; j++) {
                        // increment last zero index to start from the first non zero item
                        lastZeroIndex++;
                        tempB[j] = stack[lastZeroIndex];
                        stack[lastZeroIndex] = 0; // replace the value with 0 to show empty slot
                    }

                    // put A deck back
                    // get the last 0 index and start putting the deck from that point
                    lastZeroIndex = getLastZeroIndex(stack); // refresh pointer

                    for(int k = Ai - 1; k >= 0; k--){
                        stack[lastZeroIndex] = tempA[k];
                        lastZeroIndex--;
                    }

                    // Take deck C
                    lastZeroIndex = getLastZeroIndex(stack); // refresh pointer
                    for (int j = 0; j < Ci; j++) {
                        // increment last zero index to start from the first non zero item
                        lastZeroIndex++;
                        tempC[j] = stack[lastZeroIndex];
                        stack[lastZeroIndex] = 0; // replace the value with 0 to show empty slot
                    }

                    // put B deck back
                    // get the last 0 index and start putting the deck from that point
                    lastZeroIndex = getLastZeroIndex(stack); // refresh pointer

                    for(int k = Bi - 1; k >= 0; k--){
                        stack[lastZeroIndex] = tempB[k];
                        lastZeroIndex--;
                    }

                    // put C deck back
                    // get the last 0 index and start putting the deck from that point
                    lastZeroIndex = getLastZeroIndex(stack); // refresh pointer

                    for(int k = Ci - 1; k >= 0; k--){
                        stack[lastZeroIndex] = tempC[k];
                        lastZeroIndex--;
                    }

                }

                // print out the shuffled cards
                for (int j = 0; j < n; j++) {
                    sb.append(stack[j]).append(" ");
                }
            }

            return sb.toString();
        }

        public static int getLastZeroIndex(int[] arr){
            for (int i = 0; i < arr.length; i++){
                if(arr[i] == 0){
                    continue;
                }
                else{
                    // return the index before this as the last zero index
                    return i - 1;
                }
            }
            return 0;
        }
    }

