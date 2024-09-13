import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FindLeaders {

    // Brute Force Approach
    // time : O(n^2)
    // space : O(1)
    public static List<Integer> findLeadersBruteForce(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            
            // Check all elements to the right
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    isLeader = false;
                    break;
                }
            }
            
            if (isLeader) {
                leaders.add(arr[i]);
            }
        }
        
        return leaders;
    }

    // Optimized Approach
    // time : O(n)
    // space : O(1) ignoring the resultant array
    public static List<Integer> findLeadersOptimized(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        
        // Start from the last element
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight); // Rightmost element is always a leader
        
        // Traverse from the second last element to the first
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(arr[i]);
            }
        }
        
        // Since we are adding leaders from right to left, we need to reverse the list
        Collections.reverse(leaders);
        
        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        
        // Brute Force Approach
        System.out.println("Brute Force Leaders: " + findLeadersBruteForce(arr));
        
        // Optimized Approach
        System.out.println("Optimized Leaders: " + findLeadersOptimized(arr));

        // Test Cases
        System.out.println("Test Case 1: " + findLeadersOptimized(new int[]{1, 2, 3, 4, 0})); // [4, 0]
        System.out.println("Test Case 2: " + findLeadersOptimized(new int[]{7, 10, 4, 10, 6, 5, 2})); // [10, 6, 5, 2]
        System.out.println("Test Case 3: " + findLeadersOptimized(new int[]{5})); // [5]
        System.out.println("Test Case 4: " + findLeadersOptimized(new int[]{100, 50, 20, 10})); // [100, 50, 20, 10]
        System.out.println("Test Case 5: " + findLeadersOptimized(new int[]{1, 2, 3, 1000000})); // [1000000]
    }
}