package dao;

import entity.Role;

import java.util.ArrayList;

public interface RoleDao {
    Role add(Role role);
    Role find(long id);
    ArrayList<Role> getAll();
    Role update(Role role);
    boolean delete(long id);
}
