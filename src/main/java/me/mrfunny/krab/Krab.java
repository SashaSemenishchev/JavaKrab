package me.mrfunny.krab;

import me.mrfunny.krab.common.ClassType;
import me.mrfunny.krab.common.JavaObject;
import me.mrfunny.krab.members.method.body.possibilities.Abstractable;
import me.mrfunny.krab.members.AccessModifier;
import me.mrfunny.krab.members.ClassMember;
import me.mrfunny.krab.members.JavaField;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.JavaMethod;
import me.mrfunny.krab.members.method.MethodArgument;
import me.mrfunny.krab.members.method.body.Body;

public interface Krab extends Abstractable<Krab>, JavaObject {

    Krab setClassType(ClassType type);

    Krab addConstructor(AccessModifier accessModifier, Body body);

    Krab addConstructor(AccessModifier accessModifier, Body body, MethodArgument... arguments);

    Krab addField(JavaField field);

    Krab addMethod(JavaMethod method);

    void addMember(ClassMember<?> member);

    Krab addInnerClass(Krab other);

    Krab addImport(Type it);

    String toJavaCode();

    boolean isAbstract();

    String getName();
    boolean isStatic();
    boolean isFinal();
    AccessModifier getAccessModifier();
    Krab setStatic(boolean s);
    Krab setFinal(boolean f);
    Krab setAccessModifier(AccessModifier accessModifier);
    EnumKrab asEnum();
    static Krab newSource(String packageName, String className) {
        return newSource(packageName, className, className + ".java");
    }

    static Krab newSource(String packageName, String className, String fileName) {
        return new KrabImpl(packageName, className, fileName);
    }

    static Krab innerClass(String name) {
        return new KrabImpl(null, name, null)
            .setInnerMode()
            .setStatic(true);
    }
}
