package com.graduation.demo.service;

import com.graduation.demo.Dao.LoginRepository;
import com.graduation.demo.Model.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository repository;

    @Override
    public Login getData(String userName) {
        log.info("calling getData   service with user named " + userName);
        Login existingLogin = repository.findByUserName(userName);
        if (existingLogin == null)
            log.warn("getData With object  is null ");
        else
            log.info("getData With object response "+existingLogin);
        return existingLogin;
    }



    @Override
    public void saveLogin(Login login) {
        log.info("calling Add_Department service with Object " + login);
        Login existingLogin = repository.save(login);
        if (existingLogin == null)
            log.warn("saveLogin With object  is null ");
        else
            log.info("saveLogin With object response ");
    }
}
