package com.zallpy.userapi.service.imp;

import com.zallpy.userapi.entity.BloodTypeEntity;
import com.zallpy.userapi.dto.request.BloodTypeDTO;
import com.zallpy.userapi.repository.BloodTypeRepository;
import com.zallpy.userapi.service.BloodTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BloodTypeServiceImp implements BloodTypeService {

    BloodTypeRepository bloodTypeRepository;


    @Override
    public BloodTypeEntity create(BloodTypeDTO form) {
        return null;
    }

    @Override
    public BloodTypeEntity get(Long id) {
        return null;
    }

    @Override
    public List<BloodTypeEntity> getAll() {
        bloodTypeRepository.findAll();

       return bloodTypeRepository.findAll();
    }

    @Override
    public BloodTypeEntity update(Long id, BloodTypeDTO formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
