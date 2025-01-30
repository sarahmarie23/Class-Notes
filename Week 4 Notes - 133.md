# Week 4 - Tips and Tricks you can use with Data Structures

CSSSKL 133 - 1/31/25

    1. Use map to store the frequency of items in an object
    2. How to use iterators with map and list
    3. Use a set to find duplicates
    4. Use pair to insert into a map

## 🗺️ Use `map` the frequency of items in an object

* One popular use case for `map` is to count the frequency of items in a vector (or any other object).

* The keys store the elements and the values store the counts.

💻 Find the quantity of each size tshirt needed

>🤔❓ Testing edge cases - What if we check a size that doesn't exist?

```cpp
  vector<string> sizes = {
    "S", "M", "L", "M", "XL", "S", "M", "XS", "L", "XL",
    "M", "S", "XS", "XL", "M", "XL", "XS", "S", "L", "M"
  };

  map<string, int> counts;
  for (string s : sizes) {
    counts[s]++;
  }
  
  // Will go over a better way soon
  cout << "XS: " << counts.at("XS") << endl;
  cout << "S: " << counts.at("S") << endl;
  cout << "M: " << counts.at("M") << endl;
  cout << "L: " << counts.at("L") << endl;
  cout << "XL: " << counts.at("XL") << endl;
  // cout << "XXL: " << counts.at("XXL") << endl; Error!
```

✨ `count()` won't work if the element isn't in the map!

## 🔗 How to use iterators with `map` and `list` - a better method

### ✅ Using iterators with `map`

* Use an `iterator` to start from the beginning, keep going while it hasn't reached the end

```cpp
map<string, int>::iterator it; // Make sure you have :: 
for (it = counts.begin(); it != counts.end(); ++it) {
  cout << it->first << ": " << it->second << endl;
}
```

>🤔❓ They print in alphabetical order. Any way to fix this?

>🤔❓ Why `++it` and not `it++`? Because it is faster and the conventional way to do it.

✨ Consider other data structures. Read the documentation for other ideas!

* I have pasted a solution inside today's notes.

### ✅ Using iterators with `list`

* Reuse the same `sizes` vector from earlier.

✨ `insert` inserts the elements before the target element.

* 💻 Use an `iterator` to insert "XXS" and "XXL" in their correct places

```cpp
list<string>::iterator it3 = vectorToList.begin();
while (*it3 != "XS") { // Get up to the spot right before the location you want
  ++it3;
} 
vectorToList.insert(it3, "XXS");

it3 = vectorToList.begin(); // Bring iterator back to the beginning
while (it3 != vectorToList.end() && *it3 != "XL") {  // Make sure its not at the end first!!
  ++it3;
} 

if (it3 != vectorToList.end()) {
  vectorToList.insert(next(it3),"XXL"); // Need to move it one over
  //vectorToList.push_back("XXL"); // Can also use push_back
} 

```

⚠️ If you try to insert something at the end like you did for XXS, it won't work unless you check that the iterator is not at the end before using `insert()`.

## 🍽️ Use a `set` to find duplicates

>🤔❓ How might you have done this using a vector? Possibly by sorting and walking through the vector.

* Sets are convenient because they will get rid of any duplicate values as you insert them into the set.

>🤔❓ Ideas on how we can use this to figure out which values are duplicates?

* Idea 1: Add values one at a time, first checking if they are already in the set. If they are, add them to a vector/set/list (depending on your use case) containing all the duplicate values.

```c++
vector<int> hasDuplicates = {3, 10, 2, 5, 4, 5, 2, 2, 2, 0};
set<int> uniqueNums;
set<int> duplicatedNums;

for (int i : hasDuplicates) {
  if (uniqueNums.count(i) > 0) { // Can also do uniqueNums.count(i) because count() on a set returns 1 or 0
    duplicatedNums.insert(i);
  } else {
    uniqueNums.insert(i);
  }
}
```

✨ Can also do `uniqueNums.count(i)` because `count()` on a set returns 1 or 0.

✨ If you don't care about keeping track of the dupicates, you can just turn the vector into a set.

## 🥓 Use `pair` to insert into a `map`

* You can easily keep track of pairs of items using `pair`. And its easy to store and retrieve them with `map`

⚠️ I used the method below, a vector with the items and another with codes to make an inventory list app. I had an off-by-one error and it messed everything up! That's why using a map, and pairs in particular, can be an effective solution.

```cpp
vector<string> items = {"Avocado", "Banana", "Onion", "Potato", "Tomato"};
vector<int> codes = {4046, 4011, 4068, 4730, 4664};

map<string, int> produce;
for (int i = 0; i < items.size(); i++) {
  produce.insert(make_pair(items[i], codes[i]));
  //produce.emplace(items[i], codes[i]); // Alternative version
}
```

* So many ways to print these out!

```cpp
cout << "Use const auto to print out items to codes" << endl;
for (const auto& entry : produce) {
  cout << entry.first << ": " << entry.second << endl; 
}

cout << "Use [key, value] to print" << endl;
for (const auto& [key, value] : produce) {
  cout << key << ": " << value << endl;    
}

cout << "Use iterator to print" << endl;
for (auto it = produce.begin(); it != produce.end(); ++it) {
  cout << it->first << ": " << it->second << endl;
}
```
