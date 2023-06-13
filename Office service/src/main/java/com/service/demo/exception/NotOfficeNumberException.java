package com.service.demo.exception;

public class NotOfficeNumberException extends RuntimeException {
    public NotOfficeNumberException(Long numberOffice) {
        super(String.format("Office with number %s does not exist", numberOffice));
    }
}
