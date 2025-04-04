# Week 1 Lab

CSSSKL 142 - 4/4/25

    1. BlueJ Installation and File Organization
    2. Print Statements
    3. Simple Methods
    4. Fixing Syntax Errors

## 🚀 BlueJ Installation and File Organization

* Download link can be found [here](https://www.bluej.org/) bluej.org. Use the recommended settings.

### Staying organized

* Make it easy to locate and manage all your documents
* Create a new folder on your computer to store all your CSSSKL 142 projects and assignments. I recommend making a folder for each week inside this CSSSKL 142 folder.

> On my PC, I have UWB > Spring 2025 > CSSSKL 142 > Week 1. You can nest folders so that files aren't all lumped into one folder.

> ⚠️ If you download a file/photo/video on a phone or tablet, it automatically puts it in the right folder. But for a computer, we need to organize it ourselves.

### Steps for starting a new project

1. In your CSSSKL 142 folder, create a folder for Week 1
2. Open BlueJ
3. At the top, select Project > New Project
4. Under Location, select the folder for CSSSKL 142 > Week 1
5. If you download any starter code or lab assignments, move it from your Downloads folder to the correct location!

> ✨ Start a new BlueJ project **before** you add java files. This will make it easier to manage!

### Adding downloaded files to your project

* When you download a file from Canvas, it most likely goes to a `Downloads` file on your computer.

> ⚠️ **It is important to move or copy this file to the correct folder so you don't lose it!**

* You can click and drag, right click and choose copy, and then paste it to the correct folder.

> ✨ Practice by downloading the file called `Buggy.java` and placing it in your Week 1 folder in BlueJ.

### When you are in the project
1. Click `New Class...`
2. Give it a name (in CamelCase!) ex. MyProject
3. Make sure `Java` and `Class` are selected

### Suggestions and Options

* Clear the prefilled text and start from a blank page
    > ✨ This will help you learn the basic setup, which looks like this:

```java
public class YourClassName {
    public static void main(String[] args) {
        // code goes here

    }
}
```

* Under preferences > Editor, you can turn on or off Scope Highlighting (the colored blocks around the code)
    > ✨ This might be helpful for keeping track of your code's structure, especially when starting out
* Check 'Display line numbers'
* In the terminal window, check 'Clear screen at method call' in the Options tab, so the output erases each time you run your code
* To fix formatting: **ctrl-shift-I**

## 🌎 Print Statements

* ✅ Create a "Hello World!" print statement on your laptop.

> 📝 `println` will move to a new line after the String is printed.
>
> 📝 `print` will print the next String right next to it.

### Input
```java
System.out.println("Hello World!");
System.out.print("One Pumpkin Spice Latte, please ");
System.out.print("with whipped cream");
```

### Output
```
Hello World!
One Pumpkin Spice Latte, please with whipped cream
```

## 🧩 Simple Methods

> ✅ A Method is a block of code that performs a specific task or function.

* 📝 Create a method that prints out information for printing out a customer and their coffee order.

### Possible solution

```java
public static void orderMessage() {
    String customerName = "Sarah";
    String coffeeType = "caramel macchiatto";
    int shots = 5;
    System.out.println(customerName + ", your " + shot + " shot " + coffeeType + " is ready! " + customerName + "!!");
}
```

## 🛠️ Fixing Syntax Errors ##

### My tips and strategies

1. **Comment out all but the beginning** and uncomment section by section until you encounter a syntax error.

    > 📝 `//` to comment out a single line.
    >
    > 📝 `/*` *[code goes here]* `*/` to comment out multiple lines.
    >
    > 🔷 In BlueJ, hightlight lines of code and click F8 to comment it out and F7 to uncomment. If you don't like those buttons, you can change them under Options > Key Bindings...

2. **Fix errors at the top first**; sometimes, this will fix errors later in the code.

3. **Read the error messages**. It shows what line numbers to look at. Sometimes it tells you exactly what you need to do.

4. **Read your code line by line** and simulate what's happening on paper or a whiteboard. Is it doing what you wanted it to do?

### Common Syntax Errors

    ⚠️ Missing semicolon
    ⚠️ Mismatched quotes " ", brackets { }, parentheses ( ); missing a single quote or bracket
    ⚠️ Using ' ' instead of " "
    ⚠️ Spelling mistakes
    ⚠️ Variable was not declared
    ⚠️ You commented something out and forgot to uncomment it

* 📝 Look at Part 1 from the lab assignment. In your groups, find all the bugs so that it displays the proper output.
