package com.zallpy.userapi.service;
import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.mapper.UserMapper;
import com.zallpy.userapi.repository.UserRepository;
import com.zallpy.userapi.utils.UserUtil;
import exception.UserNotFoundException;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.zallpy.userapi.utils.UserUtil.*;
import static com.zallpy.userapi.utils.UserUtil.createFakeDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    void testGivenUserDTOThenReturnSavedMessage() {
        UserDTO userDTO = createFakeDTO();
        UserEntity expectedSavedUser = createFakeEntity();
        when(userRepository.save(any(UserEntity.class)))
                .thenReturn(expectedSavedUser);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedUser.getId());

        MessageResponseDTO succesMessage = this.userService.createUser(userDTO);
        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created user with ID " + id)
                .build();
    }

    @Test
    void testListAllUser() {

        when(userRepository.findAll())
                .thenReturn(Lists.newArrayList());

        assertTrue(this.userService.listALL().isEmpty());
    }

    @Test
    void testFindByIdSuccess() {

        when(userRepository.findById(anyLong()))
                .thenReturn(UserUtil.createFakeEntityOptional());

        assertEquals(this.userService.findById(1L), UserMapper.INSTANCE.toDTO(UserUtil.createFakeEntityOptional()
                .get()));
    }

    @Test
    void testFindByIdFail() {

        when(userRepository.findById(anyLong()))
                .thenReturn(Optional.empty());
        Assert.assertThrows(UserNotFoundException.class,()->this.userService.findById(1L));
    }
    @Test
    void testDeleteUser() {

        when(this.userRepository.findById(1L))
                .thenReturn(UserUtil.createFakeEntityOptional());
        this.userService.delete(1L);
        verify(this.userRepository).deleteById(1L);

    }
    @Test
    void testGivenUserDTOThenReturnUpdateMessage() {
        UserEntity expectedSavedUser = createFakeEntity();
        when(userRepository.save(any(UserEntity.class)))
                .thenReturn(expectedSavedUser);

        MessageResponseDTO expectedSuccessMessage = updateExpectedMessageResponse(expectedSavedUser.getId());

        MessageResponseDTO succesMessage = this.userService.updateById(createFakeDTO());

        assertEquals(expectedSuccessMessage, succesMessage);

    }
    private MessageResponseDTO updateExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Updated user with ID " + id)
                .build();

}

}