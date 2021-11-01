import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String account_number;
    private List<Double> transactions;

    public Customer(String name, String account_number, double initial_transaction) {
        this.name = name;
        transactions = new ArrayList<Double>();
        transactions.add(initial_transaction);
    }

    public String getAccount_number() {
        return account_number;
    }

    public String getName() {
        return name;
    }

    public List<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", account_number='" + account_number + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
