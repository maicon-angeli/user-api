package com.zallpy.userapi.controllertest;

import com.zallpy.userapi.controller.BloodTypeController;
import com.zallpy.userapi.controller.DocumentsController;
import com.zallpy.userapi.controller.ExamsController;
import com.zallpy.userapi.controller.UserController;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.dto.response.UserNameDTO;
import com.zallpy.userapi.service.imp.UserService;

import com.zallpy.userapi.utils.UserUtil;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@WebMvcTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;
    @MockBean
    private DocumentsController documentsController;
    @MockBean
    private ExamsController examsController;
    @MockBean
    private BloodTypeController bloodTypeController;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.userController);

    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarUsuario() {
        Mockito.when(this.userService.findById(1L))
                .thenReturn(UserUtil.createFakeDTO());
        when()
                .get("/api/{id}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
        Assert.assertEquals(this.userController.findById(1L), UserUtil.createFakeDTO());

    }

    @Test
    public void successCreateUser() {
        Mockito.when(this.userController.create(any()))
                .thenReturn(MessageResponseDTO.builder()
                        .message("Created user with ID ")
                        .build());

        Assert.assertEquals(this.userController.create(any()), MessageResponseDTO.builder()
                .message("Created user with ID ")
                .build());

    }

    @Test
    public void findAllSuccess() {
        Mockito.when(this.userService.listALL())
          .thenReturn(Lists.newArrayList());
        Assert.assertTrue(this.userController.listallUser().isEmpty());

    }

    @Test
    public void updateByIdTest() {
        Mockito.when(this.userService.updateById(1L, UserUtil.createFakeDTO()))
                .thenReturn(MessageResponseDTO.builder()
                        .message("Update user with ID ")
                        .build());

        Assert.assertEquals(this.userController.updateById(1L, UserUtil.createFakeDTO()), MessageResponseDTO.builder()
                .message("Update user with ID ")
                .build());


    }

    @Test
    public void deleteByIdTest() {
        this.userController.deleteById(1L);
        verify(userService).delete(1L);
    }
    @Test
    public void findAllbyAge() {
        Mockito.when(this.userService.ListAge(1))
                .thenReturn(Lists.newArrayList());

        Assert.assertTrue(this.userController.findNameByAge(1).isEmpty());
    }

    @Test
    public void findByEmail(){
        UserNameDTO userNameDTO = UserUtil.createFakeUserEmail();
        Mockito.when(this.userService.findUserNameByEmail(""))
                .thenReturn(userNameDTO);

        Assert.assertEquals(this.userController.findNameByEmail("")
                ,userNameDTO);
    }



}










