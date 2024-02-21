package edu.mu.VehicleManager;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.mu.Vehicle.Car;
import edu.mu.Vehicle.FuelType;
import edu.mu.Vehicle.MotorBike;
import edu.mu.Vehicle.SUV;
import edu.mu.Vehicle.StartMechanism;
import edu.mu.Vehicle.Truck;
import edu.mu.Vehicle.Vehicle;
import edu.mu.Vehicle.VehicleColor;


public class VehicleManager {


	private static VehicleManager instance = null;
	// Define paths as final so that they cannot be modified later.
	private final static String vehicleFilePath = "files/vehicleList.csv";
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	
	public VehicleManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static VehicleManager getInstance()
	{
		if(instance == null)
		{
			instance = new VehicleManager();
		}
		return instance;
	}

	public boolean initializeStock() {
		try { 
			Scanner fileIn = new Scanner(new FileInputStream(vehicleFilePath));
			fileIn = new Scanner(new FileInputStream(vehicleFilePath));
			int index = 0;
			if(fileIn.hasNextLine())
			{
				fileIn.nextLine();
			}
			while(fileIn.hasNextLine())
			{
				String line = fileIn.nextLine(); //gets the next line to hold the whole line 
				String parts[] = line.split(","); //splits the line at each " " so now the parts array has the id, Name, grade
				String type = parts[0];
				String model = parts[1];
				String make = parts[2];
				int modelYear = Integer.parseInt(parts[3]); //using parseInt to parse it from String to int and then storing it in id.
				int price = Integer.parseInt(parts[4]);
				VehicleColor color = VehicleColor.valueOf(parts[5]);
				FuelType fuelType = FuelType.valueOf(parts[6]);
				double mileage = Double.parseDouble(parts[7]);
				double mass = Double.parseDouble(parts[8]);
				int cylinders = Integer.parseInt(parts[9]);
				int gasTankCapacity = Integer.parseInt(parts[10]);
				StartMechanism startType = StartMechanism.valueOf(parts[11]);
				if(type.equals("Truck"))
				{
					vehicleList.add(new Truck(model, make, modelYear, price, color,
							fuelType, mileage, mass, cylinders, gasTankCapacity, startType));
				}
				if(type.equals("MotorBike"))
				{
					vehicleList.add(new MotorBike(model, make, modelYear, price, color,
							fuelType, mileage, mass, cylinders, gasTankCapacity, startType));
				}
				if(type.equals("Car"))
				{
					vehicleList.add(new Car(model, make, modelYear, price, color,
							fuelType, mileage, mass, cylinders, gasTankCapacity, startType));
				}
				if(type.equals("SUV"))
				{
					vehicleList.add(new SUV(model, make, modelYear, price, color,
							fuelType, mileage, mass, cylinders, gasTankCapacity, startType));
				}
				
			}
			fileIn.close();//closes file
			
			
			return true;
		} catch (FileNotFoundException e) //if file not found then return no file found and return false.
		{
			System.out.println("No File Found");
			e.printStackTrace();
			return false;
		}
		
	}
	
	//Abhi added this code to correctly instantiate vehicleList
	public ArrayList<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(ArrayList<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
//	public void VehicleManager(String fileName) {
//		
//	}
	
//nmc	
	public void displayAllCarInformation() {
		
		boolean foundCar = false;
		for(Vehicle vehicle : vehicleList) {
			if(isVehicleType(vehicle, Car.class)){
				foundCar = true;
				displayVehicleInformation(vehicle);
			}
		}
		if(!foundCar) {
			System.out.println("No Cars found in the vehicle list.");
		}
	}
//nmc
	
//	public void displayAllTruckInformation() {
//		
//	}
//	
	public void displayAllSUVInformation() 
	{
		 boolean foundSUV = false;
		    for (Vehicle vehicle : vehicleList) 
		    {
		        if (isVehicleType(vehicle, SUV.class)) 
		        {
		            foundSUV = true;
		            displayVehicleInformation(vehicle);
		        }
		    }
		    if (!foundSUV) 
		    {
		        System.out.println("No SUVs found in the vehicle list.");
		    }
	}
	
	public void displayAllTruckInformation() 
	{
		boolean foundTruck = false;
		for (Vehicle vehicle : vehicleList)
		{
			if (isVehicleType(vehicle, Truck.class))
			{
				foundTruck = true;
				displayVehicleInformation(vehicle);
			}
		}
		if(!foundTruck)
		{
			System.out.println("No trucks have been found.");
		}
		
	}

//	public void displayAllSUVInformation() {
//		
//	}
//	
//	public void displayAllMotorBikeInformation() {
//		
//	}
	
	public void displayVehicleInformation(Vehicle v)
	{
		if (v != null) 
		{
	        System.out.println(v.toString());
	    } 
		else 
		{
	        System.out.println("Invalid vehicle object. Cannot display information.");
	    }
	}
	
//	public void displayAllVehicleInformation() {
//		
//	}
	
//by nmc	
	//same function as the one commented below just can tell if it works or not from
	//terminal via print statements
	//will remove one or the other during final check with team 
	public boolean removeVehicle(Vehicle vehicle) {
		if(vehicle != null) {
			for(Vehicle v : vehicleList) {
				if(v.equals(vehicle)) {
					vehicleList.remove(v);
					System.out.println("Vehicle has been removed.");
					return true;
				} else {
					System.out.println("Vehicle removal failed.");
				}
			}
			System.out.println("Vehicle not found in the list... removal failed.");
			return false;
		}else {
			System.out.println("Invalid object... removal failed.");
			return false;
		}
	}
	
//	public boolean removeVehicle(Vehicle vehicle) {
//	    if (vehicle != null) {
//	        for (Vehicle v : vehicleList) {
//	            if (v.equals(vehicle)) {
//	                vehicleList.remove(v);
//	                return true;
//	            }
//	        }
//	    }
//	    return false;
//	}
//by nmc


	//Abhi made this code
	public boolean addVehicle(Vehicle vehicle) 
	{
		if(vehicle != null) {
			getVehicleList().add(vehicle);
			return true;
		}
		return false;
	}
	
//	public boolean saveVehicleList() {
//		
//	}
	
//	private boolean isVehicleType(Vehicle v, Class clazz) {
//		
//	}
	
//	public int getNumberOfVehichlesByType(Class clazz) {
//		
//	}
	

	//Abhi made this code.
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) 
	{
		if (vehicleList.isEmpty()) 
	 	{
            System.out.println("No vehicles in the list.");
            return null;
	 	}
	 	
		Vehicle highestCostVehicle = null;
        double highestMaintenanceCost = Double.MIN_VALUE;

        for (Vehicle vehicle : vehicleList) {
            double maintenanceCost = vehicle.calculateMaintenaceCost(distance);

            if (maintenanceCost > highestMaintenanceCost) 
            {
                highestMaintenanceCost = maintenanceCost;
                highestCostVehicle = vehicle;
            } 
            else if (maintenanceCost == highestMaintenanceCost) 
            {
                Random random = new Random();
                if (random.nextBoolean()) 
                {
                    highestCostVehicle = vehicle;
                }
            }
        }
        return highestCostVehicle;
    }
	
	
	//this is not right fix it later

	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
		 	if (vehicleList.isEmpty()) 
		 	{
	            System.out.println("No vehicles in the list.");
	            return null;
		 	}
		 	Vehicle lowestCostVehicle = null;
	        double lowestMaintenanceCost = Double.MAX_VALUE;

	        for (Vehicle vehicle : vehicleList) {
	            double maintenanceCost = vehicle.calculateMaintenaceCost(distance);

	            if (maintenanceCost < lowestMaintenanceCost) 
	            {
	                lowestMaintenanceCost = maintenanceCost;
	                lowestCostVehicle = vehicle;
	            } 
	            else if (maintenanceCost == lowestMaintenanceCost) 
	            {
	                // Randomly choose between the current vehicle and the one with the same maintenance cost
	                Random random = new Random();
	                if (random.nextBoolean()) 
	                {
	                    lowestCostVehicle = vehicle;
	                }
	            }
	        }
	        return lowestCostVehicle;
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	

