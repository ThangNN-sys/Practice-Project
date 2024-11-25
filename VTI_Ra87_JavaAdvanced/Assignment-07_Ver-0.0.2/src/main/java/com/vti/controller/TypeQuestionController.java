package com.vti.controller;

import com.vti.entity.TypeQuestion;
import com.vti.service.ITypeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/type questions")
public class TypeQuestionController {

    @Autowired
    private ITypeQuestionService service;

    // get all paging
    @GetMapping()
    public Page<TypeQuestion> getAllTypes(Pageable pageable) {
        return service.getAllTypes(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public TypeQuestion getTypeById(@PathVariable(name = "id") short id) {
        return service.getTypeById(id);
    }

    // get by name
    @GetMapping(value = "/name/{name}")
    public TypeQuestion getTypeByName(@PathVariable(name = "name") String name) {
        return service.getTypeByName(name);
    }

    // create new
    @PostMapping()
    public void createType(@RequestBody TypeQuestion create) {
        service.createType(create.toString());
    }

    // update name find by id
    @PutMapping(value = "/{id}")
    public void updateType(@RequestBody TypeQuestion updated) {
        service.updateType(updated.toString());
    }

    // update by object
    @PutMapping
    public ResponseEntity<String> updateType1(@RequestBody TypeQuestion typeQuestion) {
        try {
            updateType1(typeQuestion);
            return ResponseEntity.ok("Type Question updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Failed to update Type Question: " + e.getMessage());
        }
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteType(@PathVariable(name = "id") short id) {
        service.deleteType(String.valueOf(id));
    }

    // exists by id
    @GetMapping(value = "/is-exist-id/{id}")
    public boolean isTypeExistId(@PathVariable(name = "id") short id) {
        return service.isTypeExistId(id);
    }

    // exists by name
    @GetMapping(value = "/is-exist-name/{name}")
    public boolean isTypeExistName(@PathVariable(name = "name") String name) {
        return service.isTypeExistName(name);
    }

}
