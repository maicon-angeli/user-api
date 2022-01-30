package com.zallpy.userapi.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotEmpty
    @Size (min = 2, max = 100)
    private String firstName;
    @NotEmpty
    @Size (min = 2, max = 100)
    private String lastName;
    @Email
    private String email;
    @NotEmpty
    private int age;

    private String active;
}
