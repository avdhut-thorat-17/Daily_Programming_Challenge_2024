import java.util.Arrays;

class MissingNumber {

    // Brute force approach
    // Time complexity: O(n^2), Space complexity: O(1)
    public int findMissingNumberBruteForce(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }
        return -1; // Shouldn't be hit if inputs are valid
    }


    // Slightly optimized approach using sorting
    // Time complexity: O(n log n) due to sorting, Space complexity: O(1)
    public int findMissingNumberSorted(int[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != i) {
                return i;
            }
        }
        return n; // If no missing element is found in the sorted array
    }


    // Optimal approach using sum formula
    // Time complexity: O(n), Space complexity: O(1)
    public int findMissingNumberOptimal(int[] arr, int n) {
        // Calculate sum of first n numbers
        int totalSum = n * (n + 1) / 2;
        int arrSum = 0;

        // Calculate sum of elements in the array
        for (int num : arr) {
            arrSum += num;
        }

        // Missing number is the difference between totalSum and arrSum
        return totalSum - arrSum;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();

        int[] arr1 = {1, 2, 4, 5};
        int n1 = 5;
        System.out.println("Brute Force: " + mn.findMissingNumberBruteForce(arr1, n1)); // Output: 3
        System.out.println("Sorted: " + mn.findMissingNumberSorted(arr1, n1)); // Output: 3
        System.out.println("Optimal: " + mn.findMissingNumberOptimal(arr1, n1)); // Output: 3

        int[] arr2 = {2, 3, 4, 5};
        int n2 = 5;
        System.out.println("Brute Force: " + mn.findMissingNumberBruteForce(arr2, n2)); // Output: 1
        System.out.println("Sorted: " + mn.findMissingNumberSorted(arr2, n2)); // Output: 1
        System.out.println("Optimal: " + mn.findMissingNumberOptimal(arr2, n2)); // Output: 1

        int[] arr3 = {1, 2, 3, 4};
        int n3 = 5;
        System.out.println("Brute Force: " + mn.findMissingNumberBruteForce(arr3, n3)); // Output: 5
        System.out.println("Sorted: " + mn.findMissingNumberSorted(arr3, n3)); // Output: 5
        System.out.println("Optimal: " + mn.findMissingNumberOptimal(arr3, n3)); // Output: 5

        int[] arr4 = {1};
        int n4 = 2;
        System.out.println("Brute Force: " + mn.findMissingNumberBruteForce(arr4, n4)); // Output: 2
        System.out.println("Sorted: " + mn.findMissingNumberSorted(arr4, n4)); // Output: 2
        System.out.println("Optimal: " + mn.findMissingNumberOptimal(arr4, n4)); // Output: 2

        int[] arr5 = new int[999999];
        for (int i = 1; i <= 999999; i++) {
            arr5[i - 1] = i;
        }
        int n5 = 1000000;
        System.out.println("Optimal for large array: " + mn.findMissingNumberOptimal(arr5, n5)); // Output: 1000000
    }
}