package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.method.MethodScope;
import me.mrfunny.krab.members.method.body.Body;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.Statement;

public class DoWhileLoopStatement extends Statement implements Loop {

    private Expression terminator;
    private MethodScope scope;

    public DoWhileLoopStatement(Expression terminator, MethodScope scope) {
        this.terminator = terminator;
        this.scope = scope;
    }

    public Expression getTerminator() {
        return terminator;
    }

    public DoWhileLoopStatement setTerminationStatement(Expression terminator) {
        this.terminator = terminator;
        return this;
    }

    public DoWhileLoopStatement setScope(MethodScope scope) {
        this.scope = scope;
        return this;
    }

    @Override
    public String toJavaCode() {
        return "do" +
            scope.toJavaCode() +
            "while(" +
            terminator.toJavaCode() +
            ");"; // For some reason java requires semicolon after do {} while(...);
    }

    @Override
    public MethodScope getLoopBody() {
        return scope;
    }
}
