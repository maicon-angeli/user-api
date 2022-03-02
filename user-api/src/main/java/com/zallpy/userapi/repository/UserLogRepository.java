package com.zallpy.userapi.repository;

import com.zallpy.userapi.entity.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserLogRepository extends JpaRepository<UserLog, Long> {

    @Query("SELECT e FROM UserLog e JOIN FETCH e.roles WHERE e.username= (:username)")
    public UserLog findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);


}
