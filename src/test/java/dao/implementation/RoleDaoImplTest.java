package dao.implementation;

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
class RoleDaoImplTest {

    static long id;

    @Test
    @Order(2)
    void find() {
        assertInstanceOf(Role.class, new RoleDaoImpl().find(id));
    }

    @Test
    @Order(3)
    void getAll() {

        assertInstanceOf(new ArrayList<Role>().getClass(), new RoleDaoImpl().getAll());
    }

    @Test
    @Order(1)
    void add() {
        Role role = new Role();
        role.setName("Test");
        role = new RoleDaoImpl().add(role);
        assertInstanceOf(Role.class, role);
        this.id = role.getId_role();
    }

    @Test
    @Order(4)
    void update() {
        Role role = new RoleDaoImpl().find(id);
        role.setName("TestUpdate");
        role = new RoleDaoImpl().update(role);
        assertInstanceOf(Role.class, role);

    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(new RoleDaoImpl().delete(id));
    }
}