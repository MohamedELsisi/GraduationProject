package com.graduation.demo.controller;


import com.graduation.demo.Model.Login;
import com.graduation.demo.service.LoginService;
import com.graduation.demo.service.LoginServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginServiceImpl service;

    @PostMapping("/Login")
    @ApiOperation(value = "new Login ", response = ResponseEntity.class)
    public ResponseEntity Login(@RequestBody Login login) {
        log.info("Login_Controller ", login);

        Login existingLogin = service.getData(login.getUserName());

        if (existingLogin == null)
            return ResponseEntity.notFound().build();

        else {
            if (login.getPassword().equals(existingLogin.getPassword()))
                return ResponseEntity.status(HttpStatus.OK).body(existingLogin);
            else
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();


        }

    }

}
