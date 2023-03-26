package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.Statement;
import me.mrfunny.krab.members.method.body.possibilities.Callable;
import me.mrfunny.krab.members.method.body.possibilities.Concatenable;
import me.mrfunny.krab.members.method.body.possibilities.FieldAccessible;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

public class BraceGroupStatement
    extends Statement
    implements ResultiveExpression, Callable, FieldAccessible, Concatenable {
    private final Expression expression;

    public BraceGroupStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toJavaCode() {
        return "(" + Expression.toString(expression) + ")";
    }

    @Override
    public Class<?> getExpressionResult() {
        return Object.class;
    }
}
