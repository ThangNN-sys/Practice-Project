package com.vti.controller;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import com.vti.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/positions")
public class PositionController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Position
     */

    @Autowired
    private IPositionService service;

    // get all list
    @GetMapping()
    public List<Position> getListPositions() {
        return service.getListPositions();
    }

    // get all paging
    @GetMapping()
    public Page<Position> getAllPositions(Pageable pageable) {
        return service.getAllPositions(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Position getPositionById(@PathVariable(name = "id") short id) {
        return service.getPositionById(id);
    }

    // get by name
    @GetMapping(value = "/name/{name}")
    public Position getPositionByName(@PathVariable(name = "name") PositionName name) {
        return service.getPositionByName(name);
    }

    // create new
    @PostMapping()
    public void createPosition(@RequestBody Position create) {
        service.createPosition(create);
    }

    // update name find by id
    @PutMapping(value = "/u1/{id}")
    public void updatePosition1(@PathVariable(name = "id") short id, @RequestBody Position update1) {
        update1.setId(id);
        service.updatePosition1(id, update1.getName());
    }

    // update by object
    @PutMapping(value = "/u2/{id}")
    public void updatePosition2(@PathVariable(name = "id") short id, @RequestBody Position update2) {
        service.updatePosition2(update2);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deletePosition(@PathVariable(name = "id") short id) {
        service.deletePosition(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isPositionExistId(@PathVariable(name = "id") short id) {
        return service.isPositionExistId(id);
    }

    // exists by name
    @GetMapping(value = "/exists-name/{name}")
    public boolean isPositionExistName(@PathVariable(name = "name") PositionName name) {
        return service.isPositionExistName(name);
    }

}
