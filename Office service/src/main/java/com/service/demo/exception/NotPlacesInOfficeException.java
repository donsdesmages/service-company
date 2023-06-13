package com.service.demo.exception;

public class NotPlacesInOfficeException extends RuntimeException {
    public NotPlacesInOfficeException(Long numberOffice) {
        super(String.format("In an office with a number %s out of seats", numberOffice));
    }
}
