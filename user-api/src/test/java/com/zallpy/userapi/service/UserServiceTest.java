package com.zallpy.userapi.service;
import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.repository.UserRepository;
import com.zallpy.userapi.utils.UserUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UserServiceTest {

        @Mock
        private UserRepository userRepository;
        @InjectMocks
        private UserService userService;

        @Test
        void testGivenPeopleDTOThenReturnSavedMessage() {
            UserDTO userDTO = UserUtil.createFakeDTO();
            UserEntity expectedSavedUser = UserUtil.createFakeEntity();
            Mockito.when((UserEntity)this.userRepository.save((UserEntity) ArgumentMatchers.any(UserEntity.class)))
                    .thenReturn(expectedSavedUser);
            MessageResponseDTO expectedSuccessMessage = this.createExpectedMessageResponse(expectedSavedUser.getId());
            MessageResponseDTO succesMessage = this.userService.createUser(userDTO);
            Assertions.assertEquals(expectedSuccessMessage, succesMessage);
        }

        private MessageResponseDTO createExpectedMessageResponse(Long id) {
            return MessageResponseDTO.builder().message("Created person with ID " + id).build();
        }
    }

