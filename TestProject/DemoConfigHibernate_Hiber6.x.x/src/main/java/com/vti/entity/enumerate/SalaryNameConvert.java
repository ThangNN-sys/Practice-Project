package com.vti.entity.enumerate;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SalaryNameConvert implements AttributeConverter<SalaryName, String> {

    /*
     * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
     * Object)
     */
    @Override
    public String convertToDatabaseColumn(SalaryName name) {
        if (name == null) {
            return null;
        }

        return name.getValue();
    }

    /*
     * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
     * Object)
     */
    @Override
    public SalaryName convertToEntityAttribute(String value) {
        return SalaryName.of(value);
    }

}
