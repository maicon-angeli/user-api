package com.zallpy.userapi.controllertest;

import com.zallpy.userapi.controller.BloodTypeController;
import com.zallpy.userapi.controller.DocumentsController;
import com.zallpy.userapi.controller.ExamsController;
import com.zallpy.userapi.controller.UserController;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.serviceTest.imp.ExamsServiceImpl;
import com.zallpy.userapi.utils.ExamsUtil;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@WebMvcTest
public class ExamsControllerTest {
    @Autowired
    private ExamsController examsController;

    @MockBean
    private ExamsServiceImpl examsService;
    @MockBean
    private DocumentsController documentsController;
    @MockBean
    private UserController userController;
    @MockBean
    private BloodTypeController bloodTypeController;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.userController);

    }
    @Test
    public void findAllSuccess() {
        Mockito.when(this.examsService.getAll())
                .thenReturn(Lists.newArrayList());

        Assert.assertTrue(this.examsService.getAll().isEmpty());

    }
    @Test
    public void successCreateUser() {
        Mockito.when(this.examsController.create(any()))
                .thenReturn(MessageResponseDTO.builder()
                        .message("Created exams with ID ")
                        .build());

        Assert.assertEquals(this.examsController.create(any()), MessageResponseDTO.builder()
                .message("Created exams with ID ")
                .build());
    }

    @Test
    public void deleteByIdTest() {
        this.examsController.deleteById(1L);
        verify(examsService).delete(1L);
    }

    @Test
    public void updateByIdTest() {
        Mockito.when(this.examsService.updatebyId(1L, ExamsUtil.createFakeExDTO()))
                .thenReturn( MessageResponseDTO.builder()
                        .message("Update user with ID ")
                        .build());

        Assert.assertEquals(this.examsController.updateById(1L, ExamsUtil.createFakeExDTO())
                , MessageResponseDTO.builder()
                .message("Update user with ID ")
                .build());
    }

    @Test
    public void findByRg() {
        Mockito.when(this.examsService.findByRg(""))
                .thenReturn(Lists.newArrayList());

        Assert.assertTrue(this.examsController.findExamsByRg("").isEmpty());

    }

}
