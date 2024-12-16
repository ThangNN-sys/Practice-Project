package com.vti.service;

import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPositionService {

    List<Position> getAllPositions();

    Page<Position> getAllPositionsPaging(Pageable pageable);

    Position getPositionById(short id);

    Position getPositionByName(PositionName name);

    void createPosition(Position position);

    void updatePosition1(short id, PositionName newName);

    void updatePosition2(Position position);

    void deletePosition(short id);

    boolean isPositionExistsId(short id);

    boolean isPositionExistsName(PositionName name);

}
