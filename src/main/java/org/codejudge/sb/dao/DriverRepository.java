package org.codejudge.sb.dao;

import org.codejudge.sb.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {

    Driver findDriverById(UUID id);
}
