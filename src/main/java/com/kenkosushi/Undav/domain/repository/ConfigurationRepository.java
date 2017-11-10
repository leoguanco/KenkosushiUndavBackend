package com.kenkosushi.Undav.domain.repository;

import com.kenkosushi.Undav.domain.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration,Long> {
}
