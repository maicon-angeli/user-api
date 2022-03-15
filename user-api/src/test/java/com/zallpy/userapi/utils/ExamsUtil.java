package com.zallpy.userapi.utils;

import com.zallpy.userapi.dto.request.ExamsDTO;
import com.zallpy.userapi.dto.response.ExamsRelat;
import com.zallpy.userapi.entity.ExamsEntity;

import java.util.Optional;


public class ExamsUtil {

    private static final long EXAMS_ENTITY_ID = 1l;

    private static final String EXAM_NAME = "Hemoglobina";

    private static final double EXAM_COST = 37d;

    public static ExamsEntity createFakeEx() {
        return ExamsEntity.builder()
                .id(EXAMS_ENTITY_ID)
                .examName(EXAM_NAME)
                .examCost(EXAM_COST)
                .build();
    }

    public static ExamsDTO createFakeExDTO() {
        return ExamsDTO.builder()
                .id(EXAMS_ENTITY_ID)
                .examName(EXAM_NAME)
                .examCost(EXAM_COST)
                .build();
    }

    public static Optional<ExamsEntity> createFakeExOp() {
        return Optional.ofNullable(ExamsEntity.builder()
                .id(EXAMS_ENTITY_ID)
                .examName(EXAM_NAME)
                .examCost(EXAM_COST)
                .build());
    }

    public static ExamsRelat createFakeExExamsRelt() {
        return new ExamsRelat() {
            @Override
            public long getId() {
                return 0;
            }

            @Override
            public double getExamCost() {
                return 0;
            }

            @Override
            public String getExamName() {
                return null;
            }

            @Override
            public String getUser() {
                return null;
            }
        };


    }
}
