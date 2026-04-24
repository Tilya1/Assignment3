/**
 * Experiment class handles performance measurement and testing
 * Measures execution time using System.nanoTime()
 */
public class Experiment {
    
    private Sorter sorter;
    private Searcher searcher;
    
    /**
     * Constructor initializes Sorter and Searcher instances
     */
    public Experiment() {
        this.sorter = new Sorter();
        this.searcher = new Searcher();
    }
    
    /**
     * Measures time taken to sort an array
     * 
     * @param arr the array to sort
     * @param type "basic" for Bubble Sort, "advanced" for Merge Sort
     * @return execution time in nanoseconds
     */
    public long measureSortTime(int[] arr, String type) {
        // Create copy to preserve original array
        int[] arrCopy = arr.clone();
        
        long startTime = System.nanoTime();
        
        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(arrCopy);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(arrCopy);
        }
        
        long endTime = System.nanoTime();
        
        return endTime - startTime;
    }
    
    /**
     * Measures time taken to search for a target in array
     * 
     * @param arr the array to search (must be sorted for binary search)
     * @param target the value to search for
     * @return execution time in nanoseconds
     */
    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        
        searcher.search(arr, target);
        
        long endTime = System.nanoTime();
        
        return endTime - startTime;
    }
    
    /**
     * Runs comprehensive experiments on different array sizes and types
     * Tests performance with random and sorted data
     */
    public void runAllExperiments() {
        System.out.println("╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║     SORTING AND SEARCHING ALGORITHM PERFORMANCE ANALYSIS           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        // Array sizes to test
        int[] sizes = {10, 100, 1000, 5000};
        
        for (int size : sizes) {
            System.out.println("═══════════════════════════════════════════════════════════════════");
            System.out.println("  TESTING WITH ARRAY SIZE: " + size);
            System.out.println("═══════════════════════════════════════════════════════════════════");
            System.out.println();
            
            // Generate random array
            int[] randomArray = sorter.generateRandomArray(size);
            
            // Create sorted array for comparison
            int[] sortedArray = randomArray.clone();
            sorter.advancedSort(sortedArray);
            
            // Test sorting on random data
            testSorting(randomArray, "RANDOM", size);
            
            // Test sorting on sorted data
            testSorting(sortedArray, "SORTED", size);
            
            // Test searching (binary search requires sorted array)
            testSearching(sortedArray, size);
            
            System.out.println();
        }
    }
    
    /**
     * Helper method to test sorting algorithms
     * @param arr the array to sort
     * @param dataType description of data type (random/sorted)
     * @param size array size
     */
    private void testSorting(int[] arr, String dataType, int size) {
        System.out.println("─────────────────────────────────────────────────────────────────");
        System.out.println("  Sorting Performance - " + dataType + " Data");
        System.out.println("─────────────────────────────────────────────────────────────────");
        
        // Measure Bubble Sort
        long bubbleTime = measureSortTime(arr, "basic");
        double bubbleMs = bubbleTime / 1_000_000.0;
        
        // Measure Merge Sort
        long mergeTime = measureSortTime(arr, "advanced");
        double mergeMs = mergeTime / 1_000_000.0;
        
        // Display results
        System.out.printf("  Bubble Sort (Basic):    %,15d ns  (%,.3f ms)%n", bubbleTime, bubbleMs);
        System.out.printf("  Merge Sort (Advanced):  %,15d ns  (%,.3f ms)%n", mergeTime, mergeMs);
        
        // Calculate speedup
        double speedup = (double) bubbleTime / mergeTime;
        System.out.printf("  Merge Sort is %.2fx faster%n", speedup);
        System.out.println();
    }
    
    /**
     * Helper method to test search algorithm
     * @param arr sorted array to search in
     * @param size array size
     */
    private void testSearching(int[] arr, int size) {
        System.out.println("─────────────────────────────────────────────────────────────────");
        System.out.println("  Binary Search Performance");
        System.out.println("─────────────────────────────────────────────────────────────────");
        
        // Test searching for element at beginning, middle, end, and not found
        int[] testTargets = {
            arr[0],                      // First element
            arr[arr.length / 2],         // Middle element
            arr[arr.length - 1],         // Last element
            -1                           // Not in array
        };
        
        String[] positions = {"First", "Middle", "Last", "Not Found"};
        
        for (int i = 0; i < testTargets.length; i++) {
            long searchTime = measureSearchTime(arr, testTargets[i]);
            double searchMs = searchTime / 1_000_000.0;
            int result = searcher.search(arr, testTargets[i]);
            
            System.out.printf("  Target: %s (%d)%n", positions[i], testTargets[i]);
            System.out.printf("    Time: %,15d ns  (%,.3f ms)%n", searchTime, searchMs);
            System.out.printf("    Result: %s%n", result != -1 ? "Found at index " + result : "Not found");
            System.out.println();
        }
    }
    
    /**
     * Demonstrates sorting on small array with visible output
     */
    public void demonstrateSorting() {
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("  VISUAL DEMONSTRATION - Small Array (10 elements)");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println();
        
        // Generate small random array
        int[] smallArray = sorter.generateRandomArray(10);
        
        System.out.print("Original Array:    ");
        sorter.printArray(smallArray);
        System.out.println();
        
        // Bubble Sort demonstration
        int[] bubbleArray = smallArray.clone();
        long bubbleTime = measureSortTime(bubbleArray, "basic");
        sorter.basicSort(bubbleArray);
        System.out.print("Bubble Sort:       ");
        sorter.printArray(bubbleArray);
        System.out.printf("Time: %,d ns%n", bubbleTime);
        System.out.println();
        
        // Merge Sort demonstration
        int[] mergeArray = smallArray.clone();
        long mergeTime = measureSortTime(mergeArray, "advanced");
        sorter.advancedSort(mergeArray);
        System.out.print("Merge Sort:        ");
        sorter.printArray(mergeArray);
        System.out.printf("Time: %,d ns%n", mergeTime);
        System.out.println();
    }
}
