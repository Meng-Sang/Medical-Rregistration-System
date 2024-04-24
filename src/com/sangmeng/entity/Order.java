package com.sangmeng.entity;

public class Order {
    private String username;
    private String name;
    private String orderNumber;
    private String sno;
    private String doc_name;
    private String date;
    private int charge;
    private String charge_state;
    private String ad_no;

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getCharge_state() {
        return charge_state;
    }

    public void setCharge_state(String charge_state) {
        this.charge_state = charge_state;
    }

    public String getAd_no() {
        return ad_no;
    }

    public void setAd_no(String ad_no) {
        this.ad_no = ad_no;
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Order(String username, String name, String orderNumber, String sno, String doc_name, String date, int charge, String charge_state, String ad_no) {
        this.username = username;
        this.name = name;
        this.orderNumber = orderNumber;
        this.sno = sno;
        this.doc_name = doc_name;
        this.date = date;
        this.charge = charge;
        this.charge_state = charge_state;
        this.ad_no = ad_no;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", sno='" + sno + '\'' +
                ", doc_name='" + doc_name + '\'' +
                ", date='" + date + '\'' +
                ", charge=" + charge +
                ", charge_state='" + charge_state + '\'' +
                ", ad_no='" + ad_no + '\'' +
                '}';
    }
}
