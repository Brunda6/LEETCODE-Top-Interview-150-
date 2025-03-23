/* Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
  Input: strs = ["flower","flow","flight"]
  Output: "fl"

Example 2:
  Input: strs = ["dog","racecar","car"]
  Output: ""
  Explanation: There is no common prefix among the input strings.  */


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Start with the first string as the initial prefix
        String prefix = strs[0];
        
        // Iterate through the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it matches the beginning of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}


/*
The initial prefix is set to the first string in the array, which is "flower".

A for loop starts to iterate over the strings from index 1 to the end of the array.

 * First Iteration (i = 1), Comparing with "flow"
    The while loop checks if the current prefix is not a prefix of strs[i] (i.e., does not start at index 0).
    Current prefix: "flower"
    Current strs[i]: "flow"
    "flow".indexOf("flower") returns -1 because "flower" is longer than "flow" and is not its prefix.
    Since the condition is true, we enter the loop to shorten the prefix.
          Shortening Steps:
            "flower" → "flowe" → "flow" (when "prefix" is "flow", it matches the beginning of "flow").
            Now: "flow".indexOf("flow") returns 0, meaning "flow" is a prefix of "flow".
            Exit the while loop for "flow".

   * Second Iteration (i = 2), Comparing with "flight"
      Current prefix: "flow"
      Current strs[i]: "flight"
      "flight".indexOf("flow") returns -1 because "flight" does not start with "flow".
      Since the condition is true, we enter the loop to shorten the prefix.
          Shortening Steps:
            "flow" → "flo" → "fl" (when "prefix" is "fl", it matches the beginning of "flight").
          Now: "flight".indexOf("fl") returns 0, meaning "fl" is a prefix of "flight".
          Exit the while loop for "flight".

    * After the loop ends, the value of prefix is "fl", which is the longest common prefix for all the strings.
The method returns "fl".

*/
