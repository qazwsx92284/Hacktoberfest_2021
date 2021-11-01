import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private List<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customer_name, String account_number, double initial_transaction) {
        if(findCustomer(account_number) == null) {
            customers.add(new Customer(customer_name,account_number,initial_transaction));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String account_number, double transaction) {
        Customer customer = findCustomer(account_number);
        if(customer!=null) {
            customer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    public Customer findCustomer(String account_number) {
        if(customers!=null) {
            for(Customer customer : customers) {
                if(customer.getAccount_number().equals(account_number)) {
                    return customer;
                }
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
