package edu.mu.VehicleManager;

import java.util.*;

import edu.mu.Vehicle.*;

public class Main {
	public static void main(String[] args) {
		// Instantiate vehicleManager, perform operations based on the requirements.
		 VehicleManager vehicleManager = new VehicleManager();
		 vehicleManager.initializeStock();
		 
		 vehicleManager.saveVehicleList();

		 
		 // Read vehicle data from the vehcileList.csv file and initialize objects.
		 // TODO
		 

		 // Tested displaying number of trucks and SUVs. Also tests AverageFuelEfficiencyofSUVS as well.
		 //nmc
		 int numberOfTrucks = vehicleManager.getNumberOfVehichlesByType(Truck.class);
		 int numberOfSUVs = vehicleManager.getNumberOfVehichlesByType(SUV.class);
	     System.out.println("Average Fuel Efficiency of SUVs: " + vehicleManager.getAverageFuelEfficiencyofSUVs(vehicleManager.getDistance(), vehicleManager.getFuelPrice()));

		 
		 // Displays number of Cars.
		 //nmc
		 int numberOfCars = vehicleManager.getNumberOfVehichlesByType(Car.class);
		 
		 // Display number of Motor bikes.
		 //nmc
		 int numberOfMotorBikes = vehicleManager.getNumberOfVehichlesByType(MotorBike.class);

		 
		 
		 //used this code to test all the displays
		 vehicleManager.displayAllTruckInformation();
		 vehicleManager.displayAllCarInformation();
		 vehicleManager.displayAllMotorBikeInformation();
		 vehicleManager.displayAllSUVInformation();
		 System.out.println("\n\n\n\n\n");
		 vehicleManager.displayAllVehicleInformation();
		 System.out.println("\n\n\n\n\n");
		 
		 //created two vehicles with one exact to a vehicle in the arrayList and one not
		 Truck t = new Truck("Toyota", "Takuma", 2000, 100000.0, VehicleColor.WHITE, FuelType.DIESEL, 50000.0, 2.0, 12, 25.0, StartMechanism.KEYSTART);
		 Car c = new Car("Honda", "yo", 2024, 18000.0, VehicleColor.GRAY, FuelType.ELECTRIC, 50000.0, .25, 6, 14.0, StartMechanism.PUSHSTART);
		 
		 //tested adding the vehicle to the arrayList and removing it. also test saveVehicle list after adding and removing
		 vehicleManager.addVehicle(t);
		 vehicleManager.addVehicle(c);
		 vehicleManager.saveVehicleList();
		 
		 vehicleManager.removeVehicle(c);
		 vehicleManager.saveVehicleList();
		 
		 vehicleManager.displayVehicleInformation(t);
		 
		 //tests highest/lowest fuelEfficiency and highest/lowest MaintenanceCost/
		 ArrayList<Vehicle> highestEfficientVehicles = vehicleManager.getVehicleWithHighestFuelEfficiency(300, 3.25);
		 System.out.println("Highest efficiency value is " + highestEfficientVehicles);
		 
		 ArrayList<Vehicle> lowestEfficientVehicles = vehicleManager.getVehicleWithLowestFuelEfficiency(300, 3.25);
		 System.out.println("Lowest efficiency value is " + lowestEfficientVehicles);
		 
	     Vehicle vehicleWithHighestMaintenanceCost = vehicleManager.getVehicleWithHighestMaintenanceCost();
	     System.out.println("Highest maintenance value is " + vehicleWithHighestMaintenanceCost);
	     
	     Vehicle getVehicleWithLowestMaintenanceCost = vehicleManager.getVehicleWithLowestMaintenanceCost();
	     System.out.println("Lowest maintenance value is " + getVehicleWithLowestMaintenanceCost);
	     
		// System.out.println("Testing if vehicle type is correct " + vehicleManager.isVehicleType(t, Truck.class)); made sure if isVehicleType is correct, but it is private
//		 vehicleManager.displayVehicleInformation(t);
//		 vehicleManager.displayVehicleInformation(c);		 
	}

}
