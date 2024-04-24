package com.sangmeng.dao;
import com.sangmeng.entity.Login;
import java.util.List;

public interface LoginDao {
    public Login queryByUserName(String username);
    public int update(String sql,Object...objs);
    public List<Login> query(String sql, Object...objs);
    public boolean updateBalance(String username,int accountBalance);
}
