import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindZeroSumSubarraysOptimized {

    // Brute force approach to find all subarrays with zero sum
    // time : O(n^2)
    // space : O(1)
    public static List<int[]> findZeroSumSubarraysBF(int[] arr) {
        int n = arr.length;
        List<int[]> result = new ArrayList<>();
        
        // Loop through all possible subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            
            // Find all subarrays starting from i
            for (int j = i; j < n; j++) {
                sum += arr[j];
                
                // If the sum is zero, add the subarray to the result
                if (sum == 0) {
                    result.add(new int[]{i, j});
                }
            }
        }
        
        return result;
    }


    // Optimized approach to find all subarrays with zero sum using HashMap
    // time : O(n)
    // space : O(1)
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        int n = arr.length;
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Initialize the map with sum 0 at index -1 to handle subarrays starting from index 0
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // If the sum has been seen before, it means there is a zero sum subarray
            if (sumMap.containsKey(sum)) {
                // Get the list of all indices where this sum has occurred
                List<Integer> indices = sumMap.get(sum);
                for (int start : indices) {
                    result.add(new int[]{start + 1, i});
                }
            }

            // Add the current index to the list of indices for this sum
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        List<int[]> result = findZeroSumSubarrays(arr);
        for (int[] subarray : result) {
            System.out.println("Subarray: (" + subarray[0] + ", " + subarray[1] + ")");
        }
    }
}