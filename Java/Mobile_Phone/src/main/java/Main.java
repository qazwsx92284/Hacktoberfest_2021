public class Main {

    public static void main(String[] args) {
        MobilePhone mp = new MobilePhone("1112223333");
        Contact c1 = new Contact("David", "1111112222");
        Contact c2 = new Contact("Jake", "1231231234");
        Contact c3 = new Contact("James", "2223334444");

        mp.addNewContact(c1);
        mp.addNewContact(c2);
        mp.addNewContact(c3);

        mp.printContacts();
        System.out.println("-------------------");

        Contact c4 = new Contact("Jacob", "1231231234");
        Contact c5 = new Contact("Mark", "7777777777");
        mp.updateContact(c4,c2);
        mp.printContacts();

        System.out.println("-------------------");
        mp.updateContact(c5,c2);
        mp.removeContact(c1);
        mp.printContacts();

        System.out.println("-------------------");
        System.out.println(mp.queryContact("mark"));
        System.out.println(mp.queryContact("jake"));

        System.out.println("-------------------");
        MobilePhone mp2 = new MobilePhone("1112223333");
        mp2.addNewContact(c1);
        mp2.printContacts();
    }
}
