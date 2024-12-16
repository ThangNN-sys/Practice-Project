package com.vti.controller;

import com.vti.entity.TypeQuestion;
import com.vti.entity.enumerate.TypeQuestionName;
import com.vti.service.ITypeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/type-questions")
public class TypeQuestionController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: TypeQuestion
     */

    @Autowired
    private ITypeQuestionService service;

    // get all list
//    @GetMapping()
//    public List<TypeQuestion> getListTypeQuestion() {
//        return service.getListTypes();
//    }

    // get all paging
    @GetMapping()
    public Page<TypeQuestion> getAllTypes(Pageable pageable) {
        return service.getAllTypesPaging(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public TypeQuestion getTypeById(@PathVariable(name = "id") short id) {
        return service.getTypeById(id);
    }

    // get by name
    @GetMapping(value = "/name/{name}")
    public TypeQuestion getTypeByName(@PathVariable(name = "name") TypeQuestionName name) {
        return service.getTypeByName(name);
    }

    // create new
    @PostMapping()
    public void createType(@RequestBody TypeQuestion create) {
        service.createType(create);
    }

    // update name find by id
    @PutMapping(value = "/{id}")
    public void updateType1(@PathVariable(name = "id") short id, @RequestBody TypeQuestion update1) {
        update1.setId(id);
        service.updateType1(id, update1.getName());
    }

    // update by object
    @PutMapping(value = "/u2/{id}")
    public void updateType2(@PathVariable(name = "id") short id, @RequestBody TypeQuestion update2) {
        service.updateType2(update2);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteType(@PathVariable(name = "id") short id) {
        service.deleteType(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isTypeExistId(@PathVariable(name = "id") short id) {
        return service.isTypeExistsId(id);
    }

    // exists by name
    @GetMapping(value = "/exists-name/{name}")
    public boolean isTypeExistName(@PathVariable(name = "name") TypeQuestionName name) {
        return service.isTypeExistsName(name);
    }

}
