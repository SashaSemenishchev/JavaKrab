package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.ResultiveExpression;

public class ComparisonExpression extends Expression implements ResultiveExpression {
    private Expression expression2;
    private Expression expression1;
    private ComparisonMode comparisonMode;

    public ComparisonExpression(Expression expression1, Expression expression2, ComparisonMode comparisonMode) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.comparisonMode = comparisonMode;
    }

    public ComparisonExpression setExpression1(Expression expression1) {
        this.expression1 = expression1;
        return this;
    }

    public ComparisonExpression setExpression2(Expression expression2) {
        this.expression2 = expression2;
        return this;
    }

    public ComparisonExpression setComparisonMode(ComparisonMode comparisonMode) {
        this.comparisonMode = comparisonMode;
        return this;
    }

    @Override
    public String toJavaCode() {
        return Expression.rootExpressionToJavaCode(expression1) + comparisonMode.getJavaCode() + Expression.rootExpressionToJavaCode(expression2);
    }

    @Override
    public Class<?> getExpressionResult() {
        return boolean.class;
    }
}