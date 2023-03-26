package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.members.method.body.possibilities.Callable;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.possibilities.FieldAccessible;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

public class LocalVariableAccessExpression
        extends Expression
        implements ResultiveExpression, Callable, FieldAccessible {
    private final String name;

    public LocalVariableAccessExpression(String name) {
        this.name = name;
    }
    @Override
    public String toJavaCode() {
        return name;
    }

    @Override
    public Class<?> getExpressionResult() {
        return Object.class;
    }
}
