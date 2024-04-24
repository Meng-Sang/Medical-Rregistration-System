package com.sangmeng.entity;

public class Login {
    private String username;
    private String password;
    private String role;
    private String state;
    private String email;
    private String tel;
    private int accountBalance;
    public Login() {

    }

    public Login(String username, String password, String role, String state, String email, String tel, int accountBalance) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.state = state;
        this.email = email;
        this.tel = tel;
        this.accountBalance = accountBalance;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
