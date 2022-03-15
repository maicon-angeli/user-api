package com.zallpy.userapi.service.imp;


import com.zallpy.userapi.webSecurity.JWTCreator;
import com.zallpy.userapi.webSecurity.JWTObject;
import com.zallpy.userapi.webSecurity.SecurityConfig;
import com.zallpy.userapi.dto.request.Login;
import com.zallpy.userapi.dto.response.Session;
import com.zallpy.userapi.entity.UserLog;
import com.zallpy.userapi.repository.UserLogRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginService {

    private PasswordEncoder encoder;

    private SecurityConfig securityConfig;

    private UserLogRepository repository;

    public Session logar(Login login){
        UserLog user = repository.findByUsername(login.getUsername());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            Session session = new Session();
            session.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            session.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return session;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }

}
