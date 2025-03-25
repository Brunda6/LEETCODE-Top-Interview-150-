/* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]  */


/*
    Explanation: To solve this problem without using the division operation and in O(n) time, we can use the prefix and suffix product method.
        1. Prefix Product Pass:
           * Calculate the prefix product for each element and store it in the answer array.
           * answer[i] represents the product of all elements to the left of index i
            
        2. Suffix Product Pass:
           * Iterate from right to left while maintaining a suffix product.
           * Multiply each element in the answer array by the suffix product and update the suffix.
           * This computes the product of all elements to the right of each element:
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Compute prefix products and store in answer array
        answer[0] = 1; // No elements to the left of first element, so it's 1
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Compute suffix products and multiply to answer array
        int suffix = 1; // Initialize suffix product as 1
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}

/* Example Walkthrough:

    Input: nums = [1, 2, 3, 4]

        Prefix Pass:
            answer[0] = 1 (since nothing is on the left)
            answer[1] = answer[0] * nums[0] = 1 * 1 = 1
            answer[2] = answer[1] * nums[1] = 1 * 2 = 2
            answer[3] = answer[2] * nums[2] = 2 * 3 = 6
            Prefix Product Array: [1, 1, 2, 6]
            
        Suffix Pass:
            Start with suffix = 1
            answer[3] = 6 * 1 = 6, suffix = 1 * 4 = 4
            answer[2] = 2 * 4 = 8, suffix = 4 * 3 = 12
            answer[1] = 1 * 12 = 12, suffix = 12 * 2 = 24
            answer[0] = 1 * 24 = 24
            
        Final Answer Array: [24, 12, 8, 6] */
