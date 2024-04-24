package com.sangmeng.entity;

public class Administrative {
    private String ad_no;
    private String ad_name;
    private int num;
    private String manager;
    private String introduce;
    public Administrative() {
    }
    public Administrative(String ad_no, String ad_name, int num, String manager, String introduce) {
        this.ad_no = ad_no;
        this.ad_name = ad_name;
        this.num = num;
        this.manager = manager;
        this.introduce = introduce;
    }

    public String getAd_no() {
        return ad_no;
    }

    public void setAd_no(String ad_no) {
        this.ad_no = ad_no;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Administrative{" +
                "ad_no='" + ad_no + '\'' +
                ", ad_name='" + ad_name + '\'' +
                ", num=" + num +
                ", manager='" + manager + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
