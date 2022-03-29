package com.zallpy.userapi.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;


@Data
@Builder
public class MessageResponseDTO extends RepresentationModel<MessageResponseDTO> {


    private String message;


}


