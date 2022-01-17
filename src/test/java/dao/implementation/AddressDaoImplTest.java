package dao.implementation;

import entity.Address;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressDaoImplTest {
    static long id;

    @Test
    @Order(1)
    void add() {
        Address address = new Address();
        address.setCountry("Morrocco");
        address.setCity("Casablanca");
        address.setStreet("5 rue Ait Baha ");

        address = new AddressDaoImpl().add(address);
        assertInstanceOf(Address.class, address);
        this.id = address.getIdAddress();
    }

    @Test
    @Order(2)
    void find() {
        assertInstanceOf(Address.class, new AddressDaoImpl().find(id));
    }

    @Test
    @Order(3)
    void getAll() {
        assertInstanceOf(new ArrayList<Address>().getClass(), new AddressDaoImpl().getAll());
    }

    @Test
    @Order(4)
    void update() {
        Address address = new Address();


        address.setIdAddress(id);
        address.setCountry("Morrocco");
        address.setCity("Casablanca");
        address.setStreet("5 rue Ait Baha ");
        address = new AddressDaoImpl().update(address);
        assertInstanceOf(Address.class, address);

    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(new AddressDaoImpl().delete(id));
    }

}