package com.zallpy.userapi.dto.request;



import com.zallpy.userapi.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodTypeDTO  {


    private Long id;
    @NotEmpty
    private String bloodType;




}
