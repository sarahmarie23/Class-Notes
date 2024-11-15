# Week 8 Lab

CSSSKL 132 - 11/15/24

## 🔑 Key Points 🔑

    1. Classes and planning
    2. Abstraction
    3. Terminology

* Remember back to week 1 when I explained classes and objects, that classes are used to make objects, much like a recipe is used to bake cookies? At the time, that was all you needed to know. But now, we're making our own recipes, and making our own cookies.

* Later we will learn how to make recipes to make an entire meal (combine classes to make a larger program).

## 🏢 All about Classes - My Steps

* An architect makes blueprints, but they don't just start drawing out a building. It needs to be planned out so that all of the components will be compatible and it won't fall apart. Likewise, we will write a Class (blueprint) but we will plan it out first.

### 🎮 Today's scenario: Refactoring the Lab 5 assignment with the game inventory manager into a class so that it can be used with other classes in a bigger project 🎮

## ✨ Setting up a Class: step-by-step ✨

### Step 1: Plan out your class ✏️

* A class consists of **data members** and **member functions**. Data members are attributes of the class. We already used them when writing structs. They can be primitives like ints, data structures like Vectors, or user-defined types.

> 🤔❓ Do you see anything in the code that can be used as a data member for an `Inventory` class? Or other attributes that aren't covered but might be helpful?

```cpp
armor: array
items: vector
```

📝 Write out a class diagram. The name goes in the top box, data members in the middle, and functions on the bottom.

> 🤔❓ Functions: What member functions should an `Inventory` class have? Hint: each case in the `switch` block could be made into a function.

```cpp
addArmorItem()
addInventoryItem()
printInventory()
```

### Step 2: Start writing out the class 🧱

```cpp
class Inventory {
  public:

  private:


}; // Don't forget the ;
```

* Write this above the main function. Next week we will split it into multiple files.

> 🤔❓ What is the difference between public and private? Take a guess. Let's see how it works.
```cpp
class Inventory {
  public: 
    int myNum = 20;
  
  private:
    int cantGet = 3;
};

int main() {
  Inventory inv;
  cout << inv.myNum << endl;
  cout << inv.cantGet << endl; // Won't work

  return 0;
}
```

📝 **Public** - accessible anywhere in the code

📝 **Private** - only accessible within the class

* Consider if the attributes should be public or private. It's better to make it private whenever possible, so the information can't be directly accessed by other files.

> What we have so far

```cpp
class Inventory {
  public:
    void addArmorItem();
    void addInventoryItem();
    void printInventory();
  
  private:
    string armor[4];
    vector<string> items;
};
```

### Step 3: Bring in the Member Functions

* While you could place the functions in the class declaration, I like to keep them separate. Ideally in a separate file, but this week I will keep everything to one file.

* Copy and paste the code, writing a file like we normally would. Go through line by line and make modifications so that it does what you want it to.

> ✨ In order to test it out, we'll need to create an object in the main function, and call the function.

    `error: ‘armor’ was not declared in this scope`

That's because you need to remember to add `Inventory::` to the function signature

```cpp
void Inventory::addArmorItem()
```

* This is valid, but there's a better way. Let's demonstrate with the next function by using a **helper function**.

* They are used to **encapsulate** information from the user. The user needs to know about the function for adding items, but they don't need access to all the implementation details.

* Start by copy pasting the next function, `addInventoryItem()`

> 🤔❓ It would be best if `addInventoryItem()` just did that one task: adding an inventory item. Why? Because then it could be reused for other purposes. Maybe another character has a different method of choosing the item, but every player will need a way to add items to the Inventory.

> ✨ **Be sure to make this function private!** The less that other files can access, the better.

### We want addInventoryItem() to ONLY add an item to the inventory, not have to deal with getting the user input. How?

1. Move the logic for getting the user input to the helper method.
2. In order to get the `inventory_item`, pass it by reference to `addInventoryHelper()`.
3. Add the function declaration to the `Inventory` class

```cpp 
void addInventoryHelper(string &inventory_item)
```

4. Don't forget to call `addInventoryHelper()` from `addInventoryItem()`!

4. In main, the object still calls `addInventoryItem()`, but now `addInventoryItem()` calls `addInventoryHelper()` to get more information.

✨ Note: It's okay if we leave the `cout` dialog in, but in a larger project, consider moving the dialog to a different class.

### Let's do one more function together: `printInventory()`

* Copy and paste into the function. Do you think it's going to work?

> 🤔❓ I thought `armor[]` was private. How are we able to get the size? It's because everything private is accessible to anything within the `Inventory` class, so we're good here.

This will not work though!

```cpp
cout << myInventory.armor[0];
```

### ✨ Making an improvement: const

* It's preferred not to have any **magic numbers**. The size of the armor array, 4, isn't going to change. Something we can do to improve this code is to set the size of 4 as a constant. We'll make it **globally accessible**.

```cpp
const int ARMOR_SIZE = 4;
```

* Now in main, you can call this with no problem.

```cpp
cout << ARMOR_SIZE;
```

* While we're at it, let's add a `const` to `printInventory()`. This is because it's only getting information (the printed out inventory) and it's not changing anything;

## 🙋 Getters and setters

* **Getters (Accessors)** - Used to get information. They often have `get` in their name like `getInventorysize()`. They return information back to wherever it's being called. You can add `const` to the function signature because you're not actually changing anything. They can have parameters, but they don't have to.

In main: Getting the armor item at a specific index.


```cpp
string Inventory::getArmorAtSlot(int slot) {
  return armor[slot];
}
```

In the function:

```cpp
string Inventory::getArmorAtSlot(int slot) {
  return armor[slot];
}
```

* **Setters (Mutators)** - Used to modify data members. They usually have parameter(s) that reflect the data member that is being modified or set.

* In main: Setting the armor item at a specific index

```cpp
myInventory.setArmor("pants", 1);
```

* In the function

```cpp
void Inventory::setArmor(string gear, int index) {
  armor[index] = gear;
}
```
