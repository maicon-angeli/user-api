package com.zallpy.userapi.service;
import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.repository.UserRepository;
import com.zallpy.userapi.utils.UserUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

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
                .message("Updated user with ID " + id)
                .build();
    }



    }

