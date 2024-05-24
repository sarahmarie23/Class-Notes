# Week 9 Lab - Objects and Classes Part I

CSSSKL 142 - 5/24/24

## 🔑 Steps for Class Creation 🔑

    1. Plan out your class
    2. Create instance variables
    3. Create constructors
    4. Create methods (including accessors and mutators)
    5. Test with an object

## 🔥 Terminology: Things you need to know

✔️ **Class** - A blueprint or template used for creating objects

✔️ **Object** - An instance of a class

✔️ **Instance variable** - a variable that is declaraed in a class and has data for each object created from the class

✔️ **Public** - accessible anywhere in the code

✔️ **Private** - only accessible within the class

✔️ **Constructor** - a special method that is called to initialize an object

✔️ **`this`** - refers to the instance variables and methods of the object

✔️ **Accessor** - access the value of an instance variable

✔️ **Mutator** - change the value of an instance variable

✔️ **Static** - method or variable that belongs to the class, not the object

# ✨ Setting up a Class: step-by-step ✨

## Step 1: Plan out your class ✏️

* Before we get into a lecture, or any coding I'd like us to think about a real-life example, and we will see how it relates to objects and classes. Let's think about the game Minecraft. Have you played before, or are at least familiar with the basics?

* Fun fact: Minecraft was coded in Java!

*play a quick gameplay clip* https://www.youtube.com/shorts/Io_I6o5UFzQ  

* What sort of elements did you see in the game (or you have experienced)?

> Examples could be: character, weapons, item bar, mobs, biomes, blocks, zombies

* Each one of these things can be expressed as a Class.

📝 **Class** - A blueprint or template used for creating objects\
📝 **Object** - An instance of a class

📖🍪 analogy. The recipe is the class. It doesn't give you the cookies. You have to create the cookie object, by using the recipe class.

* Let's take one of the things we wrote here, and create a class out of it (zombies for this example)

```
📝 Let's brainstorm all the things associated with zombies.
You're a programmer. What things would you need to encode to make the zombies in the game?
```

> Examples could be: health, attack damage, baby or adult, has armor

## Step 2: Create instance variables 🧱

* Start the file

* "I'm not going to put a main method here because typically its not done that way."

* Now that we have the attributes of a zombie, we will set these as zombie attributes, called **instance variables**

**Instance variable** - a variable that is declaraed in a class and has data for each object created from the class

* Now, lets add in the instance variables
* You don't need to initialize the variables right here, just declare it. You'll see why in a bit.

```
🤔 Ask: Why am I writing **private** and not **public**???
```

📝 **Public** - accessible anywhere in the code\
📝 **Private** - only accessible within the class

```
🤔 Ask: Why am I setting these variables to private? So that the rest of the code can't access it. Easier to debug.
```

* Now we need to make a constructor

## Step 3: Create constructors 🏗️

**Constructor** - a special method that is called to initialize an object

* Let's first start with a default constructor. It doesn't take any parameters, and sets the object to the default values that you specify.

* You do this by using the keyword `this`. Do this for each instance variable you have.
* `this` - refers to the instance variables and methods of the object

⚠️ This kind of looks like a method, but missing some stuff. I'll explain.
```
🤔 Why don't you put static? Because static means that the method belongs to the class itself, not to a particular object.
Like every time you write a method in your labs, that method belongs to that class.

🤔 Why don't you put a return type? Because you are creating the object, not actually returning anything.
```


* NEXT we want to define methods accessors and mutators (getters and setters)

## Step 4: Create accessors 🔍 and mutators 🛠️

**Accessor** - access the value of an instance variable

* First do getters. This is needed so that your zombie object and get access to these private attributes

**Mutator** - change the value of an instance variable

* Next do mutators. They don't return anything, but they make changes.

* Examples for mutators: takeDamage

## Step 5: Test with an object 🕹️

* Now let's create a zombie object!

* If time, show how to make a constructor that takes arguments

### Basic Zombie class
```java
public class Zombie {
    // Instance variables
    private int health;
    private int attackDamage;
    private String zombieType;
    private boolean hasArmor;
    
    // Default constructor
    public Zombie() {
        this.health = 10;
        this.attackDamage = 5;
        this.zombieType = "Adult";
        this.hasArmor = false;
        System.out.println("A zombie has spawned!");
    }
    
    // Accessors
    public int getHealth() {
        return health;
    }
    
    public String getZombieType() {
        return zombieType;
    }
    
    // Mutators
    public void takeDamage(int damageAmount) {
        health -= damageAmount;
        System.out.println("Zombie's health is now " + health);
        
        if (health <= 0) {
            System.out.println("You killed the zombie!");
        }
    } 
}
```

## Class to demonstrate object creation

```java
public class Play {
    public static void main(String[] args) {
        // Make a zombie
        Zombie zombie = new Zombie();
        
        // See the zombie's health
        System.out.println("Zombie health: " + zombie.getHealth());
        
        // Zombie takes a hit
        zombie.takeDamage(3);
        
        // Zombie dies
        zombie.takeDamage(10);
    }
}
```

### Best Practices

    1. Use meaningful names and capitalize the words in a Class
    2. Keep the main method in a separate file
    3. Use Private when possible