package com.zallpy.userapi.service;



import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.exception.UserNotFoundException;
import com.zallpy.userapi.mapper.UserMapper;
import com.zallpy.userapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;


    public MessageResponseDTO createUser(UserDTO userDTO) {
        UserEntity usuriousToSave = userMapper.toModel(userDTO);

        UserEntity savedUsurious = userRepository.save(usuriousToSave);
        return createMessageResponse(savedUsurious.getId(), "Updated user with ID ");
    }
    public List<UserDTO> listALL()throws UserNotFoundException{
        List<UserEntity> allUser = userRepository.findAll();

        return allUser.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());



    }
    public UserDTO findById(Long id) throws Exception {
        UserEntity usurious = userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));


        return userMapper.toDTO(usurious);
    }
    public void delete(Long id) throws UserNotFoundException, Exception{
        verifyIfExists(id);
        userRepository.deleteById(id);
    }


    public MessageResponseDTO updateById( Long id, UserDTO personDTO)throws Exception {
        verifyIfExists(id);
        UserEntity usuriousToUpdate = userMapper.toModel(personDTO);


        UserEntity updateUsurious = userRepository.save(usuriousToUpdate);
        return createMessageResponse(updateUsurious.getId(), "Updated person with ID ");
    }
    private UserEntity verifyIfExists(Long id) throws UserNotFoundException{
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }




    private MessageResponseDTO createMessageResponse(long id, String message) {
        return MessageResponseDTO
                .builder()
                .message( message + id)
                .build();
    }


}
