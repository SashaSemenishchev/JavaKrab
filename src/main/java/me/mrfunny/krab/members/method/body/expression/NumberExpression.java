package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.ResultiveExpression;

public class NumberExpression extends Expression implements ResultiveExpression {
    private final Number source;

    public NumberExpression(Number source) {
        this.source = source;
    }
    @Override
    public String toJavaCode() {
        return String.valueOf(source.longValue());
    }

    @Override
    public Class<?> getExpressionResult() {
        return Number.class;
    }
}
