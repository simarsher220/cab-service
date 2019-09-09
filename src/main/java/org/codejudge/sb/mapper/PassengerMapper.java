package org.codejudge.sb.mapper;

import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.model.AvailableDriver;
import org.codejudge.sb.model.AvailableDrivers;

import java.util.ArrayList;
import java.util.List;

public class PassengerMapper {

    public static AvailableDrivers getAvailableDriversForDrivers(List<Driver> drivers) {
        AvailableDrivers availableDrivers = new AvailableDrivers();
        List<AvailableDriver> availableDriverList = new ArrayList<>();
        AvailableDriver availableDriver = new AvailableDriver();
        for (Driver driver : drivers) {
            availableDriverList.add(getAvailableDriverForDriver(driver));
        }
        availableDrivers.setAvailableDrivers(availableDriverList);
        return availableDrivers;
    }

    public static AvailableDriver getAvailableDriverForDriver(Driver driver) {
        AvailableDriver availableDriver = new AvailableDriver();
        availableDriver.setCarNumber(driver.getCarNumber());
        availableDriver.setPhoneNumber(driver.getPhoneNumber());
        availableDriver.setName(driver.getName());
        return availableDriver;
    }
}
