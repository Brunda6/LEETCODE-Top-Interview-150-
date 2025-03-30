/* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);
 
Example 1:
  Input: s = "PAYPALISHIRING", numRows = 3
  Output: "PAHNAPLSIIGYIR"

Example 2:
  Input: s = "PAYPALISHIRING", numRows = 4
  Output: "PINALSIGYAHRPI"
  Explanation:
  P     I    N
  A   L S  I G
  Y A   H R
  P     I

Example 3:
  Input: s = "A", numRows = 1
  Output: "A"    */


class Solution {
    public String convert(String s, int numRows) {
        // If there is only one row, or the number of rows is greater than or equal to
        // the length of the string, return the original string
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Create an array of StringBuilder objects for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int index = 0;
        boolean goingDown = false;

        // Traverse each character of the input string
        for (char c : s.toCharArray()) {
            rows[index].append(c);

            // Change direction at the top or bottom rows
            if (index == 0 || index == numRows - 1) {
                goingDown = !goingDown;
            }

            // Update the row index
            index += goingDown ? 1 : -1;
        }

        // Combine all rows to form the final string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}

   
