/* Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

Example 1:
    Input: citations = [3,0,6,1,5]
    Output: 3
    Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
    Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

Example 2:
    Input: citations = [1,3,1]
    Output: 1 */


/* Approach:
* Sort the array in descending order.
* Iterate over the sorted array and determine the maximum value of h such that there are at least h papers with h or more citations. */

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        // Sort citations in descending order
        Arrays.sort(citations);
        
        int n = citations.length;
        int hIndex = 0;

        // Iterate through the sorted array from highest to lowest
        for (int i = 0; i < n; i++) {
            // Number of papers with at least citations[i] citations
            int h = n - i;
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        return hIndex;
    }
}



/* Example Walkthrough:
      Input: citations = [3, 0, 6, 1, 5]
            Sort in descending order: [6, 5, 3, 1, 0]
            Iterate through the sorted array:
            At i = 0, h = 5, citations[0] = 6. Since 6 >= 5, continue.
            At i = 1, h = 4, citations[1] = 5. Since 5 >= 4, continue.
            At i = 2, h = 3, citations[2] = 3. Since 3 >= 3, hIndex = 3.
            Output: 3
            
      Input: citations = [1, 3, 1]
            Sort in descending order: [3, 1, 1]
            Iterate through the sorted array:
            At i = 0, h = 3, citations[0] = 3. Since 3 >= 3, hIndex = 1.
            Output: 1     */
     
