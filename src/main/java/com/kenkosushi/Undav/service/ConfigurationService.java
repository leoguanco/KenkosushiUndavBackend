package com.kenkosushi.Undav.service;

import com.kenkosushi.Undav.domain.model.Configuration;
import com.kenkosushi.Undav.domain.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

    private ConfigurationRepository configurationRepository;

    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository){
        this.configurationRepository=configurationRepository;
    }

    public Configuration findById(Long id){
        return configurationRepository.findOne(id);
    }
}
