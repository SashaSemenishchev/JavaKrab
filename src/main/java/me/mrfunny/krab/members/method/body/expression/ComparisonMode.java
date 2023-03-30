package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.common.JavaObject;

public enum ComparisonMode implements JavaObject {
    EQUALS("=="), NOT_EQUALS("!="), MORE("<"), LESS(">"), MORE_OR_EQUALS("<="), LESS_OR_EQUALS(">=");

    private final String javaCode;

    ComparisonMode(String javaCode) {
        this.javaCode = javaCode;
    }

    @Override
    public String toJavaCode() {
        return javaCode;
    }

    @Override
    public String toPrettyJavaCode() {
        return this.toJavaCode();
    }
}
