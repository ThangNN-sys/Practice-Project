package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SalaryNameConvert implements AttributeConverter<SalaryName, String> {

    @Override
    public String convertToDatabaseColumn(SalaryName name) {
        if (name == null) {
            return null;
        }

        return name.getValue();
    }

    @Override
    public SalaryName convertToEntityAttribute(String value) {
        return SalaryName.of(value);
    }

}
