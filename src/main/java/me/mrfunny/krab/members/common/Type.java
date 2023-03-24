package me.mrfunny.krab.members.common;

import me.mrfunny.krab.JavaObject;
import me.mrfunny.krab.members.method.body.Callable;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.FieldAccessible;

public abstract class Type
        extends Expression
        implements JavaObject, Callable, FieldAccessible {
    public static Type of(Class<?> clazz) {
        return new ClassType(clazz);
    }

    public static Type of(String name) {
        return new UserType(name);
    }

    public String classOf() {
        return toJavaCode() + ".class";
    }

    public Type asArray() {
        return Type.of(toJavaCode() + "[]");
    }

    public Type asVarargs() {
        return Type.of(toJavaCode() + "...");
    }
}
