package com.zallpy.userapi.controller;

import com.zallpy.userapi.dto.request.UserDTO;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.dto.response.UserNameDTO;
import com.zallpy.userapi.dto.response.UserSearchAgeDTO;
import com.zallpy.userapi.model.GenerateCSVReport;
import com.zallpy.userapi.model.GenerateExcelReport;
import com.zallpy.userapi.serviceTest.imp.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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

    @GetMapping(value = "/alluserreportExcel")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<UserDTO> users = (List<UserDTO>) userService.listALL();
        ByteArrayInputStream in = GenerateExcelReport.usersToExcel(users);
        // return IO ByteArray(in);
        HttpHeaders headers = new HttpHeaders();
        // set filename in header
        headers.add("Content-Disposition", "attachment; filename=users.xlsx");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType(
                "application/xlsx")).body(new InputStreamResource(in));
    }
    @GetMapping(value = "/alluserreportCSV")
    public void csvUsers(HttpServletResponse response) throws IOException {
        List<UserDTO> users = (List<UserDTO>) userService.listALL();
        GenerateCSVReport.writeUsers(response.getWriter(), users);
        response.setHeader("Content-Disposition", "attachment; filename=AllUsersCSVReport.csv");
    }


}


