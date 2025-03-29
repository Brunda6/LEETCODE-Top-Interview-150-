/* Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:
    Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    Output:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
  
Example 2:
    Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
    Output:
    [
      "What   must   be",
      "acknowledgment  ",
      "shall be        "
    ]
    Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
    Note that the second line is also left-justified because it contains only one word.
  
Example 3:
    Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
    Output:
    [
      "Science  is  what we",
      "understand      well",
      "enough to explain to",
      "a  computer.  Art is",
      "everything  else  we",
      "do                  "
    ]  */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int lineStart = index;
            int lineLength = 0;

            // Determine how many words fit in the current line
            while (index < words.length && lineLength + words[index].length() + (index - lineStart) <= maxWidth) {
                lineLength += words[index].length();
                index++;
            }

            int numWords = index - lineStart;
            int totalSpaces = maxWidth - lineLength;
            StringBuilder line = new StringBuilder();


            // This section handles the last line or lines that contain only one word, where the words are aligned to the left and extra spaces are added to the end
            // Special handling for the last line
            if (index == words.length || numWords == 1) {
                // Left-justified line
                for (int i = lineStart; i < index; i++) {
                    line.append(words[i]);
                    if (i < index - 1) line.append(" ");
                }
                // Fill the rest of the line with spaces
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } 
            
            // This section handles lines that need full justification, distributing spaces evenly between words
            else {
                // Fully justified line
                int spacesBetweenWords = totalSpaces / (numWords - 1); // is the minimum number of spaces between each word
                int extraSpaces = totalSpaces % (numWords - 1);  // is the remainder when distributing spaces evenly; these are the additional spaces to be distributed among the first few gaps.

                for (int i = lineStart; i < index; i++) {
                    line.append(words[i]);
                    if (i < index - 1) {
                        int spacesToApply = spacesBetweenWords + (i - lineStart < extraSpaces ? 1 : 0);
                        for (int j = 0; j < spacesToApply; j++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
        }

        return result;
    }
}


