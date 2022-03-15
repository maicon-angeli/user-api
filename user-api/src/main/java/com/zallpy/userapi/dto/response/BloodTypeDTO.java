package com.zallpy.userapi.dto.response;



import com.zallpy.userapi.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodTypeDTO  {


    private Long id;
    @NotEmpty
    private String bloodType;




}
