package org.codejudge.sb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.codejudge.sb.error.exception.CustomException;
import org.springframework.http.HttpStatus;

public class Location {

    private Double latitude;
    private Double longitude;

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public static void validate(Location location) {
        if (location.getLatitude() == null || location.getLongitude() == null) {
            throw new CustomException("Latitude or longitude is missing!!", HttpStatus.BAD_REQUEST);
        }
    }
}
