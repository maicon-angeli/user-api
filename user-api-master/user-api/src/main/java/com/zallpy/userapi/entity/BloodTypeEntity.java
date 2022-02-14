package com.zallpy.userapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blood_type_entity")
public class BloodTypeEntity {

    @Id
    private Long id;

    private String bloodType;

    @OneToMany (mappedBy = "bloodTypeEntity", fetch =FetchType.LAZY)
    private List<UserEntity> userEntityBlood;




}
