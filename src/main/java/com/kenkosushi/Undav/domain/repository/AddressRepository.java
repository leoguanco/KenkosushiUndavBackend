package com.kenkosushi.Undav.domain.repository;

import com.kenkosushi.Undav.domain.model.Address;
import com.kenkosushi.Undav.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by leo on 11/9/17.
 */
public interface AddressRepository extends JpaRepository<Address,Long>{

    public Collection<Address> findByUserId(User user);
}
