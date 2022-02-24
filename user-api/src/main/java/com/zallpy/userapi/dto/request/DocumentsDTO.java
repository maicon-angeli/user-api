package com.zallpy.userapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;

@Builder
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
