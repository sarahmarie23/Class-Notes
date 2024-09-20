# Week 1 Lab

CSSSKL 132 - 9/27/24

    1. Using an IDE and File Organization
    2. Print Statements
    3. Simple Methods
    4. Fixing Syntax Errors (Debugging Strategies) 

## 🚀 Using an IDE and File Organization

* An IDE (Integrated Development Environment) is a software application that helps you write code.
* Use an online one, like OnlineGDB https://onlinegdb.com 
* You can try downloading one like VS Code https://code.visualstudio.com/download but there might be extra steps so come talk to me if you need help.

### Staying organized

* Make it easy to locate and manage all your documents
* Create a new folder on your computer to store all your CSSSKL 132 projects and assignments. I recommend making a folder for each week inside this CSSSKL 132 folder.

### Your first program

* A class is a blueprint for creating objects. Think an actual blueprint like for creating a house. Or a recipe for baking cookies. A class is a recipe for baking cookie objects.

1. Choose a descriptive name like `lab_1a.cpp`
2. Start with the `int main()` function. This is where the program starts running.
3. Add a `return 0;` which means if the program returns 0, success! The program works without errors.
4. Let's display the string "Hello World" in the console. To do that, we'll need to type `std::cout << "Hello World" << endl;`. Use `<<` between strings to *concatenate* them together.
5. Lastly, add `#include <iostream>` at the top. This library is needed when you have input or output, which we do since we are printing out.

> ✨ You can also use `using namespace std` and omit the `std::` before the `cout`. This includes the standard functions so you don't have to type `std::` every time

### Completed example

```cpp
#include <iostream>
using namespace std;

int main() {
  cout << "Hello World" << "!" << endl;
  
  return 0;  
}
```

## 🌎 Print Statements

> 📝 `std::cout` starts the print statement
>
> 📝 `std:endl` ends the print statement, and goes to the next line

🤔❓ Write a print statement above the "Hello world" line, but leave out the `std:endl` so there's just a `;`. What happens, and why do you think that is?

## 🧩 Simple Methods

> 📝 A Method is a block of code that performs a specific task or function.
>
> 📝 They may or may not take in arguments, and they may or may not return anything.

### Add a method to our program

1. Decide if you need to pass anything into the method, and if it should return anything. We'll start with a simple `void myMethod()`

2. Write out the code for the method. **The method needs to be above the main function!**

3. Add a method call in main() like `myMethod();`

🤔❓ Can you call one method from another method?

### Completed example

```cpp
#include <iostream>
using namespace std;

void printGreeting() {
  cout << "Hello " << "world" << "!" << endl;
}

int main() {
  printGreeting();
  
  return 0;  
}
```

## 🛠️ Fixing Syntax Errors ##

🤔❓ What are some syntax errors we've seen today, or that you've encountered before?

### My tips and strategies

1. **Comment out all but the beginning** and uncomment section by section until you encounter a syntax error.

    > 📝 `//` to comment out a single line.
    >
    > 📝 `/*` *[code goes here]* `*/` to comment out multiple lines.

2. **Fix errors at the top first**; sometimes, this will fix errors later in the code.

3. **Read the error messages**. It shows what line numbers to look at. Sometimes it tells you exactly what you need to do.

4. **Read your code line by line** and simulate what's happening on paper or a whiteboard. Is it doing what you wanted it to do?

### Common Syntax Errors

    ⚠️ Missing semicolon
    ⚠️ Mismatched quotes " ", brackets { }, parentheses ( ); missing a single quote or bracket
    ⚠️ Using ' ' instead of " "
    ⚠️ Spelling mistakes
    ⚠️ Variable was not declared
    ⚠️ You commented something out and forgot to uncomment it
    