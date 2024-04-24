package com.sangmeng.service;

import com.sangmeng.entity.Notice;
import com.sangmeng.util.PageUtil;

import java.util.List;

public interface NoticeService {
    public boolean addNotice(Notice notice);
    public List<Notice> queryNotice(PageUtil pageUtil);
    public Notice queryByNotice_ad(String notice_ad);
    public int queryTotalNoticesNum();
    public boolean deleteNotices(String notice_ad);
}
