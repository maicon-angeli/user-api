package com.zallpy.userapi.serviceTest.imp;

import com.zallpy.userapi.dto.request.DocumentsDTO;
import com.zallpy.userapi.dto.response.DocsByEmail;
import com.zallpy.userapi.entity.DocumentsEntity;
import com.zallpy.userapi.repository.DocumentsRepository;
import com.zallpy.userapi.utils.Interface.Mappable;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DocumentsServiceImp implements Mappable {

    DocumentsRepository documentsRepository;

    public List<DocumentsDTO> getAllDoc() {
        List<DocumentsEntity> allDocs = documentsRepository.findAll();

        return map(allDocs, DocumentsDTO.class);
    }

    public DocsByEmail docsByEmail(String email) {
        return documentsRepository.findDocsByEmail(email);
    }

    /** ESTÁ SENDO CADASTRATADO E ATUALIZADO PELO USER
     public DocumentsDTO create(DocumentsDTO documentsDTO) {
     DocumentsEntity createDocsEntity = map(documentsDTO, DocumentsEntity.class);
     DocumentsEntity createDocs = documentsRepository.save(createDocsEntity);
     return map(createDocs , DocumentsDTO.class);
     }
     */
}
