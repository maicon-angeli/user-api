package com.zallpy.userapi.controllertest;

import com.zallpy.userapi.controller.BloodTypeController;
import com.zallpy.userapi.controller.DocumentsController;
import com.zallpy.userapi.controller.ExamsController;
import com.zallpy.userapi.controller.UserController;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.serviceTest.imp.BloodTypeServiceImp;
import com.zallpy.userapi.utils.BlTypeUtil;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@WebMvcTest
public class BlTControllerTest {

    @Autowired
    private BloodTypeController bloodTypeController;
    @MockBean
    private BloodTypeServiceImp bloodTypeServiceImp;
    @MockBean
    private DocumentsController documentsController;
    @MockBean
    private ExamsController examsController;
    @MockBean
    private UserController userController;


    @Before
    public void setup() {
        standaloneSetup(this.bloodTypeController);
    }

    @Test
    public void findAllSucess() {
        Mockito.when(this.bloodTypeServiceImp.getAll())
                .thenReturn(Lists.newArrayList());
        Assert.assertTrue(this.bloodTypeController.getAll().isEmpty());
    }

    @Test
    public void successCreateUser() {
        Mockito.when(this.bloodTypeController.create(any()))
                .thenReturn(MessageResponseDTO.builder()
                        .message("Created bloodtype with ID ")
                        .build());

        Assert.assertEquals(this.bloodTypeController.create(any()), MessageResponseDTO.builder()
                .message("Created bloodtype with ID ")
                .build());
    }

    @Test
    public void updateByIdTest() {
        Mockito.when(this.bloodTypeController.updateById(1L, BlTypeUtil.createFakeBlTTDO()))
                .thenReturn(MessageResponseDTO.builder()
                        .message("Update user with ID ")
                        .build());

        Assert.assertEquals(this.bloodTypeController.updateById(1L,BlTypeUtil.createFakeBlTTDO()), MessageResponseDTO.builder()
                .message("Update user with ID ")
                .build());
    }

    @Test
    public void deleteByIdTest(){
        this.bloodTypeController.deleteById(1L);
        verify(bloodTypeServiceImp).delete(1L);
    }
    /**
    @Test
    public void findByCpf(){
        Mockito.when(this.bloodTypeController.findBloodTypeCpf("84085851004"))
                .thenReturn(BlTypeUtil.createFakeBlTOptional());
            when()
                    .get("/bloodtype/cpf/{cpf}","84085851004")
                    .then()
                    .statusCode(HttpStatus.OK.value());
            Assert.assertEquals(this.bloodTypeController.findBloodTypeCpf("84085851004"),(BloodTypeCpf) UserUtil.createFakeDTO());


    }
    **/
}






