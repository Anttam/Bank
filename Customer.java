import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;
    private double Balance;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
    }

    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public double getBalance() {
        return Balance;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
