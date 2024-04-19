# Week 4 Lab

CSSSKL 142 - 4/19/24

## 🔑 Key Points 🔑

    1. For loops (1D)
    2. For loops (2D)
    3. Random Number Generator review

## 🔁 For Loops (1D)

* For loops are a tool you can use to perform action a repeated amount of times. 
* They are good when you know exactly how many times the task needs to be repeated.
* For loops have 3 parts (refer to ICA as example)

> 📝 ***initialization expression*** - Initializes a variable (only once). Choose an `int` like `int i = 0;` (Start)
>
> 📝 ***boolean expression*** - The loop will continue until this expression evaluates to `false` (Stop)
>
> 📝 ***update expression*** - Updates the initialization value (Step)



Now we'll try together (goal: problem solving using a for loop)
* ✅ Problem: Bottles of beer song from Lab 1
* ✅ Which parts are being repeated? These are perfect for a loop.
* ✅ Write a method that takes in the starting amount of bottles, but uses a for loop to reduce repetition.

Let's write the loop together
> * ✅ **Initialization expression**: However many bottles of beer we are starting with
> * ✅ **Boolean expression**: Stop when we get no more bottles
> * ✅ **Update expression**: Remove 1 bottle each round

### New method with a loop start
```java
public static void newSong(int numBottles) {
    for(int i = numBottles; i > 0; i--) {

    }
}
```

> * ✅ Now lets copy paste the methods inside this loop
> * ✅ Notice how we can call other methods from this method? It's just like calling other methods from the main method
> * ✅ Instead of `numBottles`, we are using `i`, the value we initialized in the for loop.

### Input

```java
public static void newSong(int numBottles) {
    for(int i = numBottles; i > 0; i--) {
        System.out.print(i);
        onWall();
        System.out.print(i);
        botBeer();
        takeOneDown();
        System.out.print(i-1);
        onWall();
        System.out.println(); 
    }
}
```
### Output
```
5 bottles of beer on the wall
5 bottles of beer
Take one down and pass it around
4 bottles of beer on the wall

4 bottles of beer on the wall
4 bottles of beer
Take one down and pass it around
3 bottles of beer on the wall

3 bottles of beer on the wall
3 bottles of beer
Take one down and pass it around
2 bottles of beer on the wall

2 bottles of beer on the wall
2 bottles of beer
Take one down and pass it around
1 bottles of beer on the wall

1 bottles of beer on the wall
1 bottles of beer
Take one down and pass it around
0 bottles of beer on the wall
```
### Analysis
> * ✅ Looks good until you get to "2 bottles of beer" because that's when the verse changes
> * ✅ Instead of `takeOneDown()`, a custom String is used.
> * ✅ This is the perfect place for an `if` statement
> * ✅ You'll also need an `if` statement for the `onWall()` vs `oneOnWall()` methods

```java
public static void newSong(int numBottles) {
    for(int i = numBottles; i > 0; i--) {
        System.out.print(i);
        onWall();
        System.out.print(i);
        botBeer();

        if(i == 2) {
            System.out.println("If one should happen to fall");
        } else {
            takeOneDown();
        }
        System.out.print(i-1);

        if(i == 2) {
            oneOnWall();
        } else {
            onWall();
        }
        
        System.out.println(); 
    }
}
```

```
5 bottles of beer on the wall
5 bottles of beer
Take one down and pass it around
4 bottles of beer on the wall

4 bottles of beer on the wall
4 bottles of beer
Take one down and pass it around
3 bottles of beer on the wall

3 bottles of beer on the wall
3 bottles of beer
Take one down and pass it around
2 bottles of beer on the wall

2 bottles of beer on the wall
2 bottles of beer
If one should happen to fall
1 bottle of beer on the wall

1 bottles of beer on the wall
1 bottles of beer
Take one down and pass it around
0 bottles of beer on the wall
```

### Now we just need to accomodate for the last verse

> * ✅ Let's make a separate method, and call it from our new method

```java
public static void lastVerse() {
    System.out.print("1 ");
    oneOnWall();
    System.out.print("1 ");
    System.out.println(" bottle of beer");
    System.out.println("Take it down and pass it around");
    System.out.println("no more bottles of beer on the wall");
}
```

```
...
3 bottles of beer on the wall
3 bottles of beer
Take one down and pass it around
2 bottles of beer on the wall

2 bottles of beer on the wall
2 bottles of beer
If one should happen to fall
1 bottle of beer on the wall
1  bottle of beer on the wall
1  bottle of beer
Take it down and pass it around
no more bottles of beer on the wall

1 bottles of beer on the wall
1 bottles of beer
Take one down and pass it around
0 bottles of beer on the wall
```

### Watch out for 'off-by-one' errors

*  This happens when your loop doesn't start or stop when you want it to
* You also might need to make other adjustments like adding in the extra space after the `oneOnWall()` method

```java
for(int i = numBottles; i > 1; i--) {
    System.out.print(i);
    onWall();
    System.out.print(i);
    botBeer();

    if(i == 2) {
        System.out.println("If one should happen to fall");
    } else {
        takeOneDown();
    }
    System.out.print(i-1);

    if(i == 2) {
        oneOnWall();
        System.out.println(); 
        lastVerse();
    } else {
        onWall();
    }
    
    System.out.println(); 
}
```
* You could clean up the `if statements` if you like

## ♾️ Killing an Infinite Loop
**ctrl + w** to close the output **then click the arrow** to end 

## 🔁📦For Loops (2D)

* You can nest loops inside of each other

### Before

```java
for(int i = 0; i < 5; i++) {
    System.out.print(" <3 ");
}
```

### Output

```
 <3  <3  <3  <3  <3 
```

### After

```java
for(int j = 0; j < 10; j++) {
    for(int i = 0; i < 5; i++) {
        System.out.print(" <3 ");
    }
    System.out.println();
}
```

### Output

```
 <3  <3  <3  <3  <3 
 <3  <3  <3  <3  <3 
 <3  <3  <3  <3  <3 
 <3  <3  <3  <3  <3 
 <3  <3  <3  <3  <3 
 <3  <3  <3  <3  <3 
 <3  <3  <3  <3  <3 
 <3  <3  <3  <3  <3 
 <3  <3  <3  <3  <3 
 <3  <3  <3  <3  <3 
```

## Review Random number generator

Use this import
```java
import java.util.Random;
```

Also create an instance of the Random class (like you do for Scanner)
```java
Random rand = new Random();
```

To generate a random number between 0 and n-1
```java
int num1 = rand.nextInt(5); // between 0-4
```

Generate within a range
```java
int max = 10;
int min = 5;
int num2 = rand.nextInt(max - min + 1) + min; 
```

## Getting close to finishing the number guessing game

This week's topic is for loops, and next week's will be while loops. What do we have left to finish?

* It only gives them 1 chance to guess the number

❓ A `while` loop would be a good choice to handle this. Why?

For the purposes of this class, let's change the rules of the game so that they must guess the number in 5 tries. If they don't guess it in time, the game ends and the person loses!

* Need a loop that runs 5 times

❓ Should I start i at 1? 0?

💻 Print a for loop around the content in `main`
```java
for (int i = 1; i <= 5; i++) {
    setGuessRange(); // Renamed this
    int userGuess = guessNum();
    checkGuess(userGuess, computer);
}
```

## Practicing Debugging Skills

Looks like we get an error

```
Exception in thread "main" java.util.NoSuchElementException      
        at java.base/java.util.Scanner.throwFor(Scanner.java:937)
        at java.base/java.util.Scanner.next(Scanner.java:1594)   
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at GuessingGameWeek3.guessNum(GuessingGameWeek3.java:53)
        at GuessingGameWeek3.main(GuessingGameWeek3.java:25)
```

How do we make sense of this?
* It tells you the line that the error is happening (line 25 and 53) 

✅ Tip 1: Try adding a print statement in the loop to see what's happening

```java
System.out.println("loop " + i);
```

I usually write `loop` and the index so I can see what iteration I'm on.

We see loop 1 seems to work. Loop 2 starts but the scanner doesn't take the next int. Something might be up with scanner.

❓ Any guesses? Has anyone gotten this error before?

⭐ Yes it might take some time trying to find the error!

⭐ Ask your friends if they got the same error.

* **The more you practice, the more you will get used to things like this.**

#### Fixing the problem - might have to Google or ask for help

* Refactor the code so that `scanner` is only open and closed once.

Move this to main

```java
Scanner userInput  = new Scanner(System.in);
// code with the for loop
userInput.close();
```

Change the method header

```java
public static int guessNum(Scanner userInput)
```

## Break statement: What if we guess before 5?

* You can use a `break` statement to leave the loop early.

* if the `checkGuess` method returns with "You win!" we can stop the game

💻 Refactor `checkGuess` to return a String instead of void
```java
public static String checkGuess(int user, int computer) {
    String message = "";
    if (user < computer) {
        message = "Guess higher!";
    } else if (user > computer) {
        message = "Guess lower!";
    } else  {
        message = "You win!";
    }
    
    return message;
}
```

#### Sneak peak to string methods - a Word of Caution

❓ Have you tried to use `(string1 == string2)` ?

⚠️ If you want to check if two strings are equal, use `equals()` method

⚠️ You might not get the answer you were looking for!

* When I say equal, I mean the same charaters. "Hello!" is equal to "Hello!"

* Yes, I know it might work sometimes but not always. Letting you know now to save some frustration!