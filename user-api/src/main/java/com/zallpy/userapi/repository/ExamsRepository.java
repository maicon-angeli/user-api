package com.zallpy.userapi.repository;

import com.zallpy.userapi.dto.response.ExamsCSV;
import com.zallpy.userapi.dto.response.ExamsFindByRg;
import com.zallpy.userapi.dto.response.ExamsGetAll;
import com.zallpy.userapi.dto.response.ExamsRelat;
import com.zallpy.userapi.entity.ExamsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamsRepository extends JpaRepository<ExamsEntity, Long> {
    @Query(value = "select tb_exams.id, exam_cost examCost , exam_name examName,concat(tb_users.first_name, ' ' "
            + ",tb_users.last_name) as user from tb_exams "
            + "join tb_users on tb_users.id = tb_exams.user_entity_id ", nativeQuery = true)
    List<ExamsRelat> findAllDTO();

    @Query(value ="SELECT te.id , exam_cost examCost , exam_name examName, first_name firstName, rg  FROM tb_exams te " +
            "JOIN tb_users tu ON te.user_entity_id = tu.id " +
            "JOIN tb_users_documents_entity tude ON  tu.id = tude.user_entity_id " +
            "JOIN tb_docs td  ON tude.documents_entity_id = td.id " +
            "WHERE rg = :rg" , nativeQuery = true )
    List<ExamsFindByRg> examsFindByRg(@Param("rg")  String rg);
    @Query(value = "SELECT te.id , te.exam_cost examCost , te.exam_name examName, " +
            " concat(first_name ,'',last_name )fullName , td.rg, "+
            " td.cpf, tu.email ,td.sus_number susNumber,tu.age ,tu.active  FROM tb_exams te " +
            "JOIN tb_users tu ON te.user_entity_id = tu.id " +
            "JOIN tb_users_documents_entity tude ON  tu.id = tude.user_entity_id " +
            "JOIN tb_docs td  ON tude.documents_entity_id = td.id ",nativeQuery = true)
    List<ExamsGetAll> GetAll();



}
