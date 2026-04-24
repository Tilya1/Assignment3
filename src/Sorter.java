/**
 * Sorter class handles sorting operations
 * Implements Bubble Sort (basic) and Merge Sort (advanced)
 */
public class Sorter {
    
    /**
     * Bubble Sort - Basic sorting algorithm
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * - Repeatedly steps through the array
     * - Compares adjacent elements and swaps if in wrong order
     * - Continues until no more swaps needed
     * 
     * @param arr the array to be sorted
     */
    public void basicSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if current element is greater than next
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swaps occurred, array is sorted
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * Merge Sort - Advanced sorting algorithm
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * 
     * Algorithm:
     * - Divide: Split array into two halves
     * - Conquer: Recursively sort each half
     * - Combine: Merge sorted halves
     * 
     * @param arr the array to be sorted
     */
    public void advancedSort(int[] arr) {
        if (arr.length < 2) {
            return; // Base case: array of 0 or 1 element is already sorted
        }
        mergeSort(arr, 0, arr.length - 1);
    }
    
    /**
     * Recursive merge sort helper
     * @param arr the array to sort
     * @param left starting index
     * @param right ending index
     */
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find middle point
            int mid = left + (right - left) / 2;
            
            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    /**
     * Merges two sorted subarrays
     * @param arr the array containing subarrays
     * @param left starting index of left subarray
     * @param mid ending index of left subarray
     * @param right ending index of right subarray
     */
    private void merge(int[] arr, int left, int mid, int right) {
        // Calculate sizes of subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        
        // Merge temporary arrays back into arr
        int i = 0, j = 0;
        int k = left;
        
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArray, if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArray, if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    /**
     * Prints array elements
     * @param arr the array to print
     */
    public void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Generates random array of specified size
     * @param size number of elements in array
     * @return array filled with random integers (0-999)
     */
    public int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }
}
