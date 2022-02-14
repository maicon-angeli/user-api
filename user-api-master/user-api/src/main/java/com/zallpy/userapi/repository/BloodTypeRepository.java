package com.zallpy.userapi.repository;

import com.zallpy.userapi.entity.BloodTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodTypeRepository extends JpaRepository<BloodTypeEntity , Long> {
}
