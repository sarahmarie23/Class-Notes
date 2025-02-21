# Week 7 Lab

CSSSKL 142 - 2/21/25

## 🔑 Key Points 🔑

    1. String methods 
    2. Array introduction
    3. StringBuilder

### 🚀 Today's goal

> **To become familiar some string methods and apply them to the Wordle game we've been working on.**

## 🛠️ String methods

* Strings are objects in Java, and they come with useful methods. We've worked with `Scanner` objects that use the `nextLine()` or `next()` methods. We have used `Random` objects that have the `nextInt()` method. These methods are built in, and the String class comes with several built-in methods.

* String methods sometimes go hand-in-hand with arrays, so we'll talk about some of both this week and next week.

### 🧰 Tools to keep on hand 🛠️

>
> ✅ **1. equals()**
>
>* ⭐ Use: Check if two strings are equal to each other

```java
String str1 = "Hello";
String str2 = "World";
str1.equals(str2); // returns false
```
>
> ✅ **2. substring()**
>
>* ⭐ Use: Returns a portion of a string. The first number is the starting index (inclusive) and the second number is the end index (exclusive).
>* ⚠️ It won't work if the index is out of bounds. It will throw an exception (error).
>* 👉 If you use one parameter, it returns the substring from that index to the end of the string.

```java
String myString = "Hello World";
String sub = myString.substring(1, 5); // returns "ello"
String sub2 = myString.substring(6); // returns "World"
```
>
> ✅ **3. charAt()**
>
>* ⭐ Use: Returns the char at a specific index
>* ⚠️ It won't work if the index is out of bounds. It will throw an exception (error).

```java 
String myString = "Hello World";
myString.charAt(4); // Returns 'o' 
```
>
> ✅ **4. indexOf()/lastIndexOf()**
>
>* ⭐ Use: Get the first/last index of a character in a string
>* 👉 You can even check the index of a substring
>* 👉 You can even check the index of a substring starting from a given index
>* 👉 Returns -1 if the character/substring isn't in the string

```java
String myString = "Hello World";
System.out.println(myString.indexOf("llo")); // Returns 2
System.out.println(myString.lastIndexOf('o')); // Returns 7
System.out.println(myString.indexOf('o', 5)); // Returns 7
System.out.println(myString.indexOf('o', 8)); // Returns -1
```
>
> ✅ **5. toUpperCase()/toLowerCase()**
>
>* ⭐ Use: Changes a string to all capitals or all lowercase

```java
String myString = "Hello World";
myString = myString.toUpperCase(); // Returns "HELLO WORLD"
```
>
> ✅ **6. trim()**
>
>* ⭐ Use: Remove whitespaces at the beginning or end of a string

```java
String myString = "   Hello World   ";
myString = myString.trim(); // Returns myString = "Hello World"
```

## 🧩 checkGuess() Method improvements

### Introducing StringBuilder

* We learned that strings are immutable. When we use += to add onto a string, we're actually creating a new string.

* **StringBuilder** is a class we can utilize for when we want to add on to a string. Let's use that for building up the result in `checkGuess()`.

```java
StringBuilder result = new StringBuilder("");

// don't forget to return a string!
return result.toString();
```

### Introducing Arrays

* Our algorithm doesn't work when there are duplicate letters in a word. As a test, I guessed the word "aaaaa" when the word was "apple". The result was "a****" meaning it got the first 'a' correct but it said the rest of my a's were in the wrong spot.

* We want to make sure that my guess of "aaaaa" only counts one a.

⭐ We can do this with an array. Recall that an array holds a fixed amount of a specific element, and can be modified.

🛠️ One trick I use when I need to keep counts of letters is to use an int array of size 26, so that index 0 = A, index 1 = B, and so on. Just increase the index by 1 when you encounter that letter.

```java
int[] letterCounts = new int[26];

// Count the letters in the secretWord
for (char c : secretWord.toCharArray()) {
    letterCounts[c - 'a']++;
}
```

⚠️❓ Do you see a potential problem here? What happens if the user writes capital letters? Let's fix our code so that we only need to deal with lowercase letters.

```java
// Add this in where we take in user input
guess = input.nextLine().toLowerCase();
```

⭐ You can 'subtract' letters because chars can also be represented as numbers. Just like the boolean 'true' can be represented as 1, the letter 'a' can be represented as 97.

* We need a way to first check if any letters are in the correct spot, and decrease the counts for those letters. Then on the next pass, we can check if the letter exists in the word (we made an array to help us out with that!) and we can check if that spot was already correctly found.

⭐ We'll use a second array, boolean this time.

```java
boolean[] correctPositions = new boolean[secretWord.length()];
```

* Complete `checkGuess()` method

```java
public static String checkGuess(String guess, String secretWord) {
    StringBuilder result = new StringBuilder("");
    int[] letterCounts = new int[26]; // Counts for each letter
    boolean[] correctPositions = new boolean[secretWord.length()]; // Tracks correctly placed letters
    
    // Count the letters in the secretWord
    for (char c : secretWord.toCharArray()) {
        letterCounts[c - 'a']++;
    }
    
    // First check for any letters in the correct position. Reduce those counts
    for (int i = 0; i < secretWord.length(); i++) {
        char guessedChar = guess.charAt(i);
        char correctChar = secretWord.charAt(i);

        if (guessedChar == correctChar) { // its correct
            result.append(guessedChar); // Add the letter to the result
            correctPositions[i] = true; // Mark the position as correct
            letterCounts[guessedChar - 'a']--;
        } else {
            result.append("_"); // Just a placeholder
        }
    }
    
    // Then go through and take care of the letters in the wrong position
    for (int i = 0; i < secretWord.length(); i++) {
        char guessedChar = guess.charAt(i);
        // If the current position is false (incorrect position) AND we have that letter available in letterCounts
        if (!correctPositions[i] && letterCounts[guessedChar - 'a'] > 0) {// correct letter, wrong spot
            result.setCharAt(i, '*');
            letterCounts[guessedChar - 'a']--;
        } 
    }

    return result.toString();
}
```

