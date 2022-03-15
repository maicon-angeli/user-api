package com.zallpy.userapi.service.imp;

import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.entity.UserLog;
import com.zallpy.userapi.exception.ApiException;
import com.zallpy.userapi.repository.UserLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserLogService {

    private UserLogRepository repository;

    private PasswordEncoder encoder;

    public MessageResponseDTO createUser(UserLog user) throws ApiException {

        boolean userSaved = repository.existsByUsername(user.getUsername());
        if (userSaved) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User already exists");
        }
        String pass = user.getPassword();
        //criptografando antes de salvar no banco
        user.setPassword(encoder.encode(pass));
        return createMessageResponse(repository.save(user).getId(), "User created successfully ID:");
    }

    private MessageResponseDTO createMessageResponse(long id, String message) {
        return MessageResponseDTO.builder().message(message + id).build();
    }

    public void deleteUser(long id) {
        verifyIfExists(id);
        repository.deleteById(id);
    }

    public UserLog verifyIfExists(Long id) throws ApiException {
        return repository.findById(id).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

}
