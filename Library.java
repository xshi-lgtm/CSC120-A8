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
  /**
   * Construct a Library.
   * @param name     library name
   * @param address  street address
   * @param nFloors  number of floors (>= 1)
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    System.out.println("You have built a library: 📖");
    this.collection = new Hashtable<String, Boolean>();
  }

  /** Add a title to the collection, marked available. */
  public void addTitle(String title){
      collection.put(title, true);
  }

  /**
   * Remove a title from the collection.
   * @param title the title to remove
   * @return the removed title
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


  public static void main(String[] args) {
    Library myLib = new Library("Neilson", "7 Neilson drive", 20);
    myLib.addTitle("CSC 120 Textbook");
    myLib.addTitle("SDS 291 Textbook");

    myLib.removeTitle("SDS 291 Textbook");

    myLib.checkOut("CSC 120 Textbook");

    myLib.returnBook("CSC 120 Textbook");

    System.out.println(myLib.containsTitle("CSC 120 Textbook"));

    System.out.println(myLib.isAvailable("CSC 120 Textbook"));

    myLib.printCollection();
  }

}