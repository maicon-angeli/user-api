package com.zallpy.userapi.controllerTest;

import com.zallpy.userapi.controller.BloodTypeController;
import com.zallpy.userapi.controller.DocumentsController;
import com.zallpy.userapi.controller.ExamsController;
import com.zallpy.userapi.controller.LoginController;
import com.zallpy.userapi.controller.UserController;
import com.zallpy.userapi.controller.UserLogController;
import com.zallpy.userapi.dto.response.MessageResponseDTO;


import com.zallpy.userapi.service.imp.UserLogService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserLogControllerTest {

    @Autowired
    private UserLogController userControl;


    @MockBean
    private UserLogService logService;
    @MockBean
    private DocumentsController documentsController;
    @MockBean
    private ExamsController examsController;
    @MockBean
    private BloodTypeController bloodTypeController;
    @MockBean
    private UserController userController;
    @MockBean
    private LoginController loginController;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.userControl);

}

}
