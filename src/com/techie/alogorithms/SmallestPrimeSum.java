package com.techie.alogorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestPrimeSum {
    public static void main(String[] args) {
        int n = 27;
        System.out.println("The final smallest sum of prime factors is: " + getSmallestPrimeFactors(n));
    }

    private static int getSmallestPrimeFactors(int n) {
        List<Integer> result = new ArrayList<>();

        while (n > 0) {
            List<Integer> primePieces = getPrimeFactors(n);
            System.out.printf("The prime factors of %d are %s\n", n, Arrays.toString(primePieces.toArray()));

            int sumOFactors = primePieces.stream().mapToInt(Integer::intValue).sum();

            if (n == sumOFactors || sumOFactors == 0) {
                return n;
            }

            result.add(sumOFactors);
            n = sumOFactors;
        }

        return Collections.min(result);
    }


    // Function to get the prime factors of a given number
    public static List<Integer> getPrimeFactors(int n) {
        List<Integer> primeFactors = new ArrayList<>();

        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i + 2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            primeFactors.add(n);

        return primeFactors;
    }

    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        // Corner case
        if (n <= 1) {
            return false;
        }

        // Check from 2 to the square root of n
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}