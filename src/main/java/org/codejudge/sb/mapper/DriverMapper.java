package org.codejudge.sb.mapper;

import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.model.DriverRequest;
import org.codejudge.sb.model.DriverResponse;

import java.util.UUID;

public class DriverMapper {

    public static Driver getDriverForDriverRequest(DriverRequest request) {
        Driver driver = new Driver();
        driver.setId(UUID.randomUUID());
        driver.setCarNumber(request.getCarNumber());
        driver.setLicenseNumber(request.getLicenseNumber());
        driver.setEmail(request.getEmail());
        driver.setPhoneNumber(request.getPhoneNumber());
        driver.setName(request.getName());
        return driver;
    }

    public static DriverResponse getDriverResponseForDriver(Driver request) {
        DriverResponse driver = new DriverResponse();
        driver.setId(request.getId());
        driver.setCarNumber(request.getCarNumber());
        driver.setLicenseNumber(request.getLicenseNumber());
        driver.setEmail(request.getEmail());
        driver.setPhoneNumber(request.getPhoneNumber());
        driver.setName(request.getName());
        return driver;
    }

}
