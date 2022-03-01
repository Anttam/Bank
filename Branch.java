import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    //constructor & getter
    public Branch(String name) {
        this.customers = new ArrayList<Customer>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //create new branch method
    public static Branch createBranch(String name) {
        return new Branch(name);
    }

    // adding methods
    public void addCustomer(String name, double initialTransaction) {
        for (int i = 0; i < customers.size(); i++) {
            if (findCustomer(name) != -1) {
                System.out.println("Customer already exists");
                return;
            }
        }
        customers.add(Customer.createCustomer(name));
        addTransaction(name, initialTransaction);
        System.out.println(name + " added to " + this.name + " branch");
    }

    public void addTransaction(String customerName, double amount) {
        if (findCustomer(customerName) != -1) {
            customers.get(findCustomer(customerName)).getTransactions().add(amount);
            System.out.println("Transaction of " + amount + " added to: " + customerName);
            calculateBalance(customerName);
        } else {
            System.out.println(customerName + " not found.");
        }
    }

    //printing methods

    public void printAllCustomers(boolean andTransaction) {
        System.out.println("Customers:");
        for (int i = 0; i < customers.size(); i++) {
            printCustomer(customers.get(i).getName(), andTransaction);
        }
    }

    // separate method to print individual customers for their transactions only (future implementation)
    public void printCustomer(String customerName, boolean andTransaction) {
        int customerIndex = findCustomer(customerName);
        if (customerIndex >= 0) {
            System.out.println("    " + customers.get(findCustomer(customerName)).getName());
        }
        if (andTransaction) {
            System.out.print("      Transactions:\n");
            for (int i = 0; i < customers.get(customerIndex).getTransactions().size(); i++) {
                System.out.println("        " + customers.get(customerIndex).getTransactions().get(i));
            }
            System.out.println("    Current Balance: " + customers.get(customerIndex).getBalance());
        }
    }

    //findCustomer is public, so it can also be used in the Bank class

    public int findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }

    // calculating is private as it is not used outside the branch class

    private void calculateBalance(String customerName) {
        if (findCustomer(customerName) != -1) {
            double total = 0;
            for (int i = 0; i < customers.get(findCustomer(customerName)).getTransactions().size(); i++) {
                total += customers.get(findCustomer(customerName)).getTransactions().get(i);
            }
            customers.get(findCustomer(customerName)).setBalance(total);
        }

    }
}