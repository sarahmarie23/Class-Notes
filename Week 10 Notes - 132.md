# Week 10 Lab

CSSSKL 132 - 12/6/24

## 🔑 Key Points 🔑

    1. Binary and hexadecimal numbers
    2. Making classes and objects
      -Constructors and destructors
      -How do you know public or private
      -Overloading operators to make custom functions
    3. Pointers and dynamically allocated arrays
    4. Overloaded operators

## #️⃣ Binary and Hexadecimal - how it works

* Consider the base-10 number system we have. If you have a number like 794, you can write it like

  7 * 100 + 9 * 10 + 4 * 1 = 794 Or

  7 x 10^2 + 9 x 10^1 + 4 x 10^0 = 794

* For binary, you would use 2^n instead of 10^n. Hexadecimal uses 16^n.

📝 **Base 10 to binary - 85**

    Divide by 2. The remainder is the binary digit at the least significant bit (think 'ones' place).
    Keep dividing until you get down to 0.
    The beginning of the number starts with the bottom of the list.

* 85 becomes 1010101

📝 **Binary to base 10**

    Multiply Each digit by 10^0, 10^1, etc, starting with least significant bit.

📝 **Base 10 to hexadecimal**

    Same as binary, but use 16 instad of 2
    For values greater than 9, use A = 10, B = 11, C = 12, D = 13, E = 14, F = 15.

* 85 becomes 55

📝 **Hexadecimal to base 10**

    Same as binary, but use 16^0, 16^1, etc, starting with least significant bit

## 🏡 Making Classes and objects

1. Think about where you might need to make objects and classes
  * Hint: pretty much anything!

📝 Let's get some inspiration. List out all the things that could be made into objects and classes.

https://www.youtube.com/watch?v=Rla3FUlxJdE&ab_channel=Minecraft (Stop at the 1:00 mark)

2. Pick one. What attributes does it have? What can it do?

  * Start writing the class out

💻 Consider what attributes (data members and member functions) are needed

> 🤔❓ How to know if something should be public or private?

  * Make it private if it doesn't need to be accessed by other classes.

  * Consider using private functions for validation of input pased in to public functions. Private functions can also be used for making internal calculations.

3. Write out the constructors: default and overloaded

  * Always include a default constructor!

  * Always include a destructor! Only need one.

> ✨ You don't need to call the destructor. It gets called automatically.

```c++
// Constructors
Zombie(); // Default constructor
Zombie(int health, bool baby); 

// Destructor
~Zombie();
```

4. Write out your member functions

* For something simple like this, I like to list the accessors and mutators first, but do what works best. In the real world, I like to put frequently used functions near the top, and also list the functions in the order that they are used in the program.

> ✨ Write out the header file first. When you have everything figured out that you need, write out the implementation file.

5. Move on to the implementation file

> 🤔❓ Do we really have to make separate files like this? If its a small project you can keep it in one file (even put two classes all in one file!). Be careful if your project grows though. It will be more difficult to split it up afterwards than to do it from the beginning.

* Copy over each constructor, destructor, and function.

* Add a Class:: (replace with the actual class name) before each item.

### Let's play!

* Make a `main.cpp` and outline what we should make our objects do. Be creative.

> ✨ You might discover more functions you need or changes you want to make. And that's okay!

> 🤔❓ Can you see now how you might use objects, classes, functions to create a simple program of your own?

## 🌟 Dynamically allocated arrays - an array of zombies!

* Let's say you're roaming the world at night when all of a sudden, mobs start appearing. We don't know how many will spawn, how many will be left. Make a dynamically allocated array of zombies.

```cpp
// Dynamically allocate an array of zombies 
int numZombies = 5;
Zombie* zombies = new Zombie[numZombies];  // Uses Zombie pointers
```

* We can go through this zombies array like we're used to and use the member functions we made.

```cpp
for (int i = 0; i < numZombies; i++) {
  cout << "Zombie " << i + 1 << "'s health: " << zombies[i].getHealth() << endl;
  cout << "Is it a baby zombie?! " << boolalpha << zombies[i].isBaby() << endl;
  cout << endl;
}
```

## 😊 Overloaded operators

* We use == to check if basic values like ints and strings are equal. Wouldn't it be nice if we could use == like this?

```cpp
zombie1 == zombie2
```

* Well, you can! We can define what we consider two zombies to be equal. We will need to compare each zombie attribute to the other. If they are the same, we can conclude the zombies are equal.

```cpp
// Header file
bool operator==(const Zombie &other) const;

// Implementation file
bool Zombie::operator==(const Zombie &other) const {
  return (health == other.health && baby == other.baby);
}

// Calling in main.cpp
cout << "Is zombie1 equal to zombie2? " << (zombies[0] == zombies[1]) << endl;
```

> ✨ You can use this same process for other operators, like < and >, and << to print out custom statements.

```cpp
// Header file
friend std::ostream& operator<<(std::ostream &os, const Zombie& zombie);

// Implementation file
std::ostream& operator<<(std::ostream& os, const Zombie& zombie) {
  os << "RUUUHHHHH! Health is " << zombie.health;
  return os;
}
```

> ✨ The `friend` keyword is used to gain access to the private data members.