package edu.mu.VehicleManager;
import java.io.*;
import java.util.*;
import edu.mu.Vehicle.*;

public class VehicleManager {


	private static VehicleManager instance = null;
	// Define paths as final so that they cannot be modified later.
	private final static String vehicleFilePath = "files/vehicleList.csv";
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	private final static double distance = 300;
	private final static double fuelPrice = 3.25;
	
	public double getDistance() {
		return distance;
	}
	public double getFuelPrice() {
		return fuelPrice;
	}
	
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
	//matthew did this
	public boolean initializeStock() 
	{
		//used code from previous assignments on this function 
		try 
		{ 
			Scanner fileIn = new Scanner(new FileInputStream(vehicleFilePath));
			fileIn = new Scanner(new FileInputStream(vehicleFilePath));
			if(fileIn.hasNextLine())
			{
				fileIn.nextLine();
			}
			while(fileIn.hasNextLine())
			{
				String line = fileIn.nextLine();
				String parts[] = line.split(","); 
				String type = parts[0];
				String model = parts[1];
				String make = parts[2];
				long modelYear = Long.parseLong(parts[3]); 
				double price = Double.parseDouble(parts[4]);
				VehicleColor color = VehicleColor.valueOf(parts[5]);
				FuelType fuelType = FuelType.valueOf(parts[6]);
				double mileage = Double.parseDouble(parts[7]);
				double mass = Double.parseDouble(parts[8]);
				int cylinders = Integer.parseInt(parts[9]);
				double gasTankCapacity = Double.parseDouble(parts[10]);
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
			fileIn.close();
			
			
			return true;
		} catch (FileNotFoundException e) 
		{
			System.out.println("No File Found");
			e.printStackTrace();
			return false;
		}
		
	}
	
//nmc	
	public void displayAllCarInformation() {
		//loops through the arraylist of vehicle to determine if the car is in the list.
		//if it finds it, it displays the information otherwise prints error message
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

	//matthew did this
	public void displayAllSUVInformation() 
	{
		//loops through the arraylist of vehicle to determine if the SUV is in the list.
		//if it finds it, it displays the information otherwise prints error message
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
	
	//Abhi did this
	public void displayAllTruckInformation() 
	{
		//loops through the arraylist of vehicle to determine if the truck is in the list.
		//if it finds it, it displays the information otherwise prints error message
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
	
	//Aditya
	public void displayAllMotorBikeInformation() {
		//loops through the arraylist of vehicle to determine if the motorbike is in the list.
		//if it finds it, it displays the information otherwise prints error message
		boolean foundBike = false;
		for (Vehicle vehicle : vehicleList)
		{
			if (isVehicleType(vehicle, MotorBike.class))
			{
				foundBike = true;
				displayVehicleInformation(vehicle);
			}
		}
		if(!foundBike)
		{
			System.out.println("No motorbikes have been found.");
		}
	}
	
	//Matthew did this
	public void displayVehicleInformation(Vehicle v)
	{
		//checks if the vehicle v is in the vehiclelist, and then prints out the maintenancecost, 
		//fuelefficieny, and  how the engine starts, otherwise if it wasn't found, prints an error
		if (v != null && vehicleList.contains(v)) 
		{
			
			double maintenanceCost = v.calculateMaintenaceCost(distance, fuelPrice);
			System.out.println("Maintenance cost of " + v.getBrand() + " " + v.getMake() + " is " + maintenanceCost);
			double fuelEfficiency = v.calculateFuelEfficiency(distance, fuelPrice);
			System.out.println("Fuel Efficiency cost of " + v.getBrand() + " " + v.getMake() + " is " + fuelEfficiency);
			v.startEngine();
			System.out.println("");
	    } 
		else 
		{
	        System.out.println("Invalid vehicle object. Cannot display information.");
	    }
	}
	
	//Aditya
	public void displayAllVehicleInformation() 
	{
		//loops through the arraylist of vehicle list and uses a toString(). to print all the vehicle information 
		if(vehicleList != null) {
			for(Vehicle vehicle: vehicleList) {
				System.out.println(vehicle.toString());
			}
		}
		
	}
	
	
	public boolean removeVehicle(Vehicle vehicle) {
		//Code similar to previous assignment, but loops through the arrayList of vehicleList to 
		//remove the specified vechile
	    if (vehicle != null) {
	        for (Vehicle v : vehicleList) {
	            if (v.equals(vehicle)) {
	                vehicleList.remove(v);
	                return true;
	            }
	        }
	    }
	    return false;
	}
//by nmc


	//Abhi made this code
	public boolean addVehicle(Vehicle vehicle) 
	{
		///Code similar to previous assignment, but adds the vehicle object to the end of the arrayList of vehicleList
		if(vehicle != null) {
			vehicleList.add(vehicle);
			return true;
		}
		return false;
	}
	
	//Aditya
	public boolean saveVehicleList() {
		//code similar to previous assignment,  and saves information onto CSV file and checks if it properly done. 
		//otherwise prints an error statement
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(vehicleFilePath, false));
			bw.write("Type,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType");
			bw.newLine();
			
		
			String type = null;
			
			for(Vehicle vehicle : vehicleList) {
				
				
				if(vehicle instanceof MotorBike) {
					type = "MotorBike";
				}
				if(vehicle instanceof SUV) {
					type = "SUV";
				}
				if(vehicle instanceof Car) {
					type = "Car";
				}
				if(vehicle instanceof Truck) {
					type = "Truck";
				}
				//Type,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType
				
				bw.write(type + "," + vehicle.getBrand() + "," + vehicle.getMake() + "," + vehicle.getModelYear() + "," + (vehicle.getPrice())+ "," + vehicle.getColor()+ "," + vehicle.getFuelType()+ "," + vehicle.getMileage()+ "," + vehicle.getMass()+ "," + vehicle.getCylinders()+ "," + vehicle.getGasTankCapacity()+ "," + vehicle.getStartType());
				bw.newLine();
			}
			bw.close();
			
			if (vehicleList.isEmpty()) {
				System.out.println("Cannot save empty stock.");
				return false;
			}
			
			System.out.println("Stock saved successfully.");
			return true;
				

			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
	}
	//matthew did this
	private boolean isVehicleType(Vehicle v, Class clazz) 
	{
		//determines if the class is a subclass of vehicle, if not returns false
		if(clazz.isInstance(v))
		{
			return true;
		}
	    return false;
	}
	
//nmc
	public int getNumberOfVehichlesByType(Class clazz) {
		//loops througs and if vehicle is correct, adds to count and prints the number of vehciles by the designated type
		int count = 0;
		for(Vehicle vehicle : vehicleList) {
			if(isVehicleType(vehicle, clazz)) {
				count++;
				
			}
		}
		//prints the number of vehicles of each type
		//call in main
		System.out.println("The number of " + clazz.getSimpleName() + "s: " + count);
		return count;
	}
//nmc
	//Abhi wrote this code
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice)
	{
		//checks if list is empty and prints an error, otherwise creates new arraylist and loops through 
		//with a for each loop and determines the lowest value for the fuel efficieny, uses the random if the values are the 
		//same to determine which to print
		if (vehicleList.isEmpty()) 
	 	{
            System.out.println("No vehicles in the list.");
            return new ArrayList<>();
	 	}
	 	ArrayList <Vehicle> lowestEfficientVehicles = new ArrayList<>();
        double lowestFuelEfficiency = Double.MAX_VALUE;

        for (Vehicle vehicle : vehicleList) {
            double fuelEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);

            if (fuelEfficiency < lowestFuelEfficiency) 
            {
                lowestFuelEfficiency = fuelEfficiency;
                lowestEfficientVehicles.clear();
                lowestEfficientVehicles.add(vehicle);
            } 
            else if (fuelEfficiency == lowestFuelEfficiency) 
            {
            	lowestEfficientVehicles.add(vehicle);
            }
        }
        return lowestEfficientVehicles;
    }
		
		
		
	

	//Abhi made this code.
	public Vehicle getVehicleWithHighestMaintenanceCost() 
	{
		//checks if list is empty and prints an error, otherwise creates new arraylist and loops through 
		//with a for each loop and determines the highest value for the maintenance cost, uses the random if the values are the 
		//same to determine which to print
		if (vehicleList.isEmpty()) 
	 	{
            System.out.println("No vehicles in the list.");
            return null;
	 	}
	 	
		Vehicle highestCostVehicle = null;
        double highestMaintenanceCost = Double.MIN_VALUE;

        for (Vehicle vehicle : vehicleList) {
            double maintenanceCost = vehicle.calculateMaintenaceCost(distance, fuelPrice);

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
	
	//matthew 
	public Vehicle getVehicleWithLowestMaintenanceCost() {
		//checks if list is empty and prints an error, otherwise creates new arraylist and loops through 
		//with a for each loop and determines the lowest value for the maintenance cost, uses the random if the values are the 
		//same to determine which to print
		 	if (vehicleList.isEmpty()) 
		 	{
	            System.out.println("No vehicles in the list.");
	            return null;
		 	}
		 	Vehicle lowestCostVehicle = null;
	        double lowestMaintenanceCost = Double.MAX_VALUE;

	        for (Vehicle vehicle : vehicleList) 
	        {
	            double maintenanceCost = vehicle.calculateMaintenaceCost(distance, fuelPrice);

	            if (maintenanceCost < lowestMaintenanceCost) 
	            {
	                lowestMaintenanceCost = maintenanceCost;
	                lowestCostVehicle = vehicle;
	            } 
	            else if (maintenanceCost == lowestMaintenanceCost) 
	            {
	                Random random = new Random();
	                if (random.nextBoolean()) 
	                {
	                    lowestCostVehicle = vehicle;
	                }
	            }
	        }
	        return lowestCostVehicle;
	    }
//nmc
	public double getAverageFuelEfficiencyofSUVs(double distance, double fuelPrice) {
		//loops through vehicle list and uses calculateFuelEfficieny to determine the average fuel efficieny of SUVs.
		//if the count is 0, prints an error message
		double totalFuelEfficiency = 0.0;
		int suvCount = 0;
		
		for(Vehicle vehicle : vehicleList) {
			if(isVehicleType(vehicle, SUV.class)) {
				double fuelEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
	            totalFuelEfficiency += fuelEfficiency;
	            suvCount++;
			}
		}
		if(suvCount == 0) {
			System.out.println("No SUVs exist in the list.");
			return -1.0;
		}
		return totalFuelEfficiency / suvCount;
	}
//nmc
	
	//Aditya
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice){
		//checks if list is empty and prints an error, otherwise creates new arraylist and loops through 
		//with a for each loop and determines the highest value for the fuel efficieny, uses the random if the values are the 
		//same to determine which to print
		if (vehicleList.isEmpty()) 
	 	{
            System.out.println("No vehicles in the list.");
            return new ArrayList<>();
	 	}
	 	ArrayList <Vehicle> highestEfficientVehicles = new ArrayList<>();
        double highestFuelEfficiency = Double.MIN_VALUE;

        for (Vehicle vehicle : vehicleList) {
            double fuelEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);

            if (fuelEfficiency > highestFuelEfficiency) 
            {
            	highestFuelEfficiency = fuelEfficiency;
            	highestEfficientVehicles.clear();
            	highestEfficientVehicles.add(vehicle);
            } 
            else if (fuelEfficiency == highestFuelEfficiency) 
            {
            	highestEfficientVehicles.add(vehicle);
            }
        }
        return highestEfficientVehicles;
	}
		
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

