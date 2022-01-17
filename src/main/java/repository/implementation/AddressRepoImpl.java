package repository.implementation;

import dao.AddressDao;
import dao.implementation.AddressDaoImpl;
import entity.Address;
import repository.AddressRepo;

import java.util.ArrayList;

public class AddressRepoImpl implements AddressRepo {
    private AddressDaoImpl addressDao = new AddressDaoImpl();
    @Override
    public Address add(Address address) {
        return addressDao.add(address);
    }

    @Override
    public Address find(long id) {
        return addressDao.find(id);
    }

    @Override
    public ArrayList<Address> getAll() {
        return addressDao.getAll();
    }

    @Override
    public Address update(Address address) {
        return addressDao.update(address);
    }

    @Override
    public boolean delete(long id) {
        return addressDao.delete(id);
    }
}
