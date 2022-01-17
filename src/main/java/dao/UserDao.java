package dao;

import entity.Users;

import java.util.ArrayList;

public interface UserDao {


    Users find(long id);
    ArrayList<Users> getAll();
    Users add(Users user);
    Users update(Users user);
    boolean delete(long id);
}
