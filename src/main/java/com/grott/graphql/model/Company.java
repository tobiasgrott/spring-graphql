package com.grott.graphql.model;

public class Company {
    private String name;
    private Address location;

    public String getName() {
        return name;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }
}