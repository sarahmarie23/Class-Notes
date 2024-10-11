# Week 3 Lab

CSSSKL 132 - 10/11/24

    1. ASCII and cool things you can do with it
    2. Logical and comparison operators
    3. if/else if/else statements
    4. switch statements

## 🔥 All about ASCII

* ASCII stands for American Standard Code for Information Interchange.

* Started in the 1960s to standardize encoding characters so computers could communicate. Computers understand 0s and 1s but we use words. They needed a way for information to be displayed and transmitted that was uniform among all systems and programmers.

  > ✨ [asciitable.com](http://asciitable.com) lists all the ASCII values from 0-255
  
  > ✨ Why 255? Because 255 in binary is 1111 1111, and 256 would be 1 0000 0000, which is 9 bits instead of 8 bits. 8 bits = 1 byte.

* 📝 Important ASCII values (if you forget, Google it OR just print it out!)
  * `a` = 97
  * `A` = 65
  * `a - A` = 97-65 = 32
  * Print out lowercase to uppercase: `(char) (lowerCase - 32)`
  * Note: `lowerCase` could start as an int or char

* Knowing how to use ASCII values is an extra tool you can use to help you solve problems.

### rand() and chars

* Since chars can be used like numbers (added and subtracted) why not use it with random and get a random letter?

💻 Example: Make a Caesar Cipher for a random set of initials

* A Caesar Cipher decodes letters by shifting them over 3 letters. A becomes D, B becomes E, etc.

```c++
  srand(time(0));
  
  char firstInitial = 'a' + (rand() % 26);
  char middleInitial = 'a' + (rand() % 26);
  char lastInitial = 'a' + (rand() % 26);
  
  printf("Your random initials: %c.%c.%c.\n", firstInitial, middleInitial, lastInitial);

  firstInitial += 3; // Could produce an incorrect result! 
  middleInitial += 3;
  lastInitial += 3;

  printf("After Caesar Cipher: %c.%c.%c.\n", firstInitial, middleInitial, lastInitial);
```

* There are two ways you could handle the shifting: if/else if or conditional operator (aka ternary statement).

```c++
  if (firstInitial > 119) {
    firstInitial -= 23;
  } else {
    firstInitial += 3;
  }
  
  middleInitial > 119 ? middleInitial -= 23 : middleInitial += 3;
```

## 📌 Logical and comparison operators

* Let's check out the tools and then practice using them

> 🔨 `&&` logical AND. Both items being compared must be true/1.
>
> 🔨 `||` logical OR. Only one item needs to be true for the expression to return true
>
> 🔨 `!` logical NOT. Returns the opposite `true` or `false`. Good use for a flag (more on that later).

* Note that it's *not* comparing if the two are equal. So this doesn't work on strings. If you're trying to compare ints, its checking if its 0 or not, with anything other than 0 evaluating to true.

💻 Example: Our activity recommender based on the weather example from the prelab.  
```cpp
bool isSunny = true;
bool isRaining = false;
bool isCloudy = true;

cout << (isSunny && isRaining) << endl; // prints 0
cout << (isSunny || isRaining) << endl; // prints 1
cout << !isCloudy <<endl; // prints 0
```

> ✨ Use `boolalpha` to see true or false instead of 1 or 0. Example: `cout << boolalpha << !isCloudy;` prints false

> ✨ Put it in once and it will work for the rest of the code: `cout << boolalpha;`

🤔❓ Can you check more than two? Example: `(isSunny && isRaining || isCloudy)`

## ☔ if / else if /  else statements

* Used to execute code only if a specific condition is met (aka evaluates to true). You may have tried this in lab 2, for example, if the customer ordered a small then they were charged $5, and if they ordered a large they were charged $10;

💻 Try it: Let's make some if / else if / else statements using the variables we defined.

```cpp
  if (isSunny) {
    cout<<"You should go to the beach" << endl;
    if (isCloudy) {
      cout << "But also bring a jacket" << endl;
    }
  } 
```

* You can use an if by itself and even nest it.

* Adding an else if, and an else

```cpp
  if (isSunny) {
    cout<<"You should go to the beach" << endl;
    if (isCloudy) {
      cout << "But also bring a jacket" << endl;
    }
  } else if (isRaining) {
    cout << "Bring an umbrella" << endl;
  } else {
    cout << "You should go hiking" << endl;
  }
```

## 🔀 switch statement

* A switch is similar to an if/else if/else, but its a little more restrictive because we can't use a boolean statement.

🤔❓ Why can't we use the if / else if / else that we just made, as a switch statement?

* We are limited to ints and chars!

* Example: Perhaps we know the activity, and need to know what items to bring.

```c++
  cout << "Choose an activity: " << endl; 
  cout << "a. Hiking\nb. Go to museum\nc. Watch a movie\nd. Go shopping" << endl;
  string input;
  getline(cin, input);
  
  char activity = input[0]; // Get the first letter in case they don't listen
  
  switch (activity) {
    case 'a':
      cout << "Bring water and snacks" << endl;
      break;
    case 'b':
      cout << "Wear comfortable shoes" << endl;
      break;
    case 'c':
      cout << "Be sure to buy popcorn" << endl;
      break;
    case 'd':
      cout << "Bring money" << endl;
      break;
    default:
      cout << "Stay home, you didn't pick a valid activity!";
  }
```

🤔❓ Can you put an if statement *inside* of a switch? Perhaps in one of the case statements.
