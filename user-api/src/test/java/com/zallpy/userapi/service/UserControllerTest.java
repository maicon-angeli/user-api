package com.zallpy.userapi.service;

import com.zallpy.userapi.controller.UserController;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.repository.UserRepository;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@WebMvcTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;


    @BeforeEach
    public void setup(){
     standaloneSetup(this.userController);

    }
    @Test
    public void deveRetornarSucesso_QuandoBuscarUsuario(){
            Mockito.when( this.userService.findById(1L))
                .thenReturn( new UserDTO("Maicon","Angeli","maicon@teste.com",31,"s"));


            when()
                    .get("/api/{id}",1L)
                    .then()
                    .statusCode(HttpStatus.OK.value());

    }
        @Test
        public void deveRetornarQuandoNao_HaveraSucesso(){
            Mockito.when( this.userService.findById(7L))
                    .thenReturn(null);

            when()
                    .get("/api/{id}",7L)
                    .then()
                    .statusCode(HttpStatus.NOT_FOUND.value());

}}
