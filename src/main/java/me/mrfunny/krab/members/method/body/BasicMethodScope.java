package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.JavaObject;

import java.util.Collections;
import java.util.List;

public abstract class BasicMethodScope<T> implements JavaObject {
    protected List<Statement> statements = null;

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toJavaCode() {
        if(statements == null) statements = Collections.emptyList();
        StringBuilder builder = new StringBuilder("{");
        for (Statement statement : statements) {
            builder.append(Expression.rootExpressionToJavaCode(statement));
            if(!(statement instanceof BranchableStatement)) {
                builder.append(";");
            }
        }

        return builder.append("}").toString();
    }

    public T addStatement(Statement statement) {
        this.statements.add(statement);
        return (T) this;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
