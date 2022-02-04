package com.zallpy.userapi.controller;
import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/hal+json")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createUser(@RequestBody @Valid UserDTO userDTO){

        return userService.createUser(userDTO);
    }
    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
        resources.add(new Link(uriString, "self"));

    }

    @GetMapping
    @ResponseStatus
    public List<UserDTO> listallUser() {



      return userService.listALL();

    }

    @PutMapping
    public MessageResponseDTO updateById(@RequestBody @Valid UserDTO userDTO){
        return userService.updateById( userDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteById(@PathVariable Long id) {

        userService.delete(id);
    }
}

