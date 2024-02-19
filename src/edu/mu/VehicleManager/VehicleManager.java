package edu.mu.VehicleManager;

import java.util.ArrayList;

import edu.mu.Vehicle.Vehicle;


public class VehicleManager {

	private static VehicleManager instance = null;
	// Define paths as final so that they cannot be modified later.
	private final static String vehicleFilePath = "vehicleList.csv";
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

//	public boolean readFromFile(String fileName) {
//		
//	}
	
//	public void VehicleManager(String fileName) {
//		
//	}
	
//	public void displayAllCarInformation() {
//		
//	}
	
//	public void displayAllTruckInformation() {
//		
//	}
	
//	public void displayAllSUVInformation() {
//		
//	}
	
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
	
//	public boolean addVehicle(Vehicle vehicle) {
//		
//	}
	
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
