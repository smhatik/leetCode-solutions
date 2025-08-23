package com.skytech.leetcode.soln.palindrome;

/**
 *Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *Overall Time Complexity::::
 *
 * O(d), where d = number of digits in x.
 * (For a 32-bit integer, d ≤ 10, so in practice it’s O(1), constant time.)
 *
 * Space Complexity::::
 *
 * Integer.toString(x) creates a string representation of the number.
 *
 * This requires O(d) extra space for the string.
 *
 * Only integer variables left and right are additional → O(1).
 *
 * ✅ Overall Space Complexity:
 *
 * O(d) (dominated by the string storage).
 *
 * 📌 Final Complexity
 *
 * Time: O(d) ≈ O(1) (since d ≤ 10 for 32-bit int).
 *
 * Space: O(d) (due to string conversion).
 *
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        String numberAsString = Integer.toString(x);
        int left = 0;
        int right = numberAsString.length() -1;

        while(left < right) {
            if(numberAsString.charAt(left) != numberAsString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));             // true
        System.out.println(isPalindrome(12321));           // true
        System.out.println(isPalindrome(-121));             // false
    }
}
