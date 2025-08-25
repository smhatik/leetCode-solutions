package com.skytech.leetcode.soln.longestCommonPrefix;

/**
 *
 *Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 *
 *
 * Horizontal Scanning (Most Intuitive)
 *
 * Take the first string as the prefix.
 *
 * Compare it with the second string, shorten the prefix until it matches.
 *
 * Continue with all strings.
 *
 * If at any point prefix becomes empty → return "".
 *
 * Example:
 * ["flower","flow","flight"]
 *
 * prefix = "flower"
 *
 * Compare with "flow" → common = "flow"
 *
 * Compare "flow" with "flight" → common = "fl"
 *
 * ✅ Result = "fl"
 *
 * Time Complexity: O(N * M) (N = number of strings, M = length of the shortest string).
 * Space: O(1)
 *
 */
public class LongestCommonPrefixSoln {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // take first string as prefix

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
