package com.zallpy.userapi.service;



import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.request.UserDTOImpl;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.dto.response.UserSearchAgeDTO;
import com.zallpy.userapi.dto.response.UserNameDTO;
import com.zallpy.userapi.entity.UserEntity;
import exception.UserNotFoundException;
import com.zallpy.userapi.mapper.UserMapper;
import com.zallpy.userapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;


    public MessageResponseDTO createUser(UserDTOImpl userDTO) {


        return createMessageResponse(userRepository.save(userMapper.toModel(userDTO)).getId()
                , "Created user with ID ");
    }

    public List<UserDTO> listALL(){

        return userRepository.findAllCustom();

    }

    public UserDTOImpl findById(Long id)  {
        UserEntity usurious = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
        return userMapper.toDTO(usurious);
    }

    public void delete(Long id) {
        verifyIfExists(id);
        userRepository.deleteById(id);
    }

    public MessageResponseDTO updateById( Long id, UserDTOImpl userDTO) {
        verifyIfExists(id);

        UserEntity usuriousToUpdate = userMapper.toModel(userDTO);
        UserEntity updateUser =userRepository.save(usuriousToUpdate);
        return createMessageResponse(updateUser.getId(), "Updated user with ID ");
    }
    public UserEntity verifyIfExists(Long id) throws UserNotFoundException{
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
    }
    public UserNameDTO findUserNameByEmail(String email)  {
        UserNameDTO usurious = userRepository.findUserNameByEmail(email);
        if(Objects.isNull(usurious)){
            throw new UserNotFoundException(HttpStatus.NOT_FOUND,"Usuario não encontrado!");
        }
        return usurious;
    }
    public List <UserSearchAgeDTO>ListAge(int age){


        return userRepository.findUserSearchAge(age);
    }

    private MessageResponseDTO createMessageResponse(long id, String message) {
        return MessageResponseDTO
                .builder()
                .message( message + id)
                .build();
    }


}
