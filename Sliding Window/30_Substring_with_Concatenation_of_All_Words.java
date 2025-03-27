/* You are given a string s and an array of strings words. All the strings of words are of the same length.
A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

  Example 1:
    Input: s = "barfoothefoobarman", words = ["foo","bar"]
    Output: [0,9]
    Explanation:
      The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
      The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
  
  Example 2:
    Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
    Output: []
    Explanation:
      There is no concatenated substring.
    
  Example 3:
    Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
    Output: [6,9,12]
    Explanation:
      The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
      The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
      The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].  */


import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        // Store word frequencies in a HashMap
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Sliding window for each possible start index
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If word count exceeds required, shrink from left
                    while (windowMap.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If all words match, add the starting index
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // Reset window if an invalid word is found
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}
