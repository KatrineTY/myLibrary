package com.library.models;

public class Reader {
    private int id;
    private String readerName;
    private String phone;
    private String password;

    public Reader() {
    }

    public Reader(int id, String readerName, String phone, String password) {
        this.id = id;
        this.readerName = readerName;
        this.phone = phone;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
