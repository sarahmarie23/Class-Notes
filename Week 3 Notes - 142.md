# Week 3 Lab

CSSSKL 142 - 4/12/24

## 🔑 Key Points 🔑

    1. Industry terminology: Refactoring
    2. Random number generation
    3. if/else if/else block
    4. Switch statement

## Concept: Refactoring

**Refactoring** : Restructuring code without changing its original functionality
* It does the same thing, but could be faster, use less memory, or is simply more readable.

* Now that we have learned some new techniques this week, let's refactor last week's code, starting with setting the number to be guessed as a random number

## Random Number Generation for Number to Guess

```java
// Method that returns the number for the player to guess
public static int getComputerNumber() {
    int computer;
    Random random = new Random();
    // nextInt(50) would be 0-49
    computer = random.nextInt(50) + 1;

    return computer;
}
```

### Recap on Random Number Generation
>* 📝 Basic random int between [1 - n] (inclusive)
```java
int basic = random.nextInt(n) + 1;
```

* 📝 Random int between a low and high number (inclusive)

```java
int range = random.nextInt(high - low + 1) + low;
```

* 📝 Random double between [0.0, 1.0)

```java
double chance = random.nextDouble();
```

* 📝 Random double using Math.random [0.0, 1.0)

⭐ Perhaps you want something to happen 25% of the time

```java
if (chance <= 0.25) {
    System.out.println("You get a bonus!");
} else {
    System.out.println("Your score stays they same.");
}
```

😎 Real life example: modeling ant colony behavior

```java
// Ant.java class
// choose the next city, with a touch of randomness

    int selectedCity = -1; // INITIALIZE
    double randomValue = Math.random(); // don't need to make a Math.Random object!
    double accumulatedProbability = 0.0; 

    // Go through all the neighbors and get its probability
    int neighbor = getNeighbor();
    int probability = getProbability();

    accumulatedProbability += probability;

    if (randomValue <= accumulatedProbability) {
        selectedCity = neighbor;
    }

    // Ant goes to the selectedCity
```

* This is good for chance/percentages

* Note that I have left out code for simplicity!

### ❓ Can you see another refactoring opportunity?

> 🤝 Set the numbers to guess between (1 and 50) as variables and pass them to the `getComputerNumber()` method.

## Switch Statement: checkGuess Method?

* Using control structures, another foundational programming concept you will use all the time.

* Basic outline of a `switch` statement

❓ Tell me how a switch statement works, in your own words.

```java
    switch (expression) {
        case value1:
            // Code goes here
            break;
        case value2:
            // Code goes here
            break;

        // other cases

        default:
            // Always have some default value!
    }
```

> 🤝 Work with your table to code a `switch` statement for the checkGuess method

⚠️ You might not always be able to make a `switch` statement, but you can make an if/else if/ else block!

> ❓ What's a situation that would be good for a `switch` statement?

## if/else if/else: checkGuess Method

> 💻 Help me code an `if/else if/else` block for the checkGuess method

```java
public static String checkGuess(int user, int computer) {
    String result = "";
    
    if (user < computer) {
        result = "Guess higher!";
    } else if (user > computer) {
        result = "Guess lower!";
    } else {
        result = "Correct! You win";
    }

    return result;
}
```

### Check your understanding

❓ What do you think the output of this code will be?

```java
int num = 10;

if (num % 2 == 0) {
    System.out.println("num is even");
} else if (num < 100) {
    System.out.println("num is less than 100");
}
```

❓ How could you make it so that both statements print out?

❓ Can you put a return statement inside the blocks?