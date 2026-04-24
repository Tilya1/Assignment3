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

| Array Size | Bubble Sort (ns) | Bubble Sort (ms) | Merge Sort (ns) | Merge Sort (ms) | Speedup |
|------------|------------------|------------------|-----------------|-----------------|---------|
| 10         | *[YOUR RESULT]*  | *[YOUR RESULT]*  | *[YOUR RESULT]* | *[YOUR RESULT]* | *[X.XX]x* |
| 100        | *[YOUR RESULT]*  | *[YOUR RESULT]*  | *[YOUR RESULT]* | *[YOUR RESULT]* | *[X.XX]x* |
| 1,000      | *[YOUR RESULT]*  | *[YOUR RESULT]*  | *[YOUR RESULT]* | *[YOUR RESULT]* | *[X.XX]x* |
| 5,000      | *[YOUR RESULT]*  | *[YOUR RESULT]*  | *[YOUR RESULT]* | *[YOUR RESULT]* | *[X.XX]x* |

### Sorting Performance - Sorted Data

| Array Size | Bubble Sort (ns) | Bubble Sort (ms) | Merge Sort (ns) | Merge Sort (ms) | Speedup |
|------------|------------------|------------------|-----------------|-----------------|---------|
| 10         | *[YOUR RESULT]*  | *[YOUR RESULT]*  | *[YOUR RESULT]* | *[YOUR RESULT]* | *[X.XX]x* |
| 100        | *[YOUR RESULT]*  | *[YOUR RESULT]*  | *[YOUR RESULT]* | *[YOUR RESULT]* | *[X.XX]x* |
| 1,000      | *[YOUR RESULT]*  | *[YOUR RESULT]*  | *[YOUR RESULT]* | *[YOUR RESULT]* | *[X.XX]x* |
| 5,000      | *[YOUR RESULT]*  | *[YOUR RESULT]*  | *[YOUR RESULT]* | *[YOUR RESULT]* | *[X.XX]x* |

### Binary Search Performance (Sorted Arrays)

| Array Size | First Element (ns) | Middle Element (ns) | Last Element (ns) | Not Found (ns) |
|------------|-------------------|---------------------|-------------------|----------------|
| 10         | *[YOUR RESULT]*   | *[YOUR RESULT]*     | *[YOUR RESULT]*   | *[YOUR RESULT]* |
| 100        | *[YOUR RESULT]*   | *[YOUR RESULT]*     | *[YOUR RESULT]*   | *[YOUR RESULT]* |
| 1,000      | *[YOUR RESULT]*   | *[YOUR RESULT]*     | *[YOUR RESULT]*   | *[YOUR RESULT]* |
| 5,000      | *[YOUR RESULT]*   | *[YOUR RESULT]*     | *[YOUR RESULT]*   | *[YOUR RESULT]* |

## Analysis and Observations

### 1. Which sorting algorithm performed faster? Why?

**Answer:** *[YOUR ANALYSIS HERE]*

Expected: Merge Sort should significantly outperform Bubble Sort, especially as array size increases. This is because:
- Merge Sort: O(n log n) - grows slowly
- Bubble Sort: O(n²) - grows quadratically

### 2. How does performance change with input size?

**Answer:** *[YOUR ANALYSIS HERE]*

Expected observations:
- Bubble Sort time increases dramatically (quadratically)
- Merge Sort time increases more gradually (logarithmically)
- The performance gap widens significantly with larger arrays

### 3. How does sorted vs unsorted data affect performance?

**Answer:** *[YOUR ANALYSIS HERE]*

Expected observations:
- Bubble Sort: Much faster on sorted data (O(n) with optimization)
- Merge Sort: Similar performance regardless of initial order
- This demonstrates the importance of best-case optimization

### 4. Do the results match expected Big-O complexity?

**Answer:** *[YOUR ANALYSIS HERE]*

Analysis approach:
- Compare time ratios when array size doubles/increases 10x
- O(n²): time should increase by 4x/100x
- O(n log n): time should increase by ~2x/~10x

### 5. Which searching algorithm is more efficient? Why?

**Answer:** *[YOUR ANALYSIS HERE]*

Binary Search is highly efficient because:
- Eliminates half the search space each step
- O(log n) means even million-element arrays need ~20 comparisons
- Requires sorted data as a tradeoff

### 6. Why does Binary Search require a sorted array?

**Answer:** *[YOUR ANALYSIS HERE]*

Binary Search assumes:
- If target < middle, it must be in left half
- If target > middle, it must be in right half
- This property only holds for sorted data

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

*[Write 1-2 paragraphs discussing:]*
- *How theoretical complexity translates to real performance*
- *The dramatic difference between O(n²) and O(n log n)*
- *When simpler algorithms might still be practical*
- *The importance of choosing the right algorithm for the task*

### Differences Between Theoretical and Practical Performance

*[Write 1-2 paragraphs discussing:]*
- *Why actual execution times don't always match exactly*
- *Impact of constant factors and system overhead*
- *When cache effects and memory become important*
- *How small arrays can show different patterns*

### Challenges Faced During Implementation

*[Write 1-2 paragraphs discussing:]*
- *Difficulties in implementation (if any)*
- *Debugging experiences*
- *Understanding time measurement*
- *Ensuring fair comparisons*

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
