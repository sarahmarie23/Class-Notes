# Week 10 Lab

CSSSKL 133 - 3/14/25

    1. Bitwise Operations
    2. Common bitwise tricks
    3. Using AND, OR, XOR, shifting 

## 🚶 The Six Bitwise Operators (aka bit operators)

✅ **&** AND (1 if both bits are 1)

✅ **|** OR (1 if one or both bits are 1)

✅ **^** XOR (1 if both bits are different)

✅ **~** NOT (inverts all of the bits)

✅ **<<** left shift (move bits to the left n places)

✅ **>>** right shift (move bits to the right n places)

> 🤔❓ What happens if we try to bitshift on a negative number? Or if we shift too far?

✨ The purpose of all this is so that you can precisely manipulate individual bits for low-level programming and working with hardware.

## Common Bitwise Tricks

### 🌟 Check if a number is even or odd

```c
  // Old way
if (i % 2 == 1) {
  printf("%d is odd\n", i);
} else {
  printf("%d is even\n", i);
}

// Bitwise way
if (i & 1) {
  printf("%d is odd\n", i);
} else {
  printf("%d is even\n", i);
}
```

* **Explanation** - AND the number with 1. If the LSB (least significant bit, rightmost bit) equals 1, then it's odd.

✨ **Bitwise XOR by 1 will *increase* the number by 1 if it is *even*, and *decrease* the value by 1 if it is *odd***. You could also use the number XOR 1, and see if the result is greater than or lesser than the original number.

### 🌟 Check if a number is a power of two (Leetcode #231)

```cpp
// Old way: keep dividing by 2
int powCheck = 54;
int toCheck = powCheck;
while (toCheck > 1) {
  if (toCheck % 2 != 0) {
    printf("%d is NOT a power of two\n", powCheck);
    break;
  }
  toCheck /= 2;
}
if (toCheck == 1) {
  printf("%d IS a power of two\n", powCheck);
}

// Bitwise way: Bit shift to count if each digit is 1; a power of two only has one bit set to 1.
int pwrOfTwo = 54;
toCheck = pwrOfTwo;

int count = 0;
while (toCheck > 0) {
  if (toCheck & 1) {
    count++;
  }
  toCheck = toCheck >> 1;
}

if (count == 1) {
  printf("%d is a power of two\n", pwrOfTwo);
} else {
  printf("%d is NOT a power of two\n", pwrOfTwo);
}
```

* **Explanation** - Numbers that are powers of two only have a single 1 (1000 is 8, for example) so count the amount of 1's by AND 1.
  
### 🌟 Swap numbers without using a temp value

```c

  // Old way: make a temp value
  int num1 = 17;
  int num2 = 24;
  printf("Before: %d, %d\n", num1, num2);
  
  int temp = num2;
  num2 = num1;
  num1 = temp;
  printf("Swapped: %d, %d\n", num1, num2);

  // Bitwise way: use XOR to swap
  printf("Before: %d, %d\n", num1, num2);
  if (num1 != num2) {
    num1 = num1 ^ num2;
    num2 = num1 ^ num2;
    num1 = num1 ^ num2;
  }

  printf("Swapped: %d, %d\n", num1, num2);
```

### 🌟 Get the LSB (least significant bit/rightmost bit)

* All you need to do is (num & 1).

* 1 & 1 returns 1. 0 & 1 returns 0. Therefore, you have your LS.B


### 🌟 Find the Single Number

* There are plenty of ways to do this using data structures in C++. In C, we can use XOR to eliminate pairs, because n ^ n returns 0.

✨ Just like how you can add up numbers in any order, the same holds true for XOR. `a ^ b ^ c` is the same as `c ^ b ^ a`.

```c
// Bitwise way: use XOR to cancel out duplicates
int dupes[] = {7, 3, 5, 3, 7};
int size = 5;

int result = 0;
for (int i = 0; i < size; i++) {
  result ^= dupes[i];
}

printf("The single number is: %d\n", result);
```
