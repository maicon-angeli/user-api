package com.zallpy.userapi.repository;

import com.zallpy.userapi.entity.ExamsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamsRepository extends JpaRepository<ExamsEntity , Long> {
}
