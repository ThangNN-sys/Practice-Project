package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PositionNameConvert implements AttributeConverter<PositionName, String> {

    @Override
    public String convertToDatabaseColumn(PositionName name) {
        if (name == null) {
            return null;
        }

        return name.getValue();
    }

    @Override
    public PositionName convertToEntityAttribute(String value) {
        return PositionName.of(value);
    }

}
