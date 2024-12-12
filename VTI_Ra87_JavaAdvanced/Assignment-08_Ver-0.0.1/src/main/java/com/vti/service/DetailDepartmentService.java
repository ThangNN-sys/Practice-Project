package com.vti.service;

import com.vti.entity.DetailDepartment;
import com.vti.repository.IDetailDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailDepartmentService implements IDetailDepartmentService {
    /**
     * Business Logic Layer
     * Xử lý logic nghiệp vụ, giao tiếp giữa tầng repository và controller
     * Đối tượng: DetailDepartment
     */

    @Autowired
    private IDetailDepartmentRepository repository;

    // get all
    @Override
    public List<DetailDepartment> getAllDetailDepartments() {
        return repository.findAll();
    }

    // get all paging
    @Override
    public Page<DetailDepartment> getAllDetailDepartmentsPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    // get by id with @Query
    @Override
    public DetailDepartment getDetailDepartmentById(short id) {
        return repository.findByDepartmentId(id);
    }

    // create new
    @Override
    public void createDetailDepartment(DetailDepartment detailDepartment) {
        repository.save(detailDepartment);
    }

    // update by object
    @Override
    public void updateDetailDepartment2(DetailDepartment detailDepartment) {
        repository.save(detailDepartment);
    }

    // delete by id
    @Override
    public void deleteDetailDepartment(short id) {
        repository.deleteById(id);
    }

    // exists by id
    @Override
    public boolean isDetailDepartmentExistsId(short id) {
        return repository.existsById(id);
    }


}
