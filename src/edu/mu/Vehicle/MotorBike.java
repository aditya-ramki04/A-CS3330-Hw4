package edu.mu.Vehicle;

public class MotorBike extends Vehicle{

	public MotorBike(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateMaintenaceCost(double distance, double fuelPrice) 
	{
		//uses the formula given to calculate the maintenance and returns it
		double maintenance = distance * mass * (2024 - modelYear) * cylinders * 0.0002;
		return maintenance;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) 
	{
		//uses the formula given to calculate the fuel efficiency and returns it
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice/distance *0.001;
		return fuelEfficiency;
		
	}

	@Override
	public void startEngine() 
	{
		//prints how the vehicle starts
		System.out.println("The MotorBike has started using " + startType + "!");
		
	}

}
