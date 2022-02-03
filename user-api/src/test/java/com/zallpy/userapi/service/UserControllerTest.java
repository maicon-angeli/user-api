package com.zallpy.userapi.service;

import com.zallpy.userapi.controller.UserController;
import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.repository.UserRepository;
import com.zallpy.userapi.utils.UserCreator;
import com.zallpy.userapi.utils.UserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.yaml.snakeyaml.events.Event;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@WebMvcTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @BeforeEach
    public void setup() {
        standaloneSetup(this.userController);

    }

    @Test
    public void deveRetornarSucesso_QuandoBuscarUsuario() {
        Mockito.when(this.userService.findById(1L))
                .thenReturn(new UserDTO("Maicon", "Angeli", "maicon@teste.com", 31, "s"));


        when()
                .get("/api/{id}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());

    }

    @Test
    public void updateByIdTest() {
        Mockito.when(this.userRepository.save(UserUtil.createFakeEntity()))
                .thenReturn(UserUtil.createFakeEntity());
        when()
                .put("/api", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

}
 /**
    public void deleteByIdTest(){
        Mockito.when( this.userService.delete(1L))
                .thenReturn( new UserDTO("Maicon","Angeli","maicon@teste.com",31,"s"));



        when()
                .delete("/api/{id}",1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }
    /**
    @Test
    public void MetodoPutTest() {
        Mockito.when(this.userService.updateById(patch())
                .thenReturn( new UserDTO("Maicon","Angeli","maicon@teste.com",31,"s"));


        when()
                .get("/api/")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
    **/








