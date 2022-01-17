package repository;

import entity.Users;

import java.util.ArrayList;

public interface UserRepo {
    int login(String Email, String Password);
    void logout();
    boolean updatePasswordById(String newPassword, long user_id);
    Users find(long id);
    Users findByEmail(String Email);
    ArrayList<Users> getAll();
    Users add(Users user);
    Users update(Users user);
    boolean delete(long id);

}
