package com.alaparic.carregistry.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Car extends Vehicle {
	Integer numberOfDoors;
	Boolean inConvertible;

	// constructor

	public Car() {}

	public Car(String brand, String model, Integer year, Integer numberOfDoors, Boolean inConvertible) {
		super(brand, model, year);
		this.numberOfDoors = numberOfDoors;
		this.inConvertible = inConvertible;
	}

	// getters and setters

	public Integer getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(Integer numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public Boolean getInConvertible() {
		return inConvertible;
	}

	public void setInConvertible(Boolean inConvertible) {
		this.inConvertible = inConvertible;
	}

	// methods

	public static void honk() {
		System.out.println("Honk");
	}

	public static void putSeatbelt() {
		System.out.println("Seatbelt on");
	}

	public static void drift() {
		System.out.println("Drifting");
	}

	@Override
	public String toString() {
		return "· Type of vehicle= Car, Brand=" + brand + ", Model=" + model + ", Year=" + year + ", Number Of Doors="
				+ numberOfDoors
				+ ", Is a Convertible=" + inConvertible;
	}

}
