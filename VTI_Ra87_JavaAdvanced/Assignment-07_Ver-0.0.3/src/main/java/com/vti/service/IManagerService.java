package com.vti.service;

import com.vti.entity.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IManagerService {

    List<Manager> getListManagers();

    Page<Manager> getAllManagers(Pageable pageable);

    Manager getManagerById(short id);

    Manager getManagerByYear(short year);

    void createManager(Manager manager);

    void updateManager1(short id, short newYear);

    void updateManager2(Manager manager);

    void deleteManager(short id);

    boolean isManagerExistId(short id);

    boolean isManagerExistYear(short year);

}
