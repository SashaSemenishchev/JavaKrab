package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.ResultiveExpression;

public class FieldAccessExpression extends Expression implements ResultiveExpression {

    @Override
    public String toJavaCode() {
        return null;
    }

    @Override
    public Class<?> getExpressionResult() {return Object.class;}
}
