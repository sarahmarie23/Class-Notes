# Week 2 Lab

CSSSKL 132 - 10/4/24

    1. Variables and assignment
    2. Input/cin
    3. Arithmetic expressions
    4. Random

## 🔥 All about Variables

* Variables are used to hold information.
* Declaring vs initialize
  * **Declare**: To simply create a variable without attaching any value to it
  * **Initialize**: Assigning a value to the variable. You can overwrite old values. You can NOT overwrite the data type!

  > ✨ It is not necessary to initialize a variable when you declare it, just don't forget to initialize it. This is one of those things that can be the cause of a bug i.e. you forgot to initialize it!

  > ✨ While not necessary, it is good practice to declare your variables at the location in the code where you will be using it. This reduces the scope (which makes it easier to debug) and makes it easier to read and follow.

* 📝 Primitive types (fundamental/built-in) (these are only a few)
  * `int`
  * `double`
  * `float`
  * `char`
  * `bool`
* `string` is NOT a primitive type, we know this because we had to `#include` the string library. Think of a string like a sequence of single chars built up into a single string object.

* Later we will get into other types of variables, for now, know these

## ⌨️ Input using cin

> 🔨 `std::cin` works like cout, but you use the extraction operator >>
>
> 🔨 `>>` extraction operator, use this before the variable name
>
> 🔨 `getline(cin, var_name)` if you want the whole line read in

* `cin` is included with `<iostream>`

💻 Example: Use `cin` to read in your name.  
```cpp
string name;
cout << "Type your full name: ";
cin >> name;
// try again with getline(cin, name);
```

🤔❓ Can you stream together multiple inputs on one line? Example:

```cpp
string first;
string middle;
string last; 

cin >> first >> middle >> last;
```

🤔❓ Can you **declare** multiple variables on one line? Example:

```cpp
string first, middle, last;
```

## 🧩 Arithmetic expressions: all about numbers

> 🔨 + - * / add subtract multiply divide work like usual
>
> 🔨 `%` Modulus gives you the remainder (ex: 10 % 3 = 1) because dividing 10 / 3 is 3 with 1 left over
>
> 🔨 `++` and `--` increment and decrement. Add or subtract one. Placement matters! Example: `++pizzas` vs `pizzas++`

💻 Try it: ++pizzas vs pizzas++
```cpp
int pizzas = 5;

cout << "Initial pizzas: " << pizzas << endl;
cout << "After pizzas++: " << pizzas++ << endl; // prints first, THEN increments to 6
cout << "After ++pizzas: " << ++pizzas; // increments first to 7, THEN prints
```

### Modulo

* Used to get the remainder.

📝 Quick check: Make sure you understand why these are the answers.
> 10 % 3 = 1
>
> 3 % 10 = 3
>
> 3 % 0 returns an arithmetic exception (can't divide by 0)
>
> 10 % 10 = 0


🤔❓ Why do you even need modulo? Figure out even or odd is one example.

### Converting one type to another - type casting

* double to int: rounding down a price
```cpp
double cost = 10.75;
cout << "Cost as int: " << (int) cost; // 10
```

🤔❓ Why did it round down and not up to 11?

* int to double: find the average of two numbers
```cpp
int num1 = 10;
int num2 = 5;
double average = (num1 + num2) / 2; // add (double) before the equation
cout << average;
```

### Printf

If you want to round to 2 decimal places:

```cpp
printf("$%.2f\n", 23.67368); // $ added to display a cost
```

* Add `\n` to go to the next line because it doesn't automatically do that.

## 🎲 Random

> 🔨 `srand(time(0))` used to seed rand with a starting value. time(0) is the current time
>
> 🔨 `rand() % 10 + 1` if I put 10, it would give a random number from 0-9, so if you want a range of 1 to something, add 1 to the statement
>
> 🔨 `start + (rand() % (end - start + 1))` custom range [start-end]

🤔❓ Can you do a random double? What if you type cast it to int?
