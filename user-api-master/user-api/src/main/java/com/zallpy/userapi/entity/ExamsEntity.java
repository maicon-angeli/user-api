package com.zallpy.userapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_exams")
public class ExamsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String examName;

    private double examCost;

    @ManyToOne
    @JoinColumn(name = "userEntity_id")
    private UserEntity userEntity;

}
