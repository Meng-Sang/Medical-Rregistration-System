package com.sangmeng.entity;

public class Notice {
    private String notice_id;
    private String notice_title;
    private String notice_content;
    private String notice_date;

    public String getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(String notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public String getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(String notice_date) {
        this.notice_date = notice_date;
    }

    public Notice() {
    }

    public Notice(String notice_id, String notice_title, String notice_content, String notice_date) {
        this.notice_id = notice_id;
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.notice_date = notice_date;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id='" + notice_id + '\'' +
                ", notice_title='" + notice_title + '\'' +
                ", notice_content='" + notice_content + '\'' +
                ", notice_date='" + notice_date + '\'' +
                '}';
    }
}
