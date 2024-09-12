import java.util.Arrays;

public class MergeSortedArrays {

    // Brute Force Approach
    // Time Complexity: O(m + n)
    // Space Complexity: O(m + n)
    public void bruteForce(int[] arr1, int[] arr2, int m, int n) {
        int[] arr3 = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merging both arrays into arr3
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1
        while (i < m) {
            arr3[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2
        while (j < n) {
            arr3[k++] = arr2[j++];
        }

        // Copy back to arr1 and arr2
        for (i = 0; i < m; i++) {
            arr1[i] = arr3[i];
        }
        for (j = 0; j < n; j++) {
            arr2[j] = arr3[m + j];
        }
    }

    // Slightly Optimized Approach
    // Time Complexity: O(m * n) (due to insertion of arr2)
    // Space Complexity: O(1)
    public void slightlyOptimised(int[] arr1, int[] arr2, int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            if (arr1[i] > arr2[0]) {
                // Swap arr1[i] with arr2[0]
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;

                // Sort arr2 after swapping to keep it sorted
                int first = arr2[0];
                int k;
                for (k = 1; k < n && arr2[k] < first; k++) {
                    arr2[k - 1] = arr2[k];
                }
                arr2[k - 1] = first;
            }
        }
    }

    // Optimal Approach (Gap Algorithm)
    // Time Complexity: O((m + n) * log(m + n))
    // Space Complexity: O(1)
    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int gap = nextGap(m + n);

        // Continue until the gap becomes 0
        while (gap > 0) {
            int i = 0, j = gap;

            // Compare elements in the first array (arr1)
            while (j < m) {
                if (arr1[i] > arr1[j]) {
                    swap(arr1, i, j);
                }
                i++;
                j++;
            }

            // Compare elements between arr1 and arr2
            j = j - m; // Adjust j to start comparing with arr2
            while (i < m && j < n) {
                if (arr1[i] > arr2[j]) {
                    swap(arr1, arr2, i, j);
                }
                i++;
                j++;
            }

            // Compare elements in the second array (arr2)
            i = 0;
            while (j < n) {
                if (arr2[i] > arr2[j]) {
                    swap(arr2, i, j);
                }
                i++;
                j++;
            }

            // Update the gap for the next iteration
            gap = nextGap(gap);
        }
    }

    // Function to find the next gap (Shell Sort logic)
    private static int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        }
        return (gap / 2) + (gap % 2);
    }

    // Function to swap elements within the same array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to swap elements between two different arrays
    private static void swap(int[] arr1, int[] arr2, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    // Main function to test the merge
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int m = arr1.length;
        int n = arr2.length;

        // Test the optimal gap algorithm
        merge(arr1, arr2, m, n);

        System.out.println("Array 1 after merging: " + Arrays.toString(arr1));
        System.out.println("Array 2 after merging: " + Arrays.toString(arr2));
    }
}