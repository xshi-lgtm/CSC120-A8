Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?

In House class, I overloaded moveIn method, isResident method and also the constructor, because the overloaded constructor allows the program to create a house either with or without an elevator, and the overloaded moveIn method lets the user add a resident either by passing a Student object or by directly add the resident's name, ID, and class year. The overloaded isResident method makes it possible to check residency either by passing a Student object or just a name as a String, which is more convenient.

In the Library class, I overloaded two constructors and the addTitle method. The overloaded constructors give flexibility to create libraries with different amounts of information eith just name, address, number of floors, or with an additional parameter to specify whether the building has an elevator. The overloaded addTitle method allows adding books without knowing the title, and automatically adding a default book entry called "Untitled".

In the Cafe class, the constructor is overloaded, in order to make the program run smoothly even there are not corresponding values for the input parameters. We choose to set the parameters to default values. 

The sellCoffee method is overloaded as well, because consumers do not always order for specific amount of sugar packets and creams. To ensure the program runs, we will set the default amount of sugar packets and creams. 

The restock method is overloaded to ensure that even if the barista do not enter the specific amount refilled, the program sets the restock value to maximum automatically.

The shopOptions method is overloaded to add additional methods specific to cafe class.

In Library file, I overloaded 2 constructor and addtitle method
- What worked, what didn't, what advice would you give someone taking this course in the future?
I would advice starting by understanding what overriding and overloading means in Java. And then, start with the constructor of cafe class and experiment with adding or removing parameters in the input, which can help students gain a practical idea of how to overload a code chunk. 

We spent a lot of time figuring out how to start. From the classes, we understood what override and overload basically means, but when writing the codes, we found it hard to start. Therefore, a piece of advice I would give to future students is to start by reviewing in class examples.