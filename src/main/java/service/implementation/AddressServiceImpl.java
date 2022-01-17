package service.implementation;

import entity.Address;
import repository.implementation.AddressRepoImpl;
import service.AddressService;

import java.util.ArrayList;

public class AddressServiceImpl implements AddressService {
    private AddressRepoImpl addressRepo = new AddressRepoImpl();
    @Override
    public Address add(Address address) {
        return addressRepo.add(address);
    }

    @Override
    public Address find(long id) {
        return addressRepo.find(id);
    }

    @Override
    public ArrayList<Address> getAll() {
        return addressRepo.getAll();
    }

    @Override
    public Address update(Address address) {
        return addressRepo.update(address);
    }

    @Override
    public boolean delete(long id) {
        return addressRepo.delete(id);
    }
}
