package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.JavaObject;
import me.mrfunny.krab.members.common.HasBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class MethodScope<T> implements JavaObject {
    protected List<Statement> statements = null;
    @Override
    public String toJavaCode() {
        if(statements == null) statements = Collections.emptyList();
        StringBuilder builder = new StringBuilder("{");
        for (Statement statement : statements) {
            builder.append(statement.toJavaCode());
            if(!(statement instanceof HasBody)) {
                builder.append(";");
            }
        }
        builder.append("}");

        return builder.toString();
    }

    public T addStatement(Statement statement) {
        this.statements.add(statement);
        return (T) this;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
