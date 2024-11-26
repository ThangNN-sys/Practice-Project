package com.vti.service;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import com.vti.repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Position
     */

    @Autowired
    private IPositionRepository repository;

    // get all
    @Override
    public List<Position> getListPositions() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Position> getAllPositions(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Position getPositionById(short id) {
        return repository.findPositionById(id);
    }

    // get by name with @Query
    @Override
    public Position getPositionByName(PositionName name) {
        return null;
    }

    // create new
    @Override
    public void createPosition(Position position) {
        repository.save(position);
    }

    // update name find by id
    @Override
    public void updatePosition1(short id, PositionName newName) {
        repository.updatePosition1(id, newName);
    }

    // update by object
    @Override
    public void updatePosition2(Position position) {
        repository.save(position);
    }

    // delete by id
    @Override
    public void deletePosition(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isPositionExistId(short id) {
        return repository.existsById(id);
    }

    // exists by name
    @Override
    public boolean isPositionExistName(PositionName name) {
        Position position = repository.findPositionByName(name);
        return position != null;
        // return repository.findPositionByName(name) != null; // cách viết ngắn gọn
    }

}
