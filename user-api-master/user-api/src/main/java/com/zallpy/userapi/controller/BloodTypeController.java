package com.zallpy.userapi.controller;

import com.zallpy.userapi.entity.BloodTypeEntity;
import com.zallpy.userapi.service.imp.BloodTypeServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bloodtype")
public class BloodTypeController {

    BloodTypeServiceImp bloodTypeServiceImp;

    @GetMapping
    public List<BloodTypeEntity> getAll(){

        return bloodTypeServiceImp.getAll();
    }
}
