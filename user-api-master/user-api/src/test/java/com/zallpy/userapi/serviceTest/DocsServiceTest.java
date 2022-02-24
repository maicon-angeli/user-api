package com.zallpy.userapi.serviceTest;

import com.zallpy.userapi.repository.DocumentsRepository;
import com.zallpy.userapi.serviceTest.imp.DocumentsServiceImp;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
/**
    @Test
    void listTestByEmailSucess(){
        when (documentsRepository.findDocsByEmail(anyString()))
                .thenReturn(DocsUtil.createFakeDocOpt());
    assertEquals(this.documentsServiceImp.docsByEmail(""), UserMapper.INSTANCE.toDTO(DocsUtil.createFakeDocOpt()
            .get()));
    }
    @Test
    void testFindByIdFail() {

        when (documentsRepository.findDocsByEmail(anyString()))
                .thenReturn(Optional.empty());
        Assert.assertThrows(UserNotFoundException.class,()->this.documentsServiceImp.docsByEmail(""));
    }
*/
}
