package com.sangmeng.dao;

import com.sangmeng.entity.Notice;

import java.util.List;

public interface NoticesDao {
    public boolean addNotice(Notice notice);
    public Notice queryNotice(String notice_id);
    public long queryAllNoticeForNum();
    public List<Notice> queryAllNotic();
    public List<Notice> queryNoticesByLimit(String sql);
    public int delete(String notice_ad);
}
