import java.util.Scanner;

public class oms {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (true) {

            System.out.println("Organization management system");
            System.out.println("------------------------------");
            System.out.println();
            System.out.println("1. Create and print hard coded organization");
            System.out.println("2. Print organization, add person to it and finally print it");
            System.out.println("3. Print organization, remove person from it and finally print it");
            System.out.println();
            System.out.println("Q. Quit the application");
            System.out.println();
            System.out.print("Your choice: ");

            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                break;
            }

            switch (choice) {
                case "1":
                    System.out.println("Choice 1 not implemented.");
                    break;
                case "2":
                    System.out.println("Choice 2 not implemented.");
                    break;
                case "3":
                    System.out.println("Choice 3 not implemented.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println();
        }

        System.out.println("Process finished with exit code 0");
        scanner.close();
    }
}
