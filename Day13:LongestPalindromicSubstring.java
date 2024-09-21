public class LongestPalindromicSubstring {

    // Function to find the longest palindromic substring using brute force
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int n = s.length();
        String longestPalindrome = "";
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Get the current substring from index i to j
                String currentSubstring = s.substring(i, j + 1);
                
                // Check if this substring is a palindrome
                if (isPalindrome(currentSubstring)) {
                    // If it's longer than the previously found palindrome, update
                    if (currentSubstring.length() > longestPalindrome.length()) {
                        longestPalindrome = currentSubstring;
                    }
                }
            }
        }
        
        return longestPalindrome;
    }

    // Helper function to check if a given string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Function to find the longest palindromic substring using expand around center (iterative)
    public String longestPalindromeOptimised(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0; // To track the start and end of the longest palindromic substring
        
        // Iterate over each character and consider it as a center for potential palindromes
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindrome centered at i
            int len1 = expandAroundCenter(s, i, i);
            // Check for even-length palindrome centered between i and i+1
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Take the maximum length of the two palindrome types
            int maxLength = Math.max(len1, len2);
            
            // If we found a longer palindrome, update the start and end pointers
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }
        
        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }

    // Helper function to expand around the center (iterative version)
    private int expandAroundCenter(String s, int left, int right) {
        // Expand as long as the characters on both sides are the same and within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome (note: we subtract 1 from both left and right since the last expansion failed)
        return right - left - 1;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
    
        System.out.println(solution.longestPalindrome("Brute force")); 
        System.out.println(solution.longestPalindrome("babad")); 
        System.out.println(solution.longestPalindrome("cbbd")); 
        System.out.println(solution.longestPalindrome("a"));     
        System.out.println(solution.longestPalindrome("aaaa"));  
        System.out.println(solution.longestPalindrome("abc"));
        System.out.println(solution.longestPalindrome("Optimised : "));
        System.out.println(solution.longestPalindrome("babad")); 
        System.out.println(solution.longestPalindrome("cbbd")); 
        System.out.println(solution.longestPalindrome("a"));     
        System.out.println(solution.longestPalindrome("aaaa"));  
        System.out.println(solution.longestPalindrome("abc"));   
    }
}