import java.util.*;

class Permutation {

    public void permuteUnique(List<String> res, char[] str, int idx) {
        // Base case: if idx reaches the end of the string, we have a valid permutation
        if (idx == str.length) {
            res.add(new String(str)); // Convert char array to string and add to result
            return;
        }
        
        // Use a set to track characters we've already placed at this position to avoid duplicates
        Set<Character> used = new HashSet<>();
        
        for (int i = idx; i < str.length; i++) {
            if (used.contains(str[i])) continue; // Skip duplicates
            
            used.add(str[i]); // Mark this character as used at this position
            
            // Swap current character with the character at the current index
            swap(str, idx, i);
            
            // Recurse with the next position
            permuteUnique(res, str, idx + 1);
            
            // Backtrack (undo the swap)
            swap(str, idx, i);
        }
    }

    // Helper function to swap two characters in a char array
    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static List<String> findPermutations(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        char[] str = s.toCharArray();
        Arrays.sort(str); // Sort to handle duplicates easily
        new Permutation().permuteUnique(res, str, 0);
        return res;
    }

    public static void main(String[] args) {
        String input = "aab";
        List<String> permutations = findPermutations(input);

        // Output the result
        System.out.println(permutations);
    }
}