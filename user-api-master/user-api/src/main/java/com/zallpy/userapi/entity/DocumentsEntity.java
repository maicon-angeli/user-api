package com.zallpy.userapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents_entity")
public class DocumentsEntity {

    @Id
    private Long id;

    @CPF
    private String cpf;

    @Column(unique = true)
    private String rg;

    @Column(unique = true)
    private String susNumber;

    @OneToOne
    private UserEntity userEntityDoc;
}
