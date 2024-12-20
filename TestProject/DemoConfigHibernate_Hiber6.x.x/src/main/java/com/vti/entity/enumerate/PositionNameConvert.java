package com.vti.entity.enumerate;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PositionNameConvert implements AttributeConverter<PositionName, String> {

    /*
     * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
     * Object)
     */
    @Override
    public String convertToDatabaseColumn(PositionName name) {
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
    public PositionName convertToEntityAttribute(String value) {
        return PositionName.of(value);
    }

}
