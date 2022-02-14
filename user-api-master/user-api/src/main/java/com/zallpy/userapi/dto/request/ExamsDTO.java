package com.zallpy.userapi.dto.request;

import com.zallpy.userapi.entity.UserEntity;

import javax.validation.Valid;


public class ExamsDTO {

    private long id;

    private String examName;

    private Float examCost;

    @Valid
    private UserEntity userEntity;
}
