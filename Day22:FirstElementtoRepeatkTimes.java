import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Function to find the first element to repeat exactly k times
    public static int firstElementToRepeatKTimes(int[] arr, int k) {
        // Step 1: Create a map to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Step 2: Count the frequency of each element
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 3: Iterate through the array to find the first element with frequency k
        for (int num : arr) {
            if (frequencyMap.get(num) == k) {
                return num;  // Return the first element with frequency k
            }
        }

        // If no element has frequency k, return -1
        return -1;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        int k1 = 2;
        System.out.println(firstElementToRepeatKTimes(arr1, k1)); // Output: 1

        int[] arr2 = {2, 3, 4, 2, 2, 5, 5};
        int k2 = 2;
        System.out.println(firstElementToRepeatKTimes(arr2, k2)); // Output: 5

        int[] arr3 = {1, 1, 1, 1};
        int k3 = 1;
        System.out.println(firstElementToRepeatKTimes(arr3, k3)); // Output: -1

        int[] arr4 = {10};
        int k4 = 1;
        System.out.println(firstElementToRepeatKTimes(arr4, k4)); // Output: 10

        int[] arr5 = {6, 6, 6, 6, 7, 7, 8, 8, 8};
        int k5 = 3;
        System.out.println(firstElementToRepeatKTimes(arr5, k5)); // Output: 8
    }
}