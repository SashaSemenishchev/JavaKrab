package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.JavaMethod;
import me.mrfunny.krab.members.method.MethodScope;
import me.mrfunny.krab.members.method.body.expression.*;
import me.mrfunny.krab.members.method.body.statement.*;

public class Components {
    public static FieldAccessExpression accessStaticField(Type type, String name) {
        return new FieldAccessExpression(type, name);
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

    public static ForLoopStatement forLoop() {
        return new ForLoopStatement(null, null, null, null);
    }
    public static ForLoopStatement forLoop(
        LocalVariableDeclarationStatement declaration,
        Expression checker,
        Expression incrementer
    ) {
        return new ForLoopStatement(declaration, checker, incrementer, null);
    }

    public static ForeachLoopStatement foreachLoop() {
        return new ForeachLoopStatement(null, null, null);
    }

    public static ForeachLoopStatement foreachLoop(
        LocalVariableDeclarationStatement localVariable,
        Expression looper
    ) {
        return new ForeachLoopStatement(localVariable, looper, null);
    }

    public static ForeachLoopStatement foreachLoop(
        LocalVariableDeclarationStatement localVariable,
        Expression looper,
        MethodScope scope
    ) {
        return new ForeachLoopStatement(localVariable, looper, scope);
    }

    public static ForLoopStatement forLoop(
        LocalVariableDeclarationStatement declaration,
        Expression checker,
        Expression incrementer,
        MethodScope scope
    ) {
        return new ForLoopStatement(declaration, checker, incrementer, scope);
    }

    public static DoWhileLoopStatement doWhileLoop(MethodScope body, Expression condition) {
        return new DoWhileLoopStatement(condition, body);
    }

    public static DoWhileLoopStatement doWhileLoop(Expression condition) {
        return new DoWhileLoopStatement(condition, null);
    }

    public static DoWhileLoopStatement doWhileLoop() {
        return new DoWhileLoopStatement(null, null);
    }

    public static WhileLoopStatement whileLoop(Expression condition, MethodScope body) {
        return new WhileLoopStatement(condition, body);
    }

    public static WhileLoopStatement whileLoop(Expression condition) {
        return new WhileLoopStatement(condition, null);
    }

    public static WhileLoopStatement whileLoop() {
        return new WhileLoopStatement(null, null);
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

    public static NewInstanceStatement newInstance(Type type, Expression... arguments) {
        return new NewInstanceStatement(type, arguments);
    }

    public static NewInstanceStatement newInstance(String type, Expression... arguments) {
        return newInstance(Type.of(type), arguments);
    }

    private static final DefinedStatement NULL = new DefinedStatement.Immutable("null");
    public static Expression nullVal() {return NULL;}

    private static final BoolExpression TRUE = new BoolExpression.Immutable(true);
    private static final BoolExpression FALSE = new BoolExpression.Immutable(false);
    public static BoolExpression boolTrue() {return TRUE;}
    public static BoolExpression boolFalse() {return FALSE;}
    public static BoolExpression bool() {return new BoolExpression(false);}
    private static final LocalVariableAccessExpression THIS = new LocalVariableAccessExpression.Immutable("this");

    public static LocalVariableAccessExpression thisClass() {return THIS;}
}
