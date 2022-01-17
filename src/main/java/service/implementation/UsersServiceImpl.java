package service.implementation;

import entity.Users;
import repository.implementation.UserRepoImpl;

import java.util.ArrayList;

public class UsersServiceImpl implements service.UsersService {
    private UserRepoImpl userRepo = new UserRepoImpl();
    @Override
    public int login(String Email, String Password) {
        return userRepo.login(Email,Password);
    }

    @Override
    public void logout() {

    }

    @Override
    public boolean updatePasswordById(String newPassword, long user_id) {
        return userRepo.updatePasswordById(newPassword, user_id);
    }

    @Override
    public Users find(long id) {
        return userRepo.find(id);
    }

    @Override
    public Users findByEmail(String Email) {
        return userRepo.findByEmail(Email);
    }

    @Override
    public ArrayList<Users> getAll() {
        return userRepo.getAll();
    }

    @Override
    public Users add(Users user) {
        return userRepo.add(user);
    }

    @Override
    public Users update(Users user) {
        return userRepo.update(user);
    }

    @Override
    public boolean delete(long id) {
        return userRepo.delete(id);
    }
}
