package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.method.MethodScope;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.Statement;

public class WhileLoopStatement extends Statement implements Loop {

    private final Expression condition;
    private final MethodScope scope;

    public WhileLoopStatement(Expression condition, MethodScope scope) {
        this.condition = condition;
        this.scope = scope;
    }
    @Override
    public String toJavaCode() {
        return "while(" +
            Expression.toString(condition) +
            ")" +
            scope.toJavaCode();
    }

    @Override
    public MethodScope getLoopBody() {
        return scope;
    }
}
