package me.mrfunny.krab.common;

public enum ClassType implements JavaObject {
    CLASS, ENUM, INTERFACE;

    @Override
    public String toJavaCode() {
        return name().toLowerCase();
    }

    @Override
    public String toPrettyJavaCode() {
        return toJavaCode();
    }
}
