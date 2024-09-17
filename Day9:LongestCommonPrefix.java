public class LongestCommonPrefix {

    // Function to find the longest common prefix
    public String LCP(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Start with the first string as the prefix
        String prefix = strs[0];

        // Iterate over the remaining strings
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the prefix, shorten the prefix
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // If prefix becomes empty, return empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return the final longest common prefix
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();

        // Example test case
        String[] strs = {"flower", "flow", "flight"};
        String result = obj.LCP(strs);
        System.out.println("Longest Common Prefix: " + result);  // Output: "fl"
    }
}