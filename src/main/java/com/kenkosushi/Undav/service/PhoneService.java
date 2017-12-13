package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.Phone;
import com.kenkosushi.Undav.domain.model.User;
import com.kenkosushi.Undav.domain.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PhoneService {

    private PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository){
        this.phoneRepository=phoneRepository;
    }

    public Phone findById(Long id){
        return phoneRepository.findOne(id);
    }

    public Collection<Phone> findAll(){
        return phoneRepository.findAll();
    }

    public void save(Phone phone){
        phoneRepository.save(phone);
    }

    public void update(Phone phone){
        phoneRepository.save(phone);
    }

    public void delete(Long id){
        phoneRepository.delete(id);
    }

    public Collection<Phone> findByUserId(User userId){
        return phoneRepository.findByUser(userId);
    }
}
