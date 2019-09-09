package org.codejudge.sb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AvailableDrivers {

    private List<AvailableDriver> availableDrivers;

    @JsonProperty("available_cabs")
    public List<AvailableDriver> getAvailableDrivers() {
        return availableDrivers;
    }

    public void setAvailableDrivers(List<AvailableDriver> availableDrivers) {
        this.availableDrivers = availableDrivers;
    }
}
