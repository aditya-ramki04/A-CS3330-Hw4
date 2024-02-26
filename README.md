PROJECT OVERVIEW: 
This project involves designing a vehicle showroom management system using Java Object-Oriented Programming principles. The class diagram includes an abstract base class, Vehicle, with subclasses representing Truck, Car, SUV, and MotorBike. Enumerations define FuelType, StartMechanism, and VehicleColor. The assignment requires implementing abstract methods for maintenance cost, fuel efficiency, and engine start, along with copy constructors and a toString() method. Additionally, a singleton class, VehicleManager, manages the inventory by reading from a CSV file, updating, adding, removing, and saving vehicles. The program must follow specific guidelines, including handling file-related exceptions and using version control practices. The Main class instantiates VehicleManager and performs operations as specified in the requirements. The submission involves creating a GitHub repository and providing clear commits for running the program.




NOTES IMPORTANT: 
If you look at the commits there are 56 commits including this README.md file. We are still trying to get the hang of utilizing git as a team and since we are not using any other branch but the main, we have to use the git stash command to save our changes before we pull the updated code. We all work together in person for the HW assignments so we all can assist each other with issues and communicate appropriately. I just wanted to let you guys know because I understand going through 55 commits is very tedious, we will try our best as a team to make more meaningful commits in the future. Thank you!




WORK SPLIT:
Nitin M. Chava --> public void displayAllCarInformation() | public boolean removeVehicle(Vehicle vehicle) | public int getNumb6erOfVehichlesByType(Class clazz) | public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) | MotorBike.java | README.md

Matthew Robison --> public boolean initializeStock() | public void displayAllSUVInformation() | public void displayVehicleInformation(Vehicle v) | private boolean isVehicleType(Vehicle v, Class clazz) | public Vehicle getVehicleWithLowestMaintenanceCost(double distance) | SUV.java

Aditya Ramakrishnan --> public void displayAllMotorBikeInformation() | public void displayAllVehicleInformation() | public boolean saveVechileList() | public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) | Car.java

Abhi Pasupuleti --> public void displayAllTruckInformation() | public boolean addVehicle(Vehicle vehicle) | public Vehicle getVehicleWithHighestMaintenanceCost(double distance) | public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice) | Truck.java




RUN PROGRAM:
1) https://github.com/aditya-ramki04/A-CS3330-Hw4.git
2) Go into Eclipse and import the file: A-CS3330-Hw4
3) You can then click on the program and run it!

