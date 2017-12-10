package com.kenkosushi.Undav.domain.repository;

import com.kenkosushi.Undav.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by leo on 11/9/17.
 */
public interface AddressRepository extends JpaRepository<Address,Long>{

    public Collection<Address> findByUserId(Long userId);
}
