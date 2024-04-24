package com.sangmeng.entity;

import java.util.Date;

public class IdInformation {
    private String username;
    private String name;
    private String id;
    private String province;
    private String city;
    private String address;
    private String date;
    private String idp;
    private String idn;
    public IdInformation(){

    }
    public IdInformation(String username, String name, String id, String province, String city, String address, String date, String idp, String idn) {
        this.username = username;
        this.name = name;
        this.id = id;
        this.province = province;
        this.city = city;
        this.address = address;
        this.date = date;
        this.idp = idp;
        this.idn = idn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdp() {
        return idp;
    }

    public void setIdp(String idp) {
        this.idp = idp;
    }

    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
        this.idn = idn;
    }

    @Override
    public String toString() {
        return "IdInformation{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", idp='" + idp + '\'' +
                ", idn='" + idn + '\'' +
                '}';
    }
}
