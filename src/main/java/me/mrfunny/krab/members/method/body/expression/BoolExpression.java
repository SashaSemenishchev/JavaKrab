package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

public class BoolExpression extends Expression implements ResultiveExpression {
    private boolean value;

    public BoolExpression(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public BoolExpression setValue(boolean value) {
        this.value = value;
        return this;
    }

    @Override
    public String toJavaCode() {
        return value ? "true" : "false";
    }

    @Override
    public Class<?> getExpressionResult() {
        return boolean.class;
    }
    public static class Immutable extends BoolExpression {

        public Immutable(boolean value) {
            super(value);
        }

        @Override
        public BoolExpression setValue(boolean value) {
            return this;
        }
    }


}
