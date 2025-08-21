package com.skytech.leetcode.soln.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

public class TwoSumUsingMap {

    // Method: to find indices of two numbers in an array that add up to a given target
    public static int[] twoSum(int[] nums, int target) {

        //Create a HashMap to store numbers we got so far (key: number, value: index)
        Map<Integer, Integer> numMap = new HashMap<>();

        // Loop through the array of numbers
        for(int i = 0; i < nums.length; i++) {

            //Current number at index i
            int num = nums[i];

            //Calculate the difference to reach the target
            int diff = target - num;

            //If we have seen the difference before, then we found the two numbers that add up to a given target
            if(numMap.containsKey(diff)) {

                // Return the index of the previously got number and the current index
                return new int[]{numMap.get(diff), i};
            }

            // For future lookup, store the current number with its index
            numMap.put(num, i);
        }

        //If no pair is found, return an empty array
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
