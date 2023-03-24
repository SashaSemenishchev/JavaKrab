package me.mrfunny.krab.members.method;

import me.mrfunny.krab.members.method.body.BasicMethodScope;
import me.mrfunny.krab.members.method.body.Statement;

import java.util.Arrays;
import java.util.List;

public class MethodScope extends BasicMethodScope<MethodScope> {
    public MethodScope(Statement[] statements) {
        setStatements(Arrays.asList(statements));
    }

    public MethodScope(List<Statement> statements) {
        setStatements(statements);
    }
}
