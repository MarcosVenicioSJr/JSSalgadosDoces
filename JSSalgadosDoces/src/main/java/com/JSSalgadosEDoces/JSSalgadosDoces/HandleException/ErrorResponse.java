package com.JSSalgadosEDoces.JSSalgadosDoces.HandleException;

import org.springframework.http.HttpStatusCode;

public class ErrorResponse {
    private final HttpStatusCode status;
    private final String message;

    public ErrorResponse(HttpStatusCode status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

