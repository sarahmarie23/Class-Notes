# Week 9 Lab

CSSSKL 133 - 3/7/25

    1. C-strings
    2. Arrays in C
    3. Pointers in C
    4. Structs in C


## 🦸‍♂️ Superheroes and C-Strings

* In C, strings are represented as arrays of characters, terminated by a null character (`\0`). These are called c-strings.
* No `string` class like in C++!

> 🤔❓ How do we declare a superhero's name in C?

```c
char heroName[50] = "Supernova"; // Allocate space for up to 49 characters + null terminator
```

* **Key Difference**: No std::string! We rely on character arrays and functions from string.h.
* **Reminder**: Include <string.h> for string manipulation functions.

```c
#include <stdio.h>
#include <string.h> // Include string.h

int main() {
    char villainName[50] = "Dr. Doom";
    printf("The villain's name is: %s\n", villainName); // %s is the format specifier for strings

    // Example: Finding the length of a c-string
    int length = strlen(villainName);
    printf("The length of the villain's name is: %d\n", length);

    return 0;
}
```

## 🦸‍♀️ Superhero Teams and Arrays

* Arrays in C are fixed-size collections of elements of the same type.
* Let's create an array to store the ages of our superhero team.

```c
int heroAges[3] = {25, 30, 28}; // Array of 3 integers
```

* **Key Difference**: Arrays in C don't have built-in methods like size() or dynamic resizing.

* **Reminder**: Be careful with array bounds! C doesn't have automatic bounds checking.

```c
int heroAges[3] = {25, 30, 28};

for (int i = 0; i < 3; i++) {
    printf("Hero age at index %d: %d\n", i, heroAges[i]);
}
```

## 🦸‍♂️ Superhero Powers and Pointers

* Pointers store memory addresses. They are essential for dynamic memory allocation and passing data efficiently.

* Let's use pointers to access and modify a superhero's power level.

```c
int powerLevel = 9000;
int *powerPtr = &powerLevel; // powerPtr now points to powerLevel
```

* **Key Difference**: Pointers are more explicit in C compared to C++ references.

* Reminder**: Remember the * (dereference) and & (address-of) operators!

```c
int powerLevel = 9000;
int *powerPtr = &powerLevel;

printf("Power level: %d\n", powerLevel);
printf("Power level via pointer: %d\n", *powerPtr);

*powerPtr = 9500; // Modify the value through the pointer
printf("Updated power level: %d\n", powerLevel);
```

## 🦸‍♀️ Superhero Profiles and Structs

* Structs allow you to group related data items of different types.

* Let's define a struct to represent a superhero's profile.

```c
struct Superhero {
    char name[50];
    int age;
    int powerLevel;
};
```

* **Key Difference**: Structs in C don't have member functions (methods) like classes in C++.

* **Reminder**: Use the . operator to access struct members.

```c
struct Superhero {
    char name[50];
    int age;
    int powerLevel;
};

int main() {
    struct Superhero hero1;
    strcpy(hero1.name, "Wonder Woman"); // Use strcpy to copy strings!
    hero1.age = 30;
    hero1.powerLevel = 9800;

    printf("Superhero: %s, Age: %d, Power: %d\n", hero1.name, hero1.age, hero1.powerLevel);

    return 0;
}
```

📝 Activity: Superhero Team Manager
* Create a struct to represent a superhero, including name, age, and power level.
* Create an array of these structs to represent a superhero team.
* Write a function that takes the team array and its size as input and prints out the details of each superhero.
* Write a function that takes a team array, its size, and a name, and returns the pointer to the superhero struct with that name, or NULL if it is not found.
* Use strcpy() to copy strings into your struct.
* Use pointers to modify the power level of a superhero.

🤔❓ What is the most efficient way to search for a superhero in the array?

🤔❓ How would you handle a team with a variable number of superheroes?

```c
//Example of strcpy.
#include <string.h>
strcpy(hero1.name, "Wonder Woman");
```