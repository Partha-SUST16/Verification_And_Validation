import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
class AccountTest {
    private static Account account;
    @BeforeAll
    static void Ini(){
        System.out.println("Hii");
         account = new Account("abc","12345");
    }
    @Test
    void getName() {
        System.out.println("1");
        assertEquals("abc",account.getName());
        assertEquals("bcd",account.getName());
    }

    @Test
    void setName() {
        System.out.println("2");
        account.setName("bcd");
        assertEquals("bcd",account.getName());
    }

    @Test
    void getPassword() {
        System.out.println(3);
        assertEquals("12345",account.getPassword());
    }
    @Test
    void getlessTwoChar(){
        account.setPassword("1");
        assertEquals("HII",account.getPassword());
    }

    @Test
    void setPassword() {
        System.out.println(4);
        account.setPassword("bcd");
        assertEquals("bcd",account.getPassword());
    }
}