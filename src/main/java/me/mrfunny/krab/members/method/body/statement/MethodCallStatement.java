package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.method.body.*;
import me.mrfunny.krab.members.method.body.possibilities.Callable;
import me.mrfunny.krab.members.method.body.possibilities.FieldAccessible;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

public class MethodCallStatement extends Statement implements Callable, FieldAccessible, ResultiveExpression {
    private final String name;
    private final Expression[] arguments;

    public MethodCallStatement(String name, Expression... arguments) {
        this.name = name;
        this.arguments = arguments;
    }
    @Override
    public String toJavaCode() {
        return name + "(" + Expression.toArgumentsSequence(arguments) + ")";
    }

    @Override
    public Class<?> getExpressionResult() {
        return Object.class;
    }
}
