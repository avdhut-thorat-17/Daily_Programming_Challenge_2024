import java.util.HashSet;

class LongestSubstringWithoutRepeatingCharacters {

    // Brute force solution
    public int longestSubstringBruteForce(String s) {
        int n = s.length();
        int maxLength = 0;

        // Try all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    // Helper function to check if all characters in the substring s[i...j] are unique
    private boolean allUnique(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(s.charAt(i))) {
                return false; // Found duplicate
            }
            set.add(s.charAt(i));
        }
        return true; // All characters are unique
    }

    // Optimized sliding window solution
    public int longestSubstringOptimized(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();

        // Use a sliding window with two pointers (left and right)
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // If current character is already in the set, shrink the window from the left
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set and calculate the window size
            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("Optimized result: " + obj.longestSubstringOptimized(s));
    }
}