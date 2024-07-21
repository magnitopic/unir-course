package Sprint0.java;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the the administration system!");
        System.out.println("Please select an option from the menu below:");
        System.out.println("1. Add names");
        System.out.println("2. View names");
        System.out.println("3. Exit");
        Names names = new Names();
        names.showMenu();
    }
}
