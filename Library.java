/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Map;
/**
 * A Library is a Building that manages a collection of book titles and their availability.
 * The collection maps a title to a Boolean where true = available, false = checked out.
 */
public class Library extends Building implements LibraryRequirements {
  /** Map from book title to availability. */
  private Hashtable<String, Boolean> collection;
  private final boolean hasElevator;

// Constructor
  /**
   * Construct a Library.
   * @param name     library name
   * @param address  street address
   * @param nFloors  number of floors (>= 1)
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasElevator = hasElevator;
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Overloaded constructor : Construct a Library with elevator by default.
   * @param name name of library
   * @param address address of library
   * @param nFloors number of floors in the library
   */
  public Library(String name, String address, int nFloors) {
    this(name, address, nFloors, true);
  }

  /** 
   * Add a title to the collection, marked available. 
   * @param title the title of book added to the collection
   */
  public void addTitle(String title){
      collection.put(title, true);
  }

  /** 
   * Overloaded method 
   * Add a default title "Untitled" to the collection if the book has no name
   */
  public void addTitle(){
    collection.put("Untitled",true);
  }

  /**
   * Remove a title from the collection.
   * @param title the title to remove
   * @return the removed title
   * @throws IllegalArgumentException if the book is not in the collection
   */
  public String removeTitle(String title){
    if(collection.containsKey(title)){
      collection.remove(title);
      return title;
    }else{
      throw new IllegalArgumentException(title + "not found in the collection.");
    }
  }

  /**
   * Check out a title from the collection.
   * @param title the title to check out
   * @throws IllegalArgumentException if the book has either been checked out or is not in the collection
   */
  public void checkOut(String title){
    if(collection.containsKey(title)){
      if(collection.get(title)){
        collection.put(title, false);
      }else{
        throw new IllegalArgumentException(title + "has been checked out.");
      }
    }else{
      throw new IllegalArgumentException(title + "is not in the collection.");
    }
  }

  /**
   * Return a title to the collection.
   * @param title the title to return
   * @throws IllegalArgumentException if the book is already in the collection or the book does not exist in the library
   */
  public void returnBook(String title){
    if(collection.containsKey(title)){
      if(!collection.get(title)){
        collection.put(title,true);
      }else{
        throw new IllegalArgumentException(title + "is in the collection already.");
      }
    }else{
      throw new IllegalArgumentException(title + "is not in the collection.");
    }
  }

  /**
   * Check if the collection contains a title.
   * @param title the title to check
   * @return true if the title is in the collection, false otherwise
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }
  
  /**
   * Check if a title is available.
   * @param title the title to check
   * @return true if the title is available, false otherwise
   */
  public boolean isAvailable(String title){
    return collection.getOrDefault(title, false);
  }

  /**
   * Print the entire collection with availability status.
   */
  public void printCollection(){
    System.out.println("Library Collection: \n");
    for (Map.Entry<String, Boolean> entry : collection.entrySet()) {
      if(entry.getValue()){
        System.out.println("Title: "+ entry.getKey()+ "; Status: Available" );
      }else{
        System.out.println("Title: "+ entry.getKey()+ "; Status: Checked Out" );
      }
    }
  }

// Overriden Methods
  /**
   * Show the options available in a library.
   * print the options to the terminal.
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n" + " + enter()\n" + " + exit()\n" + " + goUp()\n" + " + goDown()\n" + " + goToFloor(n)\n" + " + addTitle(String)\n" + " + removeTitle(String)\n" + " + checkOut(String)\n" + " + returnBook(String)\n" + " + containsTitle(String)\n" + " + isAvailable(String)\n" + " + printCollection()");
  }

  /**
   * Override goToFloor method to add elevator funcationality.
   * @param floorNum the floor numbe to go to
   * @throws RuntimeException if floorNum is invalid or elevator rules are violated
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Library. Must call enter() first.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Library is 1-" + this.nFloors + ".");
    }
    if (hasElevator) {
      System.out.println("You take the elevator to floor #" + floorNum + ".");
      this.activeFloor = floorNum;
    } else {
        if (Math.abs(floorNum - this.activeFloor) > 1) { // if moving to non-adjacent floors
          throw new RuntimeException("No elevator: you can only move one floor at a time.");
        } else {
            System.out.println("You walk to floor #" + floorNum + ".");
            this.activeFloor = floorNum;
        }
    }
  }


public static void main(String[] args) {
    System.out.println("------------------------------------");
    System.out.println("Test of Library constructor/methods");
    System.out.println("------------------------------------");

    Library neilson = new Library("Neilson Library", "7 Neilson Drive", 5);
    System.out.println(neilson);
    neilson.showOptions();

    System.out.println("-----------------------------------");
    System.out.println("Demonstrating add/remove/checkout");
    System.out.println("-----------------------------------");
    neilson.addTitle("CSC 120 Textbook");
    neilson.addTitle("Design as Art");
    neilson.printCollection();
    neilson.checkOut("Design as Art");
    neilson.printCollection();
    neilson.returnBook("Design as Art");
    neilson.removeTitle("CSC 120 Textbook");
    neilson.printCollection();

    System.out.println("-----------------------------------");
    System.out.println("Demonstrating enter/exit/navigation");
    System.out.println("-----------------------------------");
    neilson.enter();
    neilson.goToFloor(3);
    neilson.goToFloor(5);
    neilson.exit();

    System.out.println("-----------------------------------");
    System.out.println("All tests finished.");
    System.out.println("-----------------------------------");
    }
}