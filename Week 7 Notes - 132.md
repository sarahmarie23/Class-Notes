# Week 7 Lab

CSSSKL 132 - 11/8/24

## 🔑 Key Points 🔑

    1. Structs
    2. Using cstrings
    3. File I/O

## 🏠 Structs - when you need to store different types of data

* To store one number, you use an int. To store multiple numbers, you could use a vector. But what if you wanted a way to store an int, string, and a boolean? We can use a struct for that.

> 🤔❓ Based on our restaurant code, can you think of a good use case for a struct? Any other refactoring suggestions?

💻 Consider what attributes are needed

```c++
struct Order {
  char entree[50];
  double entreePrice;
  char drink[50];
  double drinkPrice;
  double deliveryFee;
  double discount;
  double subtotal;
  double grandTotal;
};
```

> ✨ Notice the name Order; captitalize each word for best practice

* In order to use a struct, create an instance of it in main. Same format for other variables: datatype then name.

```cpp
Order customerOrder;
```

* For practice, let's change the `entree` and `drink` strings to char arrays, or `cstring`s. And we will need to set a max length.

* We can fill in these values later. But first, let's talk about `cstrings` for a bit.

> 🤔❓ Why `cstrings`? Can you think of a reason why you'd ever need to use them?

## 🌟 Cstrings - another way to use strings

* The C programming language doesn't have a string datatype. Instead it uses char arrays. Recall that you can think of strings in C++ as char arrays as you are able to access them by index

### Differences ###

> You'll need `#include <cstring>`

> The **null terminating character** `\0` takes up a space, so keep that in mind to prevent going out of bounds!

### cstring functions

✅ `strcpy(destStr, sourceStr)`: Copies sourceStr (up to and including null character) to destStr.

✅ `strncpy(destStr, sourceStr, numChars)`: Copies up to numChars characters.

✅ `strcat(destStr, sourceStr)`: Copies sourceStr (up to and including null character) to end of destStr (starting at destStr's null character).

✅ `strncat(destStr, sourceStr, numChars)`: Copies up to numChars characters to destStr's end, then appends null character.

✅ `strchr(sourceStr, searchChar)`: Returns NULL if searchChar does not exist in sourceStr.

✅ `strlen(sourceStr)`: Returns number of characters in sourceStr up to, but not including, first null character.

✅ `int strcmp(str1, str2)`: Returns 0 if str1 and str2 are equal, non-zero if they differ.

> Since `strcmp()` returns an int, be sure to compare it to an int: `if(strcmp(str1, str2) == 0)` (this seems counter-intuitive so be careful)

### Things to look out for

> You have to be careful not to go out-of-bounds; like an array, the length of the cstring is set from the beginning. If you try to add onto it and there's not enough room, you will get an error.

```c++
  // This is okay, enough space allocated
  char greetings[11] = "Hello";
  printf("%s\n", greetings);
  
  strcat(greetings, " World");
  printf("%s\n", greetings);
  
  // Does not work, greetings is at max capacity
  strcat(greetings, "!");
  printf("%s\n", greetings);
```

> 🤔❓ What error does your IDE output? It works in some IDEs without error but it's not supposed to work.

### More functions - working with characters

✅ isalpha(c) -- Returns true if c is alphabetic: a-z or A-Z.

✅ isdigit(c) -- Returns true if c is a numeric digit: 0-9.

✅ isalnum(c) -- Returns true if c is alphabetic or a numeric digit.

✅ isspace(c) -- Returns true if character c is a whitespace.

✅ islower(c) -- Returns true if character c is a lowercase letter a-z.

✅ isupper(c) -- Returns true if character c is an uppercase letter A-Z.

✅ isblank(c) -- Returns true if character c is a blank character. Blank characters include spaces and tabs.

✅ isxdigit(c) -- Returns true if c is a hexadecimal digit: 0-9, a-f, A-F.

✅ ispunct(c) -- Returns true if c is a punctuation character. Punctuation characters include: !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~

✅ isprint(c) -- Returns true if c is a printable character. Printable characters include alphanumeric, punctuation, and space characters.

✅ iscntrl(c) -- Returns true if c is a control character. Control characters are all characters that are not printable.

> ✨ You might have already used `toupper(c)` and `tolower(c)` in previous assignments.

### cin.getline()

* Reading in user input into a char array is a little different from a string. Our old `getline()` function won't work for reading into a `cstring`.

```cpp
string input_string = "";
getline(cin, input_string);

char input_cstring[50];
cin.getline(input_cstring, 50);
```

💻 Change the getline() functions for the entree and drink and save it to the struct

```cpp
cout << "What is your entree order? ";
cin.getline(customerOrder.entree, 50);
```

## 📩 File Output #include <fstream>

* We need to send the information from the customer's order out to a `.txt` file. But there are some steps that we need to make sure we complete.

**1. Open the file:** Pick a name where you'd want to save the output file.You can even save it to a different directory, but it's easier if you practice getting it working first to a local directory.

* Use **ofstream** and give it a name

```cpp
ofstream receipt; 
receipt.open("OrderSummary.txt"); // File where you want to save it
```

> ✨ Fun fact: `ofstream` isn't capitalized like other classes because that's conventional for stream classes. Also, it came from C, where it's lowercase there.

**2. Check if the file is open:** Perhaps there is something wrong with the file location; check before you start writing.

```cpp
if (!receipt.is_open()) {
  cout << "Receipt printer is out of paper!" << endl;
  return 1; // So we don't continue with the code
}
```

**3. Write to the file:** Instead of `cout` use your output file stream (`receipt` in this example)

```cpp
receipt << "\nYou ordered a " << customerOrder.entree << " and a " << customerOrder.drink << "\n";
```

**4. Close the output file stream:**

```cpp
receipt.close();
```

> 🤔❓ Why is it so important to close the stream?

## ↩️ Back to structs for a moment

* We made a struct, declares an instance of a struct, and set values in that Order object. But how can we use it?

* Structs, like vectors, can be passed by reference by adding a `&`, making it easy to access and update.

```cpp
void calculateTotals(Order &order) {
// Code is copied over from the original
// Remember to reference the Order object
order.grandTotal = order.subtotal - (order.subtotal * order.discount * 0.01);
}
```  

* Don't forget to call it in `main`

```cpp
calculateTotals(customerOrder);
```

## 📬 File Input

### 💻 Read in and print out the receipt we just made

* We've used getline before to get a whole line of input from the user. We can also use it for getting lines from other things, like text files.

* Notice that opoening the file is the same process

```cpp
  // Open the file using an input file stream
  ifstream eReceipt;
  eReceipt.open("OrderSummary.txt");
```

* Checking is the same as well

```cpp
// Check if the file is open before you do anything further!
if (!eReceipt.is_open()) {
  cout << "We can't find your receipt.\n";
  eReceipt.close();
  return 1;
} 
```

Here's how you can use `getline()` to read line-by-line

```cpp
string currLine;
cout << "Your receipt contents:" << endl;

while (!eReceipt.eof()) {
  getline(eReceipt, currLine);
  cout << currLine << endl;
}
```

> ✨ Another way is to put the `getline()` inside the while condition
```cpp
while (getline(eReceipt, currLine)) {
  cout << currLine << endl;
}
```

