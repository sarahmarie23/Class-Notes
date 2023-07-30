# Array Indexing in Java

CSS XXX - Section X.X - 7/31/23

## Key Points

    1. Explain array indexing
    2. Code examples
    3. Debugging
    4. Pros and cons
    5. Conclusion

## **Array Indexing**

* An array is a data structure that holds elements
* It is stored in one contiguous block of memory
* Elements can be anything: String, int, double, arrarys, etc.
* Uses a zero-index (like many programming languages)

### **Code Examples - Scenario: Planning a road trip**

* Ways to initialize an array
#### How many seats does each traveler's car have?
```java
//Separate lines, fill in later
int[] seats;
seats = new int[6];
                
seats[0] = 3;
seats[1] = 5;
seats[2] = 0;
seats[3] = 8;
seats[4] = 4;
seats[5] = 4;
```
#### What is the estimated cost per day?
```java
//One line, fill in later
double[] cost = new double[3];
        
cost[0] = 231.67;
cost[1] = 540.75;
cost[2] = 399.10;
```
#### Who do we have going on the trip so far?
```java
//Initialized and filled in one line
String[] travelers = {"Alice", "Bob", "Carlos", "David", "Eve", "Frank"};
```

* Access and modify
```java
//Get the cost per traveler 
double total = 0;
for(double c : cost) {
    total += c;
}
Sytem.out.println("The cost per person is $" + total/travelers.length);
```

```java
//Print list of participants
System.out.println("Road trip participants:");
for (int person = 0; person < travelers.length; person++) {
    System.out.println((person + 1) +". " + travelers[person]);
} 
```
```java
// Modify
System.out.println("Car 1 old seat value: " + seats[1]);
seats[1] = 5;
System.out.println("New value: " + seats[1]);
```

## **Debugging**

* Watch out for "Out of Bounds" errors
* Can happen during accessing an element or during a for loop
* Code can't access something that does not exist!

```java
Exception in thread "main" 
java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
	at Main.main(Main.java:27)


** Process exited - Return Code: 1 **
```

## **Pros and Cons of Arrays**

* Easy to traverse and efficient
* Fixed size
* Data type must be the same

## **Conclusion**

* Download code and notes on Github
* Play around with the code
* Come to office hours and tutoring
