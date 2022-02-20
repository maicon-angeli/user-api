package com.zallpy.userapi.dto.request;

import com.zallpy.userapi.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentsDTO {


    private Long id;

    @NotEmpty
    private String cpf;

    @NotEmpty
    private String rg;

    private String susNumber;



}
