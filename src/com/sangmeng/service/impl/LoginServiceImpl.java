package com.sangmeng.service.impl;

import com.sangmeng.dao.impl.LoginDaoImpl;
import com.sangmeng.entity.Login;
import com.sangmeng.service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    @Override
    public Login queryByUsername(String username) {
        return new LoginDaoImpl().queryByUserName(username);
    }

    @Override
    public boolean checkLogin(String username,String password) {
        Login login = new LoginDaoImpl().queryByUserName(username);
        if(login!=null&&login.getUsername().equals(username)&&login.getPassword().equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int register(Login login) {
        int result = 0;
        String sql = "insert into logins values(?,?,?,?,?,?,?)";
        if(new LoginDaoImpl().queryByUserName(login.getUsername())==null)
        {
            result = new LoginDaoImpl().update(sql,new Object[]{login.getUsername(),login.getPassword(),login.getRole(),login.getState(),login.getEmail(),login.getTel(),login.getAccountBalance()});
            return result==1?result:-result;
        }
        else
        {
            return result;
        }
    }
}
