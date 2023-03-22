package me.mrfunny.krab.members.method.body;

import java.util.Collections;
import java.util.List;

public final class EmptyBody implements Body {
    public static final EmptyBody IT = new EmptyBody();
    private EmptyBody(){}
    @Override
    public String toJavaCode() {
        return "{}";
    }

    @Override
    public List<Statement> getStatements() {
        return Collections.emptyList();
    }
}
