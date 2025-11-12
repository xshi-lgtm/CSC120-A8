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

  public static void main(String[] args) {
    House ziskindHouse = new House("Ziskind House", "1 Henshaw Ave", 3, true, new ArrayList <Student>());
    System.out.println("ziskind");
    Student a = new Student("Cola", "991473004", 2028);
    Student b = new Student("Amy", "991472006", 2028);
    ziskindHouse.moveIn(a);
    ziskindHouse.moveIn(b);
    System.out.println("Residents after move-in: " + ziskindHouse.nResidents());
    System.out.println("Is Cola resident? " + ziskindHouse.isResident(a));
    Student moved = ziskindHouse.moveOut(a);
    System.out.println("Moved out:" + moved.getName());
  }

}