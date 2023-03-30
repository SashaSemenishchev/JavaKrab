package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

/**
 * This class to generate a known unknown code without any guarantees.
 * Should be used only for testing and playing purposes
 * Not for production
 * May produce undefined behaviour
 */
public class DefinedStatement extends Statement implements ResultiveExpression {

    private String expression;

    protected DefinedStatement(String expression) {
        this.expression = expression;
    }

    public DefinedStatement setExpression(String expression) {
        this.expression = expression;
        return this;
    }

    @Override
    public String toJavaCode() {
        return expression;
    }

    public static DefinedStatement of(String it) {
        return new DefinedStatement(it);
    }

    @Override
    public Class<?> getExpressionResult() {
        return Object.class;
    }
}
