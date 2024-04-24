package com.sangmeng.entity;

public class DataSourceEntity {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String username = "root";
    private String password = "123456wxzr";
    private String url = "jdbc:mysql://127.0.0.1:3306/paper?serverTimezone=GMT%2B8&amp&useSSL=false& allowPublicKeyRetrieval=true";
    private int maxActive = 1000;
    private int minIdle = 500;
    private int intalSize = 200;
    private int timeout = 200;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public int getIntalSize() {
        return intalSize;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public void setIntalSize(int intalSize) {
        this.intalSize = intalSize;
    }
}
