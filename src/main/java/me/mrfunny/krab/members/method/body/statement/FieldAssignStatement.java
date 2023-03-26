package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.JavaField;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.Statement;
import me.mrfunny.krab.members.method.body.expression.FieldAccessExpression;

public class FieldAssignStatement extends Statement {
    private final String name;
    private Type staticType;
    private Expression newValue;

    public FieldAssignStatement(Type staticType, String name) {
        this.name = name;
        this.staticType = staticType;
    }

    public FieldAssignStatement(JavaField field) {
        this(field.getName());
    }

    public FieldAssignStatement(String name) {
        this.name = name;
    }
    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder();
        if(staticType != null) {
            sb.append(staticType.toJavaCode()).append(".");
        }

        return sb.append(name).append("=").append(Expression.toString(newValue)).toString();
    }
}
