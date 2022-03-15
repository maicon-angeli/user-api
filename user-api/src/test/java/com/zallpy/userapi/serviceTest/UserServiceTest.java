package com.zallpy.userapi.serviceTest;

import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.dto.response.UserNameDTO;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.mapper.UserMapper;
import com.zallpy.userapi.repository.UserRepository;
import com.zallpy.userapi.service.imp.UserService;
import com.zallpy.userapi.utils.UserUtil;
import com.zallpy.userapi.exception.ApiException;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.zallpy.userapi.utils.UserUtil.*;
import static com.zallpy.userapi.utils.UserUtil.createFakeDTO;
import static org.junit.jupiter.api.Assertions.*;
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
        Assert.assertThrows(ApiException.class, () -> this.userService.findById(1L));
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
        when(userRepository.findById(anyLong()))
                .thenReturn(Optional.of(expectedSavedUser));

        MessageResponseDTO expectedSuccessMessage = updateExpectedMessageResponse(expectedSavedUser.getId());

        MessageResponseDTO succesMessage = this.userService.updateById(createFakeEntity().getId(), createFakeDTO());

        assertEquals(expectedSuccessMessage, succesMessage);

    }

    private MessageResponseDTO updateExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Update user with ID " + id)
                .build();
    }

    @Test
    public void findAllSucess() {

        Mockito.when(this.userRepository.findUserSearchAge(1))
                .thenReturn(Lists.newArrayList());
        Assert.assertTrue(this.userService.ListAge(1).isEmpty());
    }

    @Test
    void testFindByEmail() {
        UserNameDTO userNameDTO = UserUtil.createFakeUserEmail();
        when(userRepository.findUserNameByEmail(""))
                .thenReturn(userNameDTO);

        assertEquals(this.userService.findUserNameByEmail(""), userNameDTO);
    }

    @Test
    void testFindByEmailFail() {
        UserNameDTO userNameDTO = UserUtil.createFakeUserEmail();
        when(userRepository.findUserNameByEmail(""))
                .thenReturn(null);
        Assert.assertThrows(ApiException.class, () -> this.userService.findUserNameByEmail(""));
    }
}