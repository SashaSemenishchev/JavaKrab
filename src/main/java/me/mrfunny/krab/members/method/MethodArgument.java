package me.mrfunny.krab.members.method;

import me.mrfunny.krab.JavaObject;
import me.mrfunny.krab.members.common.Type;

public class MethodArgument implements JavaObject {
    private final String name;
    private final Type typeOf;

    public MethodArgument(Type typeOf, String name) {
        this.typeOf = typeOf;
        this.name = name;
    }
    @Override
    public String toJavaCode() {
        return typeOf.toJavaCode() + " " + name;
    }

    public static MethodArgument of(Type typeOf, String name) {
        return new MethodArgument(typeOf, name);
    }
}
