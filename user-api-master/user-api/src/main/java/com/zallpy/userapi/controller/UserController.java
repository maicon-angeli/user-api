package com.zallpy.userapi.controller;
import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.request.UserDTOImpl;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.dto.response.UserSearchAgeDTO;
import com.zallpy.userapi.dto.response.UserNameDTO;
import com.zallpy.userapi.service.UserService;
import exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;


@RestController
@RequestMapping(value = "/api", produces = "application/hal+json")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createUser(@RequestBody @Valid UserDTOImpl userDTO){

        return userService.createUser(userDTO);
    }
    @GetMapping("/{id}")
    public UserDTOImpl findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/email/{email}")

    public UserNameDTO findNameByEmail(@PathVariable String email) {
        return userService.findUserNameByEmail(email);
    }

    @GetMapping("/age/{age}")
    public List <UserSearchAgeDTO> findNameByAge(@PathVariable int age){
        return userService.ListAge(age);
    }

    @GetMapping
    @ResponseStatus
    public List<UserDTO> listallUser(){
/**
        List<UserDTO> userDTOList = userService.listALL();
        if(userDTOList.isEmpty()){
            return  null;
        }else {
            for (UserDTO userDTO : userDTOList){

                long id = userDTO.getId();

            userDTO.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
        }**/
      return userService.listALL();
    }

    @PutMapping("/up/{id}")
    public MessageResponseDTO updateById(@Valid @PathVariable Long id, @RequestBody UserDTOImpl userDTO){
        return userService.updateById( id, userDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteById(@PathVariable Long id) {

        userService.delete(id);
    }

}

