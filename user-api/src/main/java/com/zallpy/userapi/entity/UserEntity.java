package com.zallpy.userapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="tb_users")

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


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<DocumentsEntity> documentsEntity ;

    @ManyToOne
    @JoinColumn(name = "blood_type_entity_id")
    private BloodTypeEntity bloodTypeEntity ;

}
