package com.zallpy.userapi.controller;

import com.zallpy.userapi.dto.request.ExamsDTO;
import com.zallpy.userapi.dto.response.ExamsFindByRg;
import com.zallpy.userapi.dto.response.ExamsRelat;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.dto.response.UserNameDTO;
import com.zallpy.userapi.service.imp.ExamsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/exams")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExamsController {
    ExamsServiceImpl examsServiceImpl;

    @GetMapping
    public List<ExamsRelat> getAll() {
        return examsServiceImpl.getAll();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MessageResponseDTO create(@RequestBody ExamsDTO examsDTO) {

        return examsServiceImpl.create(examsDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        examsServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@Valid @PathVariable Long id, @RequestBody ExamsDTO examsDTO) {
        return examsServiceImpl.updatebyId(id, examsDTO);
    }

    @GetMapping("/rg/{rg}")
    public List<ExamsFindByRg> findExamsByRg(@PathVariable String rg) {

        return examsServiceImpl.findByRg(rg);
    }
}

