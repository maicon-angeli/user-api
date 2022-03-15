package com.zallpy.userapi.controllertest;

import com.zallpy.userapi.controller.BloodTypeController;
import com.zallpy.userapi.controller.DocumentsController;
import com.zallpy.userapi.controller.ExamsController;
import com.zallpy.userapi.controller.UserController;
import com.zallpy.userapi.dto.response.DocsByEmail;

import com.zallpy.userapi.service.imp.DocumentsServiceImp;
import com.zallpy.userapi.utils.DocsUtil;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.annotation.PathVariable;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

@WebMvcTest
public class DocsControllerTest {

    @Autowired
    private DocumentsController documentsController;

    @MockBean
    private DocumentsServiceImp documentsService;
    @MockBean
    private UserController userController;
    @MockBean
    private ExamsController examsController;
    @MockBean
    private BloodTypeController bloodTypeController;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.userController);
    }
    @Test
    public void findAllSuccess() {
        Mockito.when(this.documentsController.getAllDoc())
                .thenReturn(Lists.newArrayList());

        Assert.assertTrue(this.documentsController.getAllDoc().isEmpty());
    }

    @Test
    public void findBYEMAIL() {
        DocsByEmail docsByEmail = DocsUtil.createFakeDocsByEmail();
        Mockito.when(this.documentsService.docsByEmail(""))
                .thenReturn(docsByEmail);

        Assert.assertEquals(this.documentsController.docsByEmail(""),docsByEmail);
    }
}
