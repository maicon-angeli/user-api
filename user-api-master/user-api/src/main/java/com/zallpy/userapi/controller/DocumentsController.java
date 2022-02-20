package com.zallpy.userapi.controller;


import com.zallpy.userapi.dto.request.BloodTypeDTO;
import com.zallpy.userapi.dto.request.DocumentsDTO;
import com.zallpy.userapi.entity.DocumentsEntity;
import com.zallpy.userapi.service.imp.DocumentsServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docs")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DocumentsController {

    DocumentsServiceImp documentsServiceImp;

    @GetMapping
    public List<DocumentsDTO> getAllDoc(){

        return documentsServiceImp.getAllDoc();
    }
    /** ESTA SENDO CRIADO/ATUALIZADO /EXCLUIDO PELO UserController!
    @PostMapping
    public DocumentsDTO create(@RequestBody DocumentsDTO documentsDTO){

        return documentsServiceImp.create(documentsDTO);
    }
    **/
}
