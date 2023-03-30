package me.mrfunny.krab.members.common;

import me.mrfunny.krab.common.JavaObject;
import me.mrfunny.krab.members.method.body.possibilities.Callable;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.possibilities.FieldAccessible;
import me.mrfunny.krab.members.method.body.statement.NewInstanceStatement;

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

    public Type asArrayType() {
        return Type.of(toJavaCode() + "[]");
    }

    public Type asVarargs() {
        return Type.of(toJavaCode() + "...");
    }

    public NewInstanceStatement newInstance(Expression... arguments) {
        return new NewInstanceStatement(this, arguments);
    }

    public static final Type VOID = Type.of("void");
    public static final Type INT = Type.of("int");
    public static final Type BYTE = Type.of("byte");
    public static final Type LONG = Type.of("long");
    public static final Type CHAR = Type.of("char");
    public static final Type SHORT = Type.of("short");
    public static final Type BOOLEAN = Type.of("boolean");
    public static final Type DOUBLE = Type.of("double");
    public static final Type FLOAT = Type.of("float");

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Type)) return false;

        return toJavaCode().equals(((Type)obj).toJavaCode());
    }
}
