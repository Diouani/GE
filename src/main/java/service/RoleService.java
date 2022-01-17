package service;

import entity.Role;

import java.util.ArrayList;

public interface RoleService {
    Role add(Role role);
    Role find(long id);
    Role findByName(String roleName);
    ArrayList<Role> getAll();
    Role update(Role role);
    boolean delete(long id);
}
