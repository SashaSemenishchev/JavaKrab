package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.method.MethodScope;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.Statement;

public class ForeachLoopStatement extends Statement implements Loop {

    private LocalVariableDeclarationStatement declaration;
    private Expression looper;
    private MethodScope scope;

    public ForeachLoopStatement(LocalVariableDeclarationStatement forVariable, Expression looper, MethodScope scope) {
        this.declaration = forVariable;
        this.looper = looper;
        this.scope = scope;
    }

    public ForeachLoopStatement setLooper(Expression looper) {
        this.looper = looper;
        return this;
    }

    public ForeachLoopStatement setScope(MethodScope scope) {
        this.scope = scope;
        return this;
    }

    @Override
    public String toJavaCode() {
        return "for(" +
            ((LocalVariableDeclarationStatement)declaration.clone())
                .setInitializer(null)
                .toJavaCode() +
            ":" +
            Expression.toString(looper) +
            ")" +
            (scope == null ? "{}" : scope.toJavaCode());
    }

    @Override
    public MethodScope getLoopBody() {
        return scope;
    }
}
