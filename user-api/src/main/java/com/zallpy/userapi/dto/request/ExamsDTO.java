package com.zallpy.userapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamsDTO extends RepresentationModel <ExamsDTO> {


    private long id;

    @NotEmpty
    private String examName;
    @NotEmpty
    private double examCost;

    private Long userId;
}

