package com.vti.dto;

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

}
