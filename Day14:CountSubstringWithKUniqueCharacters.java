import java.util.HashMap;
import java.util.Map;

class CountSubstringWithKUniqueCharacters {
    
    // Function to count substrings with exactly K unique characters
    public int countSubstring(String s, int k) {
        int count = 0;
        
        // Outer loop to iterate over every possible starting point of a substring
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];  // Frequency array to track character occurrences
            int uniqueChars = 0;       // Track the number of unique characters

            // Inner loop to iterate over the end of the substring
            for (int j = i; j < s.length(); j++) {
                int charIndex = s.charAt(j) - 'a';  // Get index of character 'a' -> 0, 'b' -> 1, etc.

                // If it's the first time we see this character, increment uniqueChars
                if (freq[charIndex] == 0) {
                    uniqueChars++;
                }

                // Increment the frequency of the current character
                freq[charIndex]++;
                
                // If the number of unique characters equals k, increment the count
                if (uniqueChars == k) {
                    count++;
                }

                // If the number of unique characters exceeds k, break the loop
                else if (uniqueChars > k) {
                    break;
                }
            }
        }
        
        return count;
    }

    // Function to count substrings with exactly K distinct characters
    public int countSubstringOptimised(String s, int k) {
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    // Helper function to count substrings with at most K distinct characters
    private int countAtMostKDistinct(String s, int k) {
        if (k == 0) return 0;

        int count = 0;
        int left = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            // Add character at 'right' to the window
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

            // If we have more than k distinct characters, shrink the window
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);

                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            // Count the number of valid substrings with at most k distinct characters
            count += right - left + 1;
        }

        return count;
    }


    public static void main(String[] args) {
        CountSubstringWithKUniqueCharacters solution = new CountSubstringWithKUniqueCharacters();
        String s = "aabacbebebe";
        int k = 3;
        System.out.println("The number of unique substrings : " + solution.countSubstring(s,k));
        System.out.println("The number of unique substrings : " + solution.countSubstringOptimised(s,k));
    }
}