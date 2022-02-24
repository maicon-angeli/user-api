package com.zallpy.userapi.serviceTest;

import com.zallpy.userapi.dto.request.BloodTypeDTO;
import com.zallpy.userapi.dto.response.BloodTypeCpf;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.BloodTypeEntity;
import com.zallpy.userapi.mapper.UserMapper;
import com.zallpy.userapi.repository.BloodTypeRepository;
import com.zallpy.userapi.serviceTest.imp.BloodTypeServiceImp;
import com.zallpy.userapi.utils.BlTypeUtil;
import com.zallpy.userapi.utils.UserUtil;
import exception.UserNotFoundException;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.zallpy.userapi.utils.BlTypeUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BlTServiceTest {
    @Mock
    private BloodTypeRepository bloodTypeRepository;
    @InjectMocks
    private BloodTypeServiceImp bloodTypeServiceImp;

    @Test
    void testGivenBloodTypeDTOTheReturnSavedMessage() {
        BloodTypeDTO bloodTypeDTO = createFakeBlTTDO();
        BloodTypeEntity expectedSavedUser = createFakeBlTEntity();
        when(bloodTypeRepository.save(any(BloodTypeEntity.class)))
                .thenReturn(expectedSavedUser);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedUser.getId());

        MessageResponseDTO succesMessage = this.bloodTypeServiceImp.create(bloodTypeDTO);
        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("blood type created successfully: ID " + id)
                .build();
    }

    @Test
    void testListAllBT() {
        when(bloodTypeRepository.findAll())
                .thenReturn(Lists.newArrayList());
        assertTrue(this.bloodTypeServiceImp.getAll().isEmpty());
    }


    private MessageResponseDTO updateExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("BloodyType is Update-" + id)
                .build();
    }

    @Test
    void testGivenBloodTypeThenReturnUpdateMessage() {
        BloodTypeEntity expectedSavedUser = createFakeBlTEntity();
        when(bloodTypeRepository.save(any(BloodTypeEntity.class)))
                                .thenReturn(expectedSavedUser);
        when(bloodTypeRepository.findById(anyLong()))
                .thenReturn(Optional.of(expectedSavedUser));

        MessageResponseDTO expectedSuccessMessage = updateExpectedMessageResponse(expectedSavedUser.getId());

        MessageResponseDTO succesMessage = this.bloodTypeServiceImp.updatebyId(createFakeBlTEntity().getId(),createFakeBlTTDO());

        assertEquals(expectedSuccessMessage, succesMessage);

    }
    @Test
    void testDeleteBlT() {

        when(this.bloodTypeRepository.findById(1L))
                .thenReturn(BlTypeUtil.createFakeBlTOptional());
        this.bloodTypeServiceImp.delete(1L);
        verify(this.bloodTypeRepository).deleteById(1L);
    }

    @Test
    void testFindByCpfFail() {

        when(bloodTypeRepository.findBloodTypeCpf(""))
            .thenReturn(bloodTypeServiceImp.findBloodTypeCpf(""));

    assertEquals(this.bloodTypeRepository.findBloodTypeCpf("")

            ,UserMapper.INSTANCE.toDTO(UserUtil.createFakeEntityOptional()
                    .get()));
    }

     @Test
     void testFindByCpfSucess() {
     when(bloodTypeRepository.findBloodTypeCpf(""))
     .thenReturn(bloodTypeServiceImp.findBloodTypeCpf(""));
        Assert.assertThrows(UserNotFoundException.class,()->this.bloodTypeServiceImp.findBloodTypeCpf(""));
    }


}
