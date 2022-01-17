package repository;

import entity.Role;

import java.util.ArrayList;

public interface RoleRepo {

    Role add(Role role);
    Role find(long id);
    Role findByName(String roleName);
    ArrayList<Role> getAll();
    Role update(Role role);
    boolean delete(long id);

}
