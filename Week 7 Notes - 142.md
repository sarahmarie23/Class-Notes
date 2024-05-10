# Week 7 Lab

CSSSKL 142 - 5/10/24

## 🔑 Key Points 🔑

    1. String methods 
    2. Array introduction
    3. Debugging

### 🚀 Today's goal

> **To become familiar some string methods and apply them to the hangman game we've been working on.**

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

## 🧩 Hangman Methods

### Introducing the `char[] status` array

* I needed a way to keep track of the status of the guessed letters, so I could compare it to the secret word. An array made the most sense for this. Let's initialize this array and update it when the letters are correctly guessed. 

📝 Sketch a visalization of an array and understand how to index it

❓ What are the similarities and differences between a char array and a string?

```java
char[] status = new char[secretWord.length()];
```

* This is one way to initialize an array, we will go more in depth next week.

* I thought, if I could just fill it with _ and update it to the guessed letter, that would make it easy to use for checking.

* There is a convenient method for filling an array with something:

```java
Arrays.fill(status, '_');
```

### ✔️ **checkIfWordGuessed Method**

* We use a while loop to continuously check if the word is guessed. Let's compare the secret word to the status, and see if they have the same characters.

### 🛠️ String Method #1: `String.equals()`

* You can't compare strings in Java with ==, so we use `String.equals()`

* `status` is an array, can we convert it to a string?

### 🛠️ String Method #2: `String.valueOf()`

```java
char[] arr = {'a', 'b', 'c'};
String arrToStr = String.valueOf(arr);
```

Using them together

```java
public static boolean checkIfWordGuessed(String secretWord, char[] status) {
    if (secretWord.equals(String.valueOf(status))) {
        return true;
    }
    return false;
}
```

### ✔️ **checkLetterGuess Method**

* I mentioned earlier the array would be easy to update as the user made their guesses. Let's work a method that takes the guesses and updates the status. I'll initialize a boolean in main so that we can tell the user if their guess was correct or not

```java
boolean isGuessCorrect = checkLetterGuess(guess, secretWord, status);
```

* Make a for loop to compare each character of the secretWord to the guess. At the same time, we can update status if we have a match.

### 🛠️ String Method #3: `String.charAt()`

* Works nicely when you want to check character by character with a for loop

```java
public static boolean checkLetterGuess(char guess, String secretWord, char[] status) {
    // see if the letter is in the secret word
    int count = 0;
    for (int i = 0; i < secretWord.length(); i++) {
        if (guess == secretWord.charAt(i)) {
            status[i] = guess;
            count++;
        }
    }
    if (count != 0) { 
        return true;
    }
    return false;
}
```

❓ Looking a bit ahead: I passed in the array, but I didn't return it. Will it keep the changes we made? Why or why not? (spoiler alert: we didn't pass the actual array, we just passed a reference to it!)

### ✔️ **displayStatus Method**

* We need some output so we know what the guesses look like so far. We could use a for loop...OR we could use a for-each loop. You can easily iterate through an array with a for-each loop.

```java
public static void displayStatus(char[] status) {
    // print with a space between letters for legibility
    for (char c : status) {
        System.out.print(c + " ");
    }
    System.out.println();
}
```

⚠️ Remember that you can't make changes to the array when going through it with a for each loop. Also, you need to start at the beginning of the array.

### Test it out and see what happens

* Test a winning and losing condition. It works for losing but not winning. Work it out together. Revisit the logic in the while loop. We need to update this to make it correct.

```java
while(!checkIfWordGuessed(secretWord, status) && mistakesMade < 6)
```

## 🧩 Java String problem techniques

* Having the tools is great, but it would be nice to know some techniques that will improve your problem-solving skills

### 🌟 Going through each character of a string

* Using a for loop and `charAt()`

```java
String myString = "Hello World";

for (int i = 0; i < myString.length(); i++) {
    System.out.println(myString.charAt(i)); // Iterates over each character
}
```

* Using a for each loop and `toCharArray()`

```java
String myString = "Hello World";

for(char c : myString.toCharArray()) {
    System.out.println(c); // Iterates over each character
}
```

### 🪓 Splitting a string into an array

* Our class hasn't done arrays yet, but we will next week
* You can split by any sequence, doesn't have to be a single space

```java
String snacks  = "juice, ice cream, chips, bananas";
String[] shopping = snacks.split(", ");
// Returns an array of ["juice", "ice cream", "chips", "bananas"]
```

>* 👉 Notice how if I split by ", " instead of " " it will keep 'ice cream' together as one string.

### 🧱 StringBuilder

* Instead of concatenating strings together with '+', use a `StringBuilder` as a convenient way to keep adding on to a string
* 🌟`StringBuilder` is more efficient than concatenating strings because it doesn't initialize a new string every time a string is added on.

```java
StringBuilder fullName = new StringBuilder();
String first = "Holly";
String middle = "the";
String last = "Husky";

fullName.append(first);
fullName.append(" ").append(middle);
fullName.append(" ").append(last);
fullName.append(" is the UW mascot");

System.out.println(fullName.toString());
```

>* 👉 Notice that you need to convert it to a string to be able to print it out.
>* 👉 Notice that you can chain multiple methods together!
