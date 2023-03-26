package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.members.method.body.possibilities.Concatenable;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

public class ConcatenationExpression
    extends Expression
    implements ResultiveExpression {

    private Expression expression2;
    private Expression expression1;

    public ConcatenationExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    public ConcatenationExpression setExpression1(Expression expression1) {
        this.expression1 = expression1;
        return this;
    }

    public ConcatenationExpression setExpression2(Expression expression2) {
        this.expression2 = expression2;
        return this;
    }

    @Override
    public String toJavaCode() {
        return Expression.toString(expression1) + "+" + Expression.toString(expression2);
    }

    @Override
    public Class<?> getExpressionResult() {
        return Object.class;
    }
}
