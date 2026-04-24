/**
 * Searcher class handles searching operations
 * Implements Binary Search algorithm
 */
public class Searcher {
    
    /**
     * Binary Search - Efficient search algorithm for sorted arrays
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * - Requires sorted array
     * - Repeatedly divides search interval in half
     * - Compares target with middle element
     * - Eliminates half of remaining elements each step
     * 
     * @param arr the sorted array to search in
     * @param target the value to search for
     * @return index of target if found, -1 otherwise
     */
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            // Calculate middle index (avoids overflow)
            int mid = left + (right - left) / 2;
            
            // Check if target is at mid
            if (arr[mid] == target) {
                return mid;
            }
            
            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }
        
        // Target not found
        return -1;
    }
    
    /**
     * Helper method to verify if array is sorted
     * Binary search only works on sorted arrays
     * 
     * @param arr the array to check
     * @return true if sorted, false otherwise
     */
    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
