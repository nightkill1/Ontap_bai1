package com.example.model;

public class contact {
    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    int id;

    public contact(int id, String name, String DOB, String phone, String address) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    String name;
    String DOB;
    String phone;
    String address;

    public contact() {

    }


}
