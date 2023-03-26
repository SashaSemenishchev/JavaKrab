package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.JavaMethod;
import me.mrfunny.krab.members.method.body.environment.LocalVariable;
import me.mrfunny.krab.members.method.body.expression.*;
import me.mrfunny.krab.members.method.body.statement.*;

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

    public static StringExpression string(String string) {
        return new StringExpression(string);
    }

    public static IfStatement.ConditionBranch conditionBranch(Expression condition, BasicMethodScope<?> body) {
        return new IfStatement.ConditionBranch(condition, body);
    }

    public static IfStatement ifStatement(IfStatement.ConditionBranch baseConditionBranch) {
        return new IfStatement(baseConditionBranch);
    }

    public static ComparisonExpression compare(
        Expression expression1,
        Expression expression2,
        ComparisonMode comparisonMode
    ) {
        return new ComparisonExpression(expression1, expression2, comparisonMode);
    }

    public static LocalVariableDeclarationStatement declareLocalVariable(Type typeOf, String name) {
        return new LocalVariableDeclarationStatement(typeOf, name);
    }
    public static LocalVariableDeclarationStatement declareLocalVariable(
        Type typeOf,
        String name,
        Expression initializer
    ) {
        return new LocalVariableDeclarationStatement(typeOf, name, initializer);
    }

    public static LocalVariableDeclarationStatement declareLocalVariable(
            Type typeOf,
            String name,
            Expression initializer,
            boolean isFinal
    ) {
        return new LocalVariableDeclarationStatement(typeOf, name, initializer, isFinal);
    }

    public static LocalVariableAssignStatement assignLocalVariable(String name, Expression value) {
        return new LocalVariableAssignStatement(name, value);
    }

    public static LocalVariableAssignStatement assignLocalVariable(
        LocalVariable localVariable,
        Expression value
    ) {
        return new LocalVariableAssignStatement(localVariable.getName(), value);
    }

    public static MethodCallStatement call(String name, Expression... arguments) {
        return new MethodCallStatement(name, arguments);
    }

    public static MethodCallStatement call(JavaMethod method, Expression... arguments) {
        return call(method.getName(), arguments);
    }

    public static MethodCallStatement call(Expression prev, String name, Expression... arguments) {
        MethodCallStatement result = new MethodCallStatement(name, arguments);
        result.previousExpression = prev;
        return result;
    }

    public static MethodCallStatement call(Expression prev, JavaMethod method, Expression... arguments) {
        return call(prev, method.getName(), arguments);
    }

    public static FieldAccessExpression accessField(String name) {
        return new FieldAccessExpression(name);
    }

    public static Expression nullVal() {
        return DefinedExpression.of("null");
    }

    public static NewInstanceStatement newInstance(Type type, Expression... arguments) {
        return new NewInstanceStatement(type, arguments);
    }

    public static NewInstanceStatement newInstance(String type, Expression... arguments) {
        return newInstance(Type.of(type), arguments);
    }
}
