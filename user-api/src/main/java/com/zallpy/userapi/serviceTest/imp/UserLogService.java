package com.zallpy.userapi.serviceTest.imp;

import com.zallpy.userapi.entity.UserLog;
import com.zallpy.userapi.repository.UserLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserLogService {

    private UserLogRepository repository;

    private PasswordEncoder encoder;
    public void createUser(UserLog user){
        String pass = user.getPassword();
        //criptografando antes de salvar no banco
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }



}
