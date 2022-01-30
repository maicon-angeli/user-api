package com.zallpy.userapi.controller;
import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.exception.UserNotFoundException;
import com.zallpy.userapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid UserDTO userDTO){
        return userService.createUser(userDTO);
    }
    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id)throws UserNotFoundException {
        return userService.findById(id);
    }
    @GetMapping
    @ResponseStatus
    public List<UserDTO> listALL(){
        return userService.listALL();
    }

    @PutMapping("{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody @Valid UserDTO userDTO)throws UserNotFoundException{
        return userService.updateById(id, userDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteById(@PathVariable Long id) throws UserNotFoundException {
        userService.delete(id);
    }
}

