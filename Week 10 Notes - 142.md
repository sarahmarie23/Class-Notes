# Week 10 Lab

CSSSKL 142 - 5/31/24

## 🔑 Key Points 🔑

    1. Static variables and methods
    2. Ragged Arrays
    3. File I/O
    4. CSS 143 Sneak Peek - Inheritance and more!

### FINAL REVIEW

## 🎁 Using `static` variables and methods

* `Static` means that the variable or method belongs to the class itself, and not an instance of the class (or object)
* Instead of using `object.methodName()` you'd use `Class.methodName()`

* Let's practice by making a `Chest` class

* We'll have the default chest be a small chest, but also make a constructor for a large chest.

```java
public class Chest {
    // Instance variables
    private int numberOfItems;
    private boolean isLargeChest;
    private String[][] itemsInChest;

    // Constructors
    public Chest() {
        this.numberOfItems = 0;
        this.isLargeChest = false;
        this.itemsInChest = new String[3][];
    }

    public Chest(Boolean isLargeChest) {
        this.numberOfItems = 0;
        this.isLargeChest = true;
        this.itemsInChest = new String[6][];
    }

    // Getters

    // Setters
    public void setNumberOfItems(int numberOfItems) {
        if (isLargeChest) {
            this.numberOfItems = Math.min(this.numberOfItems, 54);
        } else {
            this.numberOfItems = Math.min(this.numberOfItems, 27);
        }
    }
}
```

✅ I like to practice validating user input, so you can't put too many items in the chest, so I'm creating a check for that. The defaults are max 54 and 27 items, but I don't like using "magic numbers" in my code. This is the perfect opportunity for a **Static Variable**.

🤔 Can't I just make an instance variable for max capacity and update it if the size changes? Technically yes, but the max capacity has to do with the Chest class, not an individual chest. Every single chest object will have the same max capacity.

* Add them at the top

```java
// Static variables
public static final int SMALL_CHEST_CAPACITY = 27;
public static final int LARGE_CHEST_CAPACITY = 54;
```

* I'm choosing to use the `final` keyword because this number isn't going to change, so might as well make it so that it can't.

* Now I can access it like this, no getter needed because this is a class-level variable. We call it directly from the class without making an object from it.

```java
int max = Chest.LARGE_CHEST_CAPACITY;
```

## 🏹 Using Ragged Arrays

* We started out by setting our items arrays to be either 3 or 6 rows. But maybe we don't fill it up all the way, and therefore we need to fill in the items row by row

* My idea is to have the user type a string of items separated by spaces, take that and break it up into an array, and stick those in for the inner arrays. Assume the user is doing it correctly here! If I had more time, I'd validate for user input.

* Inside the driver code

```java
// Ragged arrays practice - fill it up
System.out.println("Fill up the chest row by row.");
System.out.println("Type the items, separated by a space.");
System.out.println("Press enter twice to finish.");

Scanner input = new Scanner(System.in);

int row = 0;
while (row < chest1.getRows()) {
    String line = input.nextLine();
    if (line.isEmpty()) {
        break;
    }
    String[] items = line.split(" ");
    chest1.addItemsToChest(row, items);
    row++;
}

// Print out the ragged array
chest1.printItemsInChest();
```

* Inside the `Chest` class:

```java
public void addItemsToChest(int row, String[] items) {
    itemsInChest[row] = items;
}

public void printItemsInChest() {
    for (int row = 0; row < itemsInChest.length; row++) {
        System.out.printf("Row %d: ", row);
        for (int col = 0; col < itemsInChest[row].length; col++) {
            System.out.print(itemsInChest[row][col] + " ");
        }
        System.out.println();
    }
}
```

> Assume all of the rows have something in them; otherwise check in the inner for loop that the array is not null

## 🌎 File I/O and more - Using a `World` class

Let's look at this `World` class and some things to note

1. I called the `initializeTerrain()` from within the constructor, and that's perfectly fine to call an instance method from within a constructor or even another instance method.

2. I used the `this` keyword in my constructors to make sure it was referring to the instance variables width, height, and not the arguments `width` and `height` passed in. If there's no question on which `width` you're referring to, technically you don't need to use `this`, but its best practice to do so.

3. Private method `initializeTerrain()`: This is a great example of where you should use a private method. It's called from within the class, and I don't want any World objects calling the method, so best to make it private.

>🤔 Should I make `initializeTerrain` static? Why or why not?

### File I/O - Saving to a file

Let's save the map to a txt file, and then upload it again. But first go over some terms:

**BufferedReader** - For when you need to read large files and/or read characters.

**Scanner** - For when you need to read in tokens of strings separated by spaces, commas, etc.

They both have different methods.
Scanner is easier to understand.

### Writing out to a text file - use PrintWriter and FileOutputStream

>🤔 When would you need to add `true` to the FileOutputStream? Hint: we used it when making the diary log.
```java
public void saveGrid(String filename) {
    try {
        PrintWriter writer = new PrintWriter(new FileOutputStream(filename)); // not adding "true" because we want to overwrite

        for (char[] row : grid) {
            for (char block : row) {
                writer.print(block);
            }
            writer.println();
        }
        System.out.println("Your game has been saved to " + filename);
        writer.close();
    } catch (IOException e) {
        System.out.println("File not found!");
        System.exit(0);
    }
}
```
### Reading in a file to 2D array - use Scanner

```java
public void loadGrid(String filename) {
    try {
        Scanner scanner = new Scanner(new File(filename));
        int row = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int col = 0; col < line.length(); col++) {
                grid[row][col] = line.charAt(col);
            }
            row++;
        }
        scanner.close(); // Don't forget!
    } catch (FileNotFoundException e) {
        System.out.println("File not found!");
        System.exit(0);
    }
    System.out.println("Your game is now loaded");
}
```

>🤔 How do you know when to use `IOException` or `FileNotFoundException`?

>🤔 You can catch the exceptions in the method signature, or in the try/catch block. Which is better? Try/catch block allows you to make a custom exception.

## 🧟 Inheritance - CSS 143 sneak peek

* The first few weeks of CSS 143 will talk about inheritance in detail, so let's talk a bit about it conceptually and why we should use it.

### Take a look at the classes Player, Creeper, Zombie, etc

* They all have a health variable. You can probably think of some other attributes that are common to multiple classes.

* Inheritance allows you to make one class that different entities can use, and add on to it to customize the child class.

* Be careful not to inherit too deeply and only use it if you really need to

### Method overriding

* Let's say we made a `HostileMob` class that `Zombie` and `Creeper` extended. They both have health, the both attack, they both take damage, they both have drops. They both inherited all those attributes and methods. But let's say their `attack()` method is different, because the Zombie simply hits the player, while the Creeper has to charge up first, if the player is close enough. Maybe the default `attack()` method was to deal 2 damage, but the Zombie's was different. The Zombie class would `@Override` the `attack()` method because it's not using the default version.
