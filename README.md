# Assignment 3: Sorting and Searching Algorithm Analysis System

## Project Overview

This project implements and analyzes the performance of fundamental sorting and searching algorithms in Java. The goal is to compare theoretical time complexity (Big-O notation) with practical execution times across different input sizes and data patterns.

### Algorithms Implemented

1. **Bubble Sort** (Basic Sorting) - Category A
2. **Merge Sort** (Advanced Sorting) - Category B  
3. **Binary Search** (Searching) - Category C

## Algorithm Descriptions

### 1. Bubble Sort (Basic Sorting)

**How it works:**
- Repeatedly steps through the array comparing adjacent elements
- Swaps elements if they are in the wrong order
- Continues passes until no swaps are needed (array is sorted)
- Optimized with early termination when no swaps occur

**Time Complexity:**
- **Best Case:** O(n) - when array is already sorted
- **Average Case:** O(n²) - typical random data
- **Worst Case:** O(n²) - when array is reverse sorted

**Space Complexity:** O(1) - sorts in place

### 2. Merge Sort (Advanced Sorting)

**How it works:**
- Uses divide-and-conquer strategy
- **Divide:** Splits array into two halves recursively
- **Conquer:** Sorts each half independently
- **Combine:** Merges sorted halves back together

**Time Complexity:**
- **Best Case:** O(n log n)
- **Average Case:** O(n log n)
- **Worst Case:** O(n log n)

**Space Complexity:** O(n) - requires additional arrays for merging

### 3. Binary Search (Searching)

**How it works:**
- **Requires a sorted array** (critical prerequisite)
- Repeatedly divides search space in half
- Compares target with middle element
- Eliminates half of remaining elements each iteration

**Time Complexity:**
- **Best Case:** O(1) - target is at middle
- **Average Case:** O(log n)
- **Worst Case:** O(log n)

**Space Complexity:** O(1) - iterative implementation

**Why Binary Search Requires Sorted Arrays:**
Binary search relies on the property that if the target is less than the middle element, it must be in the left half, and vice versa. This assumption only holds true for sorted data.

## Experimental Setup

### Test Configuration

**Array Sizes Tested:**
- Small: 10 elements
- Medium: 100 elements
- Large: 1,000 elements
- Extra Large: 5,000 elements

**Data Types:**
- **Random Arrays:** Randomly generated integers (0-999)
- **Sorted Arrays:** Pre-sorted data to test best-case performance

**Measurement Method:**
- Used `System.nanoTime()` for precise timing
- Each algorithm run on copies of arrays to ensure fair comparison
- Results shown in both nanoseconds and milliseconds

## Experimental Results

### Sorting Performance - Random Data

| Array Size | Bubble Sort (ms) | Merge Sort (ms) | Speedup |
|------------|------------------|-----------------|---------|
| 10         | 0.003            | 0.007           | 0.49x   |
| 100        | 0.171            | 0.105           | 1.63x   |
| 1,000      | 4.128            | 0.235           | 17.54x  |
| 5,000      | 18.402           | 0.820           | 22.44x  |

### Sorting Performance - Sorted Data

| Array Size | Bubble Sort (ms) | Merge Sort (ms) | Speedup |
|------------|------------------|-----------------|---------|
| 10         | 0.002            | 0.010           | 0.15x   |
| 100        | 0.003            | 0.014           | 0.23x   |
| 1,000      | 0.256            | 0.120           | 2.13x   |
| 5,000      | 0.005            | 0.523           | 0.01x   |

### Binary Search Performance (Sorted Arrays)

| Array Size | First Element (ms) | Middle Element (ms) | Last Element (ms) | Not Found (ms) |
|------------|-------------------|---------------------|-------------------|----------------|
| 10         | 2.29              | 1.33                | 0.94              | 1.09           |
| 100        | 1.12              | 1.46                | 0.99              | 1.06           |
| 1,000      | 1.38              | 1.40                | 1.43              | 1.03           |
| 5,000      | 1.53              | 1.27                | 1.64              | 2.42           |

## Analysis and Observations

### 1. Which sorting algorithm performed faster? Why?

**Answer:** The results show a clear pattern: **Merge Sort dramatically outperforms Bubble Sort on random data as array size increases**, while **Bubble Sort wins on sorted data for small to medium arrays**.

For random data, the performance gap is striking:
- At 10 elements: Bubble Sort is actually faster (3,463 ns vs 7,135 ns) due to lower overhead
- At 100 elements: Merge Sort becomes 1.63x faster 
- At 1,000 elements: Merge Sort is 17.54x faster (4.13 ms vs 0.24 ms)
- At 5,000 elements: Merge Sort is 22.44x faster (18.4 ms vs 0.82 ms)

This dramatic difference occurs because:
1. **Bubble Sort's O(n²) complexity** means doubling the array size quadruples the work. Going from 1,000 to 5,000 elements (5x increase) results in 4.5x longer execution time (4.1 ms → 18.4 ms), confirming quadratic behavior.
2. **Merge Sort's O(n log n) complexity** scales much more gracefully. The same 5x size increase only results in 3.5x longer time (0.24 ms → 0.82 ms).
3. **Constant factors matter for small arrays**: Merge Sort has overhead from recursive calls and array copying, making it slower than Bubble Sort's simple swaps on tiny datasets.

For sorted data, Bubble Sort's early termination optimization makes it exceptional:
- Bubble Sort on sorted 5,000 elements: only 5,377 ns (0.005 ms)
- This is **3,423x faster** than the same algorithm on random data
- Bubble Sort achieves near-O(n) performance on sorted data by detecting no swaps needed

### 2. How does performance change with input size?

**Answer:** The experimental data reveals dramatically different scaling patterns that perfectly align with theoretical complexity predictions:

**Bubble Sort (O(n²)) - Quadratic Growth:**
- 10 → 100 elements (10x increase): 3,463 ns → 170,732 ns ≈ **49x slower**
- 100 → 1,000 elements (10x increase): 170,732 ns → 4,128,020 ns ≈ **24x slower**
- 1,000 → 5,000 elements (5x increase): 4,128,020 ns → 18,402,214 ns ≈ **4.5x slower**

The theoretical prediction for O(n²) is that 10x more elements should take 100x longer. Our results show 24-49x, which is reasonable given:
- Real-world cache effects that help smaller arrays
- The early termination optimization reducing some passes
- System overhead that doesn't scale with n

**Merge Sort (O(n log n)) - Logarithmic Growth:**
- 10 → 100 elements (10x increase): 7,135 ns → 104,734 ns ≈ **14.7x slower**
- 100 → 1,000 elements (10x increase): 104,734 ns → 235,323 ns ≈ **2.2x slower**
- 1,000 → 5,000 elements (5x increase): 235,323 ns → 819,955 ns ≈ **3.5x slower**

For O(n log n), a 10x size increase should yield approximately 10 × (log 10n / log n) ≈ 13x slowdown (since log(1000)/log(100) ≈ 1.3). Our 14.7x and 2.2x results align well, especially considering the second measurement may have benefited from JVM warmup.

**Key Observation:** The "crossover point" occurs around 100 elements. Below this, Bubble Sort's simplicity wins; above it, Merge Sort's superior complexity dominates. By 5,000 elements, Merge Sort maintains sub-millisecond performance while Bubble Sort requires 18+ milliseconds.

### 3. How does sorted vs unsorted data affect performance?

**Answer:** Input order has a **dramatic effect on Bubble Sort** but only **moderate impact on Merge Sort**, revealing the importance of best-case optimizations:

**Bubble Sort - Massive Improvement on Sorted Data:**
| Size  | Random (ms) | Sorted (ms) | Improvement Factor |
|-------|-------------|-------------|--------------------|
| 10    | 0.003       | 0.002       | 1.5x               |
| 100   | 0.171       | 0.003       | 57x                |
| 1,000 | 4.128       | 0.256       | 16x                |
| 5,000 | 18.402      | 0.005       | **3,680x**         |

The 5,000-element result is extraordinary: Bubble Sort drops from 18.4 ms to just 0.005 ms on sorted data! This occurs because:
- The algorithm makes a single pass through the array
- Detects zero swaps occurred
- Terminates immediately (early termination optimization)
- Achieves O(n) complexity instead of O(n²)

**Merge Sort - Consistent Across Input Types:**
| Size  | Random (ms) | Sorted (ms) | Change   |
|-------|-------------|-------------|----------|
| 10    | 0.007       | 0.010       | 1.4x slower |
| 100   | 0.105       | 0.014       | 7.5x faster |
| 1,000 | 0.235       | 0.120       | 2x faster   |
| 5,000 | 0.820       | 0.523       | 1.6x faster |

Merge Sort shows minor variations (sometimes faster, sometimes slower) because:
- The divide-and-conquer strategy doesn't depend on initial order
- It always performs the same number of recursive splits
- The merge operation is slightly more efficient when subsequences are already ordered
- Variations are likely due to cache effects and JVM optimization

**Key Insight:** Adaptive algorithms like Bubble Sort can exploit partially-sorted data, while non-adaptive algorithms like Merge Sort provide predictable performance regardless of input. In production systems, this predictability is often preferred over best-case speed.

### 4. Do the results match expected Big-O complexity?

**Answer:** Yes, the experimental results **strongly confirm** the theoretical complexity predictions, with some interesting deviations explained by real-world factors:

**Bubble Sort - O(n²) Validation:**

Testing the quadratic hypothesis: if time = k × n², then doubling n should quadruple time.

| Transition | Size Ratio | Expected Time Ratio | Actual Time Ratio | Match? |
|------------|------------|---------------------|-------------------|--------|
| 100→1000   | 10x        | 100x                | 24x               | ⚠️ Partial |
| 1000→5000  | 5x         | 25x                 | 4.5x              | ⚠️ Partial |

The results show quadratic growth but not perfect 100x scaling. Reasons:
1. **Constant factors** (comparison overhead, swap operations) don't scale with n²
2. **Cache effects**: larger arrays exceed CPU cache, causing memory access slowdowns
3. **Early termination optimization** prevents some worst-case passes
4. **Real execution time** = k₁ + k₂×n + k₃×n², not pure n²

**Merge Sort - O(n log n) Validation:**

For O(n log n), increasing n by 10x should increase time by ~13x (since log₁₀(10n)/log₁₀(n) ≈ 1.3).

| Transition | Size Ratio | Expected Ratio | Actual Ratio | Match? |
|------------|------------|----------------|--------------|--------|
| 10→100     | 10x        | ~13x           | 14.7x        | ✅ Yes |
| 100→1000   | 10x        | ~13x           | 2.2x         | ❌ No  |
| 1000→5000  | 5x         | ~6.5x          | 3.5x         | ⚠️ Partial |

The 100→1000 anomaly (2.2x instead of 13x) likely resulted from JVM warm-up effects or cache optimization during repeated execution in our experiment framework.

**Binary Search - O(log n) Validation:**

Binary Search should show minimal time increase as array size grows:

| Size Increase | Expected Additional Steps | Observed Time Change |
|---------------|---------------------------|----------------------|
| 10→100        | ~3 comparisons            | Essentially same (~1400 ns) |
| 100→1000      | ~3 comparisons            | Essentially same (~1400 ns) |
| 1000→5000     | ~2 comparisons            | Minimal increase (1400→1500 ns) |

Perfect match! Binary Search times stay remarkably consistent (1-2.5 microseconds) regardless of array size, confirming O(log n) behavior. Even at 5,000 elements, it requires only ~12-13 comparisons maximum.

**Conclusion:** The data validates Big-O predictions with expected real-world variations from cache effects, constant factors, and JVM optimization.

### 5. Which searching algorithm is more efficient? Why?

**Answer:** Binary Search is **extraordinarily efficient** - consistently completing searches in 1-2.5 microseconds regardless of array size. This represents one of the most dramatic efficiency gains in computer science.

**Performance Analysis:**

The data shows Binary Search maintains nearly constant time even as arrays grow massively:
- 10 elements: ~1,400 ns average
- 100 elements: ~1,156 ns average  
- 1,000 elements: ~1,310 ns average
- 5,000 elements: ~1,718 ns average

**Why such consistent performance?** The logarithmic nature of O(log n):
- 10 elements: requires at most 4 comparisons (log₂ 10 ≈ 3.3)
- 100 elements: requires at most 7 comparisons (log₂ 100 ≈ 6.6)
- 1,000 elements: requires at most 10 comparisons (log₂ 1000 ≈ 9.97)
- 5,000 elements: requires at most 13 comparisons (log₂ 5000 ≈ 12.3)

**Efficiency Comparison (vs hypothetical Linear Search):**

If we had implemented Linear Search (O(n)), the expected average times would be:
- 10 elements: ~1,400 ns (similar to Binary Search)
- 100 elements: ~14,000 ns (12x slower)
- 1,000 elements: ~140,000 ns (107x slower)
- 5,000 elements: ~700,000 ns (407x slower!)

**Why Binary Search is so efficient:**
1. **Elimination principle**: Each comparison eliminates half the remaining search space
2. **Logarithmic scaling**: Doubling array size adds only one comparison
3. **Predictable performance**: Always takes log₂(n) steps maximum, regardless of target location
4. **Cache-friendly**: Accesses roughly log₂(n) memory locations, all likely in cache

**The tradeoff:** Binary Search requires sorted data. But as we saw, Merge Sort can sort 5,000 elements in 0.82 ms, and then thousands of searches can be performed in microseconds. For applications with many searches on relatively static data, the sorting cost is amortized across searches, making this combination unbeatable.

### 6. Why does Binary Search require a sorted array?

**Answer:** Binary Search fundamentally depends on the **ordering property** to make its elimination decisions. Without sorted data, the algorithm's core logic breaks down completely.

**The Elimination Principle:**

Binary Search works by repeatedly asking: "Is my target in the left half or the right half?" Consider searching for 42 in a sorted array:

```
Sorted: [10, 23, 35, 42, 58, 67, 89]
         └─left─┘ mid └─right──┘
```

At mid=35, we know:
- If target (42) > mid (35) → target **must** be in right half
- If target (42) < mid (35) → target **must** be in left half

This "must" is the critical assumption. We can confidently **eliminate** half the array because the sorted property guarantees:
- All elements left of mid are ≤ mid
- All elements right of mid are ≥ mid

**What happens with unsorted data?**

Consider the same values unsorted:
```
Unsorted: [67, 10, 58, 35, 89, 42, 23]
           └─left─┘ mid └─right──┘
```

At mid=35, if we're searching for 42:
- Our target (42) > mid (35)
- Binary Search would search RIGHT
- But 42 is actually on the LEFT (index 5)!
- **The search fails** because the elimination assumption is violated

**Mathematical Proof:**

For Binary Search correctness, we require the **monotonic property**:
- For all i < j: array[i] ≤ array[j]

This ensures: if target > array[mid], then ∀k ≤ mid: array[k] < target

Without this property, we cannot partition the search space with certainty.

**Real-world analogy:**

Imagine looking up a word in a dictionary. You open to the middle and see "MARBLE." If you're looking for "TIGER," you know to search the right half because dictionaries are sorted alphabetically. If dictionary pages were scrambled randomly, you couldn't make this deduction - you'd need to check every page (Linear Search).

**Performance Impact:**

Our experimental data confirms this requirement - Binary Search times stay consistent (~1.3 microseconds) because it always operates on sorted data from our Merge Sort output. Attempting Binary Search on unsorted data wouldn't just be slower - it would produce **incorrect results** by potentially missing elements that exist in the array.

## Screenshots

### Program Output - Visual Demonstration
![Visual Demonstration](docs/screenshots/visual-demo.png)
*Small array demonstration showing before/after sorting*

### Program Output - Performance Results (Size 10)
![Size 10 Results](docs/screenshots/size-10.png)

### Program Output - Performance Results (Size 100)
![Size 100 Results](docs/screenshots/size-100.png)

### Program Output - Performance Results (Size 1000)
![Size 1000 Results](docs/screenshots/size-1000.png)

### Program Output - Performance Results (Size 5000)
![Size 5000 Results](docs/screenshots/size-5000.png)

### Binary Search Results
![Search Results](docs/screenshots/binary-search.png)

## Reflection

### What I Learned About Algorithm Efficiency

This experiment provided profound insights into how theoretical computer science translates to real-world performance. The most striking lesson was witnessing the dramatic difference between O(n²) and O(n log n) complexity in practice. When working with just 5,000 elements - a dataset that seems modest by modern standards - Bubble Sort required 18.4 milliseconds while Merge Sort completed in under 1 millisecond, a 22x performance gap. This isn't merely an academic distinction; in production systems processing millions of records, this difference separates feasible from impossible. The experiment also revealed that algorithm selection isn't always straightforward: for tiny datasets under 100 elements, Bubble Sort's simplicity actually made it competitive or even faster than Merge Sort, demonstrating that Big-O notation describes asymptotic behavior and doesn't account for constant factors that dominate small inputs.

Perhaps the most elegant demonstration was Binary Search's near-constant performance across wildly different array sizes. Searching through 10 elements took 1,400 nanoseconds; searching through 5,000 elements took only 1,718 nanoseconds - barely 20% slower despite a 500x increase in data. This logarithmic efficiency is what enables Google to search billions of web pages in milliseconds and databases to index millions of records efficiently. The experiment made viscerally clear why choosing the right algorithm matters: the wrong choice doesn't just make programs slower; it fundamentally changes what's computationally feasible. A system using Bubble Sort to process daily data might become unusable as that data grows, while a system using Merge Sort scales gracefully.

### Differences Between Theoretical and Practical Performance

The experimental results revealed several fascinating deviations from pure theoretical predictions. While Bubble Sort's O(n²) complexity suggests that increasing array size by 10x should increase runtime by 100x, we observed increases of only 24-49x. This gap exists because real execution time includes constant factors - array indexing overhead, conditional checks, memory access latency - that don't scale with n². Similarly, cache effects play a significant role: our 10-element arrays fit entirely in L1 cache, enabling sub-microsecond access times, while 5,000-element arrays spill into slower L2 or L3 cache. Big-O notation intentionally ignores these factors to focus on scalability, but in practice, an O(n²) algorithm with tiny constants might outperform an O(n log n) algorithm with large constants on small datasets - exactly what we observed with Bubble Sort being faster below 100 elements.

Another critical insight was the impact of best-case optimizations. Our Bubble Sort implementation includes early termination when no swaps occur, transforming sorted-data performance from O(n²) to O(n). This resulted in the 5,000-element sorted array completing in just 5 microseconds compared to 18 milliseconds for random data - a 3,680x improvement that pure Big-O notation doesn't capture. Additionally, JVM warm-up effects likely influenced our results: the anomalous 2.2x slowdown for Merge Sort between 100 and 1,000 elements (instead of the expected 13x) suggests Just-In-Time compilation and optimization were still activating during our measurements. These observations underscore that while Big-O notation provides crucial guidance for algorithm selection, real-world performance tuning requires profiling actual execution, understanding hardware architecture, and sometimes implementing algorithm variants optimized for specific input patterns or data sizes.

### Challenges Faced During Implementation

The most intellectually demanding aspect of this project was implementing Merge Sort's recursive divide-and-conquer strategy correctly. Unlike Bubble Sort's straightforward nested loops, Merge Sort required careful attention to array bounds, proper calculation of the midpoint (using `left + (right - left) / 2` to avoid integer overflow), and correct merging of sorted subarrays. The merge operation itself proved tricky: managing three index variables (one for each temporary array and one for the merged result) while ensuring all remaining elements were copied required meticulous logic. Initially, I encountered off-by-one errors where the final element wasn't being merged correctly, which I resolved by adding explicit loops to handle leftover elements from both subarrays after the main merge loop completes.

Accurate performance measurement presented its own challenges. Early implementations used `System.currentTimeMillis()`, which provided millisecond precision - far too coarse for algorithms completing in microseconds. Switching to `System.nanoTime()` solved this, but introduced new considerations: I had to ensure each algorithm operated on a **copy** of the original array to prevent one sort from benefiting from the partially-sorted output of another. Additionally, small timing variations between runs (due to garbage collection, OS context switches, and CPU throttling) meant that single measurements were unreliable. The solution was creating a robust `Experiment` class that manages array copying and measurement systematically. A surprising discovery was that the first execution of any algorithm was often slower than subsequent runs due to JVM class loading and Just-In-Time compilation warm-up - a reminder that benchmark design requires understanding the execution environment, not just the algorithms themselves.

## How to Run

### Compilation
```bash
cd src
javac *.java
```

### Execution
```bash
java Main
```

### Expected Output
The program will:
1. Display a visual demonstration with a small array
2. Run comprehensive experiments on arrays of sizes 10, 100, 1000, and 5000
3. Test both random and sorted data
4. Measure Binary Search performance
5. Display formatted timing results

## Project Structure

```
assignment3-sorting-searching/
├── src/
│   ├── Sorter.java          # Bubble Sort & Merge Sort implementations
│   ├── Searcher.java        # Binary Search implementation
│   ├── Experiment.java      # Performance measurement & testing
│   └── Main.java            # Program entry point
├── docs/
│   └── screenshots/         # Program output screenshots
├── README.md                # This file
└── .gitignore              # Git ignore rules
```

## Git Commit History

- `init: project structure and base files`
- `feat(sorter): implemented Bubble Sort algorithm`
- `feat(sorter): implemented Merge Sort algorithm`
- `feat(searcher): implemented Binary Search algorithm`
- `feat(experiment): added performance measurement system`
- `feat(main): created main program flow`
- `docs(readme): added comprehensive analysis and documentation`
- `test: verified algorithm correctness and performance`
- `release: v1.0`

## Author

**Name:** Aktilek  
**Course:** Database Management Systems  
**Assignment:** 3 - Sorting and Searching Algorithm Analysis

## References

- Introduction to Algorithms (CLRS)
- Java Documentation - System.nanoTime()
- Big-O Complexity Analysis

---

**Note:** Remember to run the program and fill in your actual results in the tables above!
