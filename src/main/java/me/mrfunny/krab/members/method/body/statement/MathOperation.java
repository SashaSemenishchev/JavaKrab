package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.common.JavaObject;

public enum MathOperation implements JavaObject {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String opcode;

    MathOperation(String opcode) {
        this.opcode = opcode;
    }

    @Override
    public String toJavaCode() {
        return opcode;
    }

    @Override
    public String toPrettyJavaCode() {
        return toJavaCode();
    }
}
