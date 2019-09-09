package org.codejudge.sb.service;

import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.error.exception.NotFoundException;
import org.codejudge.sb.model.Location;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    private DriverService driverService;

    @Autowired
    public PassengerService(DriverService driverService) {
        this.driverService = driverService;
    }

    public List<Driver> getAvailableCabs(Location request) {
        GeodeticCalculator geoCalc = new GeodeticCalculator();
        Ellipsoid reference = Ellipsoid.WGS84;
        GlobalPosition userLocation = new GlobalPosition(request.getLatitude(), request.getLongitude(), 0.0);
        List<Driver> drivers = driverService.getAllDrivers();
        if (CollectionUtils.isEmpty(drivers)) {
            throw new NotFoundException("No cabs available!", HttpStatus.OK);
        }
        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.getLatitude() != null) {
                GlobalPosition driverLocation = new GlobalPosition(driver.getLatitude(), driver.getLongitude(), 0.0);
                double distance = geoCalc.calculateGeodeticCurve(reference, userLocation, driverLocation).getEllipsoidalDistance();
                Integer distanceInKm = (int) distance / 1000;
                if (distanceInKm <= 4) {
                    availableDrivers.add(driver);
                }
            }
        }
        if (CollectionUtils.isEmpty(availableDrivers)) {
            throw new NotFoundException("No cabs available!", HttpStatus.OK);
        }
        return availableDrivers;
    }
}
