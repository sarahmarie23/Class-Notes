# Week 7 - Sorting

CSSSKL 133 - 2/21/25

    1. Overview of sorting algorithms: Selection and Insertion, Quicksort and Merge sort
    2. Coding Selection Sort from Pseudocode
    3. Using the Call Stack with QuickSort
    4. Big-O time complexities for these algorithms

## 🏠 Four sorting algorithms - An Overview

✨ Note: When we talk about big O notation, we're concerned with the **worst case** i.e. the array is reverse sorted. There are also notations for the best case and average case.

### Simple sorts - Selection Sort and Insertion Sort (O(n^2))

**Selection Sort**
 
* Visualization: Ordering people by height (shortest to tallest). You find the shortest person, swap them with the person in front. Now go to the remaining people and find the next shortest. Swap them with the second person in line. Repeat until everyone has been sorted.

* Big O explained: Even if it's sorted, all of the elements still need to be checked.

> 🤔❓ Technically, you iterate over n-1 elements each round, so why is it O(n^2) instead of something like O(1/2n^2)? Because we don't care about the factor multiplied by n.

**Insertion Sort**

* Visualization: Drawing several cards from the top of the deck and placing them in your hand in order. Pick up one card. Take the next card and start from the left until you find the spot where it belongs. Repeat until you have all of the cards in your hand.

* Big O explained: Since you need to take a card and start from the left side of your hand, you might have to check every single card each time you draw a card.

✨ Insertion sort is good for sorting a small number of elements. Sources vary, but [this site](https://algs4.cs.princeton.edu/23quicksort/) lists 15 as the cutoff.

### Divide and Conquer - Quicksort (O(n^2)) and Merge Sort (O(n log n))

**Quicksort**

* Visualization: You are sorting books on a shelf by title. You pick a pivot book (say, the middle one). Move the lower titles to the left and the higher titles to the right of the pivot book. Repeat the process on both sides until the shelf is sorted.

* Big O explained: Already sorted results in a slow runtime. Runtime depends on how you choose the pivot. Worst case would be randomly choosing the pivot.

> 🤔❓ Where does quicksort excel? When the elements are randomly placed. It has the advantage of sorting in place.

**Merge sort**

* Visualization: Sorting a stack of papers. Split the papers in two piles, and keep splitting until you have single piles. Merge those two papers together in order. Keep moving up and merging papers until all are brought back together and sorted.

* Big O explained: Since this is a divide and conquer algorithm, it is O(n log n) best and worst case.

## Let's Code Selection Sort from Pseudocode

```
SELECTION-SORT(A)
  n = length(A)
  for i = 0 to n - 2 do
      minIndex = i
      for j = i + 1 to n - 1 do
          if A[j] < A[minIndex] then
              minIndex = j
      swap A[i] and A[minIndex]
```

  * In a nutshell: Loop through the array from 0 to n-2. minIndex keeps track of the smallest element's index. Then swap the current element with the element of minIndex. Loop until sorted.

```cpp
void selectionSort(int arr[], int n) {
  for (int i = 0; i < n - 1; i++) {
    int minIndex = i;
    for (int j = i + 1; j < n; j++) {
      if (arr[j] < arr[minIndex]) {
        minIndex = j;
      }
    }
    swap(arr[i], arr[minIndex]); // Use the built in C++ swap() function
  }
}
```

## Using the Call Stack with Quicksort - using OnlineGDB

* It can be helpful to visualize the call stack. This will help you with debugging and see what's going on with your code.

* Use a breakpoint (in VS Code, it's a small red dot placed by clicking to the left of the line number) in the following locations

✅  When we reach the base case
```cpp
  if (low >= high) {
    return;
  }
```
✅ Calling partition()
```cpp
partitionIndex = partition(numbers, low, high);
```
✅ When the pivot value is selected
```cpp
int pivot = numbers[midpoint];
```
✅ When the values are being swapped
```cpp
swap(numbers[leftPtr], numbers[rightPtr]);
```
✅ When partition() finishes and we return the right ptr
```cpp
return rightPtr;
```

✨ The program will stop whereever you have a breakpoint. Pick important variables, function calls, return statement, anything you want to keep an eye out for.

* Check out the call stack. You can see each function as it is pushed to the stack and popped off.

* **Local Variables** - Want to save yourself the trouble of cout-ing variables all the time? Just see your variables here!

* Breakpoints and Watchpoints - Check and uncheck which breakpoints you wish to watch.

### Debugger commands

* **Continue** - Keep going to the next breakpoint. The program will stop there.

* **Step into** - Go line by line through the function. Helpful if you want to watch how variables change.

* **Step over** - Go line by line but don't go inside the function call

* **Step out** - If you stepped into a function and want to return back to the calling function.

✨ Play around with it and see if you can follow along on the call stack with the function calls as the push and pop off.