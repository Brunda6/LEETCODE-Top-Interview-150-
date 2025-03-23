/* Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
    Input: nums = [3,2,3]
    Output: 3

Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2  */


class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        // First pass: find the candidate for majority element
        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // Set the candidate
            }
            count += (num == candidate) ? 1 : -1;  // Increment or decrement the count
        }

        return candidate;  // The candidate is the majority element
    }
}



/* To solve the problem of finding the majority element in an array (the element that appears more than ⌊n / 2⌋ times) in linear time and O(1) space, we can use the Boyer-Moore Voting Algorithm. This algorithm efficiently determines the majority element with a single pass through the array and requires no additional space.

****Boyer-Moore Voting Algorithm
*Initialization: Start with a candidate and a count initialized to zero.
*First Pass: Iterate through the array. For each element:
        If the count is zero, set the current element as the candidate and increment the count.
        If the current element is the same as the candidate, increment the count.
        If the current element is different from the candidate, decrement the count.
*Result: The candidate at the end of the iteration is the majority element.*/
