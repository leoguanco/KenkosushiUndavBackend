package com.kenkosushi.Undav.domain.repository;

import com.kenkosushi.Undav.domain.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PhoneRepository extends JpaRepository<Phone,Long>{

    public Collection<Phone> findByUserId(Long id);
}
