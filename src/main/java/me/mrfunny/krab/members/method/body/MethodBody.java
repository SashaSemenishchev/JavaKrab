package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.members.AccessModifier;
import me.mrfunny.krab.members.Accessible;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodBody extends MethodScope<MethodBody> implements Body {

    public MethodBody(List<Statement> statements) {
        this.statements = statements;
    }

    public MethodBody(Statement... statements) {
        this(new ArrayList<>(Arrays.asList(statements)));
    }
}
