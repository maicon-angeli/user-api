package com.zallpy.userapi.serviceTest.imp;


import com.zallpy.userapi.dto.request.BloodTypeDTO;
import com.zallpy.userapi.dto.response.BloodTypeCpf;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.BloodTypeEntity;
import com.zallpy.userapi.repository.BloodTypeRepository;
import com.zallpy.userapi.utils.Interface.Mappable;
import exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BloodTypeServiceImp  implements Mappable {

    BloodTypeRepository bloodTypeRepository;

    public MessageResponseDTO create(BloodTypeDTO form) {
        BloodTypeEntity createbloodTypeEntity = map(form, BloodTypeEntity.class);
        BloodTypeEntity createform = bloodTypeRepository.save(createbloodTypeEntity);

        return createMessageResponse(map(createform,BloodTypeDTO.class).getId(),
                "blood type created successfully: ID ");
    }

      public List<BloodTypeDTO> getAll() {
        List<BloodTypeEntity> bloodTypeList = bloodTypeRepository.findAll();

        return map(bloodTypeList, BloodTypeDTO.class);
    }


    public MessageResponseDTO updatebyId(Long id, BloodTypeDTO bloodTypeDTO) {
        verifyIfExists(id);
        BloodTypeEntity bloodToUpdate = map(bloodTypeDTO, BloodTypeEntity.class) ;
        BloodTypeEntity updateBloodType =bloodTypeRepository.save(bloodToUpdate);
        return createMessageResponse(map(updateBloodType,BloodTypeDTO.class).getId()
                ,"BloodyType is Update-");
    }

    public void delete(Long id)  {
        verifyIfExists(id);
        bloodTypeRepository.deleteById(id);
    }
    public BloodTypeCpf findBloodTypeCpf(String cpf)
    {
        return bloodTypeRepository.findBloodTypeCpf(cpf);
    }

    public BloodTypeEntity verifyIfExists(Long id) throws UserNotFoundException {
        return bloodTypeRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(HttpStatus.NOT_FOUND,"ID NOT FOUND"));
    }

    private MessageResponseDTO createMessageResponse(long id, String message) {
        return MessageResponseDTO
                .builder()
                .message( message + id)
                .build();
    }




}
