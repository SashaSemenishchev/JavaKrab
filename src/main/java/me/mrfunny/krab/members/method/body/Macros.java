package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.statement.MethodCallStatement;

public class Macros {
    public static final Type SYSTEM = Type.of("java.lang.System");

    public static MethodCallStatement sout(Expression toPrint) {
        return SYSTEM.accessField("out").call("println", toPrint);
    }
}
