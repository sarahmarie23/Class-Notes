# Week 6 Lab

CSSSKL 132 - 11/1/24

## 🔑 Key Points 🔑

	1. Utilizing functions
	2. Pass by value vs pass by reference
	3. Functions that return values
	4. Separating code into a header file and main.cpp file
    
## 📦 Moving code into functions

* Let's look back to the in-class code from week 4. It was about loops and we made a user-generated todo list.

* Consider what blocks of code would be good in a function.

> ❓🤔 How do you know if you should make a function?



Start with the first problem (taking in user todo items)

```cpp
void getTodoItem(vector<string> todo_list) {
  bool theres_room_left = true;
	int max_items = 4;
	int count = 0;

	cout << "What is your todo item #" << count + 1 << "? Type stop to finish" << endl;
	string todo_item;
	getline(cin, todo_item);
	cin.clear();

	while (theres_room_left && todo_item != "stop") { 
		count++;
		todo_list.push_back(todo_item);
		cout << "What is your todo item #" << count + 1 << "? Type stop to finish" << endl;
		getline(cin, todo_item);
		cin.clear();

    theres_room_left = (count == max_items) ? false : true;
	}
}
```

* I told you that the function needed to be placed above the main function. But there's a better way to do that!

> 📝 Add a **function declaration**. This way you can put the **function definition** (block of code) after `main`.

### Problem: Nothing went into the vector. How do you suppose we fix that?

## 📩 Pass by value vs pass by reference

* This code uses ***pass by value*** meaning we just passed the value of the vector, a copy, into the function. When a value was added, it was added to the copy that is *only reachable from within the function*.

* Solution: You might think, "What if I just return a vector to main, that way it has all the information?" Sure, you could do that. But that wastes memory and will slow things down.

* The real solution: Pass a *reference* of the vector to the function. Any changes made to the vector in the function will be made on the original vector. There's only one original vector in play here.

* A reference is the ***address in memory where the element is stored*** so you can directly access and modify the element.

> ✨ This concept is tricky for many students and it's going to get a bit more challenging! Make sure you understand this concept this week.

> ✔️ **Tip:** if you can explain pass by value and pass by reference to a friend, that's a good way you know you understand. Even better: explain it to your friend who *doesn't* know programming, or even a child! That means you *really* know.

> 📝 Fix the function header so that it passes in a reference to a vector.

> 📝 Also update the function declaration.

### ✔️ Now complete the rest of the functions.

## 🚚 Functions that return values

* On lab 1, we went over functions that were void (didn't return anything). It would be helpful if we could use functions that do return something. Maybe they calculate a value, or generate a string from user input.

> 📝 Make a function that returns the most recently added item to the list.

```cpp
string getLastItem(vector<string>& todo_list) {
  // Returns the last element of the list
  if (todo_list.empty()) {
    return "The list is empty!";
  }
  
  return todo_list.back();
}
```

> ✨ Make sure you test it for both full and empty lists!

## 🗂️ Working with multiple files

* Now that we've separated the code into functions, we can organize it even further.

### Start with the Header file

* A file that contains

1. Guards - so the contents of the header file doesn't get accidentally reused and cause the "multiple definition" error

 * Example: There are multiple files in the project that `#include` that header file

> ✨ Include these three guards

```c++
#ifndef HEADER_H // All caps, use _, replace HEADER with the name of your header
#define HEADER_H

// function declarations

#endif
```

2. Your function declarations

> If you wrote them above main, copy paste them over

### Moving on to main.cpp

```c++
#include "header.h"
#include <iostream>
#include <vector>

using namespace std;

int main() {
  
	vector<string> todo_list;
	
	getTodoItem(todo_list);
	forLoopPrint(todo_list);
	printListBackwards(todo_list);
	string last = getLastItem(todo_list);
	
	cout << "the last item is: " << last;
	
	return 0;
}
```

## 🏔️ Bonus: Constants

* Your code could have elements that are declared once and never changed. In fact, they probably aren't ever supposed to change. An example of that would be `int max_items = 6;`. We can declare it as a **constant** to ensure it can never be changed during the life of the program.

```c++
const int MAX_ITEMS = 6;
```

> ✨ It is conventional to use this style of all caps and underscores.

* I'm leaving it in `functions.cpp` but if you need it to be used in other files you could put it in the header.

