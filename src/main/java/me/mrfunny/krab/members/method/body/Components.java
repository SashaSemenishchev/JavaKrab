package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.expression.*;
import me.mrfunny.krab.members.method.body.statement.IfStatement;

public class Components {
    public static FieldAccessExpression accessStaticField(Type type, String name) {
        return new FieldAccessExpression(type, name);
    }

    public static LocalVariableAccessExpression thisClass() {
        return new LocalVariableAccessExpression("this");
    }

    public static LocalVariableAccessExpression accessLocalVariable(String name) {
        return new LocalVariableAccessExpression(name);
    }

    public static NumberExpression num(Number number) {
        return new NumberExpression(number);
    }

    public static Expression string(String string) {
        return new Expression() {
            @Override
            public String toJavaCode() {
                return '"' + string + '"';
            }
        };
    }

    public static IfStatement.ConditionBranch conditionBranch(Expression condition, BasicMethodScope<?> body) {
        return new IfStatement.ConditionBranch(condition, body);
    }

    public static IfStatement ifStatement(IfStatement.ConditionBranch baseConditionBranch) {
        return new IfStatement(baseConditionBranch);
    }

    public static ComparisonExpression compare() {
        return new ComparisonExpression(null, null, ComparisonMode.EQUALS);
    }
    public static ComparisonExpression compare(Expression expression1, Expression expression2, ComparisonMode comparisonMode) {
        return new ComparisonExpression(expression1, expression2, comparisonMode);
    }
}
