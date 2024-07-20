package com.JSSalgadosEDoces.JSSalgadosDoces.HandleException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter @Setter @NoArgsConstructor
public class ApiException extends Exception{
    private HttpStatus status;
    private String message;

    public ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
