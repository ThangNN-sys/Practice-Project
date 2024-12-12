package com.vti.controller;

import com.vti.entity.Employee;
import com.vti.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/employees")
public class EmployeeController {
    /**
     * Presentation Layer
     * Nhận yêu cầu từ người dùng, điều phối và trả về kết quả phù hợp
     * Đối tượng: Employee
     */

    @Autowired
    private IEmployeeService service;

    // get all list
//    @GetMapping()
//    public List<Employee> getListEmployees() {
//        return service.getListEmployees();
//    }

    // get all paging
    @GetMapping()
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return service.getAllEmployeesPaging(pageable);
    }

    // get by id
    @GetMapping(value = "/{id}")
    public Employee getEmployeeByAccId(@PathVariable(name = "id") short id) {
        return service.getEmployeeByAccId(id);
    }

    // get by year
    @GetMapping(value = "/year/{year}")
    public Employee getEmployeeByYear(@PathVariable(name = "year") short year) {
        return service.getEmployeeByYear(year);
    }

    // create new
    @PostMapping()
    public void createEmployee(@RequestBody Employee create) {
        service.createEmployee(create);
    }

    // update name find by id
    @PutMapping(value = "/u1/{id}")
    public void updateEmployee1(@PathVariable(name = "id") short id, @RequestBody Employee employee) {
        employee.setAccountId(id);
        service.updateEmployee1(id, employee.getWorkingNumberOfYear());
    }

    // update by object
    @PutMapping(value = "/u2")
    public void updateEmployee2(@RequestBody Employee employee) {
        service.updateEmployee2(employee);
    }

    // delete by id
    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(@PathVariable(name = "id") short id) {
        service.deleteEmployee(id);
    }

    // exists by id
    @GetMapping(value = "/exists-id/{id}")
    public boolean isEmployeeExistId(@PathVariable(name = "id") short id) {
        return service.isEmployeeExistsId(id);
    }

    // exists by year
    @GetMapping(value = "/exists-year/{name}")
    public boolean isEmployeeExistYear(@PathVariable(name = "name") short year) {
        return service.isEmployeeExistsYear(year);
    }

}
