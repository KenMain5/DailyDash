package com.DailyDash.AccountManagement.entity;

public enum Role {
    ADMIN("ADMIN_ROLE"),
    USER("ADMIN_USER");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
