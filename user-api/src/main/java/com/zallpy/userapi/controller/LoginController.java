package com.zallpy.userapi.controller;

import com.zallpy.userapi.dto.request.Login;
import com.zallpy.userapi.dto.response.Session;
import com.zallpy.userapi.serviceTest.imp.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {
    LoginService service;
    @PostMapping
    public Session logar(@RequestBody Login login){

        return service.logar(login);
    }


}
