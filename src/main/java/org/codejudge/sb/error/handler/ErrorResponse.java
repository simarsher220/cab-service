package org.codejudge.sb.error.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    private String status;
    private String reason;

    ErrorResponse(String reason) {
        status = "failure";
        this.reason = reason;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
