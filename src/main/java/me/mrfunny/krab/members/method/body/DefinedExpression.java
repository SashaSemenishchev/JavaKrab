package me.mrfunny.krab.members.method.body;

public class DefinedExpression extends Expression {

    private final String expression;

    protected DefinedExpression(String expression) {
        this.expression = expression;
    }
    @Override
    public String toJavaCode() {
        return expression;
    }

    public static DefinedExpression of(String it) {
        return new DefinedExpression(it);
    }
}
