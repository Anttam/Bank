import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches;

    // constructor
    // no need for bank name because there is only 1 bank
    public Bank() {
        branches = new ArrayList<Branch>();
    }

    // adding methods

    public void addBranch(String name) {
        if (findBranch(name) >= 0) {
            System.out.println("Branch already exists");
        } else {
            branches.add(Branch.createBranch(name));
        }
    }

    public void addCustomer(String branchName, String customerName, double initialAmount) {
        if (findBranch(branchName) == -1) {
            System.out.println("branch not found. Customer was not added");
        } else {
            branches.get(findBranch(branchName)).addCustomer(customerName, initialAmount);
        }
    }

    public void addTransaction(String customerName, double amount) {
        if (findCustomerBranch(customerName) == -1) {
            System.out.println("Customer not found");
        } else {
            branches.get(findCustomerBranch(customerName)).addTransaction(customerName, amount);
        }
    }

    //printing methods

    public void printAllBranches(boolean andCustomers, boolean andTransactions) {
        for (int i = 0; i < branches.size(); i++) {
            System.out.println(branches.get(i).getName());
            if (andCustomers) {
                System.out.print("  ");
                printBranchCustomers(branches.get(i).getName(), andTransactions);
            }
        }
    }

    public void printBranchCustomers(String branchName, boolean andTransactions) {
        int branchIndex = findBranch(branchName);
        if (branchIndex >= 0) {
            branches.get(branchIndex).printAllCustomers(andTransactions);
        }
    }

    //private methods for searching

    private int findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    private int findCustomerBranch(String customerName) {
        for (int i = 0; i < branches.size(); i++) {
            branches.get(i).findCustomer(customerName);
            if (branches.get(i).findCustomer(customerName) >= 0) {
                return i;
            }
        }
        return -1;
    }

}


