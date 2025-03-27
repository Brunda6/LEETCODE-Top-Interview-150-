/*  Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
  
Example 1:
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
  
Example 2:
    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation: 
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]  */

/* Solution-1 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;  // Normalize k to avoid unnecessary full cycles

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse the rest of the elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


/* Solution-2 */

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;  // Normalize k
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];   //   (i + k) % n calculates the new index where each element should be placed after rotation.
        }
        
        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }
}


