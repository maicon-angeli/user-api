package com.zallpy.userapi.utils;

import com.zallpy.userapi.dto.response.BloodTypeDTO;
import com.zallpy.userapi.dto.response.BloodTypeCpf;
import com.zallpy.userapi.entity.BloodTypeEntity;

import java.util.Optional;

public class BlTypeUtil {


    private static final Long BLOOD_TYPE_ENTITY_ID = 1L;
    private static final String BLOODTYPE = "O+";

    public static BloodTypeEntity createFakeBlTEntity() {
        return BloodTypeEntity.builder()
                .id(BLOOD_TYPE_ENTITY_ID)
                .bloodType(BLOODTYPE)
                .build();
    }

    public static BloodTypeDTO createFakeBlTDTO() {
        return BloodTypeDTO.builder()
                .id(BLOOD_TYPE_ENTITY_ID)
                .bloodType(BLOODTYPE)
                .build();
    }
    public static Optional<BloodTypeEntity> createFakeBlTOptional() {
        return Optional.ofNullable( BloodTypeEntity.builder()
                .id(BLOOD_TYPE_ENTITY_ID)
                .bloodType(BLOODTYPE)
                .build());
    }
    public static BloodTypeCpf createFakeBlTCPF() {
        return new BloodTypeCpf() {
            @Override
            public String getFullName() {
                return null;
            }

            @Override
            public String getBloodType() {
                return null;
            }

            @Override
            public String getCpf() {
                return null;
            }
        };
    }
}
