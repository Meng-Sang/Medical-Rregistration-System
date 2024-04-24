package com.sangmeng.service.impl;

import com.sangmeng.dao.NoticesDao;
import com.sangmeng.dao.impl.NoticesDaoImpl;
import com.sangmeng.entity.Notice;
import com.sangmeng.service.NoticeService;
import com.sangmeng.util.PageUtil;

import java.util.List;

public class NoticeServiceImpl implements NoticeService {
    @Override
    public boolean addNotice(Notice notice) {
        NoticesDaoImpl noticeDaoImpl = new NoticesDaoImpl();
        if(noticeDaoImpl.queryNotice(notice.getNotice_id())!=null)
            return false;
        if(!noticeDaoImpl.addNotice(notice))
            return false;
        return true;
    }

    @Override
    public List<Notice> queryNotice(PageUtil pageUtil) {
        String sql = "select * from (select * from notices order by notice_id desc) as new limit"+PageUtil.getLimit(pageUtil);
        return new NoticesDaoImpl().queryNoticesByLimit(sql);
    }

    @Override
    public Notice queryByNotice_ad(String notice_ad) {
        return new NoticesDaoImpl().queryNotice(notice_ad);
    }

    @Override
    public int queryTotalNoticesNum() {
        return (int)new NoticesDaoImpl().queryAllNoticeForNum();
    }

    @Override
    public boolean deleteNotices(String notice_ad) {
        return new NoticesDaoImpl().delete(notice_ad)==1?true:false;
    }
}
