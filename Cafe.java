/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    // Attributes
    private int nCoffeeOunces;
    private int nSugarPackets; 
    private int nCreams;
    private int nCups; 
    private Boolean hasElevator; // added hasElevator attribute to the cafe class to measure whether the cafe has an elevator

    /**
     * Overloaded constructor
     * This constructor initializes condition for cafe class with inputs of names, address, and number of floors. 
     * 
     * @param name the name of the coffee shop
     * @param address the address of the coffee shop
     * @param nFloors the number of floors the coffee shop has
     */
    public Cafe(String name, String address, int nFloors) {
        System.out.println("You have built a cafe: ☕");
        super(name, address, nFloors);
        this.nCoffeeOunces = 100; // setting fixed values for parameters
        this.nSugarPackets = 50;
        this.nCreams = 40;
        this.nCups = 150;
        this.hasElevator = false;
    }

    /**
     * original constructor
     * The constructor for cafe with given information that intialize the condition for a cafe.
     * 
     * @param name the name of the coffee shop
     * @param address the address of the coffee shop
     * @param nFloors the number of floors of the coffee shop
     * @param nCoffeeOunces the number of ounces coffee in stock
     * @param nSugarPackets the number of packages of sugar in stock
     * @param nCreams the number of splashes of cream in the stock
     * @param nCups the number of cups in the stock
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        System.out.println("You have built a cafe: ☕");
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = false; // the original constructor in A7 does not pass parameter hasElevator, adding this line to set default value to false
    }

    /**
     * Overloaded constructor
     * The constructor passes entire set of parameters, added hasElevator to allow setting for elevators in the building
     * 
     * @param name the name of the coffee shop
     * @param address the address of the coffee shop
     * @param nFloors the number of floors the coffee shop has
     * @param nCoffeeOunces the amount of coffee in ounces the coffee shop has
     * @param nSugarPackets the number of sugar packets the coffee shop has
     * @param nCreams the number of splashes of creams the coffee shop has
     * @param nCups the number of cups the coffee shop has
     * @param hasElevator records whether the coffee shop has an elevator
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, Boolean hasElevator) {
        System.out.println("You have built a cafe: ☕");
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
    }


    /**
     * Overloaded method
     * The method passes size as the only variable and reduce the default amount of sugar packets, creams and ups
     * 
     * @param size the size of coffee the consumer orders
     */
    public void sellCoffee(int size){
        if (size <= this.nCoffeeOunces && 2 <= this.nSugarPackets && 1 <= this.nCreams && this.nCups > 0){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= 2; // reduces the default amount of relevant products 
            this.nCreams -= 1;
            this.nCups -= 1;
        }
    }

    /**
     * This sellCoffee method that updates the information of the stock in the coffee shop after selling cups of coffee
     * 
     * @param size size of coffee in ounces
     * @param nSugarPackets the number of sugar packets used for the coffee
     * @param nCreams the number of splashes of cream for the coffee 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (size <= this.nCoffeeOunces && nSugarPackets <= this.nSugarPackets && nCreams <= this.nCreams && this.nCups > 0){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
    }

    /**
     * Overriding goToFloor method
     * This method only allows users to enter the first floor.
     * 
     * @param floorNum the floor number to go to
     * @throws RuntimeException throws appropriate exception message if users want to do invalid operations
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (floorNum > 1) {
            throw new RuntimeException("You can only access the first floor.");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * Overloading the restock method 
     * This method overloads the coffee shop to the default value if no parameter input.
     */
    private void restock() {
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 50;
        this.nCreams = 40;
        this.nCups = 150;
    }

    /**
     * Restock the inventory when being called (only allowed to be called privately)
     * 
     * @param nCoffeeOunces amount of coffee in ounces to be restocked
     * @param nSugarPackets number of sugar packets to be restocked
     * @param nCreams amount of creams to be restocked
     * @param nCups number of cups to be restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Overriding the showOptions method
     * Adding additional methods to the printed list
     */
    public void showOptions(){
        super.showOptions();
        System.out.println("More available options at " + this.name + ":\n + sellCoffee() \n + restock()");
    }

    /**
     * The main method to show the functionality of the methods. 
     */
    public static void main(String[] args) {

        System.out.println("------------------------------------");
        System.out.println("Test of Cafe constructor/methods");
        System.out.println("------------------------------------");
        
        Cafe compassCafe = new Cafe("Compass Cafe", "10 Neilson Drive", 3, 100, 50, 40, 150, true);
        System.out.println(compassCafe);
        compassCafe.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        compassCafe.sellCoffee(2, 3, 3);
        compassCafe.restock(300, 300, 300, 300);
        compassCafe.enter();
        compassCafe.goUp();
        compassCafe.goDown();
        compassCafe.goToFloor(2);
        compassCafe.restock();
        compassCafe.restock(1000, 1000, 1000, 1000);
        compassCafe.exit();
    }
    
}