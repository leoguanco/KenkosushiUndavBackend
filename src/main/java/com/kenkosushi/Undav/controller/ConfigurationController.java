package com.kenkosushi.Undav.controller;

import com.kenkosushi.Undav.domain.model.Configuration;
import com.kenkosushi.Undav.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class ConfigurationController {

    private ConfigurationService configurationService;

    @Autowired
    public ConfigurationController(ConfigurationService configurationService){
        this.configurationService=configurationService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/admin/configurations/{id}")
    public ResponseEntity<Configuration> updateConfiguration(@PathVariable Long id,Configuration configuration){
        ResponseEntity<Configuration> response;
        Configuration configuration1=configurationService.findById(id);

        if(configuration1!=null){
            configurationService.update(configuration);
            response= new ResponseEntity<Configuration>(configuration1,HttpStatus.OK);
        }
        else{
            response=new ResponseEntity<Configuration>(configuration1,HttpStatus.NOT_FOUND);
        }

        return response;
    }

}
