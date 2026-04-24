# Quick Start Guide

## Setup and Compilation

### Step 1: Navigate to project directory
```bash
cd assignment3-sorting-searching
```

### Step 2: Compile the code
```bash
cd src
javac *.java
```

This will compile all four Java files:
- Sorter.java
- Searcher.java
- Experiment.java
- Main.java

### Step 3: Run the program
```bash
java Main
```

## What to Expect

The program will:
1. Display a header with algorithm information
2. Show a visual demonstration with a small 10-element array
3. Run performance tests on array sizes: 10, 100, 1000, and 5000
4. Test both RANDOM and SORTED data
5. Measure Binary Search performance
6. Display timing results in both nanoseconds and milliseconds

## Taking Screenshots

You'll need to capture screenshots of:
1. Visual demonstration output
2. Results for size 10
3. Results for size 100
4. Results for size 1000
5. Results for size 5000
6. Binary Search results

Save these in `docs/screenshots/` folder.

## Filling in README.md

After running the program:
1. Copy the execution times from your output
2. Fill in the tables in README.md
3. Answer the analysis questions based on your results
4. Write your reflection sections

## Git Workflow

### Initial setup
```bash
git init
git add .
git commit -m "init: project structure and base files"
```

### Feature commits (suggested order)
```bash
git add src/Sorter.java
git commit -m "feat(sorter): implemented Bubble Sort algorithm"

git add src/Sorter.java
git commit -m "feat(sorter): implemented Merge Sort algorithm"

git add src/Searcher.java
git commit -m "feat(searcher): implemented Binary Search algorithm"

git add src/Experiment.java
git commit -m "feat(experiment): added performance measurement system"

git add src/Main.java
git commit -m "feat(main): created main program flow"

git add README.md
git commit -m "docs(readme): added comprehensive analysis and documentation"

git commit -m "test: verified algorithm correctness and performance"

git tag -a v1.0 -m "release: v1.0"
```

### Push to GitHub
```bash
git remote add origin <your-github-repo-url>
git push -u origin main
git push --tags
```

## Troubleshooting

### If compilation fails
- Make sure Java JDK is installed: `java -version` and `javac -version`
- Check that you're in the `src` directory
- Ensure all files are present

### If output is cut off
- Increase terminal/console buffer size
- Redirect output to a file: `java Main > output.txt`

### For better visibility
- Use a terminal with good formatting support
- Ensure UTF-8 encoding for box-drawing characters

## Tips

- Run the program multiple times to see consistency in results
- Results may vary slightly between runs due to system load
- For large arrays, expect Bubble Sort to be significantly slower
- Binary Search should be extremely fast (microseconds)

Good luck!
