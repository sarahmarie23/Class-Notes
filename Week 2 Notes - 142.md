# Week 2 Lab

CSSSKL 142 - 4/5/24

## 🔑 Key Points 🔑

    1. Making a Project
    2. More advanced methods
    3. Scanner Class
    4. Math Class

## Concept: Learning by projects

You might have heard (and if you haven't, you will) that the best way to learn programming is by doing a project. But you might say to yourself, I don't know enough to make a project!

That's what I thought too. Throughout the next couple lessons, we will be working on a project that you can build upon, add to, and refine to make it your own.

## The Project: Number Guessing Game

* Me: Let's play a game. I'm thinking of a number between 1 and 50. What is your guess?
* You: *25*
* Me: Higher!
* You: *37*
* Me: Lower!
* You: *35*
* Me: Correct! It took you only 3 guesses.

## Making a Plan

> 🤝 The guessing game has some steps. With your table group, list them out in a text file.

1. Statement: "Guess a number between 1 and 50
2. Get the answer from the player
3. Check if the answer is higher, lower, or correct
4. The result is given to the player. 
5. If its higher or lower, player guesses again.
6. If the result is correct, display "Correct!" with the amount of guesses.

### Next Steps

* Create a new file, or Class called `GuessingGame.java`
* Copy paste your list into the `main` method 
#### ✔️Practice good file organization!

## Class vs Object vs Method?

Before we continue, it would be important to have some idea on what these concepts are. We don't formally learn about making classes and objects until the end of the quarter, but I believe it will help to have a basic understanding.

* 📝 **Class** is like a recipe. It tells you what to do, and can be reused many times.

* 📝 **Object** is like the cookies you bake with the recipe. You can make different batches and customize to your needs.

* 📝 **Method** is like the steps of the recipe. You might have different steps to follow with different parameters (flavors, batch size, etc.). Each step would be its own method.

## Making Methods

* Each component can be made into a method.

> ❓ Why should I make separate methods? Can't I just put everything in the main method?

* So far, the methods you've seen in this class have looked something like this

```java
public static void takeOneDown() {

}
```

✔️ Understand the components of the method header

⭐ Choose a meaningful name and use lowerCamelCase

⭐ Use a verb phrase, because methods do something

> 📝 **Parameters** - the list of variables your method expects. They go between the ()
>
> 📝 **Argument** - the actual values that are passed into the method when it is called

### Make a method from one of the steps from earlier

```java
public static void getPlayerGuess() {
        
}
```

## Working with Scanner

* In order to get the player's guess, we need a Scanner object.

```java
Scanner input = new Scanner(System.in);
```

* Use the `Scanner` **class** to *instantiate* a `Scanner` **object**

📝 Be sure you understand each component of the object

* Take a peek at the methods in the 📐 Math Class

⭐ Fun fact: because `Math` is a utility class, you don't need to *instantiate* an object to use its methods like you do for the `Scanner` class

> ❓ Consider: Should I put the Scanner in the main method or by getPlayerGues method?

⭐ Put it inside each method that needs it. This way, you can only use it when its needed, because you initialize it and then close it in that method. Its better to not have to pass in objects if you don't need to. Perhaps another method uses Scanner differently, this way you can customize it to that method's needs.

```java
public static void getPlayerGuess() {
    // Get the answer from the player
    Scanner input = new Scanner(System.in);
    int guess = input.nextInt();    
    System.out.println("You guessed " + guess);
    input.close();
}
```
### 🤝 As a table, complete the method header for `checkGuess`

> ❓ Do you see a problem here? Where do we get the number we are checking against? How do we get the information of the user's guess to that method?

* For now, since we haven't learned random numbers yet, we will make the number to guess as a hardcoded variable.

* Also, let's return the guess from the getPlayerGuess method, and pass playerGuess and numberToGuess into checkGuess

## 🏫 Scanner Class - other methods besides `nextInt()`

* Remember that we use the `Scanner` class to take in user input, so that we can do something with that data.

> 📝 `import java.util.Scanner;` add this at the very top of the file
>
> 📝 `Scanner theScannerName = new Scanner(System.in);` create a `Scanner` object
>
> 📝 `nextLine()` method to read in a `String` value
>
> 📝 `nextInt()` method to read in an `int` value
>
> 📝 `next()` method to read in a single chunk of input
>
> 📝 `close()` method to close the `Scanner`
>
>>⭐This ensures that the program can properly clean-up memory and use it for other tasks. It's like returning a borrowed book to the library when you're done so the next person can check it out.

> ❓ If I were to ask the player to enter their name so that it would read back "Welcome to the game, *name*!" which Scanner method should I use? Why?

⚠️ Be careful with `next()` vs `nextLine()`. `next()` only reads in a single chunk of text at a time (this is called *tokenization*). `nextLine()` will read in the entire line, including whitespace.



⚠️ How do you know if you should use `next()` or `nextLine()`?
> Use `next()` when
>* You are reading in input that is separated by spaces and you need to separate the parts into different variables.
>* You are reading in a single chunk
```java
Scanner input = new Scanner(System.in);

System.out.println("Enter your full name");
String fname = input.next();
String mname = input.next();
String lname = input.next();
System.out.println("Welcome to the game, " + fname + " " + mname + " " + lname + "!");
```
>
> Use `nextLine()` when
>* You are reading in input that contains spaces
>* You need to read in an entire line of data, not just a single word
```java
Scanner input = new Scanner(System.in);

System.out.println("Enter your full name");
String fullName = input.nextLine();

System.out.println("Welcome to the game, " + fullName + "!");
```

## 📐 Math Class 

* The Math class has many useful methods
* It comes with Java, so you don't need to import the library
* `Math.min(num1, num2)` returns the smaller number
* `Math.max(num1, num2)` returns the larger number
> Notice how `min(num1, num2)` looks like a method call because it is one!

## Bonus

⭐Float vs Double - how big can you go? Try it

```java
double bigDub = Double.MAX_VALUE;
float bigFloat = Float.MAX_VALUE;

System.out.println(Math.max(bigDub, bigFloat));
```

⭐Using `printf`
```java
String favFood = "Pizza";
System.out.printf("My favorite food is %s", favFood);

double total = 23.9089;
System.out.printf("Your total with tax is $%.2f", total);
``` 