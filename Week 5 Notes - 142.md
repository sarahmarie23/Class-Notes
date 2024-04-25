# Week 5 Lab

CSSSKL 142 - 4/26/24

## 🔑 Key Points 🔑

    1. Starting a new project 
    2. While loops
    3. Do while loops
    4. Validating user input
    5. Bonus: Intro to string methods
 

## 📝 New project: Hangman

* The purpose of learning by making projects is that you learn how to make something that works together, practice troubleshooting on something more than random problems, and it makes it more fun.

* For the number guessing game, we started out from scratch so you could get practice with the project planning process. To save time, I've worked that out, on `notes.txt`. Some things to note:

1. **I did this before I even started coding anything.** I thought about the components that would be required for a game of hangman.

2. **I did a little pseudocode.** There are no rules to pseudocode, but I indented the gameplay loop. Notice that I used `while` and `if`? That's a good hint that you might want to use a while loop and if statement.

3. **Consider what's absolutely needed**, and what's "nice to have". Perhaps its not necessary to display the number of chances left, but you can't play the game if you don't display blanks on the screen.

4. **The plan will change** as you work out the components.

### 🧰 Check out the starter code 🛠️

* I've written an output (at the bottom) of what I expect the final project to look like. This will help me with testing; did the code produce the expected results?

## 🍪 My project planning process 🍪

1. **Write the outline of the program, without code.**
2. **Consider the methods.** Methods are the actions of things that need to be done. Just do the headers, leave them empty.
3. **Consider the variables.** What values do you need? Strings? Summing something with an int?

#### These will change over time!

### I've done the method to explain the rules and getting the secret word. We can start out with a hardcoded word first, make sure it works, and THEN do the `getSecretWord` method. 

## ✅ Validating user input

* It would be nice to have a way if the user types the wrong thing, they could enter again, instead of the code crashing.

* Midterm story

### Start with getUserGuess

* How would you typically get a user guess?

```java
public static String getUserGuess(Scanner input) {
    // TODO week 6
    String s = "";
    
    System.out.println("Guess a single letter: ");
    s = input.next();
        
    return s;
}
```

* It works, but what if the user entered a # ? Or a longer word?

* Let's fix it so that it checks for those things

## ➿ Do-While Loops

* This is the perfect opportunity for a **`do-while loop`**. We need to do something at least once, and then keep doing it if we get the wrong input!

1. Put what we have so far in the `do` block
2. Condition: While its not a single letter. So length must be no more than 1, and it has to be an alphabetic character.

## ⚙️Introduction to String methods

**`s.length()`** - gives you the length of the string (you might have used this before)

**`Character.isLetter(char)`** - unfortunately Java does not have a convenient String method to check if it's made of letters or not. We can check one character at a time though.

**`s.charAt(0)`** - gets the character at a specific string index. So we check if the character is a letter at the first index.

* ⭐ One more thing to change. Since we are dealing with single letters we should use chars. Interestingly enough, there's no Scanner method to get a char like there is for int and double. We can return a char by using the `charAt()` method 

#### Final version
```java
public static char getUserGuess(Scanner input) {
    // TODO week 6
    String s = "";
    do {
        System.out.println("Guess a single letter: ");
        s = input.next().toLowerCase();
        
    } while (!(Character.isLetter(s.charAt(0))) || s.length() > 1);

    return s.charAt(0);
}
```

### Test it! Make sure it works for all situations!

## 🔁 While loops

### Look at the notes...does the gameplay part look like a while loop to you?

* Let's get this loop started. We won't have it all completed but at least we can start putting what we have in place.

```
while the word hasn't been guessed OR max moves made
```

* The first part, while the word hasn't been guessed yet, sounds like we need to check if the current guesses is equal to the word.

* To keep track of the current guesses, an array would be really useful! We will learn about this later.

* For now, we can use the method `checkIfWordGuessed` and fill in the details later

```java
// while the word hasn't been guessed 
// OR max moves made
while (checkIfWordGuessed(secretWord, null) || mistakesMade < 6) {
    char guess = getUserGuess(input);
}
```