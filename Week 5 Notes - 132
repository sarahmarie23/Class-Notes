# Week 5 Lab

CSSSKL 132 - 10/25/24

## 🔑 Key Points 🔑

    1. Arrays and their functions
    2. Vectors and their functions
    3. 2D arrays and vectors

## 🌟 Array vs vector? - Make a table to compare them

✅ Arrays and Vectors are both data structures.

✅ They both hold elements of the same type.

✅ They both are accessible by index.

✅ Vectors are **dynamic**. They can grow and shrink.

✅ You don't need to declare the size when you initialize Vectors.

✅ Vectors have their own set of methods.

✅ Add your own facts!

## 📦 Arrays: Declare, insert element, access element, looping, functions

> ✨ A string can be represented as an array of chars, which is why you could access chars like `my_string[i]`.



### 1D arrays

_**Ways to initialize**_

1. No elements - **Must declare a size!**

    ```cpp
    string schedule[4] = {};  
    ```

2. With all elements

    ```cpp
    string schedule[] = {"CSS 132", "Calc 1", "American history"}; 
    ```

3. With some elements

    ```cpp
    string schedule[4] = {"CSS 132"}; 
    ```

> ✨ If you don't add a size, it will take the size of the number of elements!

_**Insert element**_

* Access it at an index `schedule[2] = "Physics";`

> ✨ If there is already an element there, it will be overridden.

> 🤔❓ What happens if I did `schedule[5] = "Physics";`?

_**Access element**_

> `string my_class = schedule[2];`

### Looping through an array

* For loop - How do you get the size?

> ✔️ To get the size: ```sizeof(array_name);``` but this is the size in **bytes**. To get the quantity, divide by the size of the first element.

```cpp
cout << "size of schedule: " << sizeof(schedule) << endl; // returns 96
int num_classes = sizeof(schedule) / sizeof(schedule[0]); // returns 3 

for (int i = 0; i < num_classes; i++) {
  printf("Class %i: %s\n", i, schedule[i].c_str());
}
```

> ✨ To `printf()` a string, add `.c_str()` to the end of the string variable.

* For each loop

```cpp
for (string c : schedule) {
  cout << c << endl;
}
```
> ✨ Fun fact: You wouldn't be able to use `string class` (which is more clear!) because `class` is a reserved word in C++.

_**Array functions**_

### `sort()`

`sort(arr, arr + arr_size);`

> ✨Don't forget to import the `<algorithm>` library!

> ✔️ **Note on sorting strings:** They will be sorted by ASCII value. Capital letters are "less" than lowercase.

### `swap()` - Simply indicate which to swap

`swap(arr[0], arr[1]);`

> 🤔❓ Can you swap an entire array? How about in a 2D array, swap one element from one array into another array? Can you swap elements in two separate arrays?

### 2D arrays

* Must assign the size of the inner arrays!
* Leaving the first [] empty is optional. It will figure out the size (3 in this case).

```cpp
string year[][3] = {
  {"CSS 132", "Calc 1", "American history"},
  {"CSS 133", "Calc 2", "Writing"},
  {"Chemistry", "Econ", "Music"}
};
```

* Getting the size works the same as getting the size for a 1D array

```cpp
int num_semesters = sizeof(year) / sizeof(year[0]);
```

> ✨ We want to know how many elements are in the array. This 2D array has arrays for its elements, so how many inner arrays are there?

* Looping goes **Row by Row** on the outer loop and **Column by Column** on the inner looop!

```cpp
for (int sem = 0; sem < num_semesters; sem++) {
  for (int c = 0; c < num_classes; c++) {
    cout << year[sem][c] << " ";
  }
  cout << endl;
}
```

> ✨ You can use i for the outer loop and j for the inner loop, but it can be helpful to use variables that represent your use case.

## ↗️ Vectors

* Like an array, but it is resizable

_**Ways to initialize**_

1. No elements

```cpp
vector<string> v_classes;
```

2. With elements

```cpp
vector<string> v_classes = {"CSS 132", "Calc 1", "American history"};
```

_**Insert element**_

1. Insert at the end

```cpp
v_classes.push_back("Art");
```

2. Insert somewhere else

```cpp
v_classes[0] = "Art"; // Just like an array
v_classes.at(0) = "Art";
```

_**Access element**_

```cpp
string first_class = v_classes[0]; // Just like an array
string next_class = v_classes.at(1);
```

### Looping through a vector

* Using a for each loop: Same as for an array

```c++
for (string s : v_classes) {
  cout << s << " " << endl;
}
```

* Using a for loop: You can use the size() function to easily get the size

```cpp
for (int i = 0; i < v_classes.size(); i++) {
  printf("Class %i: %s\n", i, v_classes[i].c_str());
}
```

### 2D Vector looping

> ✨ Note the `vector<vector<string>>` data type
* The rest is the same as the array

* For loop

```cpp
vector<vector<string>> v_year = {
  {"CSS 132", "Calc 1", "American history"},
  {"CSS 133", "Calc 2", "Writing"},
  {"Chemistry", "Econ", "Music"}
};

for (int sem = 0; sem < v_year.size(); sem++) {
  for (int c = 0; c < v_year[0].size(); c++) {
    cout << v_year[sem][c] << " ";
  }
  cout << endl;
}
```
* And we were able to use the `size()` function

* For each loop

```cpp
for (vector<string> sem : v_year) {
  for (string s : sem) {
    cout << s << " " << endl;
  }
  
  cout << endl;
}
```
> ✨ There is an easier way: use `auto` instead of `vector<string>` and `string` in the for each loop expressions.

### Vector functions

* `at()` - Get the element at that index
* `front()` - Get the first element
* `back()` - Get the last element
* `push_back()` - Add element to the end
* `pop_back()` - Remove element from the end
* `size()` - Get the size of the vector
* `empty()` - Returns true if a vector is empty, false otherwise
* `vector1.swap(vector2)` - Swap the contents of two vectors