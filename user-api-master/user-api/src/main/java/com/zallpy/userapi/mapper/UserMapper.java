package com.zallpy.userapi.mapper;

import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserEntity toModel(UserDTO userDTO);
    UserDTO toDTO(UserEntity userEntity);

}
