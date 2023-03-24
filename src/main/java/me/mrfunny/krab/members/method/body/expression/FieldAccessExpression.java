package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.*;

public class FieldAccessExpression
        extends Expression
        implements ResultiveExpression, Callable, FieldAccessible {

    private  Type staticType = null;
    protected String name;
    public FieldAccessExpression(String name) {
        this.name = name;
    }

    public FieldAccessExpression(Type staticType, String name) {
        this.name = name;
        this.staticType = staticType;
    }

    @Override
    public String toJavaCode() {
        return (staticType == null ? "" : staticType.toJavaCode() + ".") + name;
    }

    @Override
    public Class<?> getExpressionResult() { return Object.class; }
}
