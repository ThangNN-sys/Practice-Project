package com.vti.service;

import com.vti.entity.DetailDepartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDetailDepartmentService {
    public Page<DetailDepartment> getAllDetailDepartments(Pageable pageable);

    public DetailDepartment getDetailDepartmentByID(short id);

    public void createDetailDepartment(DetailDepartment detailDepartment);

    public void updateDetailDepartment(DetailDepartment detailDepartment);

    public void deleteDetailDepartment(short id);

    public boolean isDetailDepartmentExistsByID(short id);
}
