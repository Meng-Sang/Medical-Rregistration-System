package com.sangmeng.entity;

public class Doctor {
    private String username;
    private String ad_no;
    private String ad_name;
    private String sno;
    private String name;
    private String self_introduction;
    private String photo;
    private int charge;
    private String level;
    private String audit;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getAd_no() {
        return ad_no;
    }

    public void setAd_no(String ad_no) {
        this.ad_no = ad_no;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelf_introduction() {
        return self_introduction;
    }

    public void setSelf_introduction(String self_introduction) {
        this.self_introduction = self_introduction;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public Doctor(String username, String ad_no, String ad_name, String sno, String name, String self_introduction, String photo, int charge, String level, String audit) {
        this.username = username;
        this.ad_no = ad_no;
        this.ad_name = ad_name;
        this.sno = sno;
        this.name = name;
        this.self_introduction = self_introduction;
        this.photo = photo;
        this.charge = charge;
        this.level = level;
        this.audit = audit;
    }

    public Doctor() {
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "username='" + username + '\'' +
                ", ad_no='" + ad_no + '\'' +
                ", ad_name='" + ad_name + '\'' +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", self_introduction='" + self_introduction + '\'' +
                ", photo='" + photo + '\'' +
                ", charge=" + charge +
                ", level='" + level + '\'' +
                ", audit='" + audit + '\'' +
                '}';
    }
}
