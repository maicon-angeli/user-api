package com.zallpy.userapi.controller;

import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.dto.response.UserNameDTO;
import com.zallpy.userapi.dto.response.UserSearchAgeDTO;
import com.zallpy.userapi.entity.UserEntity;
import com.zallpy.userapi.service.imp.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid UserDTO userDTO){
                      return userService.createUser(userDTO);
    }

    @GetMapping(path = "/{id}")
    public UserDTO findById(@PathVariable Long id)
    {

        return userService.findById(id);
    }

    @GetMapping("/email/{email}")
    public UserNameDTO findNameByEmail(@PathVariable String email) {

        return userService.findUserNameByEmail(email);
    }

    @GetMapping("/age/{age}")
    public List<UserSearchAgeDTO> findNameByAge(@PathVariable int age){

        return userService.ListAge(age);
    }

    @GetMapping
    @ResponseStatus
    public List<UserDTO> listallUser(){
      return userService.listALL();
    }

    @PutMapping(path = "/test/{id}")
    public MessageResponseDTO updateById(@Valid @PathVariable Long id, @RequestBody UserDTO userDTOImpl){
           return userService.updateById(id, userDTOImpl);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

}

