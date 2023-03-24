package me.mrfunny.krab.members.method.body;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodBody extends BasicMethodScope<MethodBody> implements Body {

    public MethodBody(List<Statement> statements) {
        this.statements = statements;
    }

    public MethodBody(Statement... statements) {
        this(new ArrayList<>(Arrays.asList(statements)));
    }
}
