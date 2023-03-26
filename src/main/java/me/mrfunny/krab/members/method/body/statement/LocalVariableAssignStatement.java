package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;
import me.mrfunny.krab.members.method.body.Statement;
import me.mrfunny.krab.members.method.body.environment.LocalVariable;

public class LocalVariableAssignStatement extends Statement implements ResultiveExpression {
    private final String name;
    private final Expression newValue;
    private boolean valueMode = false;

    public LocalVariableAssignStatement(String name, Expression newValue) {
        this.name = name;
        this.newValue = newValue;
    }

    public LocalVariableAssignStatement(LocalVariable localVariable, Expression newValue) {
        this(localVariable.getName(), newValue);
    }

    public LocalVariableAssignStatement asValue() {
        this.valueMode = true;
        return this;
    }
    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder();
        if(valueMode) {
            sb.append("(");
        }
        sb.append(name).append("=").append(Expression.toString(newValue));
        if(valueMode) {
            sb.append(")");
        }
        return sb.toString();
    }

    @Override
    public Class<?> getExpressionResult() {
        return Object.class;
    }
}
