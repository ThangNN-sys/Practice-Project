package com.vti.service;

import com.vti.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPositionService {

    Page<Position> getAllPositions(Pageable pageable);

    Position getPositionById(short id);

    Position getPositionByName(String name);

    void createPosition(Position position);

    void updatePosition(short id, String newName);

    void updatePosition(Position position);

    void deletePosition(short id);

    boolean isPositionExistId(short id);

    boolean isPositionExistName(String name);

}
