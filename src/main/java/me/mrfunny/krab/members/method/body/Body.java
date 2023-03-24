package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.JavaObject;
import me.mrfunny.krab.members.method.MethodScope;

import java.util.Arrays;
import java.util.List;

public interface Body extends JavaObject {
    static Body of(Statement... statements) {
        return of(Arrays.asList(statements));
    }

    static Body of() {
        return EmptyBody.IT;
    }

    List<Statement> getStatements();
    static Body empty() {
        return EmptyBody.IT;
    }

    static MethodScope scope(Statement... statements) {
        return new MethodScope(statements);
    }

    static Body of(List<Statement> statements) {
        return new MethodBody(statements);
    }
}
