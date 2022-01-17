package repository;

import entity.Address;

import java.util.ArrayList;

public interface AddressRepo {

    Address add(Address address);
    Address find(long id);
    ArrayList<Address> getAll();
    Address update(Address address);
    boolean delete(long id);
}
