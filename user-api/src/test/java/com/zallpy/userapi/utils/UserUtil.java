package com.zallpy.userapi.utils;

import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.entity.UserEntity;

import java.util.Optional;

public class UserUtil {
    private static final String FIRST_NAME = "Maicon";
    private static final String LAST_NAME = "Angeli";
    private static final String EMAIL = "maicon2@teste.com";
    private static final Long USER_ENTITY_ID = 9L;
    private static final int AGE = 31;
    private static final String ACTIVE = "S";


    public static UserDTO createFakeDTO() {
        return UserDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .age(AGE)
                .active(ACTIVE)
                .email(EMAIL)
                .build();
    }

    public static UserEntity createFakeEntity() {
        return UserEntity.builder()
                .id(USER_ENTITY_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .age(AGE)
                .active(ACTIVE)
                .email(EMAIL)
                .build();
    }

    public static Optional<UserEntity> createFakeEntityOptional(){
        return Optional.ofNullable(UserEntity.builder()
                .id(USER_ENTITY_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .age(AGE)
                .active(ACTIVE)
                .email(EMAIL)
                .build());
    }
}

