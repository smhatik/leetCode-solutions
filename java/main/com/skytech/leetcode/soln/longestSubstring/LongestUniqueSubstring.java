package com.skytech.leetcode.soln.longestSubstring;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 *Given a string s, find the length of the longest substring without duplicate characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 * Time: O(n)
 *
 * Space/Memory: O(1) for best case. worst case O(n)
 *
 */
public class LongestUniqueSubstring {

    // Version 1: Correct sliding window
    public static int lengthOfLongestSubstringV1(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // shrink from left until duplicate removed
            while (window.contains(current)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // Version 2: Reset window on duplicate
    public static int lengthOfLongestSubstringV2(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            // reset completely if duplicate
            while (window.contains(current)) {
                window = new HashSet<>();
                left = right;
            }

            window.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    @Test
    public void testSameResults() {
        assertEquals(3, lengthOfLongestSubstringV1("abcabcbb"));
        assertEquals(3, lengthOfLongestSubstringV2("pwwkew"));
        assertEquals(2, lengthOfLongestSubstringV1("abba"));
        assertEquals(2, lengthOfLongestSubstringV2("abba"));
        assertEquals(3, lengthOfLongestSubstringV1("dvdf")); // correct answer = 3 ("pwke")
        assertEquals(3, lengthOfLongestSubstringV2("dvdf")); // correct answer = 3 ("pwke")
    }

    @Test
    public void testVersion2Fails() {
        // Classic test case where Version 2 fails
        assertEquals(3, lengthOfLongestSubstringV1("abcabcbb")); // correct answer = 3 ("abc")
        assertEquals(3, lengthOfLongestSubstringV2("abcabcbb")); // correct answer = 3 ("abc")
        assertEquals(4, lengthOfLongestSubstringV1("wpwkew")); // correct answer = 4 ("pwke")
        assertEquals(4, lengthOfLongestSubstringV2("wpwkew")); // correct answer = 4 ("pwke")
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringV2("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstringV2("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstringV1("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstringV1("wpwkew"));   // 4
        System.out.println(lengthOfLongestSubstringV1(""));         // 0
        System.out.println(lengthOfLongestSubstringV2("au"));       // 2
        System.out.println(lengthOfLongestSubstringV1("dvdf"));       // 3
    }
}
