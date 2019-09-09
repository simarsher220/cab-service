package org.codejudge.sb.controller;

import org.codejudge.sb.entity.Driver;
import org.codejudge.sb.mapper.DriverMapper;
import org.codejudge.sb.model.DriverRequest;
import org.codejudge.sb.model.Location;
import org.codejudge.sb.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @RequestMapping(value = "/driver/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody DriverRequest request) {
        DriverRequest.validateDriverRequest(request);
        Driver driver = driverService.registerDriver(request);
        return new ResponseEntity<>(DriverMapper.getDriverResponseForDriver(driver), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/driver/{id}/sendLocation/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void sendDriverLocation(@PathVariable("id") UUID id, @RequestBody Location request) {
        Location.validate(request);
        driverService.storeDriverLocation(id, request);
    }
}
