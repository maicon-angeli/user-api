package com.zallpy.userapi.serviceTest;

import com.zallpy.userapi.dto.response.DocsByEmail;
import com.zallpy.userapi.repository.DocumentsRepository;
import com.zallpy.userapi.service.imp.DocumentsServiceImp;
import com.zallpy.userapi.utils.DocsUtil;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DocsServiceTest {

    @Mock
    private DocumentsRepository documentsRepository;

    @InjectMocks
    private DocumentsServiceImp documentsServiceImp;


    @Test
    void testListAllDocs() {

        when(documentsRepository.findAll())
                .thenReturn(Lists.newArrayList());

        assertTrue(this.documentsServiceImp.getAllDoc().isEmpty());
    }

    @Test
    void listTestByEmailSucess(){
        DocsByEmail docsByEmail = DocsUtil.createFakeDocsByEmail();
        when (documentsRepository.findDocsByEmail(""))
                .thenReturn(docsByEmail);
     assertEquals(this.documentsServiceImp.docsByEmail(""),docsByEmail);
    }




}
