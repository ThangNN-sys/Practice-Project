package com.vti.service;

import com.vti.entity.Position;
import com.vti.repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PositionService implements IPositionService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Position
     */

    @Autowired
    private IPositionRepository repository;

    @Override
    public Page<Position> getAllPositions(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Position getPositionById(short id) {
        return repository.findPositionById(id);
    }

    @Override
    public Position getPositionByName(String name) {
        return repository.findPositionByName(name);
    }

    @Override
    public void createPosition(Position position) {
        repository.save(position);
    }

    @Override
    public void updatePosition(short id, String newName) {
        Position position = new Position(id, newName);
        repository.save(position);
    }

    @Override
    public void updatePosition(Position position) {
        repository.save(position);
    }

    @Override
    public void deletePosition(short id) {
        repository.deletePosition(id);
    }

    @Override
    public boolean isPositionExistId(short id) {
        return repository.existsById(id);
    }

    @Override
    public boolean isPositionExistName(String name) {
        Position position = repository.findPositionByName(name);
        return position != null;
        // return repository.findPositionByName(name) != null; // cách viết ngắn gọn
    }
}
