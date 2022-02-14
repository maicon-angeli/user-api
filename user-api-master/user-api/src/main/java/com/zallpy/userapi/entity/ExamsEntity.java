package com.zallpy.userapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exams_entity")
public class ExamsEntity {

    @Id
    private long id;

    private String examName;

    private Float examCost;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userEntity_id")
    private UserEntity userEntity;
}
