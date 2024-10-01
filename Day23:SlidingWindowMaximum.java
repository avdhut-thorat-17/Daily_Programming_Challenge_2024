import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];  // To store the max of each window
        Deque<Integer> deque = new LinkedList<>();  // Deque to store indices of array elements

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of this window (i.e., index < i - k + 1)
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove elements from the deque that are smaller than the current element
            // because they cannot be the maximum in future windows
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // If we've processed at least k elements, add the front of the deque to the result
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(arr1, k1)));

        // Test Case 2
        int[] arr2 = {1, 5, 3, 2, 4, 6};
        int k2 = 3;
        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(arr2, k2)));

        // Test Case 3
        int[] arr3 = {7, 7, 7, 7};
        int k3 = 1;
        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(arr3, k3)));
    }
}