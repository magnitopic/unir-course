package Sprint0.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Names {

	private ArrayList<String> names = new ArrayList<String>();

	public void showMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		System.out.println("_".repeat(50));
		System.out.println();
		switch (choice) {
			case 1:
				this.addNames();
				break;
			case 2:
				this.viewNames();
				break;
			case 3:
				scanner.close();
				this.exit();
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
				break;
		}
	}

	public void addNames() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the names you would like to add separated by coma:");
		String input = scanner.nextLine();
		String[] names = input.split(",");
		for (String name : names) {
			this.names.add(name);
		}
		System.out.println("Done! Names have been added");
		scanner.close();
	}

	public void viewNames() {
		System.out.println("Curent names:");
		for (String name : this.names) {
			System.out.println(name);
		}
	}

	public void exit() {
		System.out.println("Thank you for using the administration system!");
		exit();
	}
}
