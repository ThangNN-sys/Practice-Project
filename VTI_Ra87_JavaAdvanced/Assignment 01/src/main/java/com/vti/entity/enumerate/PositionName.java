package com.vti.entity.enumerate;

public enum PositionName {
    DEV("Dev"), TEST("Test"), SCRUMMASTER("ScrumMaster"), PM("PM");

    private final String value;

    PositionName(String value) {
        this.value = value;
    }

    public static PositionName of(String value) {
        if (value == null) {
            return null;
        }

        for (PositionName name : PositionName.values()) {
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
