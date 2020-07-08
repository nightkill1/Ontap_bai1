package com.example.controller;

import com.example.model.contact;

import java.util.List;

public interface IContactController {
    public List<contact> getAllContact();
    public void update(contact contact);
    public void add(contact contact);
}
