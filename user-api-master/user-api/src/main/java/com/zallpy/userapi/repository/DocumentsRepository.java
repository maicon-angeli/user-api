package com.zallpy.userapi.repository;

import com.zallpy.userapi.entity.DocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsRepository extends JpaRepository<DocumentsEntity, Long> {
}
