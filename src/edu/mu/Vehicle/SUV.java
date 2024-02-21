package edu.mu.Vehicle;

public class SUV extends Vehicle {

	public SUV(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calculateMaintenaceCost(double distance, double fuelPrice) {
		// TODO Auto-generated method stub
		
    }
		

	@Override
	public void calculateFuelEfficency(double distance, double fuelPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
		
	}

}
