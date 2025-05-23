```java
import java.util.Arrays; // Import this class for some helpful array functions
import java.util.Random;

public class Week8Arrays {
    public static void main(String[] args) {
        /*
         * Functions we need for working with arrays in a video game
         * 
         * - Print the array's contents
         * - Add an element to the array
         *      - Be sure to check if it is full or occupied
         * - Use/get an element
         *      - Check if it's durability is used up (aka item breaks and is deleted)
         * - Delete an element
         * 
         * Be sure to account for 1D and 2D arrays
         */

        // 1. Declare a new 1D String array  
        // String arrays default fill with null, so we will fill with "" to make it easier
        String[] hotbar = new String[10]; // default fills with null
        Arrays.fill(hotbar, "");

        // 2. Add some items to the array. Print it out and check your results 
        System.out.println(addItem(hotbar, "sword"));
        System.out.println(addItem(hotbar, "pickaxe"));
        System.out.println(addItem(hotbar, "torches"));
        
        System.out.println();
        printArray(hotbar);
        System.out.println();
        
        // 3. Use an item in the array
        useItemByName(hotbar, "sword");

        printArray(hotbar);
        System.out.println();

        // 4. Delete an item from the array
        deleteItemByItemNum(hotbar, 2); 

        printArray(hotbar);
        System.out.println();
        
        // 5. Add a new item. It should be placed in the same spot where the previous item was deleted
        System.out.println(addItem(hotbar, "diamonds"));

        System.out.println();
        
        // 6. Print to check your code
        printArray(hotbar);

        System.out.println("\n===========Working with 2D arrays==============");

        // Repeat the process, but for 2D arrays
        // How big do you want the array to be, in terms of rows and columns?
        // 1. Declare a new 2D String array
        int rows = 3;
        int cols = 10;
        String[][] inventory = new String[rows][cols];

        // Notice how we fill with "" compared to the 1D array
        for (String[] row : inventory) {
            Arrays.fill(row, "");
        }

        // Let's use the same function name, but change the parameter to a 2D array!
        // This is called method overloading
        // 2. Add some items to the array 
        System.out.println(addItem(inventory, "dirt"));
        System.out.println(addItem(inventory, "cobblestone"));
        System.out.println(addItem(inventory, "wood"));

        System.out.println();
        printArray(inventory);
        System.out.println();

        // 3. Use an item in the array
        useItemByName(inventory, "dirt");
        // Let's also test an item that's NOT in the array
        useItemByName(inventory, "sword");

        System.out.println();

        printArray(inventory);
        System.out.println();

        // 4. Delete an item from the array
        deleteItemByItemNum(inventory, 1, 2); 

        printArray(inventory);
        System.out.println();

        // 5. Add a new item. It should be placed in the same spot where the previous item was deleted
        System.out.println(addItem(inventory, "diamonds"));
        
        System.out.println();
        
        // 6. Print to check your code
        printArray(inventory);
    }

    /**
     * Prints numbered array contents, for example 
     * 1. Item 1
     * 2. Item 2
     * 3. Item 3
     *
     * @param arr The array to print
     */
    public static void printArray(String[] arr) {
        System.out.println("Your array contains:");
        for (int index = 0; index < arr.length; index++) {
            System.out.println((index + 1) + ". " + arr[index]);
        }
    }

    public static void printArray(String[][] arr) {
        System.out.println("Your array contains:");
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col].equals("")) {
                    System.out.print(" ____ | ");
                } else {
                    System.out.print(arr[row][col] + " | ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Adds the item to the next available slot in the array and returns a success message
     * If the array is full, return a message stating that the array is full
     * If the item was added successfully, return a message
     * Example: "Item sword was added to slot 3" means that arr[2] = "sword"
     * 
     * @param arr The array which is getting an item added to it
     * @param item The item to be added to the array
     * @return A String message of success or failure 
     */
    public static String addItem(String[] arr, String item) {
        // First make sure that the array is not already full
        int index = 0; // Keep track of the slot you are checking
        for (String s : arr) {
            if (s.equals("")) {
                break; // We reached an empty slot
            }
            index++;
        }

        if (index == arr.length) {
            return "Array full, can't add item " + item;
        }

        // Add the item
        arr[index] = item;

        String message = ("Item " + item + " was added to slot " + (index + 1));

        return message;
    }

    public static String addItem(String[][] arr, String itemToAdd) {
        int row = 0; // keep track of the row and col you are checking
        int col = 0;
        boolean foundSpace = false;
        
        // take care of this first so you don't waste time looking for a space!
        if (row == arr.length || col == arr[0].length) {
            return "Array full, can't add item " + itemToAdd;
        }

        // using a for loop is easier and more readable
        for (row = 0; row < arr.length; row++) {
            for (col = 0; col < arr[row].length; col++) {
                if (arr[row][col].equals("")) {
                    foundSpace = true;
                    break;
                }
            }
            if (foundSpace) {
                break;
            }
        }
        

        // add the item
        arr[row][col] = itemToAdd;

        String message = ("Item " + itemToAdd + " was added to row " + (row + 1) + " column " + (col + 1));
        
        return message;
    }

    /**
     * "Uses" (not delete) the item, given the item name, if it exists
     * If it doesn't exist, state an error message
     * Have a chance for the item to break, thus deleting it
     *
     * @param arr The array that has the item to be used
     * @param item The name of the item, as a String
     */
    public static void useItemByName(String[] arr, String item) {
        int index;
        boolean itemFound = false;
        for (index = 0; index < arr.length; index++) {
            if (arr[index].equals(item)) {
                System.out.println("You use the " + item);
                itemFound = true;
                break;
            }
        }

        if (!itemFound) {
            System.out.println(item + " was not in the array");
        }

        // After using, you could use random number to determine if it breaks
        // and gets deleted!
        Random rand = new Random();
        if (rand.nextInt(101) <= 30) { // random num between 0-100
            // 30% chance to break
            System.out.println("Your " + item + " has broken!");
            arr[index] = ""; // delete the broken item
        }
    }

    public static void useItemByName(String[][] arr, String item) {
        int row = 0;
        int col = 0;
        boolean itemFound = false;
        for (row = 0; row < arr.length; row++) {
            for (col = 0; col < arr[row].length; col++) {
                if (arr[row][col].equals(item)) {
                    System.out.println("You use the " + item);
                    itemFound = true;
                    break;
                }
            }
            if (itemFound) {
                break;
            }
        }

        if (!itemFound) {
            System.out.println(item + " was not in the array");
        }

        // After using, you could use random number to determine if it breaks
        // and gets deleted!
        Random rand = new Random();
        if (rand.nextInt(101) <= 30) { // random num between 0-100
            // 30% chance to break
            System.out.println("Your " + item + " has broken!");
            arr[row][col] = "";
        }
    }

    /**
     * Deletes an item, given the item number (space in the array, NOT index)
     * Be sure to validate for improper indexing!
     * If the slot is already empty, state that
     * 
     * REQUIREMENT: the user will enter a number 1-length
     * You need to make sure that lines up with the array index!
     * Example: Item 1 corresponds to index 0
     *
     * @param arr The array which has an item to be deleted
     * @param itemNum The slot number that corresponds to the item being deleted
     */
    public static void deleteItemByItemNum(String[] arr, int itemNum) {
        if (itemNum < 1 || itemNum > arr.length) {
            System.out.println("Invalid index!");
        } else {
            String previousItem = arr[itemNum - 1];
            arr[itemNum - 1] = "";
            System.out.println(previousItem + " successfully deleted");
        }
    }

    public static void deleteItemByItemNum(String[][] arr, int rowNum, int colNum) {
        if (rowNum < 1 || rowNum > arr.length) {
            System.out.println("Invalid index!");
        } else if (colNum < 1 || colNum > arr.length) {
            System.out.println("Invalid index!");
        } else {
            String previousItem = arr[rowNum - 1][colNum - 1];
            arr[rowNum - 1][colNum - 1] = "";
            System.out.println(previousItem + " successfully deleted");
        }
    }
}
```