package com.zallpy.userapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="user_entity")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private int age;

    private String active;

    @OneToMany (mappedBy = "userEntity", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ExamsEntity> examsEntities;

    @OneToOne (mappedBy = "userEntityDoc", fetch =FetchType.LAZY)
    private DocumentsEntity documentsEntity ;

    @ManyToOne(fetch =FetchType.LAZY)
    private BloodTypeEntity bloodTypeEntity ;





}
