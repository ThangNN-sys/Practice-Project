package com.vti.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DepartmentTypeConvert implements AttributeConverter<Department.Type, String> {
    @Override
    public String convertToDatabaseColumn(Department.Type type) {
        if (type == null) {
            return null;
        }

        return type.toString();
    }

    @Override
    public Department.Type convertToEntityAttribute(String sqlValue) {
        if (sqlValue == null || sqlValue.isEmpty()) {
            return null;
        }

        return Department.Type.valueOf(sqlValue);
    }
}
