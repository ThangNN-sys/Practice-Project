package com.vti.entity.enumerate;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TypeQuestionNameConvert implements AttributeConverter<TypeQuestionName, String> {

    @Override
    public String convertToDatabaseColumn(TypeQuestionName name) {
        if (name == null) {
            return null;
        }

        return name.getValue();
    }

    @Override
    public TypeQuestionName convertToEntityAttribute(String value) {
        return TypeQuestionName.of(value);
    }

}
