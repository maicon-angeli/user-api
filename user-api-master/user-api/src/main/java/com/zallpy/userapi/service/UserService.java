package com.zallpy.userapi.service;



import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.UserEntity;
import exception.UserNotFoundException;
import com.zallpy.userapi.mapper.UserMapper;
import com.zallpy.userapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;


    public MessageResponseDTO createUser(UserDTO userDTO) {

        return createMessageResponse(userRepository.save(userMapper.toModel(userDTO)).getId()
                , "Created user with ID ");
    }

    public List<UserDTO> listALL(){
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id)  {
        UserEntity usurious = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
        return userMapper.toDTO(usurious);
    }

    public void delete(Long id) {
        verifyIfExists(id);
        userRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(  UserDTO userDTO) {

        UserEntity usuriousToUpdate = userMapper.toModel(userDTO);

        return createMessageResponse(userRepository.save(usuriousToUpdate).getId(), "Updated user with ID ");
    }
    public UserEntity verifyIfExists(Long id) throws UserNotFoundException{
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
    }

    private MessageResponseDTO createMessageResponse(long id, String message) {
        return MessageResponseDTO
                .builder()
                .message( message + id)
                .build();
    }

}
