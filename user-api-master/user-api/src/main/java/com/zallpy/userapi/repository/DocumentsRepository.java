package com.zallpy.userapi.repository;

import com.zallpy.userapi.dto.response.DocsByEmail;
import com.zallpy.userapi.entity.DocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocumentsRepository extends JpaRepository<DocumentsEntity, Long> {
    @Query(value ="SELECT tu.id , CONCAT(tu.first_name  , ' ',tu.last_name)fullName,cpf,rg,sus_number" +
            " susNumber FROM tb_users tu " +
            "JOIN tb_users_documents_entity tude  ON tu.id  = tude.user_entity_id " +
            "JOIN tb_docs td  ON tude.documents_entity_id = td.id " +
            "WHERE email = :email ", nativeQuery = true)
    DocsByEmail findDocsByEmail(@Param("email")  String email);
}
