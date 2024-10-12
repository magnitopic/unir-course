package Sprint3.Lab1;

import Sprint3.alaparic.src.main.java.com.alaparic.carregistry.model.Vehicle;

public class Motorbike extends Vehicle {
	Integer engineDisplacement;
	Boolean hasSidecar;

	// constructor

	public Motorbike(String brand, String model, Integer year, Integer engineDisplacement, Boolean hasSidecar) {
		super(brand, model, year);
		this.engineDisplacement = engineDisplacement;
		this.hasSidecar = hasSidecar;
	}

	// getters and setters

	public Integer getEngineDisplacement() {
		return engineDisplacement;
	}

	public void setEngineDisplacement(Integer engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}

	public Boolean getHasSidecar() {
		return hasSidecar;
	}

	public void setHasSidecar(Boolean hasSidecar) {
		this.hasSidecar = hasSidecar;
	}

	// methods

	public static void wheelie() {
		System.out.println("Wheelie");
	}

	public static void putHelmet() {
		System.out.println("Helmet on");
	}

	@Override
	public String toString() {
		return "· Type of vehicle= Motorbike, Brand=" + brand + ", Model=" + model + ", Engine Displacement="
				+ engineDisplacement
				+ ", Year=" + year + ", Has Sidecar=" + hasSidecar;
	}

}
