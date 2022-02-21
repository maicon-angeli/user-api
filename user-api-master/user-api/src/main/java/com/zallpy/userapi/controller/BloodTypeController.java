package com.zallpy.userapi.controller;

import com.zallpy.userapi.dto.request.BloodTypeDTO;


import com.zallpy.userapi.dto.response.BloodTypeCpf;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.service.imp.BloodTypeServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bloodtype")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BloodTypeController {

    BloodTypeServiceImp bloodTypeServiceImp;

    @GetMapping
    public List<BloodTypeDTO> getAll(){

        return bloodTypeServiceImp.getAll();
    }
    @PostMapping
    public MessageResponseDTO create(@RequestBody BloodTypeDTO form){

        return bloodTypeServiceImp.create(form);
    }

   @PutMapping("/{id}")
   public MessageResponseDTO updateById(@Valid @PathVariable Long id, @RequestBody BloodTypeDTO bloodTypeDTO){
       return bloodTypeServiceImp.updatebyId(id, bloodTypeDTO);

    }

    @DeleteMapping("/{id}")
    public  void deleteById(@PathVariable Long id) {
        bloodTypeServiceImp.delete(id);
    }

    @GetMapping("cpf/{cpf}")
    public BloodTypeCpf findBloodTypeCpf(@PathVariable String cpf){
        return bloodTypeServiceImp.findBloodTypeCpf(cpf);

    }

}
