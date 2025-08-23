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
 *
 * Follow up: Could you solve it without converting the integer to a string?
 *
 * clean and optimal solution using reverse half of the number
 *
 *
 * Why this is best:
 *
 * ✅ No extra space → avoids using a string or char array
 *
 * ✅ Efficient → we only reverse half of the digits, not the entire number
 *
 * ✅ Time Complexity → O(log₁₀(n)) (since we process digits)
 *
 * ✅ Space Complexity → O(1) constant
 *
 * 👉 Example:
 *
 * x = 1221
 *
 * reverse half → 12
 *
 * remaining half → 12 → palindrome ✅
 *
 * x = 12321
 *
 * reverse half → 123
 *
 * remaining half → 12
 *
 * compare 12 == 123/10 → palindrome ✅
 *
 */
public class PalindromeNumberWithoutConvert {
    public static boolean isPalindrome(int x) {

        // Negative numbers are not palindrome
        // Numbers ending with 0 (except 0 itself) are not palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {
            int lastDigit = x % 10;          // Take last digit  // 12321 % 10 = 1 (for 1st iterate)
            reversedHalf = reversedHalf * 10 + lastDigit;

            x /= 10;                     // Remove last digit and it is 1232 (for 1st iterate)
        }


        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf / 10 (middle digit ignored)
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));             // true
        System.out.println(isPalindrome(12321));           // true
        System.out.println(isPalindrome(-121));             // false
    }
}
