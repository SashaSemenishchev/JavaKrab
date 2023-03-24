package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.members.method.body.Callable;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.FieldAccessible;
import me.mrfunny.krab.members.method.body.ResultiveExpression;

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
