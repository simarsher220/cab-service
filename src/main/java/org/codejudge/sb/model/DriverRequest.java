package org.codejudge.sb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.codejudge.sb.error.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DriverRequest {

    private String name;
    private String licenseNumber;
    private String email;
    private Long phoneNumber;
    private String carNumber;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("license_number")
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("phone_number")
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("car_number")
    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public static void validateDriverRequest(DriverRequest driverRequest) {
        validateName(driverRequest.getName());
        validateLicenseNumber(driverRequest.getLicenseNumber());
        validateEmail(driverRequest.getEmail());
        validatePhoneNumber(driverRequest.getPhoneNumber());
        validateCarNumber(driverRequest.getCarNumber());
    }

    private static void validateName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new CustomException("Name is missing", HttpStatus.BAD_REQUEST);
        }
    }

    private static void validateLicenseNumber(String licenseNumber) {
        if (StringUtils.isEmpty(licenseNumber)) {
            throw new CustomException("License Number is missing", HttpStatus.BAD_REQUEST);
        }
    }

    private static void validateEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            throw new CustomException("Email is missing", HttpStatus.BAD_REQUEST);
        }
    }

    private static void validatePhoneNumber(Long phoneNumber) {
        String phone = String.valueOf(phoneNumber);
        if (StringUtils.isEmpty(phoneNumber)) {
            throw new CustomException("Phone number is missing", HttpStatus.BAD_REQUEST);
        }
        Pattern pattern = Pattern.compile("\\d{10}");
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.matches()) {
            throw new CustomException("Invalid phone number", HttpStatus.BAD_REQUEST);
        }
    }

    private static void validateCarNumber(String carNumber) {
        if (StringUtils.isEmpty(carNumber)) {
            throw new CustomException("Car number is missing", HttpStatus.BAD_REQUEST);
        }
    }
}
