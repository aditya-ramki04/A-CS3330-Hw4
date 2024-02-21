package edu.mu.VehicleManager;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import edu.mu.Vehicle.Vehicle;


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
				String color = parts[5];
				String fuelType = parts[6];
				String mileage = parts[7];
				double mass = Double.parseDouble(parts[8]);
				int cylinders = Integer.parseInt(parts[9]);
				int gasTankCapacity = Integer.parseInt(parts[10]);
				String startType = parts[11];
				if(type.equals("Truck"))
					{
						vehicleList.add(new Truck(model, make, modelYear, price, color,
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
	
//	public void VehicleManager(String fileName) {
//		
//	}
	
//	public void displayAllCarInformation() {
//		
//	}
	
//	public void displayAllTruckInformation() {
//		
//	}
//	
//	public void displayAllSUVInformation() {
//		
//	}
//	
//	public void displayAllMotorBikeInformation() {
//		
//	}
	
//	public void displayVehicleInformation(Vehicle v){
//		
//	}
	
//	public void displayAllVehicleInformation() {
//		
//	}
	
//	public boolean removeVehicle(Vehicle vehicle) {
//		
//	}
	
	//Abhi added this code to correctly instantiate vehicleList
	public ArrayList<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(ArrayList<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
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
	
//	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
//		
//	}
	
//	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
