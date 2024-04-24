package com.sangmeng.entity;

public class Invest {
    private String username ;
    private String investNumber;
    private int amount ;
    private int charge;
    private String way;
    private String state;
    private String date;

    public Invest(String username, String investNumber, int amount, int charge, String way, String state, String date) {
        this.username = username;
        this.investNumber = investNumber;
        this.amount = amount;
        this.charge = charge;
        this.way = way;
        this.state = state;
        this.date = date;
    }

    public Invest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInvestNumber() {
        return investNumber;
    }

    public void setInvestNumber(String investNumber) {
        this.investNumber = investNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invest{" +
                "username='" + username + '\'' +
                ", investNumber='" + investNumber + '\'' +
                ", amount=" + amount +
                ", charge=" + charge +
                ", way='" + way + '\'' +
                ", state='" + state + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
