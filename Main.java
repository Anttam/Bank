import java.util.Scanner;

public class Main {
    private static Bank myBank = new Bank();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;

        actions();
        while (!quit) {
            System.out.println("6. to list actions");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("closing...");
                    scanner.close();
                    quit = true;
                    break;
                case 1:
                    listBranches();
                    break;
                case 2:
                    listCustomers();
                    break;
                case 3:
                    addBranch();
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    addTransaction();
                    break;
                case 6:
                    actions();
                    break;

            }
        }
    }

    // List actions method

    private static void actions() {
        System.out.println(
                "0. exit\n"
                        + "1. list branches\n"
                        + "2. list customers\n"
                        + "3. add branch\n"
                        + "4. add customer\n"
                        + "5. add transaction\n"
        );
    }

    // action methods

    private static void listBranches() {
        System.out.println("would you to see the customers? (1 = yes 2 = no)");
        String seeCustomers = scanner.nextLine();
        System.out.println("would you to see the customers' transactions? (1 = yes 2 = no)");
        String seeTransactions = scanner.nextLine();
        myBank.printAllBranches(checkForYes(seeCustomers), checkForYes(seeTransactions));
    }

    public static void listCustomers() {
        boolean andTransactions = false;
        System.out.println("Enter branch name");
        String branchName = scanner.nextLine();
        System.out.println("would you like to see transactions?(1 = yes 2 = no)");
        String seeTransactions = scanner.nextLine();
        myBank.printBranchCustomers(branchName, checkForYes(seeTransactions));
    }

    public static void addBranch() {
        System.out.println("Enter new branch name:");
        String name = scanner.nextLine();
        myBank.addBranch(name);
    }

    public static void addCustomer() {
        System.out.println("Enter branch name:");
        String branchName = scanner.nextLine();
        System.out.println("Enter new customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter the initial deposit amount:");
        double initialAmount = scanner.nextDouble();
        scanner.nextLine();
        myBank.addCustomer(branchName, customerName, initialAmount);
    }

    public static void addTransaction() {
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter Transaction amount ('-' for a withdraw)");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        myBank.addTransaction(customerName, amount);
    }

    // used to allow different inputs

    public static boolean checkForYes(String input) {
        return input.equalsIgnoreCase("yes")
                || input.equalsIgnoreCase("y")
                || input.equalsIgnoreCase("1");
    }

}
