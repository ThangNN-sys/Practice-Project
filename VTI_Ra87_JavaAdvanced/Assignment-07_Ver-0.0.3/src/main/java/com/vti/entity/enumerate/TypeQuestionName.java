package com.vti.entity.enumerate;

public enum TypeQuestionName {
    Esay("0"), MultipleChoice("1");

    private final String value;

    TypeQuestionName(String value) {
        this.value = value;
    }

    public static TypeQuestionName of(String value) {
        if (value == null) {
            return null;
        }

        for (TypeQuestionName name : TypeQuestionName.values()) {
            if (name.getValue().equals(value)) {
                return name;
            }
        }

        return null;
    }

    public String getValue() {
        return value;
    }

}
