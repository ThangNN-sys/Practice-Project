package com.vti.service;

import com.vti.entity.Manager;
import com.vti.repository.IManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService implements IManagerService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: Manager
     */

    @Autowired
    private IManagerRepository repository;

    // get all
    @Override
    public List<Manager> getListManagers() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<Manager> getAllManagers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public Manager getManagerById(short id) {
        return repository.findManagerById(id);
    }

    // get by number of year with @Query
    @Override
    public Manager getManagerByYear(short year) {
        return repository.findManagerByYear(year);
    }

    // create new
    @Override
    public void createManager(Manager manager) {
        repository.save(manager);
    }

    // update find by id
    @Override
    public void updateManager1(short id, short newYear) {
        Manager manager = repository.findManagerById(id);
        repository.save(manager);
    }

    // update by object
    @Override
    public void updateManager2(Manager manager) {
        repository.save(manager);
    }

    // delete by id
    @Override
    public void deleteManager(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isManagerExistId(short id) {
        return repository.existsById(id);
    }

    // exists by number of year
    @Override
    public boolean isManagerExistYear(short year) {
        Manager manager = repository.findManagerByYear(year);
        return manager != null;
        // return repository.findManagerByYear(year) != null; // cách viết ngắn gọn
    }

}
