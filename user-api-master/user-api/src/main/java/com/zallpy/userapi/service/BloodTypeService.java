package com.zallpy.userapi.service;

import com.zallpy.userapi.entity.BloodTypeEntity;
import com.zallpy.userapi.dto.request.BloodTypeDTO;

import java.util.List;


public interface BloodTypeService {

    BloodTypeEntity create(BloodTypeDTO form);

    BloodTypeEntity get(Long id);

    List<BloodTypeEntity> getAll();

    BloodTypeEntity update(Long id, BloodTypeDTO formUpdate);

    void delete(Long id);

}
