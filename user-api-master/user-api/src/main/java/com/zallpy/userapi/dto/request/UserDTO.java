package com.zallpy.userapi.dto.request;

import com.zallpy.userapi.entity.BloodTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO  {

    private Long id;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    private String email;

    private int age;

    private String active;

    @Valid
    @NotEmpty
    private List<DocumentsDTO> documentsEntity;

    private BloodTypeEntity bloodTypeEntity;




}

