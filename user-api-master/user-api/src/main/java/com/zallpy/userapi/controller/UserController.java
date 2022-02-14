package com.zallpy.userapi.controller;

import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.dto.response.UserDTOFull;
import com.zallpy.userapi.dto.response.UserNameDTO;
import com.zallpy.userapi.dto.response.UserSearchAgeDTO;
import com.zallpy.userapi.service.imp.BloodTypeServiceImp;
import com.zallpy.userapi.service.imp.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;
    private BloodTypeServiceImp bloodTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createUser(@RequestBody @Valid UserDTO userDTO){
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
    public List<UserDTOFull> listallUser(){
      return userService.listALL();
    }

    @PutMapping(path = "/test/{id}")
    public UserDTO updateById(@Valid @PathVariable Long id, @RequestBody UserDTO userDTOImpl){

        userDTOImpl.add(linkTo(methodOn(UserController.class)).withSelfRel());

                    return userService.updateById(id, userDTOImpl);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }
}

