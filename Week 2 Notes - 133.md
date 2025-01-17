# Week 2 Lab

CSSSKL 133 - 1/17/25

    1. Making a linked list from scratch
    2. Problem Solving: Deleting duplicates from a linked list 
    3. Comparing LL speed to an array
    4. Using argc and argv in main

## 🔗 Making your own linked list

* I will use a struct for the Node and a class for the LinkedList.

* Like any class, you'll need data members, constructors, and functions.

```cpp
struct Node {
  // Data Members
  int val;
  Node* next;

  // Constructors
  Node() : val(0), next(nullptr) {}
  Node(int x) : val(x), next(nullptr) {}
  Node(int x, Node* next) : val(x), next(next) {} 
};
```

```cpp
class LinkedList {
  Node* head;
  LinkedList() : head(nullptr) {}
  ~LinkedList();
}

LinkedList::~LinkedList() {
  cout << "Destroying LL" << endl;
  Node* curr = head; // Need a placeholder pointer to travel the LL
  while (curr != nullptr) {
    Node* next = curr->next;
    delete curr;
    curr = next;
  }
}
```

* Also add in a function to add a node to the end

```cpp
void LinkedList::addNodeAtEnd(int data) {
  Node* newNode = new Node(data);
  if (head == nullptr) {
    head = newNode;
    return;
  }
  Node* curr = head;
  while (curr->next != nullptr) {
    curr = curr->next;
  }
  curr->next = newNode;
}
```

✨ I am keeping these all in one file but you could/should separate them out and add a header file

## 🧩 Deleting duplicates from a linked list - How to work through a coding problem

* Leetcode #83 - Assumptions:

  * You are given the head of a singly-linked list.

  * The values are in increasing order, and can range from [1-100].

  * You need to delete the duplicate nodes, not just copy over the values.

>🤔❓ Should we delete the first instance or the second?

📝 Draw it out so you can see what is happening

### 📝 Your turn: Check out problem 1 of the lab

  * Together, let's write some tests that we could use to test out this problem.

  * Use `addNodeAtEnd()` to build up a linked list.

### 🤔❓ Consider some situations and edge cases (draw this out)

* What happens if there are more than 2 duplicates?

* What if the linked list had all of the same value?

* What if the linked list had all different values?

### Write pseudocode for the steps

```cpp
void deleteDuplicates(Node* head) {

  if (head == nullptr) { // Empty list situation
    return;
  }

  Node* curr = head; // Pointer to the current node so we always have access to the LL
  while (curr->next != nullptr) {
    // Duplicate found
    if (curr->val == curr->next->val) {
      Node* temp = curr->next; // Pointer to the next node; delete this one
      curr->next = temp->next; // Tell curr to now skip the node that needs to be deleted and go to the next node;
      delete temp; // Free the memory from the duplicated node
    } else { // Keep moving the curr pointer to the next node 
      curr = curr->next;
    }
  }

  return; // Lists with only 1 node will not enter the while loop
}
```


## ⏲️ Comparing linked list speed to an array

* Use the `<chrono>` class to make a start and stop timer, then compare stop-start

* It can use miliseconds as the unit of time

* Source: [Post from Cubbi on 5/28/2012](https://cplusplus.com/forum/general/72007/)

```cpp
auto t1 = std::chrono::high_resolution_clock::now();
test_function();
auto t2 = std::chrono::high_resolution_clock::now();
std::cout << "test function took "
          << std::chrono::duration_cast<std::chrono::milliseconds>(t2-t1).count()
          << " milliseconds\n";
```
* Test by using a function to add up all the values in an equally value array and linked list

```cpp
// Place inside the Linked List class
int sumList() { 
  int sum = 0;
  Node* curr = head;
  while (curr != nullptr) {
    sum += curr->val;
    curr = curr->next;
  }
  return sum;
}
```

## 🤝 Using argc and argv in main

* This allows you to pass some arguments (as strings) that can be used in main.

* `int argc`: This is the number of arguments that were passed in. **You don't actually pass this value in! It figured out automatically for you**

✨It will be equal to the size of your list of arguments plus one, because `argv[0]` contains the program's name.

* If you pass in "100" you're passing in a string. If you intended for it to be used as an int, you need to convert it in main.

`int size = atoi(argv[1]);`