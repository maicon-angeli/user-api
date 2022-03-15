package com.zallpy.userapi.serviceTest;

import com.zallpy.userapi.dto.request.ExamsDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.ExamsEntity;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.repository.ExamsRepository;
import com.zallpy.userapi.repository.UserRepository;
import com.zallpy.userapi.service.imp.ExamsServiceImpl;
import com.zallpy.userapi.utils.ExamsUtil;
import com.zallpy.userapi.exception.ApiException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.zallpy.userapi.utils.ExamsUtil.createFakeEx;
import static com.zallpy.userapi.utils.ExamsUtil.createFakeExDTO;

import static org.junit.jupiter.api.Assertions.*;
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

        when(examsRepository.findAllDTO())
                .thenReturn(Lists.newArrayList());

        assertTrue(this.examsService.getAll().isEmpty());
    }

    @Test
    void testGivenUserDTOThenReturnSavedMessage() {
        ExamsDTO examsDTO = createFakeExDTO();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        examsDTO.setUserId(1L);
        ExamsEntity expectedSavedexam = createFakeEx();
        when(examsRepository.save(any(ExamsEntity.class)))
                .thenReturn(expectedSavedexam);
        when(userRepository.findById(1L))
                .thenReturn(Optional.of(userEntity));

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedexam.getExamName());

        MessageResponseDTO succesMessage = this.examsService.create(examsDTO);
        assertEquals(expectedSuccessMessage, succesMessage);
    }
    @Test
    void testGivenUserDTOThenReturnFailMessage() {
        ExamsDTO examsDTO = createFakeExDTO();
        examsDTO.setUserId(1L);
          when(userRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(ApiException.class,()->this.examsService.create(examsDTO));
    }

    private MessageResponseDTO createExpectedMessageResponse( String message) {
        return MessageResponseDTO
                .builder()
                .message("Registered exam----" + message)
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
        ExamsDTO examsDTO = createFakeExDTO();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        examsDTO.setUserId(1L);
        ExamsEntity expectedSavedExam = createFakeEx();
        when(examsRepository.save(any(ExamsEntity.class)))
                .thenReturn(expectedSavedExam);
        when(examsRepository.findById(anyLong()))
                .thenReturn(Optional.of(expectedSavedExam));
        when(userRepository.findById(1L))
                .thenReturn(Optional.of(userEntity));
        MessageResponseDTO expectedSuccessMessage = updateExpectedMessageResponse(expectedSavedExam.getExamName());

        MessageResponseDTO succesMessage = this.examsService.updatebyId(1L,examsDTO);

        assertEquals(expectedSuccessMessage, succesMessage);

    }
    private MessageResponseDTO updateExpectedMessageResponse(String message) {
        return MessageResponseDTO
                .builder()
                .message("Exam update---" + message)
                .build();
    }

    @Test
    void testListAllExamsFindByRG() {

        when(examsRepository.examsFindByRg(""))
                .thenReturn(Lists.newArrayList());

        assertTrue(this.examsService.findByRg("").isEmpty());
    }
    @Test
    void testGivenUserDTOThenReturnUpdateMessageFail() {
        ExamsDTO examsDTO = createFakeExDTO();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        examsDTO.setUserId(1L);
        ExamsEntity expectedSavedExam = createFakeEx();
         when(examsRepository.findById(anyLong()))
                .thenReturn(Optional.of(expectedSavedExam));
        when(userRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(ApiException.class,()->this.examsService.updatebyId(1L,examsDTO));

    }

}
