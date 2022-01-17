package dao.implementation;

import entity.Address;
import entity.Role;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoleDaoImplTest {

    static long id;

    @Test
    @Order(2)
    void find() {
    }

    @Test
    @Order(3)
    void getAll() {

        assertInstanceOf(new ArrayList<Address>().getClass(), new RoleDaoImpl().getAll());
    }

    @Test
    @Order(1)
    void add() {
        Role role = new Role();
        role.setName("Test");
        role = new RoleDaoImpl().add(role);
        assertInstanceOf(Address.class, role);
        this.id = role.getId_role();
    }

    @Test
    @Order(4)
    void update() {
        Role role = new Role();
        role.setName("TestUpdate");
        role = new RoleDaoImpl().update(role);
        assertInstanceOf(Address.class, role);

    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(new RoleDaoImpl().delete(id));
    }
}