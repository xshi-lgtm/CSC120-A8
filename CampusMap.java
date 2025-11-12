import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        Building ford = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        Building bass = new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4);
        Building burton = new Building("Burton Hall", "46 College Ln, Northampton, MA 01063", 4);
        Building seelye = new Building("Seelye Hall", "2 Seelye Dr #1, Northampton, MA 01060", 4);
        myMap.addBuilding(ford);
        myMap.addBuilding(bass);
        myMap.addBuilding(burton);
        myMap.addBuilding(seelye);

        House ziskind = new House("Ziskind House", "1 Henshaw Ave, Northampton, MA 01063", 3, true, new ArrayList<Student>(),true);
        House scales = new House("Scales House", "2 Seelye Dr #1, Northampton, MA 01060", 3, true, new ArrayList<Student>(),true);
        House lamont = new House("Lamont House", "2 Seelye Dr #1, Northampton, MA 01060", 4, true, new ArrayList<Student>(),true);
        House morris = new House("Morris House", "2 Seelye Dr #1, Northampton, MA 01060", 4, false, new ArrayList<Student>());
        myMap.addBuilding(ziskind);
        myMap.addBuilding(scales);
        myMap.addBuilding(lamont);
        myMap.addBuilding(morris);


        Library neilson = new Library("Neilson Library", "2 Seelye Dr #1, Northampton, MA 01060", 4);
        Library ag = new Library("Alumnae Gymnasium", "2 Seelye Dr #1, Northampton, MA 01060", 4, false);
        myMap.addBuilding(neilson);
        myMap.addBuilding(ag);

        Cafe compass = new Cafe("Compass Cafe", "2 Seelye Dr #1, Northampton, MA 01060", 2);
        Cafe cc = new Cafe("Campus Center Cafe", "2 Seelye Dr #1, Northampton, MA 01060", 3, 200, 100, 80, 300);
        Cafe tunic = new Cafe("Tunic Cafe", "186 Main St, Northampton, MA 01060", 5, 200, 100, 80, 300, true);
        myMap.addBuilding(compass);
        myMap.addBuilding(cc);
        myMap.addBuilding(tunic);
        
        System.out.println(myMap);

        System.out.println("------------------------------------");
        System.out.println("Going to Ford Hall");
        System.out.println("------------------------------------");
        System.out.println(ford.toString());
        ford.showOptions();
        ford.enter();
        ford.goUp();
        ford.goDown();
        ford.exit();

        System.out.println("------------------------------------");
        System.out.println("Going to Campus Center Cafe");
        System.out.println("------------------------------------");
        System.out.println(cc.toString());
        cc.showOptions();
        cc.sellCoffee(2);

        System.out.println("------------------------------------");
        System.out.println("Going to Compass Cafe");
        System.out.println("------------------------------------");
        System.out.println(compass.toString());
        compass.showOptions();
        compass.sellCoffee(220, 50, 100);
        compass.enter();
        compass.exit(); //since restock is private, tested in the cafe class, cannot test the overrided code here.

        System.out.println("------------------------------------");
        System.out.println("Going to Tunic Cafe");
        System.out.println("------------------------------------");
        System.out.println(tunic.toString());
        tunic.showOptions(); // has an elevator, unable to test because cannot used by consumers

        System.out.println("------------------------------------");
        System.out.println("Going to Ziskind House");
        System.out.println("------------------------------------");
        System.out.println(ziskind.toString());
        ziskind.showOptions();
        Student a = new Student("Cola", "991473004", 2028);
        Student b = new Student("Amy", "991472006", 2028);
        ziskind.moveIn(a);
        ziskind.moveIn(b);
        
        ziskind.enter();
        ziskind.goToFloor(3);
        ziskind.goDown();
        ziskind.goDown();
        ziskind.exit();
        ziskind.moveIn("Joyce", "991472004",2028);
        Student c = new Student ("Doris", "991470803", 2027);
        ziskind.moveIn(c);
        ziskind.isResident(c);
        ziskind.isResident("Cola");

        System.out.println("------------------------------------");
        System.out.println("Going to Morris House");
        System.out.println("------------------------------------");
        System.out.println(morris.toString());
        morris.showOptions();
        morris.enter();
        morris.goToFloor(2);
        morris.goDown();
        morris.exit();

        System.out.println("------------------------------------");
        System.out.println("Going to Neilson Library");
        System.out.println("------------------------------------");
        System.out.println(neilson.toString());
        neilson.showOptions();
        neilson.enter();
        neilson.goToFloor(3);
        neilson.goToFloor(1);
        neilson.exit();

        System.out.println("------------------------------------");
        System.out.println("Going to Alumnae Gymnasium");
        System.out.println("------------------------------------");
        System.out.println(ag.toString());
        ag.showOptions();
        ag.enter();
        ag.goUp();
        ag.goDown();
        ag.exit();
        ag.addTitle("Harry Potter.");
        ag.addTitle();

    }   

}