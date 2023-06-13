package com.service.demo.dto;


public enum PositionEnum {
    JUNIOR(1),
    MIDDLE(2),
    SENIOR(3),
    LEAD(4);

    private final long id;

    PositionEnum(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
