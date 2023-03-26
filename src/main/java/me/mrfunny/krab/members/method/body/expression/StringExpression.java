package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.members.method.body.possibilities.Concatenable;
import me.mrfunny.krab.members.method.body.possibilities.Callable;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

public class StringExpression extends Expression implements Callable, ResultiveExpression {

    private final String value;

    public StringExpression(String value) {
        this.value = value;
    }
    @Override
    public String toJavaCode() {
        return value == null ? "null" : '"' + value + '"';
    }

    @Override
    public Class<?> getExpressionResult() {
        return String.class;
    }
}
