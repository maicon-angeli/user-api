package com.zallpy.userapi.mapper;

import com.zallpy.userapi.dto.request.UserDTOImpl;
import com.zallpy.userapi.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserEntity toModel(UserDTOImpl userDTOImpl);
    UserDTOImpl toDTO(UserEntity userEntity);

}
