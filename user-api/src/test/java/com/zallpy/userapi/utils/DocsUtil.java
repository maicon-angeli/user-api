package com.zallpy.userapi.utils;

import com.zallpy.userapi.dto.request.DocumentsDTO;
import com.zallpy.userapi.dto.response.DocsByEmail;
import com.zallpy.userapi.entity.DocumentsEntity;

import java.util.Optional;

public class DocsUtil {
    private static final Long DOCUMENTS_ENTITY_ID = 1L;
    private static final String CPF ="840.858.510-04";
    private static final String RG = "603131.99";
    private static final String SUS_NUMBER = "123603131.99";

    public static DocumentsEntity createFakeDocEnt(){
        return DocumentsEntity.builder()
                .id(DOCUMENTS_ENTITY_ID)
                .cpf(CPF)
                .rg(RG)
                .susNumber(SUS_NUMBER)
                .build();
    }
    public static DocumentsDTO createFakeDocDTO(){
        return DocumentsDTO.builder()
                .id(DOCUMENTS_ENTITY_ID)
                .cpf(CPF)
                .rg(RG)
                .susNumber(SUS_NUMBER)
                .build();
    }
    public static Optional<DocumentsEntity> createFakeDocOpt(){
        return Optional.ofNullable(DocumentsEntity.builder()
                .id(DOCUMENTS_ENTITY_ID)
                .cpf(CPF)
                .rg(RG)
                .susNumber(SUS_NUMBER)
                .build());
    }

    public static DocsByEmail createFakeDocsByEmail(){
        return new DocsByEmail() {
            @Override
            public Long getId() {
                return null;
            }

            @Override
            public String getFullName() {
                return null;
            }

            @Override
            public String getCpf() {
                return null;
            }

            @Override
            public String getRg() {
                return null;
            }

            @Override
            public String getSusNumber() {
                return null;
            }
        } ;


}
}
