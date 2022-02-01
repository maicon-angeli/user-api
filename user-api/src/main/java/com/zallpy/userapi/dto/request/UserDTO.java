package com.zallpy.userapi.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends RepresentationModel<UserDTO> {



    @NotEmpty
    @Size (min = 2, max = 100)
    private String firstName;
    @NotEmpty
    @Size (min = 2, max = 100)
    private String lastName;
    private String email;

    private int age;

    private String active;
}
