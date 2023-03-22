package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.JavaObject;
import me.mrfunny.krab.members.common.HasBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Body extends JavaObject {
    static Body of(Statement... statements) {
        return of(Arrays.asList(statements));
    }

    List<Statement> getStatements();
    static Body empty() {
        return EmptyBody.IT;
    }

    static Body of(List<Statement> statements) {
        return new MethodBody(statements);
    }
}
