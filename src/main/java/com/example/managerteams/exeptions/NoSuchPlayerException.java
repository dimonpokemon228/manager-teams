package com.example.managerteams.exeptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class NoSuchPlayerException extends ResponseStatusException{
    public NoSuchPlayerException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
