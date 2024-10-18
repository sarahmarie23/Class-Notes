# Week 4 Lab

CSSSKL 132 - 10/18/24

## 🔑 Key Points 🔑

    1. While loops
    2. Do-while loops
    3. For loops and for-each loops
    4. Looping applications

## 🔁 Learning while loops - Todo List app example

* Today's scenario is that we would like to create a todo list app, where the user can enter a list of to do items and check them off when finished.

* A while loop will execute until the condition is false. The app needs to take in a list of todo items, so let's make a while loop that asks the user to enter items until they tell the program to stop.

  > ✨ It's good practice to think of the functionality BEFORE you think of the code needed.

  > ✨ I'm going to start using vectors now. Find a list of the vector's functions in the docs or this site is helpful <https://www.geeksforgeeks.org/vector-in-cpp-stl/>
  
```c++
#include <vector>

// vector<dataType> vectorName;
vector<string> todo_list; // Empty vector

int count = 0; // Let's keep count of how many items they have added
cout << "What is item #" << count + 1 << "? Type stop to finish." <<  endl; // Start at 0 in case they enter nothing

string todo_item;
getline(cin, todo_item);
cin.clear();

while (todo_item != "stop") {
  count++;
  todo_list.push_back(todo_item); // Add it to the vector
  cout << "What is item #" << count + 1 << "? Type stop to finish." <<  endl;
  getline(cin, todo_item);
  cin.clear();
}
```

### ☑️ Technique - Boolean flag

* One useful technique is to use a boolean flag that you switch to the opposite value when a certain condition is met. This can be good for a game that is keeping track of whose turn it is `bool user_turn = true;`

* Let's make a max amount of todo items and a boolean flag to mark that.

```c++
int max_items = 5; // Could do const int MAX_ITEMS = 5;
bool theres_room_left = true;
```

* And then change the while loop if its at max capacity

```c++
while (theres_room_left || todo_item != "stop") {
  // No changes here
  // Check for max capacity
  if (count == max_items) {
    theres_room_left = false;
  } else {
    theres_room_left = true;
  }
}
```

> ✨ Clean it up with a ternary operator

```c++
// Same thing, one line!
theres_room_left = (count == max_items) ? false : true;
```

🤔❓ But why isn't it stopping? There's something else we should do...use &&. This is a really common mistake! Check your while loop condition if its not working as you expected.

🏆 Bonus challenge: Can you figure out how to make the loop stop before asking for item #6?

## 👉 Do-While Loop - At least one round

* Since we know we need to ask the user at least once (it's possible they don't add anything so they are only asked once) a do-while loop could be appropriate here.

* We do need to rearrange some items, and take into account the `todo_item == 'stop'`

```c++
vector<string> todo_list;
int count = 0; 
string todo_item = "";

do {
  cout << "What is item #" << count + 1 << "? Type stop to finish." <<  endl;
  getline(cin, todo_item);
  cin.clear();
  count++;
  if (todo_item == "stop") { // we don't want to append stop
    break;
  }
  todo_list.push_back(todo_item);
  // Check for max capacity
  theres_room_left = (count == max_items) ? false : true;
  
} while (theres_room_left && todo_item != "stop");

```

* However, this might be less readable and more cumbersome.

🤔❓ Can you think of any use cases for a do-while loop? A good use case is for user validation: ask the user to enter something, record the response, while the response is invalid. Its guaranteed they will have to make at least one response.

## 🗂️ For loops - For when you KNOW when to start and stop

* While you can turn any loop into a for loop or a while loop (and vice versa), for loops are especially useful when you need to go over elements in an object that is indexed, like going over characters in a string or going over ints in a vector.

* The three statements are called the initialization, condition/test, and update

* 💻 Example: Print out the todo list with a for loop

```c++
cout << "Printing out using a for loop" << endl;
for (int i = 0; i < todo_list.size(); i++) {
  cout << todo_list.at(i) << endl;
}
```

* However, you can do the exact same operation using a for-each loop (aka range-based for loop)

```c++
cout << "Printing out using a for each loop" << endl;
for (string item : todo_list) {
  cout << item << endl;
}
```

### ❌ Limitations of the for each loop

1. Need to go through all elements *in order*
2. Can't change the elements
3. Don't have indices; sometimes its helpful to have them!

## 🌟 Looping applications - some helpful tools to know

### ☑️ You can do more than i++ in the update statement

* You can += 2 to only go through every other element

* 💻 Example: Go over every other item in the vector and append the word "- DONE!" to the end of the item.

```c++
for (int i = 0; i < todo_list.size(); i += 2) {
  todo_list.at(i).append(" - DONE!");
}
```

> ✨ Double check that it works with even or odd length vectors!

* You can go backwards using i--. You can use i /= 2, i *= 3.

### ☑️ Tip for preventing "array index out of bounds" errors

* A common task is to go through an object and compare one element to the next.

* 💻 Example: You have a vector with the temperatures for the week, and wanted to know, for each day to the next, did the temperature increase, decrease, or stay the same?

* It's easy to accidentally go to far if you're comparing one index to the next.

```c++
vector<int> temps = {50, 56, 56, 43, 44};
// ERROR! std::out_of_range
for (int i = 0; i < temps.size(); i++) {
  if (temps.at(i) < temps.at(i+1)) {
    cout << "Increase" << endl;
  } else if (temps.at(i) > temps.at(i+1)) {
    cout << "Decrease" << endl;
  } else {
    cout << "Stayed the same" <<endl;
  }
}
```

* To fix it: Start from the second element, and look backwards

```c++
for (int i = 1; i < temps.size(); i++) {
  if (temps.at(i-1) < temps.at(i)) {
    cout << "Increase" << endl;
  } else if (temps.at(i-1) > temps.at(i)) {
    cout << "Decrease" << endl;
  } else {
    cout << "Stayed the same" <<endl;
  }
}
```
