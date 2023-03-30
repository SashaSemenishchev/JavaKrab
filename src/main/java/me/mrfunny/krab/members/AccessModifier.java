package me.mrfunny.krab.members;

import me.mrfunny.krab.common.JavaObject;

public enum AccessModifier implements JavaObject {
    PUBLIC("public"),
    PRIVATE("private"),
    PROTECTED("protected"),
    PACKAGE_PRIVATE("");

    private final String javaName;

    AccessModifier(String javaName) {
        this.javaName = javaName;
    }

    @Override
    public String toJavaCode() {
        return javaName;
    }

    @Override
    public String toPrettyJavaCode() {
        return this.toJavaCode();
    }
}
