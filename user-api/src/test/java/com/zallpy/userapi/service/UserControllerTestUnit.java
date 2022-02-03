package com.zallpy.userapi.service;

import com.zallpy.userapi.controller.UserController;
import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.utils.UserCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)

public class UserControllerTestUnit {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userServiceMock;

    @BeforeEach
    void setup(){
     Page <UserDTO> userPage = new PageImpl<> ( List.of(UserCreator.createValidUser()));
        BDDMockito.when(userServiceMock.listALL())
                .thenReturn(List.of(UserCreator.createValidUser()));

        BDDMockito.when(userServiceMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(UserCreator.createValidUser());

        BDDMockito.when(userServiceMock.createUser(ArgumentMatchers.any(UserDTO.class)))
                .thenReturn(MessageResponseDTO.builder().build());
    }


    @Test
    @DisplayName("List return list of users inside page object when successful")
    void list_ReturnsUser(){
        String expectdName = UserCreator.createValidUser().getFirstName();
        List<UserDTO> userPage = userController.listallUser().stream().collect(Collectors.toList());



        }

    @Test
    @DisplayName("FindByUser inside page object when successful")
    void CreateUserID(){
       String expectedname =  UserCreator.createValidUser().getFirstName();





    }

}

/**

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void userTestGetAll() throws Exception {
      userService.listALL();
        mockMvc.perform(get("/api"))

                .andExpect(status().isOk());
    }

    @Test
    public void userPostTest() throws Exception {
        UserDTO userDTO =new UserDTO("Joao","Alfredo","alfredof@email.com",51,"S");

        mockMvc.perform(post("/api")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isCreated());
    }
    @Test
    public void userPutTest() throws Exception{

    }

**/



