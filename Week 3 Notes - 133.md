# Week 3 Lab

CSSSKL 133 - 1/24/25

    1. Inheritance - subclasses and parent classes
    2. Overriding Member Functions - using base and derived class functions
    3. Pure virtual functions and abstract base classes

## 🔗 Inheritance - A look back on the `Gear` class

* In CSSSKL 132 we came up with a `Gear` class that includes attributes and functions for things like armor and weapons.

* While they have similarities (type, health, strength, material), there are some important difference. Armor doesn't deal damage like weapons do. Weapons are used from the hotbar, whereas armor needs to be worn to be using it. This is where inheritance and polymorphism come in.

✨ Note: I added a new constructor to `Gear` that only takes a `type`for simplicity!

* Let's make an `Armor` class that inherits from `Gear`. `Armor` will have the attitional data member `slot` and the additional member function `printEquipMessage();`.

>🤔❓ What happens to the constructors? Do you need to make new ones? The derived class will use the parent class's constructors, but you can make your own additional constructors. Say I want to add a constructor that uses `Gear(std::string &type);` but additionally, sets the `Armor`'s `slot` property, so I can initialize it like this:

```cpp
Armor helmet("helmet", "head");
```

> Then I would need to add this constructor to `Armor`

```cpp
Armor(string type, string slot) : Gear(type), slot(slot) {}
```

>🤔❓ We're getting an error that we can't access `type`. This is because `type` is private inside `Gear`. We need to change its visibiilty to `protected`.

* Instantiate a piece of Gear and a piece of Armor

```cpp
// Instantiate a Gear object 
cout << "Default Gear; it takes damage" << endl;
Gear gear1;
gear1.takeDamage(3);

cout << endl;

// Instantiate an Armor object
cout << "Using derived class Armor to make a helmet and also take damage" << endl;
Armor helmet("helmet", "head");
helmet.printEquipMessage();
helmet.takeDamage(2); // helmet can use functions from Gear

/*
Default Gear; it takes damage
3 was taken to your diamond sword gear!

Using derived class Armor to make a helmet and also take damage
helmet was equipped to head
2 was taken to your diamond helmet gear!
Gear destructor called
Gear destructor called
*/
```

* And let's make a `Weapon` class while we're at it

```cpp
class Weapon : public Gear {
public:
  Weapon(string type, int hotbarIndex) 
    : Gear(type), hotbarIndex(hotbarIndex) {}

  void printEquipMessage() {
    cout << type << " was equipped to space " << hotbarIndex << endl;
  }

  int criticalAttack() {
    int damage = health;
    // 20% chance to make a criticalAttack
    if (rand() % 5 == 0) {  
      damage = health * strength;
      cout << "Critical attack! Dealing " << damage << " damage!";
    } else {
      cout << "Regular attack: " << damage << " dealt" << endl;
    } 
    return damage;
  } 

private:
  int hotbarIndex;
};

```

* We can see that both classes have the same function, `printEquipMessage()`, they are just different depending on the object.

* This is where **inheritance** comes in. We can make a base class `Gear` that other classes derive from it.

## ✂️ Refining `Gear` into an abstract base class

* We want to set up `Gear` into an **abstract base class** so any new classes that are `Gear` (think is-a versus has-a relationship) will need to implement the functions of `Gear`, and they can do so in their own customized way.

* We need to make `printEquipMessage()` virtual so when we call it using a Weapon or Armor, the compiler will know the correct version to use.

### Steps to follow

1. Make `Gear` (the parent/base class) abstract - Gear.h

* Add our new function.

✨ Any class that is derived from Gear MUST define its version of `printEquipMessage()`. This gives us a lot of flexibility, especially for unknown future classes!

```cpp
virtual void printEquipMessage() const = 0;
```

⚠️ Be aware that you can't instantiate objects from abstract classes. So you'll need to remove/comment out any Gear instances in main.

2. Make `Gear`'s destructor virtual - this will allow proper cleanup

```cpp
virtual ~Gear();
```

3. Add `override` to functions in the derived classes header file - this is best practice to indicate that they are overridden functions.

```cpp
void printEquipMessage() const override; // In header file
```

⚠️ You might run into an error when you instantiate an object that came from derived classes, and you pass in string literals. A string literal is just a "string in quotes". So if you're getting an error with

```cpp
Armor helmet("helmet", "head");
```

You need to pass strings as `const string&`. For example, your constructor would look like

```cpp
Armor(const string &type, const string &slot) 
  : Gear(type), slot(slot) {};
```

## ⚗️ Pure virtual functions vs virtual functions

* What we just did was an example of a **pure virtual function**. We declared a virtual function in a base class and set it to `= 0`.

✨ This means that any subclass MUST implement that function. But what if you want to make a default function that *has the option* to be overridden?

### 🤖 Use a virtual function

* In the base class, add `virtual` to the function name. In the base class, also implement the function.

```cpp
virtual int dealDamage() const;
```

```cpp
helmet.dealDamage(); // Calls Armor's version
helmet.Gear::dealDamage(); // Calls Gear's version
```

* Call the function like you normally do if you would like to use the derived class's function. Otherwise, add the class before the function call like the example above.
