package com.example.controller;

import android.app.Application;

import com.example.model.contact;

import java.util.ArrayList;
import java.util.List;

public class ContactController extends Application implements IContactController {
    List<contact> listContact =  new ArrayList<>();
    public ContactController()
    {
        listContact.add(new contact(1,"Nguyễn Minh Hoàng","06/08/1999","0344612169","Nha Trang"));
        listContact.add(new contact(2,"Nguyễn Hoàng Minh","06/08/1998","0344612969","Nha Trang"));
        listContact.add(new contact(3,"Hoàng Minh Nguyễn","06/08/1997","0344612669","Nha Trang"));
        listContact.add(new contact(4,"Nguyễn Minh Hoàng Đẹp Trai","06/08/1996","0344612969","Nha Trang"));
    }

    @Override
    public List<contact> getAllContact() {
        return listContact;
    }

    @Override
    public void update(contact contact) {

    }

    @Override
    public void add(contact contact) {

    }
}
