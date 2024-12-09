package com.vti.service;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPositionService {

    List<Position> getListPositions();

    Page<Position> getAllPositions(Pageable pageable);

    Position getPositionById(short id);

    Position getPositionByName(PositionName name);

    void createPosition(Position position);

    void updatePosition1(short id, PositionName newName);

    void updatePosition2(Position position);

    void deletePosition(short id);

    boolean isPositionExistId(short id);

    boolean isPositionExistName(PositionName name);

}
