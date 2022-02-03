import dao.implementation.AddressDaoImpl;
import dao.implementation.RoleDaoImpl;
import dao.implementation.UsersDaoImpl;
import entity.Address;
import entity.Role;
import entity.Users;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsersDaoImplTest {

    static long id;

    @Test
    @Order(1)
    void add() {
        Address address = new Address();
        Role role = new RoleDaoImpl().find(1L);

        Users user = new Users();
        address.setCountry("Morrocco");
        address.setCity("Casablanca");
        address.setStreet("5 rue Ait Baha ");
        address = new AddressDaoImpl().add(address);
        user.setRole(role);
        user.setAddress(address);
        user.setFirst_name("Youssef");
        user.setLast_name("Diouani");
        user.setEmail("admin@gmail.com");
        user.setPassword("admin");
        System.out.println(address);
        System.out.println(role);
        user = new UsersDaoImpl().add(user);
        assertInstanceOf(Users.class, user);


        this.id = user.getUserId();
    }

    @Test
    @Order(2)
    void find() {
        System.out.println(id);

        assertInstanceOf(Users.class, new UsersDaoImpl().find((int)id));
    }

    @Test
    @Order(3)
    void getAll() {
        assertInstanceOf(new ArrayList<Users>().getClass(), new UsersDaoImpl().getAll());
    }

    @Test
    @Order(4)
    void update() {
        Users user = new UsersDaoImpl().find(id);


        user.setFirst_name("update");
        user.setLast_name("update");
        user.setEmail("admin@gmail.com");
        user.setPassword("admin");

        user = new UsersDaoImpl().update(user);
        assertInstanceOf(Users.class, user);

    }

    @Test
    @Order(5)
    void delete() {



       assertTrue(new UsersDaoImpl().delete(id));
    }
}