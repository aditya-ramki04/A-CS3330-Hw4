package edu.mu.Vehicle;

public class Truck extends Vehicle 
{	
	//Abhi made this code
	
	public Truck(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) 
	{
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public double calculateMaintenaceCost(double distance, double fuelPrice) 
	{
		double maintenance = distance * mass * (2024 - modelYear) * cylinders * 0.002;
		return maintenance;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) 
	{
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice/distance *0.1;
		return fuelEfficiency;
		
	}

	@Override
	public void startEngine() {
		System.out.println("The truck has started using " + startType + "!");
		
	}
	
	
	
}
