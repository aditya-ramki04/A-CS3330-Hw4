package edu.mu.Vehicle;

public class SUV extends Vehicle {

	public SUV(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateMaintenaceCost(double distance, double fuelPrice) 
	{
		double maintenance = distance * mass * (2024 - modelYear) * cylinders * 0.001;
		return maintenance;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) 
	{
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice/distance *0.05;
		return fuelEfficiency;
		
	}

	@Override
	public void startEngine() {
		System.out.println("The SUV has started using " + startType + "!");
		
	}

}