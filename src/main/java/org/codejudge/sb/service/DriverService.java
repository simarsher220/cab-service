package org.codejudge.sb.service;

import org.codejudge.sb.dao.DriverRepository;
import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.error.exception.CustomException;
import org.codejudge.sb.mapper.DriverMapper;
import org.codejudge.sb.model.DriverRequest;
import org.codejudge.sb.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver registerDriver(DriverRequest request) {
        Driver driver = null;
        try {
            driver = DriverMapper.getDriverForDriverRequest(request);
            driver = driverRepository.saveAndFlush(driver);
        }
        catch (Exception e) {
            throw new CustomException("Couldn't register driver!", HttpStatus.BAD_REQUEST);
        }
        return driver;
    }

    public void storeDriverLocation(UUID id, Location request) {
        Driver driver = null;
        driver = driverRepository.findDriverById(id);
        if (driver == null) {
            throw new CustomException("Driver not found!", HttpStatus.BAD_REQUEST);
        }
        try {
            driver.setLatitude(request.getLatitude());
            driver.setLongitude(request.getLongitude());
            driverRepository.saveAndFlush(driver);
        }
        catch (Exception e) {
            throw new CustomException("Couldn't update driver location!", HttpStatus.BAD_REQUEST);

        }
    }

    List<Driver> getAllDrivers() {
        List<Driver> drivers = driverRepository.findAll();
        return drivers;
    }
}
