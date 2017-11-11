package com.kenkosushi.Undav.service;


import com.kenkosushi.Undav.domain.model.Address;
import com.kenkosushi.Undav.domain.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;



/**
 * Created by leo on 11/9/17.
 */

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address findById(Long id){
        return addressRepository.findOne(id);
    }

    public Collection<Address> findAll(){
        return addressRepository.findAll();
    }

    public void save(Address address){
        addressRepository.save(address);
    }

    public void update(Address address){
        addressRepository.save(address);
    }

    public void delete(Long id){
        addressRepository.delete(id);
    }


}
