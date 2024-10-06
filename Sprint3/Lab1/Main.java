package Sprint3.Lab1;

import java.util.ArrayList;
import java.util.Scanner;

import Sprint3.Lab1.Vehicle;

public class Main {

	public static void main(String[] args) {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		do {
			showFirstMenu();
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid option");
				continue;
			}
			handleSecondMenu(option, vehicles, scanner);
		} while (option != 3);
		System.out.println("Goodbye");
	}

	private static void handleSecondMenu(int option, ArrayList<Vehicle> vehicles, Scanner scanner) {
		switch (option) {
			case 1:
				handleSecondMenuOptOne(vehicles, scanner);
				break;
			case 2:
				handleSecondMenuOptTwo(vehicles, scanner);
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid option");
				break;
		}
	}

	private static void handleSecondMenuOptOne(ArrayList<Vehicle> vehicles, Scanner scanner) {
		showSecondMenuOptOne();
		int option;
		try {
			option = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("Invalid option");
			return;
		}
		switch (option) {
			case 1:
				addCar(vehicles, scanner);
				break;
			case 2:
				addMotorbike(vehicles, scanner);
				break;
			default:
				System.out.println("Invalid option");
				break;
		}
	}

	private static void handleSecondMenuOptTwo(ArrayList<Vehicle> vehicles, Scanner scanner) {
		showSecondMenuOptTwo();
		int option = Integer.parseInt(scanner.nextLine());
		switch (option) {
			case 1:
				showAllVehicles(vehicles);
				break;
			case 2:
				showTypeOfVehicles(vehicles, scanner);
				break;
			case 3:
				showVehiclesByBrand(vehicles, scanner);
				break;
			default:
				System.out.println("Invalid option");
				break;
		}
	}

	private static void showFirstMenu() {
		System.out.println("1. Add a vehicle");
		System.out.println("2. Show vehicles");
		System.out.println("3. Exit");
		System.out.println("__________________________");
	}

	private static void showSecondMenuOptOne() {
		System.out.println("1. Add a car");
		System.out.println("2. Add a motorbike");
	}

	private static void showSecondMenuOptTwo() {
		System.out.println("1. Show all vehicles");
		System.out.println("2. Show type of vehicles");
		System.out.println("3. Show vehicles by brand");
	}

	private static void addCar(ArrayList<Vehicle> vehicles, Scanner scanner) {
		System.out.println("Enter the brand of the car");
		String brand = scanner.nextLine();
		System.out.println("Enter the model of the car");
		String model = scanner.nextLine();
		System.out.println("Enter the year of the car");
		int year = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter the number of doors of the car");
		int numberOfDoors = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter if the car is convertible (true/false)");
		boolean inConvertible = Boolean.parseBoolean(scanner.nextLine());
		vehicles.add(new Car(brand, model, year, numberOfDoors, inConvertible));
	}

	private static void addMotorbike(ArrayList<Vehicle> vehicles, Scanner scanner) {
		System.out.println("Enter the brand of the motorbike");
		String brand = scanner.nextLine();
		System.out.println("Enter the model of the motorbike");
		String model = scanner.nextLine();
		System.out.println("Enter the year of the motorbike");
		int year = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter the engine displacement of the motorbike");
		int engineDisplacement = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter if the motorbike has a sidecar (true/false)");
		boolean hasSidecar = Boolean.parseBoolean(scanner.nextLine());
		vehicles.add(new Motorbike(brand, model, year, engineDisplacement, hasSidecar));
	}

	private static void showAllVehicles(ArrayList<Vehicle> vehicles) {
		System.out.println("________________");
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.toString());
		}
		System.out.println("________________");
	}

	private static void showTypeOfVehicles(ArrayList<Vehicle> vehicles, Scanner scanner) {
		System.out.println("Enter the type of vehicle (car/motorbike)");
		String type = scanner.nextLine();
		System.out.println("________________");
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getClass().getSimpleName().equals(type)) {
				System.out.println(vehicle);
			}
		}
		System.out.println("________________");
	}

	private static void showVehiclesByBrand(ArrayList<Vehicle> vehicles, Scanner scanner) {
		System.out.println("Enter the brand of the vehicle");
		String brand = scanner.nextLine();
		System.out.println("________________");
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getBrand().equals(brand)) {
				System.out.println(vehicle);
			}
		}
		System.out.println("________________");
	}
}
