package com.kenkosushi.Undav.domain.repository;

import com.kenkosushi.Undav.domain.model.Phone;
import com.kenkosushi.Undav.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PhoneRepository extends JpaRepository<Phone,Long>{

    public Collection<Phone> findByUser(User user);
}
