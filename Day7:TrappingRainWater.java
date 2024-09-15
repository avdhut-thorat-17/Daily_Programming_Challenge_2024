import java.util.*;
import java.util.Arrays;
class TrapingRainWater{
    // brute force 
    // time : O(n^2)
    // space : O(1)
    public int TrapingRainWaterBruteForce(int[] height){
        int total = 0;
        for(int i=0;i<height.length;i++){  // for each position i will keep track
            // calculate maxHeight from left
            int maxFromLeft = 0;
            for(int j = 0;j < i; j++){
                if(maxFromLeft < height[j]){
                    maxFromLeft = height[j];
                }
            }
            maxFromLeft = Math.max(maxFromLeft,height[i]);
            // calculate maxHeight from right
            int maxFromRight = 0;
            for(int k = height.length-1;k > i; k--){
                if(maxFromRight < height[k]){
                    maxFromRight = height[k];
                }
            }
            maxFromRight = Math.max(maxFromRight,height[i]);

            // calculate the water for each position
            total += Math.min(maxFromLeft,maxFromRight) - height[i];
        }
        return total;
    }

    // slightly optimal (time optimal)
    // time : O(n)
    // space : O(n)
    public int TrappingRainWaterOptimal(int[] height) {
        int n = height.length;
        if (n == 0) return 0;  // Handle edge case

        int[] left = new int[n];
        int[] right = new int[n];

        // Calculate max from the left for each index
        left[0] = height[0];
        for (int j = 1; j < n; j++) {
            left[j] = Math.max(left[j - 1], height[j]);
        }

        // Calculate max from the right for each index
        right[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {  // Fix: Ensure j is in range
            right[j] = Math.max(right[j + 1], height[j]);  // Fix: right[j+1] instead of right[j-1]
        }

        // Calculate the total trapped water
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(left[i], right[i]) - height[i];
        }

        return total;
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;  // Two pointers
        int max_left = 0, max_right = 0;  // To store the maximum heights encountered from both sides
        int totalWater = 0;  // To store the total trapped water

        while (left <= right) {
            if (height[left] <= height[right]) {
                // If the current height at left pointer is less than or equal to height at right pointer
                if (height[left] >= max_left) {
                    // Update max_left if we encounter a taller bar
                    max_left = height[left];
                } else {
                    // Otherwise, calculate the trapped water
                    totalWater += max_left - height[left];
                }
                left++;  // Move the left pointer to the right
            } else {
                // If the current height at right pointer is less than height at left pointer
                if (height[right] >= max_right) {
                    // Update max_right if we encounter a taller bar
                    max_right = height[right];
                } else {
                    // Otherwise, calculate the trapped water
                    totalWater += max_right - height[right];
                }
                right--;  // Move the right pointer to the left
            }
        }

        return totalWater;
    }

    public static void main(String[] args){
        TrapingRainWater obj = new TrapingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // int[] height = {1,2,3,4};
        System.out.println(obj.TrappingRainWaterOptimal(height));
    }
}