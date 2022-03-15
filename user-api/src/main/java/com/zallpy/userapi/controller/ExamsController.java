package com.zallpy.userapi.controller;

import com.zallpy.userapi.dto.response.ExamsGetCSV;
import com.zallpy.userapi.dto.request.ExamsDTO;
import com.zallpy.userapi.service.imp.ExamsServiceImpl;
import com.zallpy.userapi.dto.response.ExamsFindByRg;
import com.zallpy.userapi.dto.response.ExamsRelat;
import com.zallpy.userapi.dto.response.MessageResponseDTO;
import com.zallpy.userapi.utils.generateFiles.GenerateCSVReport;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;



@RestController
@RequestMapping("/exams")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExamsController  {
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
    @GetMapping(value = "/allexamsreportCSV")
    public void csvExams(HttpServletResponse response) throws IOException {


        List<ExamsGetCSV> allCSV = examsServiceImpl.getAllCSV();
        allCSV.forEach(examsGetCSV -> examsGetCSV.format());
        GenerateCSVReport.writeGetAll(response.getWriter(), allCSV);
        response.setHeader("Content-Disposition", "attachment; filename=AllExamsCSVReport.csv");
    }

}

