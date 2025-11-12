/* This is a stub for the House class */

import java.util.ArrayList;

/**
 * A House is a kind of Building that may have a dining room and maintains a list of Student residents.
 */
public class House extends Building implements HouseRequirements{
  /** The list of students who currently live in this House. */
  private ArrayList<Student> residents;
  /** Whether this house has a dining room. */
  private boolean hasDiningRoom;
  private final boolean hasElevator;

  /**
    * Construct a House.
    * @param name        the building name
    * @param address     the street address
    * @param nFloors     number of floors in the building
    * @param hasDiningRoom whether the house has a dining room
    * @throws RuntimeException if nFloors < 1 (enforced by Building)
    */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, ArrayList<Student> residents){
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<Student>();
    hasElevator = false;
    System.out.println("System.out.println(\"You have built a house: 🏠\");");
  }
  /**
   * Overloaded: Construct a House.
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   * @param residents
   * @param hasElevator
   * @throws RuntimeException if nFloors < 1 (enforced by Building)
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, ArrayList<Student> residents, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<Student>();
    System.out.println("System.out.println(\"You have built a house: 🏠\");");
  }

// Accessors
  /** @return true if the house has a dinning room, false otherwise */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }; 
  /** @return the number of current residents */
  public int nResidents(){
    return this.residents.size();
  }; 

// Overridden
  /** @Override showOptions
   * Prints the options available in a House */
  public void showOptions() {
    super.showOptions();
    System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn(s) \n + moveOut(s) \n + isResident(s) \n + goToFloor(n)");
  }

  /**
   * Override gotoFloor method to add elevator functionality
   * @param floorNum the floor number to go to
   */
    public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("Enter the house before navigating floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range is 1-" + this.nFloors + ".");
    }
    if (!hasElevator && Math.abs(floorNum - this.activeFloor) > 1) {
      throw new RuntimeException("No elevator: you must move one floor at a time.");
    }
    super.goToFloor(floorNum);
  }

  /**
   * Move a student into the house
   * @param s the student to move in
   */
  public void moveIn(Student s){
    if (!this.residents.contains(s)){
      this.residents.add(s);
    } else {
      throw new IllegalArgumentException(s.getName()+ "is already a resident.");
    }
  }
  
  /**
   * Move a student out of the house
   * @param s
   * @return the student that moved out, or null if s was not a resident
   */
  public Student moveOut(Student s){
    if (this.residents.remove(s)){
      return s;
    }
    else {
      throw new IllegalArgumentException(s.getName() + "is not a resident");
    }
  }

  /** Check if a student is a current resident
   * @param s the student to check
   * @return true if s is a resident, false otherwise
   */
  public boolean isResident(Student s){
    return this.residents.contains(s);
  };

//Overloads
  /** Check if a student is a current resident
   * @param name the name of the student to check
   * @return true if a student with the given name is a resident, false otherwise
   */
  public boolean isResident(String name){
    for (Student s : residents) {
      if (s.getName().equals(name)) return true;
    }
    return false;
  }

  /**
   * Move a student into the house
   * @param name
   * @param id
   * @param classYear
   */
  public void moveIn(String name, String id, int classYear){
    this.moveIn(new Student(name, id, classYear));
  }

public static void main(String[] args) {
    System.out.println("------------------------------------");
    System.out.println("Test of House constructor/methods");
    System.out.println("------------------------------------");
    
    House ziskindHouse = new House("Ziskind House", "1 Henshaw Ave", 3, true, new ArrayList<Student>());
    System.out.println(ziskindHouse);
    ziskindHouse.showOptions();

    System.out.println("-----------------------------------");
    System.out.println("Demonstrating moveIn/moveOut/residents");
    System.out.println("-----------------------------------");

    Student a = new Student("Cola", "991473004", 2028);
    Student b = new Student("Amy", "991472006", 2028);
    ziskindHouse.moveIn(a);
    ziskindHouse.moveIn(b);
    System.out.println("Residents after move-in: " + ziskindHouse.nResidents());
    System.out.println("Is Cola resident? " + ziskindHouse.isResident(a));
    Student moved = ziskindHouse.moveOut(a);
    System.out.println("Moved out: " + moved.getName());
    System.out.println("Residents after move-out: " + ziskindHouse.nResidents());

    System.out.println("-----------------------------------");
    System.out.println("Demonstrating enter/exit/navigation (no elevator)");
    System.out.println("-----------------------------------");
    ziskindHouse.enter();
    ziskindHouse.goToFloor(2);
    ziskindHouse.goToFloor(3);
    ziskindHouse.goDown(); 
    ziskindHouse.goDown(); 
    ziskindHouse.exit();

    System.out.println("-----------------------------------");
    System.out.println("Testing House with elevator");
    System.out.println("-----------------------------------");
    House lamontHouse = new House("Lamont House", "2 Elm Street", 4, true, new ArrayList<Student>(), true);
    System.out.println(lamontHouse);
    lamontHouse.enter();
    lamontHouse.goToFloor(4);
    lamontHouse.goToFloor(1); 
    lamontHouse.exit();
}


}