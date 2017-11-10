package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.Phone;
import com.kenkosushi.Undav.domain.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
