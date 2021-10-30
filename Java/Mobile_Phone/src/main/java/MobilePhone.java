import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private List<Contact> contacts;
    private String number;

    public MobilePhone(String phoneNumber) {
        this.number = phoneNumber;
        contacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact newContact) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(newContact.getName()) || contact.getPhoneNumber().equals(newContact.getPhoneNumber())) {
                return false;
            }
        }
        contacts.add(newContact);
        return true;
    }

    public boolean updateContact(Contact newContact, Contact oldContact) {
        int index = findContact(oldContact);
        if(index>=0) {
            contacts.set(index, newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if(index >= 0) {
            contacts.remove(index);
            return true;
        }
        return false;
    }

    private int findContact(Contact target_contact) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(target_contact.getName()) || contact.getPhoneNumber().equals(target_contact.getPhoneNumber())) {
                return contacts.indexOf(contact);
            }
        }
        return -1;
    }

    private int findContact(String nameOrPhoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(nameOrPhoneNumber) || contact.getPhoneNumber().equalsIgnoreCase(nameOrPhoneNumber)) {
                return contacts.indexOf(contact);
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if(index>=0) {
            return contacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        for(Contact contact : contacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }


}