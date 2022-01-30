package com.zallpy.userapi.utils;

import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.entity.UserEntity;

public class UserUtil {
    private static final String FIRST_NAME = "MAICON";
    private static final String LAST_NAME = "ANGELI";
    private static final String EMAIL = "MAICON@EMAIL.COM";
    private static final long PERSON_ID = 2L;
    private static final int AGE = 32;
    private static final String ACTIVE = "s";


    public static UserDTO createFakeDTO() {
        return UserDTO
                .builder()
                .firstName("MAICON")
                .lastName("ANGELI")
                .age(32)
                .active("s")
                .email("MAICON@EMAIL.COM")
                .build();
    }

    public static UserEntity createFakeEntity() {
        return UserEntity
                .builder()
                .firstName("MAICON")
                .lastName("ANGELI")
                .age(32)
                .active("s")
                .email("MAICON@EMAIL.COM")
                .build();
    }
}


