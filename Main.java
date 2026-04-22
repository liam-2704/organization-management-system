import java.util.Scanner;

public class Main {

    private static Group organization = null;

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
                    createOrganization();
                    organization.print(0);
                    break;

                case "2":
                    if (organization == null) {
                        System.out.println("Organization not created yet.");
                        break;
                    }

                    organization.print(0);

                    System.out.println("Enter group name: ");
                    String groupName = scanner.nextLine();

                    Group targetGroup = organization.findGroup(groupName);

                    if (targetGroup == null) {
                        System.out.println("Group not found.");
                        break;
                    }

                    System.out.print("Enter new worker name: ");
                    String workerName = scanner.nextLine();
                    System.out.println(workerName + " is added.");

                    targetGroup.add(new Worker(workerName));

                    System.out.println();
                    organization.print(0);
                    break;

                case "3":

                    System.out.println();
                    organization.print(0);
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

    private static void createOrganization() {

        organization = new Group("ABC Company", "Hoang Lam Duong", "Alexander Barbu");

        Group accounting = new Group("Accounting", "Leo Matsu");
        Group engineering = new Group("Engineering", "Raf Jabbari");
        Group marketing = new Group("Marketing", "Steve Rogers");

        accounting.add(new Worker("Rares Barbu"));
        accounting.add(new Worker("Wally Allan"));
        accounting.add(new Worker("Cris Evans"));

        engineering.add(new Worker("Illia Hormone"));
        engineering.add(new Worker("Mickey Mouse"));
        engineering.add(new Worker("LeBrone James"));

        marketing.add(new Worker("Stephen Curry"));
        marketing.add(new Worker("Michael Jackson"));
        marketing.add(new Worker("Drake"));

        organization.add(accounting);
        organization.add(engineering);
        organization.add(marketing);
    }
}
