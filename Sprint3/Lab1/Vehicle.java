package Sprint3.Lab1;

public class Vehicle {
	String brand;
	String model;
	int year;

	// constructor
	public Vehicle(String brand, String model, int year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
	}

	// getters and setters

	public static void startEngine() {
		System.out.println("Engine started");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	// methods
	public static void accelerate(int speed) {
		System.out.println("Accelerating");
	}

	public static void brake(int speed) {
		System.out.println("Breaking");
	}

}
