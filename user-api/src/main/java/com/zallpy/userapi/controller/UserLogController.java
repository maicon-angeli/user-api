package com.zallpy.userapi.controller;

import com.zallpy.userapi.entity.UserLog;
import com.zallpy.userapi.serviceTest.imp.UserLogService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserLogController {

    private UserLogService service;

    @PostMapping
    public void postUser(@RequestBody UserLog user) {
        service.createUser(user);
    }

}
