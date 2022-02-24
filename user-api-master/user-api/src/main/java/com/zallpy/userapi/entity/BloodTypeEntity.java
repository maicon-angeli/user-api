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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_blood_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BloodTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bloodType;

    @OneToMany (mappedBy = "bloodTypeEntity", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserEntity> userEntityBlood;




}
