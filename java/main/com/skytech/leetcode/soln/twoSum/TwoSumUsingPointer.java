package com.skytech.leetcode.soln.twoSum;


import java.util.Arrays;

/**
 * Problem: Two Sum
 * Description: Find two numbers in an array that add up to a specific target value and return their indices.
 * Example:
 *Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Time: O(n)
 * Memory/Space: O(n)
 */
public class TwoSumUsingPointer {

    // Method: to find indices of two numbers in an array that add up to a given target
    // Here we follow two pointer technique.
    public static int[] twoSum(int[] nums, int target) {

        //If not sorted
        Arrays.sort(nums);
        //assign two pointers to find the pair of indices which sum is equal to target
        int left = 0;
        int right = nums.length -1;

        //Iteration will be continue until left is less than right
        while(left < right) {

            //If we left and right indices values sum is equal to target then we will find the pair
            if(nums[left] + nums[right] == target) {
                return new int[]{left, right};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else right--;
        }

        //No pair is found, return an empty array
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

}
