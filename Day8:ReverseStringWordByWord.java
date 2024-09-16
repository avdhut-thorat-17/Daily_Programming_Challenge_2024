class ReverseStringWordByWord {
    
    // Method to reverse the words in a sentence
    public String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Split the string into words based on spaces
        String[] words = str.split("\\s+");
        
        // Initialize a StringBuilder to hold the reversed sentence
        StringBuilder reversed = new StringBuilder();
        
        // Traverse the words array from the end to the start
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");  // Add space between words
            }
        }

        // Convert StringBuilder to string and return
        return reversed.toString();
    }

    public static void main(String[] args) {
        // Test string
        String str = "     India is my country    ";

        // Create an object of the class
        ReverseStringWordByWord obj = new ReverseStringWordByWord();

        // Reverse the words
        String reversedStr = obj.reverse(str);

        // Print the reversed sentence
        System.out.println(reversedStr);
    }
}