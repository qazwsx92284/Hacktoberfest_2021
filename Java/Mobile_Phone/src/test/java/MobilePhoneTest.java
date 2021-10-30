import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobilePhoneTest {

    private static MobilePhone mp = new MobilePhone("1112223333");
    private static Contact c0 = new Contact("Ann", "9999999999");
    private static Contact c1 = new Contact("David", "1111112222");
    private static Contact c2 = new Contact("Jake", "1231231234");
    private static Contact c3 = new Contact("James", "2223334444");

    @BeforeAll
    public static void init() {
        mp.addNewContact(c0);
    }

    @Test
    public void addNewContactTest() {
        boolean actualReturnVal = mp.addNewContact(c1);
        assertEquals(c1, c1);
        assertEquals("David", c1.getName());
        assertEquals("1111112222", c1.getPhoneNumber());
        assertTrue(actualReturnVal);
    }

    @Test
    public void updateContactTest() {
        boolean actualReturnVal = mp.addNewContact(c0);
        mp.updateContact(c2,c0);
        assertEquals(c2, mp.queryContact("Jake"));
        assertTrue(actualReturnVal);
    }

    @Test
    public void removeContactTest() {
        assertNotNull(mp);
        boolean actualReturnVal = mp.removeContact(c0);
        assertNull(mp.queryContact(c0.getName()));
        assertTrue(actualReturnVal);
    }

    @Test
    public void queryContactTest() {
        Contact actualContact = mp.queryContact(c0.getName());
        assertEquals(c0, actualContact);
    }
    
    @Test
    public void queryContactNotFoundTest() {
        Contact notFoundContact = mp.queryContact("Alice");
        assertNull(notFoundContact);
    }
}
