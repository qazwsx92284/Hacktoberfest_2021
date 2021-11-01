import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branch_name) {
        if(findBranch(branch_name)==null) {
            branches.add(new Branch(branch_name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branch_name, String account_number ,String customer_name, double initial_transaction) {
        Branch branch = findBranch(branch_name);
        if(branch != null) {
            if(branch.findCustomer(account_number) == null) {
                branch.newCustomer(customer_name, account_number, initial_transaction);
                return true;
            }
        }
        return false;
    }

    public boolean addCustomerTransaction(String branch_name, String account_number, double transaction) {
        Branch branch = findBranch(branch_name);
        if(branch != null) {
            Customer customer = branch.findCustomer(account_number);
            customer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    private Branch findBranch(String branch_name) {
        for(Branch branch : branches) {
            if(branch.getName().equalsIgnoreCase(branch_name)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branch_name, boolean print_transaction) {
        Branch branch = findBranch(branch_name);
        if(branch!=null) {
            System.out.println("Customer details for branch" + branch_name);
            for(Customer customer : branch.getCustomers()) {
                System.out.println("Customer : " + customer.getName());
                System.out.println("Accnt# : " + customer.getAccount_number());
                System.out.println("Transactions");
                System.out.println(customer.getTransactions());
            }

            return true;
        }

        return false;
    }
}
