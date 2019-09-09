package org.codejudge.sb.error.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NotFoundResponse {

    private String message;

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
