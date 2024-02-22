package edu.mu.VehicleManager;

import edu.mu.Vehicle.Car;
import edu.mu.Vehicle.MotorBike;
import edu.mu.Vehicle.SUV;
import edu.mu.Vehicle.Truck;

public class Main {
	public static void main(String[] args) {
		// Instantiate vehicleManager, perform operations based on the requirements.
		 VehicleManager vehicleManager = new VehicleManager();
		 vehicleManager.initializeStock();
		 
		 // Read vehicle data from the vehcileList.csv file and initialize objects.
		 // TODO
		 
		 
		 
		 
		 
		 
		 
		 
		 // Display all vehicle information.
		 //nmc
		 int numberOfTrucks = vehicleManager.getNumberOfVehichlesByType(Truck.class);
		 int numberOfSUVs = vehicleManager.getNumberOfVehichlesByType(SUV.class);

		 
		 
		 
		 
		 
		 
		 // Display all car information.
		 //nmc
		 int numberOfCars = vehicleManager.getNumberOfVehichlesByType(Car.class);


		 
		 
		 
		 
		 
		 
		 
		 // Display all motorbike information.
		 //nmc
		 int numberOfMotorBikes = vehicleManager.getNumberOfVehichlesByType(MotorBike.class);

		 
		 
		 
		 
		 
		 
		 
	}

}
