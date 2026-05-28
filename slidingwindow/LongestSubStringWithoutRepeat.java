package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeat {

    // Given a string s, find the length of the longest substring without repeating characters.
    
    public static void main(String[] args) {
        test("abcabcbb", 3);
        // test("bbbbb", 1);
        // test("pwwkew", 3);
        // test("dvdf",3);
    }

    private static void test(String s, int expected) {
        int result = lengthOfLongestSubstring2(s);
        System.out.println("Input: " + s);
        if (result == expected) {
            System.out.println("Test passed");
        } else {
            System.out.println("Failed Expected: " + expected + ", Got: " + result);
        }
        System.out.println();
    }

    // public static int lengthOfLongestSubstring(String s) {
    //     if (s == null || s.length() == 0) {
    //         return 0; 
    //     }

    //     char[] chars = s.toCharArray();
    //     int windowStart = 0, windowEnd = 0, maxLength = 0;
    //     StringBuffer subString = new StringBuffer(s.length());

    //     for (windowEnd = 0; windowEnd < chars.length; windowEnd++) {
    //         char currentChar = chars[windowEnd];

    //         maxLength = Math.max(maxLength, subString.length()-1);
            
    //         if(subString.length()>0 && subString.charAt(subString.length() - 1) == currentChar){
    //             subString.setLength(0);
    //             subString.append(currentChar);
    //         }
    //         else if(subString.length()>0 && subString.charAt(0)==currentChar){
    //             subString.deleteCharAt(0);                
    //         }
    //         subString.append(currentChar);
    //     }

        
    //     return maxLength;
    // }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0; 
        }

        // This set acts as our window keeper. It only holds unique characters.
        Set<Character> seen = new HashSet<>();
        int windowStart = 0;
        int maxLength = 0;

        // Expand the window with windowEnd
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);

            // If we hit a duplicate, shrink the window from the left 
            // until that duplicate character is completely evicted.
            while (seen.contains(currentChar)) {
                seen.remove(s.charAt(windowStart));
                windowStart++;
            }

            // Now that the duplicate is safely evicted, add the new character
            seen.add(currentChar);

            // Calculate the maximum window size seen so far
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
