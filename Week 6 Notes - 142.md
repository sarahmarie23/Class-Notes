# Week 6 Lab

CSSSKL 142 - 5/3/24

## 🔑 Key Points 🔑

    1. File I/O tools
    2. Reading and writing text files
    3. Try/catch

## 📝 File I/O

* There are multiple ways to accomplish reading and writing to files in Java. I will show you the methods used in the lab assignment and how I choose to do file I/O. While you may use your preferred methods, please refer to your CSS 142 professor if they have specific methods you'll need to use on their homework.

### 🧰 Tools to keep on hand 🛠️

> ✅ **1. Scanner**
>
>* ⭐ Use: To take in input, can be from the user or a File
>* ⭐ Good for: Tokenized data, like CSV files; ints and doubles
>* ⭐ Parameter: `System.in` for user input or a `File` for text file
>
> ✅ **2. BufferedReader**
>
>* ⭐ Use: To take in character input
>* ⭐ Good for: Large files, reading lines at a time
>* ⭐ Parameter: `FileReader` to read in a file
>
> ✅ **3. PrintWriter**
>
>* ⭐ Use: To write to a new file **or** overwrite an existing file
>* ⭐ Parameter: If you just want a new file, then a file name, such as "MyFile.txt". Otherwise, use  `FileOutputStream`
>
> ✅ **4. File**
>
>* ⭐ Use: Establishing the file path of a file
>* ⭐ `File myFile = new File(fileName);`
>
> ✅ **5. FileReader**
>
>* ⭐ Use: Used for reading in character data from a file
>* ⭐ `FileReader reader = new FileReader(fileName)`
>
> ✅ **6. FileOutputStream**
>
>* ⭐ Use: For writing to a file, using bytes
>* ⭐ Parameters: A file name, such as "MyFile.txt", and boolean
>* ⭐ `FileOutputStream fos = new FileOutputStream(myFile, true);`
>* ⭐ Use `true` to append to a file; `false` or blank will overwrite
>

### Hangman Game: `readFile` method and `saveResultsToFile` method

1. `readFile`: Reads a text file of words and prints it to the screen. Later we will save it to an array for better functionality.
2. `readFileBufferedReader`: Same as `readFile`, but uses `BufferedReader`.
3. `saveResultsToFile`: Saves the results of each game to a text file, without overwriting the data.

### 1. readFile using 👀 `Scanner` and `File` 📁

* I passed the `File` in to the method in order to make sure `readFile` only needs to deal with reading the file. It's one less thing that could make debugging harder if the method wasn't working.

* Also, if I wanted to use the file somewhere else, I could.

* Use a try-catch block. In file I/O we use it to try to read in the file and catch an error in case the file does not exist.

  👉 This way you can handle the error instead of having the code crash.

* Use a `while` loop with the `Scanner.hasNextLine()` method

    ❓ Couldn't I use `Scanner.hasNext()`?

```java
try {
    Scanner fileInput = new Scanner(filename);

    while (fileInput.hasNextLine()) {
        String line = fileInput.nextLine();
        System.out.println(line);
    }
    fileInput.close(); // Don't forget to close!
} catch (FileNotFoundException e) {
    System.out.println("File not found or could not be opened");
}
```

### 2. readFileBufferedReader using 💪 `BufferedReader` and `FileReader` 🗄️

* You can accomplish the same task with various objects.

* BufferedReader uses the `readLine()` method. If you do it similar to `Scanner`, you might notice something odd.

```java
while (buffRead.readLine() != null) {
    String line = buffRead.readLine();
    System.out.println(line);
}
```

* To take care of the `null` at the end:

```java
try {
    FileReader brWords = new FileReader(filename);
    BufferedReader buffRead = new BufferedReader(brWords);

    String line = buffRead.readLine();
    while (line != null) {
        System.out.println(line);
        line = buffRead.readLine();
    }
    buffRead.close();
} catch (IOException e) {
    System.out.println("File not found or could not be opened");
}
```

### 3. saveResultsToFile using ✍️ `Printwriter` and `FileOutputStream` 🏞️

* `FileOutputStream` takes in a file name, and `true` if you don't want it to overwrite the file.

* We need to initialize the `PrintWriter` outside the try block (there are other ways but right now we are doing it this way).

```java
PrintWriter writer = null;

try {
    writer = new PrintWriter(new FileOutputStream(fileName, true));

    writer.println("The word to guess was: " + secretWord);
    // other text to write

    writer.close();
} catch (FileNotFoundException e) {
    System.out.println("File not found or could not be opened");
}
```

## 🕸️ Try/Catch

* The purpose of the try/catch block is to catch errors so that you can do something about it if an error happens.
* You can prevent the program from crashing.
* Think of `try/catch` like an `if/else`. If the condition in the `if` statement is met, we proceed with what's in the block.
If not, we move onto the `else`.
* In `try/catch`, we try to do what's in the `try`, and if an exception, or error occurs, you can print an error message or call some other code.

## 🌟 Bonus: Max and Min

* Use `Double.MAX_VALUE` to keep track of the min value, instead of 0.0. `Double.MIN_VALUE` is used for the max value.

```java
public class MinMaxExample {
    public static void main(String[] args) {
        double min = Double.MAX_VALUE; // initialize to Double.MAX_VALEUE;
        double max = Double.MIN_VALUE; // initialize to Double.MIN_VALIUE;
        double[] temps = {10.0, 15.0, 20.0, 18.0, 12.0};
        
        for (double temp : temps) {
            System.out.println("current temp: " + temp);
            System.out.println("current min: " + min);
            System.out.println("current max: " + max);
            
            if (temp < min) { // Check for min
                min = temp;
                System.out.println("new min: " + min);
            }
            if (temp > max) { // Check for max
                max = temp;
                System.out.println("new max: " + max);
            }
            System.out.println();
        }
        System.out.println("Minimum temperature: " + min);
        System.out.println("Maximum temperature: " + max);
    }
}
```
