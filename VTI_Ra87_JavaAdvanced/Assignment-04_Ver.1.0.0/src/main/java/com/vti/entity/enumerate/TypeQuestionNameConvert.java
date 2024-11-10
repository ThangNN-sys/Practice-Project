package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TypeQuestionNameConvert implements AttributeConverter<TypeQuestionName, String> {

	/*
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.
	 * Object)
	 */
	@Override
	public String convertToDatabaseColumn(TypeQuestionName name) {
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
	public TypeQuestionName convertToEntityAttribute(String value) {
		return TypeQuestionName.of(value);
	}

}
