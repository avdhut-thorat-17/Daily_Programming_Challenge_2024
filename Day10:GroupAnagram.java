import java.util.*;

class GroupAnagram {
    // time : O(N².k.log K).
    // space : O(N.K)
    public void gABruteForce(String strs[], List<List<String>> res, List<Boolean> isTaken) {
        for (int i = 0; i < strs.length; i++) { // for each word
            if (isTaken.get(i)) continue; // Skip already grouped words
            
            List<String> subList = new ArrayList<>();
            String original = strs[i];
            char[] sortedOriginal = original.toCharArray();
            Arrays.sort(sortedOriginal); // Sort the characters of the word
            subList.add(original);
            isTaken.set(i, true);

            for (int j = i + 1; j < strs.length; j++) { // for remaining words
                if (isTaken.get(j)) continue;
                
                String currentWord = strs[j];
                char[] sortedCurrentWord = currentWord.toCharArray();
                Arrays.sort(sortedCurrentWord);
                
                if (Arrays.equals(sortedOriginal, sortedCurrentWord)) {
                    subList.add(currentWord);
                    isTaken.set(j, true); // Mark as grouped
                }
            }
            res.add(subList); // Add this group of anagrams to the result
        }
    }
    // time : O(N².K.log K)
    // space : O(N.K)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Sort the string to use as the key
            char[] sortedStr = str.toCharArray();
            Arrays.sort(sortedStr);
            String key = new String(sortedStr);
            
            // Add the original string to the corresponding anagram group
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        
        // Collect all the grouped anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new ArrayList<>();
        List<Boolean> isTaken = new ArrayList<>(Collections.nCopies(strs.length, false)); // Initialize isTaken with false
        
        GroupAnagram obj = new GroupAnagram();
        // obj.gABruteForce(strs, res, isTaken);
        List<List<String>> result = obj.groupAnagrams(strs);
        
        // for (List<String> group : res) {
        //     System.out.println(group);
        // }
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}