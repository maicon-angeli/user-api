package com.zallpy.userapi.serviceTest;

import com.zallpy.userapi.dto.request.ExamsDTO;
import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.ExamsEntity;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.repository.ExamsRepository;
import com.zallpy.userapi.repository.UserRepository;
import com.zallpy.userapi.serviceTest.imp.ExamsServiceImpl;
import com.zallpy.userapi.utils.ExamsUtil;
import com.zallpy.userapi.utils.UserUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.zallpy.userapi.utils.ExamsUtil.createFakeEx;
import static com.zallpy.userapi.utils.ExamsUtil.createFakeExDTO;

import static com.zallpy.userapi.utils.UserUtil.createFakeDTO;
import static com.zallpy.userapi.utils.UserUtil.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamsServiceTest {

    @Mock
    private ExamsRepository examsRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ExamsServiceImpl examsService;


    @Test
    void testListAllUser() {

        when(examsRepository.findAll())
                .thenReturn(Lists.newArrayList());

        assertTrue(this.examsRepository.findAllDTO().isEmpty());
    }

    @Test
    void testGivenUserDTOThenReturnSavedMessage() {
        ExamsDTO examsDTO = createFakeExDTO();
        ExamsEntity expectedSavedUser = createFakeEx();
        when(examsRepository.save(any(ExamsEntity.class)))
                .thenReturn(expectedSavedUser);
        when(examsRepository.findById(anyLong()))
                .thenReturn(Optional.of(expectedSavedUser));

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedUser.getId());

        MessageResponseDTO succesMessage = this.examsService.create(examsDTO);
        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Registered exam----" + id)
                .build();
    }

    @Test
    void testDeleteExams() {

        when(this.examsRepository.findById(1L))
                .thenReturn(ExamsUtil.createFakeExOp());
        this.examsService.delete(1L);
        verify(this.examsRepository).deleteById(1L);

    }
    @Test
    void testGivenUserDTOThenReturnUpdateMessage() {
        ExamsEntity expectedSavedUser = createFakeEx();
        when(examsRepository.save(any(ExamsEntity.class)))
                .thenReturn(expectedSavedUser);
        when(examsRepository.findById(anyLong()))
                .thenReturn(Optional.of(expectedSavedUser));

        MessageResponseDTO expectedSuccessMessage = updateExpectedMessageResponse(expectedSavedUser.getId());

        MessageResponseDTO succesMessage = this.examsService.updatebyId(createFakeEx().getId(),createFakeExDTO() );

        assertEquals(expectedSuccessMessage, succesMessage);

    }
    private MessageResponseDTO updateExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Exams is Update-" + id)
                .build();
    }

    @Test
    void testListAllExamsFindByRG() {

        when(examsRepository.examsFindByRg(""))
                .thenReturn(Lists.newArrayList());

        assertTrue(this.examsService.findByRg("").isEmpty());
    }

}
