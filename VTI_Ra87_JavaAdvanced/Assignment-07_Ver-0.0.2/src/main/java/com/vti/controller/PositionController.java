package com.vti.controller;

import com.vti.entity.Position;
import com.vti.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Position getPositionByName(@PathVariable(name = "name") String name) {
        return service.getPositionByName(name);
    }

    // create new
    @PostMapping()
    public void createPosition(@RequestBody Position position) {
        service.createPosition(position);
    }

    // update name find by id
    @PutMapping(value = "/{id}")
    public void updatePosition(@RequestBody Position position) {
        service.updatePosition(position);
    }

    // update by object
    @PutMapping
    public ResponseEntity<String> updatePosition1(@RequestBody Position position) {
        try {
            updatePosition1(position);
            return ResponseEntity.ok("Position updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Failed to update position: " + e.getMessage());
        }
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deletePosition(@PathVariable(name = "id") short id) {
        service.deletePosition(id);
    }

    // exists by id
    @GetMapping(value = "/is-exist-id/{id}")
    public boolean isPositionExistId(@PathVariable(name = "id") short id) {
        return service.isPositionExistId(id);
    }

    // exists by name
    @GetMapping(value = "/is-exist-name/{name}")
    public boolean isPositionExistName(@PathVariable(name = "name") String name) {
        return service.isPositionExistName(name);
    }

}
