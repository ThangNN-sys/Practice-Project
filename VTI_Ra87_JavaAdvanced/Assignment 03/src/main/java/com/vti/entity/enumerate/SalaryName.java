package com.vti.entity.enumerate;

public enum SalaryName {
    DEV("600"), TEST("700"), SCRUMMASTER("1500"), PM("2000");

    private final String value;

    SalaryName(String value) {
        this.value = value;
    }

    public static SalaryName of(String value) {
        if (value == null) {
            return null;
        }

        for (SalaryName name : SalaryName.values()) {
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