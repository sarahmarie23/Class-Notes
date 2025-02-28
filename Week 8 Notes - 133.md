# Week 8 - Sorting, Searching, Recursion Practice

CSSSKL 133 - 2/28/25

    1. Revisit Merge Sort - Using a Linked List
    2. Traversing a matrix using recursion
    3. Finding the time complexity - a look at previous problems

## 📄 Mergesort, but this time, on a linked list

* Recall that the merge sort algorithm is a divide and conquer algorithm, where the elements are split in half until they can't be split any further. Then the pairs of elements are sorted, and these sorted sublists are combined with the others until the whole list is sorted.

* We can do the same on a linked list. First let's look at the pseudocode (from lab 7):

```c++
mergeSort(arr, left, right):
  if left >= right:
    return  // Base case: A single element is already sorted
  
  mid = (left + right) / 2  // Integer division assumed
  
  mergeSort(arr, left, mid)  // Sort first half 
  mergeSort(arr, mid + 1, right)  // Sort second half
  
  merge(arr, left, mid, right)  // Merge the two sorted halves
```

* Turning it into a linked list version

```cpp
Node* mergeSort(Node* head) {
  // Base case: a single node is already sorted
  if (head == nullptr || head->next == nullptr) {
    return head;
  }

  // Find the middle node (I'm using a separate method)
  Node* second = split(head); // Returns the start of the second half

  head = mergeSort(head); 	// Sort first half
  second = mergeSort(second); // Sort second half

  return merge(head, second); // Merge the two sorted halves
}
```

* We can't just find the middle index, so we'll need to traverse the linked list to find the middle using the fast and slow pointer technique. Then we can disconnect the nodes and have a left and right half.

```c++
Node* split(Node* head) {
	// Start with a slow and fast pointer pointing to the head of the linked list
	Node* prev = nullptr; // Also keep track of the previous node
	Node* slow = head;
	Node* fast = head;
	
	// while the fast pointer hasn't reached the end of the list AND fast's next is not pointing to nullptr
	while (fast != nullptr && fast->next != nullptr) {
		prev = slow;
		fast = fast->next->next; // move the fast pointer two steps
		slow = slow->next; // move the slow pointer one step
	}
	
	// Disconnect the first half from the second
	if (prev) {
		prev->next = nullptr;
    }
	
    return slow;
}
```

✨ Note: The linked list version returns a node, whereas the regular version has a void return type. This is because we need a way to access the nodes in the list.

* The array version needed us to create an array and copy the elements in order into it. For a linked list, we will compare the two lists, one node at a time, and set `next` by recursively calling `merge()` and advancing the pointer with the smaller value.

✨ This can be space efficient as we don't need to allocate extra array space; just reroute the pointers!

* Now complete `merge()`

```c++
Node* merge(Node* first, Node* second) {
	// If either list is empty, return the other list
	if (!first) {
		return second;
	}
	if (second == nullptr) {
		return first;
	}
	
	// Compare the first nodes from each list. We want the smaller one.
	if (first->val < second->val) {
		
		// Set the next node by recursively calling merge, moving one node down the lin.
		first->next = merge(first->next, second);
		return first;
		
	} else { // Else the second node's val is smaller 
		
		// Set the next node by recursively calling merge, moving one node down the line.
		second->next = merge(first, second->next);
		return second;
	}
}
```

## 🚇 Traversing a maze/matrix using recursion

* Imagine you have a grid where you start at (0, 0) and need to try and traverse to the bottom right corner (3, 3) in this example, a `0` represents an opening whereas a `1` represents a wall.

* Return `true` if there is a way out of the maze, `false` otherwise.

```cpp
vector<vector<int>> grid1 = {
  {0, 0, 1, 0}, 
  {1, 0, 1, 0}, 
  {0, 0, 0, 1}, 
  {1, 1, 0, 0}
}; 
```

* A path exists in this maze! The following, however, does not have a way out.

```cpp
vector<vector<int>> grid2 = {
  {0, 1, 1, 0}, 
  {1, 1, 0, 1}, 
  {0, 0, 1, 0}, 
  {1, 0, 0, 1}
}; 
```

* 🤔❓ Just by looking at it, how would you solve it?

### Let's use recursion to see if we can escape

* Base case: if you go out of bounds, or hit a wall, we return `false`

```cpp
if (row < 0 || col < 0 || row >= n || col >= n || grid[row][col] == 1) {
  return false;
}
```

* The other base case: we made it to the end!

```cpp
if (row == n - 1 && col == n - 1) {
  return true;
}
```

* Recursive case: Try every direction

```cpp
// Try moving in all 4 directions
bool foundPath = canEscape(grid, row + 1, col) || 
                 canEscape(grid, row - 1, col) || 
                 canEscape(grid, row, col + 1) || 
                 canEscape(grid, row, col - 1);  
```

* ⚠️ Be sure to mark the elements that you already visited, otherwise you'll be stuck in an infinite loop!

```cpp
// Mark the cell as visited to avoid infinite loops
grid[row][col] = 1;
```

✨ Let's make an improvement by introducing **backtracking**. There might be a case where you marked a cell as visited, but you actually needed that path. This is why you should unmark that cell if you didn't get to the end.

```cpp
// Unmark the cell before returning (backtracking)
grid[row][col] = 0;
```

## ⏱️ Checking the time complexity of prior problems

### Week 2

```cpp
// Problem 3 - findTheMiddleValue()
int LinkedList::findTheMiddleValue() {
  Node* slow = _head;
  Node* fast = _head;

  while (fast != nullptr && fast->next != nullptr) {
    slow = slow->next;
    fast = fast->next->next;
  }

  return slow->data;
}
```

* **Time complexity:** O(n)
* **Space complexity:** O(1)
* **Explanation:** The list is traversed once. The only extra space needed is the two pointers, which doesn't matter how long the list is.

### Week 4

```cpp
int numberOfUnhappyCustomers(queue<int>& customers, queue<int>& dishes) {
  int maxRounds = customers.size(); 
  int rejects = 0;

  while (!customers.empty() && !dishes.empty()) {
    if (customers.front() == dishes.front()) { // Customer is served
      customers.pop();
      dishes.pop();
      rejects = 0; // Reset rejects since we made progress
    } else {
      // Customer not served, go to the back of the queue
      customers.push(customers.front());
      customers.pop();
      rejects++;

      // Break if everyone has gone through and no dishes are served
      if (rejects == customers.size()) {
        break;
      }
    }
  }

  return customers.size(); 
}
```

* **Time complexity:** O(n * m) (customers * dishes)
* **Space complexity:** O(n)
* **Explanation:** Worst case, every customer rejects every dish, There are two queues, both the same size, and they scale linerarly.

### Week 5

```cpp
// in main
vector<pair<string, string>> grocery2 = {
  {"Chicken", "Meat"}, {"Onion", "Produce"}, {"Banana", "Produce"}, {"Milk", "Dairy"}, {"Cheese", "Dairy"}, {"Fish", "Meat"}, {"Steak", "Meat"}, {"Ice cream", "Freezer"}
};

// Custom sort function called sortByDeptThenItem
sort(grocery2.begin(), grocery2.end(), sortByDeptThenItem);

// sortByDeptThenItem
bool sortByDeptThenItem(pair<string, string> e1, pair<string, string> e2) {
  // Sort by item if the depts are equal
  if (e1.second == e2.second) {
    return e1.first < e2.first;
  }
  return e1.second < e2.second; 
}
```

* **Time complexity:** O(n log n)
* **Space complexity:** O(n)
* **Explanation:** Somewhat of a trick question, since `sort()` algorithm is determined under the hood. `sortByDeptThenItem()` is O(1) time since it just compares the items. Therefore, choose O(n log n). Since `sort()` requires extra space for recursive calls, it uses O(n) space.
