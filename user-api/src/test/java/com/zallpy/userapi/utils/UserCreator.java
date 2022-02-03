package com.zallpy.userapi.utils;

import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.entity.UserEntity;

public class UserCreator {

    public static UserDTO createUseTobeSave(){
        return UserDTO.builder()
                .firstName("Maicon")
                .build();
    }
    public static UserDTO createValidUser(){
        return UserDTO.builder()
                .firstName("Maicon")
                .build();



    }
    public static UserDTO createValidUpdateUser(){
        return UserDTO.builder()
                .firstName("Vanessa")
                .build();
    }

}
