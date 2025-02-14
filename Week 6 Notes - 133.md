# Week 6 - Recursion

CSSSKL 133 - 2/14/25

    1. Finding a Base Case
    2. Divide and Conquer
    3. Backtracking

## 🏠 Finding a Base Case

* To solve any recursion problems, it is essential to establish a **base case**. This will make sure your function has a terminating condition and won't have infinite recursion.

* It can be helpful to think about some real-life examples of recursion, like you did for your prelab this week. And we'll practice again with another example.

* 📌 Problem: Consider the scene where someone is holding a flower, plucking it's petals one at a time. They alternate saying the the phrases "He loves me" and "He loves me not".

> 🤔❓ What would be the base case here?

* Write a function that takes in the number of petals and recursively calls itself to state the phrase

```cpp
// In main
int numPetals = 3;
pluckPetal(numPetals); 

void pluckPetal(int petals) {
  if (petals == 0) { 
    cout << "No petals left!";
    return;
  }
  
  if (petals % 2 == 1) {
    cout << "He loves me..." << endl;
  } else {
    cout << "He loves me not..." << endl;
  }

  pluckPetal(petals - 1);
}
```

## 🔪 Divide and Conquer

* Sometimes you can split a problem in half and tackle each half individually. Each half can then be further split in half until you get one part left, and can perform a calculation or whatever needs to be done.

> 🤔❓Any real life examples? Slicing a loaf of bread (cut in half, then in half again, until you have an individual slice).

* 📌 Problem: You have a chocolate bar and want to split it up into pieces for everyone. You could break off one square at a time, but you'd like to speed things up. So you split it in half, and give each half to your friends, so they can keep splitting until everyone has a piece. 

```cpp
// In main
int numPieces = 20;
splitChocolate(numPieces);

void splitChocolate(int pieces) {
  if (pieces == 1) { 
    cout << "The last piece!" << endl;
    return;
  }

  int half = pieces / 2;
  cout << "Splitting " << pieces << " pieces into " << half << " and " << pieces - half << endl;
  cout << endl;

  splitChocolate(half);
  splitChocolate(pieces - half);
}
```

✨ What are some signs that you could use divide and conquer?

* The problem can be broken into smaller versions of itself.
* Each smaller version can be solved independently.
* You can combine the solutions of the smaller problems to get the final answer.
* A brute force solution would be too slow.
* Sorting, searching, or optimization is involved.

## 👣 Backtracking

* Backtracking is another recursive technique where you solve a problem one piece at a time, until you find the correct solution.

* Search every possible combination until you find what you're looking for.

> 🤔❓Any real life examples? Games like chess, sudoku

**There are three types of problems in backtracking:**

* Decision Problem – In this, we search for a feasible solution.
* Optimization Problem – In this, we search for the best solution.
* Enumeration Problem – In this, we find all feasible solutions.

✨ What are some signs that you could use backtracking?

* You need to explore all possible combinations or configurations.
* The problem involves satisfying constraints or rules.
* You need to find all solutions, not just one.
* The problem requires sequential decisions that depend on previous choices.

* 📌 Problem: You are buying a bouquet and get to choose 3 different flowers for the bouquet. What are the different combinations of flowers you can choose from?

```cpp
// In main; also inclue a constant for the max flowers in the bouquet (3)
vector<string> availableFlowers = { "Rose", "Tulip", "Daffodil", "Lily", "Orchid" };
vector<string> bouquet;

bouquetCombinations(bouquet, availableFlowers);


void bouquetCombinations(vector<string> currBouquet, vector<string> remainingFlowers) { 
  if (currBouquet.size() == MAX_FLOWERS_IN_BOUQUET) { // Base case: Bouquet full
  
    for (int i = 0; i < currBouquet.size(); i++) {
        cout << currBouquet.at(i) << "  ";
    }
    cout << endl;

  } else { // Recursive case: Add one flower to the bouquet
    for (unsigned int i = 0; i < remainingFlowers.size(); ++i) {
      string tmpFlower = remainingFlowers.at(i);
      remainingFlowers.erase(remainingFlowers.begin() + i); // Remove flower from list
      currBouquet.push_back(tmpFlower); // Add to bouquet

      // Recursively pick the next flower
      bouquetCombinations(currBouquet, remainingFlowers);

      // Backtrack: Restore the flower to the list and remove from bouquet
      remainingFlowers.insert(remainingFlowers.begin() + i, tmpFlower);
      currBouquet.pop_back();
    }
  }
}
```