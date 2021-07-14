package com.example.JavaBackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String fullname;
    private long phone_number;
    private boolean send_email;
    private String email;
    private String address;
    private long contacts;
    private String valid_period;
    private String app_id;
    private int capacity;
    private String postscript;
    private boolean background;

    public UserInfo(long id, String username, String password, String fullname, long phone_number, boolean send_email, String email, String address, long contacts, String valid_period, String app_id, int capacity, String postscript, boolean background) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone_number = phone_number;
        this.send_email = send_email;
        this.email = email;
        this.address = address;
        this.contacts = contacts;
        this.valid_period = valid_period;
        this.app_id = app_id;
        this.capacity = capacity;
        this.postscript = postscript;
        this.background = background;
    }

    public UserInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public boolean isSend_email() {
        return send_email;
    }

    public void setSend_email(boolean send_email) {
        this.send_email = send_email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContacts() {
        return contacts;
    }

    public void setContacts(long contacts) {
        this.contacts = contacts;
    }

    public String getValid_period() {
        return valid_period;
    }

    public void setValid_period(String valid_period) {
        this.valid_period = valid_period;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    public boolean isBackground() {
        return background;
    }

    public void setBackground(boolean background) {
        this.background = background;
    }
}
