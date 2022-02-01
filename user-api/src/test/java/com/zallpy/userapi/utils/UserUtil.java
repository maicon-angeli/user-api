package com.zallpy.userapi.utils;

import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.entity.UserEntity;

public class UserUtil {
    private static final String FIRST_NAME = "Maicon";
    private static final String LAST_NAME = "Angeli";
    private static final String EMAIL = "maicon@teste.com";
    private static final long PERSON_ID = 1L;
    private static final int AGE = 31;
    private static final String ACTIVE = "S";


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


