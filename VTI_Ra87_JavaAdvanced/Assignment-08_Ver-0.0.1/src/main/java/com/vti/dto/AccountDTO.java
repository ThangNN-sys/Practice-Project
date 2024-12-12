package com.vti.dto;

import com.vti.entity.enumerate.SalaryName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {

    private short id;

    private String username;

    private String firstName;

    private String lastName;

    private String departmentName;

    private String positionName;

    private SalaryName salaryName;

}
