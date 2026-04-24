/**
 * Main class - Entry point for the Sorting and Searching Analysis System
 * 
 * This program analyzes and compares the performance of:
 * - Bubble Sort (Basic - O(n²))
 * - Merge Sort (Advanced - O(n log n))
 * - Binary Search (O(log n))
 * 
 * Tests are performed on arrays of varying sizes with both random and sorted data.
 * 
 * @author Aktilek
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        // Print header
        printHeader();
        
        // Create experiment instance
        Experiment experiment = new Experiment();
        
        // Run visual demonstration with small array
        experiment.demonstrateSorting();
        
        // Run comprehensive performance experiments
        experiment.runAllExperiments();
        
        // Print conclusion
        printConclusion();
    }
    
    /**
     * Prints program header
     */
    private static void printHeader() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                    ║");
        System.out.println("║        SORTING AND SEARCHING ALGORITHM ANALYSIS SYSTEM             ║");
        System.out.println("║                                                                    ║");
        System.out.println("║  Algorithms Implemented:                                           ║");
        System.out.println("║    • Bubble Sort (Basic Sorting - O(n²))                           ║");
        System.out.println("║    • Merge Sort (Advanced Sorting - O(n log n))                    ║");
        System.out.println("║    • Binary Search (Searching - O(log n))                          ║");
        System.out.println("║                                                                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    /**
     * Prints program conclusion
     */
    private static void printConclusion() {
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("  ANALYSIS COMPLETE");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println();
        System.out.println("Key Observations:");
        System.out.println("  1. Merge Sort consistently outperforms Bubble Sort");
        System.out.println("  2. Performance gap widens as array size increases");
        System.out.println("  3. Both algorithms perform better on already sorted data");
        System.out.println("  4. Binary Search is extremely fast on sorted arrays");
        System.out.println("  5. Time complexity theory matches practical results");
        System.out.println();
        System.out.println("For detailed analysis, see README.md");
        System.out.println();
    }
}
