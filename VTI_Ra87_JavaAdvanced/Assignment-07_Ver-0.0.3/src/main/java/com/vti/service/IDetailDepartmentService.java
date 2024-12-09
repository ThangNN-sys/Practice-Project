package com.vti.service;

import com.vti.entity.DetailDepartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDetailDepartmentService {

    List<DetailDepartment> getListDetailDepartments();

    Page<DetailDepartment> getAllDetailDepartments(Pageable pageable);

    DetailDepartment getDetailDepartmentById(short id);

    void createDetailDepartment(DetailDepartment detailDepartment);

    void updateDetailDepartment2(DetailDepartment detailDepartment);

    void deleteDetailDepartment(short id);

    boolean isDetailDepartmentExistId(short id);

}
