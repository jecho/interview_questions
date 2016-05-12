package com.foxley.interview;

import java.util.HashSet;

/*
 *
 *  Date 05/10/2016
 *  @author Jecho Ricafrente
 *
 *  Longest repeating substring
 *
 *  Time complexity is O(n)
 *  Space complexity is O(n) 
 *
 */

public class LongestNonRepeatingSubstring {

    // goal is to fill set and take the max from the current vs
    // the set's size, and to clear the set when we've detected
    // a duplicate
    public static int longestNRSubstringLen(String input) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(max, set.size());
            } else {
                set.clear();
                set.add(c);
            }
        }

        return max;
    }
}
