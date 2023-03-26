package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.method.body.*;
import me.mrfunny.krab.members.method.body.possibilities.Callable;
import me.mrfunny.krab.members.method.body.possibilities.FieldAccessible;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;

import java.util.Arrays;
import java.util.Iterator;

public class MethodCallStatement extends Statement implements Callable, FieldAccessible, ResultiveExpression {
    private final String name;
    private final Expression[] arguments;

    public MethodCallStatement(String name, Expression... arguments) {
        this.name = name;
        this.arguments = arguments;
    }
    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder(name).append("(");
        Iterator<Expression> iterator = Arrays.stream(arguments).iterator();
        while(iterator.hasNext()) {
            sb.append(Expression.toString(iterator.next()));
            if(iterator.hasNext()) {
                sb.append(",");
            }
        }
        return sb.append(")").toString();
    }

    @Override
    public Class<?> getExpressionResult() {
        return Object.class;
    }
}
