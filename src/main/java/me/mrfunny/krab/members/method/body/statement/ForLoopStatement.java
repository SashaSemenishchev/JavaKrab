package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.method.MethodScope;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.Statement;

public class ForLoopStatement extends Statement implements Loop {
    private LocalVariableDeclarationStatement declaration;
    private Expression terminator;
    private Expression incrementor;
    private MethodScope scope;

    public ForLoopStatement(
        LocalVariableDeclarationStatement declarationStatement,
        Expression terminationEvaluator,
        Expression incrementor,
        MethodScope scope
    ) {
       this.declaration = declarationStatement;
       this.terminator = terminationEvaluator;
       this.incrementor = incrementor;
       this.scope = scope;
    }

    public void setDeclaration(LocalVariableDeclarationStatement declaration) {
        this.declaration = declaration;
    }

    public void setScope(MethodScope scope) {
        this.scope = scope;
    }

    public void setIncrementor(Expression incrementor) {
        this.incrementor = incrementor;
    }

    public void setTerminator(Expression terminator) {
        this.terminator = terminator;
    }

    public LocalVariableDeclarationStatement getDeclaration() {
        return declaration;
    }

    public Expression getTerminator() {
        return terminator;
    }

    public Expression getIncrementor() {
        return incrementor;
    }

    public MethodScope getScope() {
        return scope;
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder("for(");
        if(declaration != null) {
            sb.append(Expression.toString(declaration));
        }
        sb.append(";");
        if(terminator != null) {
            sb.append(Expression.toString(terminator));
        }
        sb.append(";");
        if(incrementor != null) {
            sb.append(Expression.toString(incrementor));
        }
        return sb.append(")")
            .append(scope == null ? "{}" : scope.toJavaCode())
            .toString();
    }

    @Override
    public MethodScope getLoopBody() {
        return scope;
    }
}
