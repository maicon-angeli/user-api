package com.zallpy.userapi.repository;


import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
