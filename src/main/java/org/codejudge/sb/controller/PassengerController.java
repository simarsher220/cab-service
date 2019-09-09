package org.codejudge.sb.controller;

        import org.codejudge.sb.entity.Driver;
        import org.codejudge.sb.mapper.PassengerMapper;
        import org.codejudge.sb.model.Location;
        import org.codejudge.sb.service.PassengerService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.List;

@RestController
public class PassengerController {

    private PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @RequestMapping(value = "/passenger/available_cabs/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAvailableCabs(@RequestBody Location request) {
        Location.validate(request);
        List<Driver> drivers = passengerService.getAvailableCabs(request);
        return new ResponseEntity<>(PassengerMapper.getAvailableDriversForDrivers(drivers),HttpStatus.OK);
    }
}
