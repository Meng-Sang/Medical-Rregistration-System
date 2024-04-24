package com.sangmeng.service;

import com.sangmeng.entity.Login;

public interface LoginService {
    public Login queryByUsername(String username);
    public boolean checkLogin(String username,String password);
    public int register(Login login);
}
