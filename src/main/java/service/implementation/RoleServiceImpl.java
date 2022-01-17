package service.implementation;

import entity.Role;
import repository.implementation.RoleRepoImpl;
import service.RoleService;

import java.util.ArrayList;

public class RoleServiceImpl implements RoleService {
    private RoleRepoImpl roleRepo = new RoleRepoImpl();
    @Override
    public Role add(Role role) {
        return roleRepo.add(role);
    }

    @Override
    public Role find(long id) {
        return roleRepo.find(id);
    }

    @Override
    public Role findByName(String roleName) {
        return roleRepo.findByName(roleName);
    }

    @Override
    public ArrayList<Role> getAll() {
        return roleRepo.getAll();
    }

    @Override
    public Role update(Role role) {
        return roleRepo.update(role);
    }

    @Override
    public boolean delete(long id) {
        return roleRepo.delete(id);
    }
}
