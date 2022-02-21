package com.zallpy.userapi.repository;

import com.zallpy.userapi.dto.response.BloodTypeCpf;
import com.zallpy.userapi.entity.BloodTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BloodTypeRepository extends JpaRepository<BloodTypeEntity , Long> {


    @Query(value = "SELECT tu.id, CONCAT(tu.first_name , ' ', tu.last_name)fullName, " +
            " tbt.blood_type bloodType, cpf  FROM  tb_users tu " +
            "JOIN tb_blood_type tbt ON tu.id = tbt.id "  +
            "JOIN tb_users_documents_entity tude ON tu.id = tude.user_entity_id " +
            "JOIN tb_docs td ON tude.documents_entity_id =td.id " +
            "WHERE cpf = :cpf ", nativeQuery = true)
    BloodTypeCpf findBloodTypeCpf (@Param("cpf")  String cpf);

}
