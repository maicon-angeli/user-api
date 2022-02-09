package com.zallpy.userapi.repository;


import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.request.UserDTOImpl;
import com.zallpy.userapi.dto.response.UserSearchAgeDTO;
import com.zallpy.userapi.dto.response.UserNameDTO;
import com.zallpy.userapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "select id,first_name as firstName,last_name as lastName, email , age ,active " +
            "from user_entity order by id" , nativeQuery = true)
    List <UserDTO> findAllCustom();

    @Query(value = "select id,CONCAT (first_name,' ',last_name)as fullName from user_entity  " +
            "where email = :email" , nativeQuery = true)
    UserNameDTO findUserNameByEmail(@Param("email")  String email);

    @Query(value = "select id,CONCAT (first_name,' ',last_name)as compliName from user_entity  " +
            "where age = :age" , nativeQuery = true)
    List <UserSearchAgeDTO> findUserSearchAge(@Param("age") int age);
}
