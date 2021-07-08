package com.graduation.demo.service;

import com.graduation.demo.Model.Login;

public interface LoginService {
    public Login getData(String userName);
    public void saveLogin(Login login);

}
