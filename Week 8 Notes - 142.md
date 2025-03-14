# Week 8 Lab

CSSSKL 142 - 2/128/25

## 🔑 Key Points 🔑

    1. Read a file into an array - Wordle
    2. 2D Arrays
    3. Ragged/Jagged arrays
    4. Array fun facts

### As you study and practice, some things to keep in mind

## 📦 Array vs ArrayList? - Make a table to compare them

✅ Arrays and ArrayLists are both data structures.

✅ They both hold a collection of the same type.

✅ They both are accessible by index.

✅ ArrayLists are **dynamic**. They can grow and shrink.

✅ You don't need to declare the size when you initialize ArrayLists.

✅ ArrayLists have their own set of methods [add(), remove(), size(), get(), indexOf()].

✅ Arrays use .length to get the length

✅ Arrays.sort(arrName), Arrays.toString(arrName)

✅ ArrayLists hold objects, while arrays can hold objects or primitives

## 🎲 Arrays - finishing up Wordle

* Here's our `readFileScanner` method from week 6:

```java
    public static void readFileScanner(File fileName) {
        Scanner input;
        try {
            input = new Scanner(fileName);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
```

* Let's refactor it so that it takes the file and puts the words into an array.

* Change the return type to `String[]` and we can use it for the game. Declare an array in the method.

❓ Problem: We need to declare an array with a size, but I don't know how many words there are. What are our options?

>✔️ Go through the file once and count the lines
>
>✔️ Use an ArrayList
>
>✔️ Set a size. If there are more lines than the set size, either exclude them from the array, or make a new array.

* Let's try the first method.

* In the main method, add in the array to save it to:

```java
String[] wordBank = readFileScanner(myFile);
```

* Completed `readFileScanner` method

```java
public static String[] readFileScanner(File fileName) {
        // Declare the array
        // Get the number of words on the list
        int wordCount = getWordCount(fileName);
        String[] words = new String[wordCount];

        // Return an empty array if getWordCount returns 0
        if (wordCount == 0) {
            return words;
        }
        
        // Now continue filling the array with the words
        // Try this first and fail:
        //Scanner input = new Scanner(fileName);        
        Scanner input;
        String currString;
        
        try {
            input = new Scanner(fileName);
            int index = 0;

            while (input.hasNextLine()) {
                currString = input.nextLine();
                words[index] = input.nextLine();
                index++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return words;
    }
}
```

* Write a helper function to keep the code organized and uncluttered.

```cpp
public static int getWordCount(File fileName) {
    int wordCount = 0;
    Scanner input;
    String currString;

    try {
        input = new Scanner(fileName);
        while (input.hasNext()) {
            currString = input.next();
            wordCount++;
        }    
        input.close();
    } catch (FileNotFoundException e) {
        System.out.println("File not found! Exiting game.");
    } 
    System.out.println("There were " + wordCount + " words in the file!");
    return wordCount;
}
```    

### And now we can use it to get a random word

```java
Random rand = new Random();
String secretWord = wordBank[rand.nextInt(3264)];
```

* You could have also used an `ArrayList`

```java
public static ArrayList<String> readBufferedReaderAndArrayList(String file) {
    ArrayList<String> myList = new ArrayList<>();

    try {
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        
        String line = br.readLine();
        while (line != null) {
            myList.add(line);
            line = br.readLine();
        }
        br.close();
    } catch (IOException e) {
        System.out.println("There was an IOException");
    }

    return myList;
}
```

```java
// Get the secret word simply without using a method
String secretWord = wordBank[random.nextInt(3264)]; 
```

```java
String secretWord = wordsAL.get(rand.nextInt(3264));
```

## 🏠 2D arrays

* An array holds a group of elements, ordered by index. But what if we wanted to hold a group of *arrays*? Now we would have a 2D array. And yes, you can nest them even further.

### Common Examples - Why use 2D arrays?

    1. Matrix operations
    2. Displaying a game grid (tic-tac-toe, chess, battleship)
    3. Displaying a 2D map or image (top-down video game, screen pixels)
    4. Traversing a maze

### Initializing 2D arrays

* **Method 1**: With elements declared

    ```java
    String[][] playlists = {
        {"s1", "s2", "s3"},
        {"s4", "s5", "s6"},
    };
    ```

* **Method 2**: Without elements

    ```
    String[][] playlists = new String[2][3];
    ```
* The first value in `String[2][3]` refers to the number of **rows**, or number of arrays.
* The second value refers to the number of **columns**, or number of elements in each array.
* In this example, we have 2 sets of playlists with 3 songs in each.


### Connection to for loops

* When we studied double nested for loops, like for drawing ascii art, we talked about how the outside loop goes row-by-row and the inside loop goes char-by-char.
* When you are going through a 2D array, you also use a double nested for loop. The outer loop goes row-by-row, while the inner goes column by column.

    ```java
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(array[i][j]);
            }
        }
    ```
✅ How do you figure out what value to use for `rows` and `columns`?
* With a regular array, you use `arrayName.length`.
* To get the number of rows for the outer loop, think "How many arrays are in this array?" So you can just use `arrayName.length`  
* The inner loop is a little different. You need to know how many elements are in each array. So you need to get the length of a single array. You can do this by `arrayName[0].length`



## ⛰️ Ragged/Jagged 2D array

* An array of arrays, where the inner arrays (rows) can be different lengths

* Example: Make an array that consists of each word in the hangman game as a char array

```java
public static void arrayOfCharArrays(String[] wordBank, char[][] wordsToChars) {
    int i = 0;
    for (String s : wordBank) {
        wordsToChars[i] = s.toCharArray();
        i++;
    }
}
```

### Printing a 2D array

* First, do it the hard way

```java
public static void print2DArray(char[][] arrayToPrint) {
    for (int row = 0; row < arrayToPrint.length; row++) {
        System.out.print("Array number " + row + ": ");
        for (int col = 0; col < arrayToPrint[row].length; col++) {
            System.out.print(arrayToPrint[row][col] + " ");
        }
        System.out.println();
    }
}
```

* You can use `for each` loops to make it easier if you're just printing and not modifying

```java
for (char[] arr : arrayToPrint) {
    for (char c : arr) {
        System.out.print(c);
    }
    System.out.println();
}
```

## 🚀 Array fun facts
* Arrays in Java are passed ***by reference***. This means that you can pass an array into a method, change it, and you don't have to return it back for the changes to be saved!

```java
public class ArrayReferenceExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        
        // Before modification
        System.out.println("Before modification:");
        printArray(array);
        
        // Modifying the array inside a method
        modifyArray(array);
        
        // After modification
        System.out.println("\nAfter modification:");
        printArray(array);
    }
    
    // Method to modify the array
    public static void modifyArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2; // Doubling each element
        }
    }
    
    // Method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```

📝 **By default, int elements are initialized to 0**

📝 **By default, String elements are initialized to `null`**

📝 **By default, boolean elements are initialized to `false`**

* `String[] args` is a 1D array!

```java
public static void main(String[] args) {...}
```

* We use an IDE to run Java programs, but you can run a program from the command line and pass in *arguemnts* for args, and the main method can access those arguments like you would in an array anywhere else. `args[0]` for example would get you the first argument passed in.