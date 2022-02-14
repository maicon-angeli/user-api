package com.zallpy.api.resource;

import com.zallpy.api.domain.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonResource {

    @GetMapping(value = "/id")
    public ResponseEntity <Person> findById(@PathVariable Integer id){

                return ResponseEntity.ok().body(new Person(1,"valdir", "val@mail.com", "123"));

    }
}
