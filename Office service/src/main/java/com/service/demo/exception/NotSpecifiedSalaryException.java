package com.service.demo.exception;

public class NotSpecifiedSalaryException extends RuntimeException {
    public NotSpecifiedSalaryException(String positionName) {
        super(String.format("Position with name %s does not exist", positionName));
    }
}
