import java.util.*;

class Sort_0s_1s_2s {
    // Brute force 
    // time complexity : O(n^2)
    // space complexity : O(1)
    public void bruteForce(int[] nums){
        // bubble sort
        int n = nums.length;
        for(int i=0;i<n;i++){
            boolean flag = false;
            for(int j=0;j < n-1-i;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if(flag == false){
                break;
            }
        }
    }

    // slightly optimise 
    // time complexity : O(n(logn))
    // space complexity : O(1)
    // QuickSort function
    public void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(nums, low, high);

            // Recursively sort elements before and after the partition
            quicksort(nums, low, pivotIndex - 1);
            quicksort(nums, pivotIndex + 1, high);
        }
    }

    // Partition function (Lomuto partition scheme)
    private int partition(int[] nums, int low, int high) {
        // Choose the pivot element (here, we are choosing the last element as pivot)
        int pivot = nums[high];
        int i = low - 1;  // Index of smaller element

        for (int j = low; j < high; j++) {
            // If the current element is less than or equal to the pivot
            if (nums[j] <= pivot) {
                i++;  // Increment the index of the smaller element
                swap(nums, i, j);
            }
        }

        // Swap the pivot element with the element at index i+1
        swap(nums, i + 1, high);

        // Return the partition index
        return i + 1;
    }

    // Function to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Method to perform the Dutch National Flag sorting
    // time complexity : O(n)
    // space complexity : O(1)
    public void dnf(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } else if (nums[mid] == 2) {
                // Swap nums[mid] and nums[high]
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;

                high--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        Sort_0s_1s_2s sorter = new Sort_0s_1s_2s();
        
        // Test cases
        int[] nums1 = {0, 1, 2, 1, 0, 2, 1, 0};
        int[] nums2 = {0, 1, 2};
        
        // Perform the sorting
        sorter.dnf(nums1);
        sorter.dnf(nums2);
        
        // Print sorted arrays
        System.out.println("Sorted array 1: " + Arrays.toString(nums1));
        System.out.println("Sorted array 2: " + Arrays.toString(nums2));
    }
}