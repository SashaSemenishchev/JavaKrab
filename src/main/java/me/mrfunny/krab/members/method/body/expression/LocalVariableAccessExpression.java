package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.members.method.body.possibilities.Callable;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.possibilities.FieldAccessible;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

public class LocalVariableAccessExpression
        extends Expression
        implements ResultiveExpression, Callable, FieldAccessible {
    private String name;

    public LocalVariableAccessExpression(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalVariableAccessExpression setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toJavaCode() {
        return name;
    }

    @Override
    public Class<?> getExpressionResult() {
        return Object.class;
    }

    public static class Immutable extends LocalVariableAccessExpression {

        public Immutable(String name) {
            super(name);
        }

        @Override
        public LocalVariableAccessExpression setName(String name) {
            return this;
        }
    }
}
