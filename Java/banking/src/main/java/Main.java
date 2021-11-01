public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Woori");

        bank.addBranch("NYC");

        bank.addCustomer("NYC", "1111111111", "Jack", 100.50);
        bank.addCustomer("NYC", "2222222222", "David", 50.50);

        bank.addCustomerTransaction("NYC", "1111111111", 50.50);
        bank.addCustomerTransaction("NYC", "2222222222", 40.40);

        bank.listCustomers("NYC", true);

    }
}
