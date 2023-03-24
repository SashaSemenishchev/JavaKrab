package me.mrfunny.krab.members.method;

import me.mrfunny.krab.exception.KrabException;
import me.mrfunny.krab.members.Abstractable;
import me.mrfunny.krab.members.AccessModifier;
import me.mrfunny.krab.members.ClassMember;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.Body;
import me.mrfunny.krab.members.method.body.BranchableStatement;
import me.mrfunny.krab.members.method.body.Statement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JavaMethod extends ClassMember<JavaMethod> implements Abstractable<JavaMethod> {
    protected boolean isAbstract = false;
    protected Body body = null;
    protected List<MethodArgument> arguments = new LinkedList<>();

    public JavaMethod(AccessModifier accessModifier, Type returnType, boolean isFinal, boolean isStatic, String name) {
        super(accessModifier, returnType, isFinal, isStatic, name);
    }

    @Override
    public Type getType() {
        return getReturnType();
    }

    public JavaMethod setReturnType(Type returnType) {
        this.type = returnType;
        return this;
    }

    public JavaMethod setArguments(MethodArgument... arguments) {
        this.arguments = new LinkedList<>(Arrays.asList(arguments));
        return this;
    }

    public JavaMethod setArguments(List<MethodArgument> arguments) {
        this.arguments = arguments;
        return this;
    }

    public JavaMethod addArgument(MethodArgument argument) {
        arguments.add(argument);
        return this;
    }

    public Type getReturnType() {
        return type;
    }

    @Override
    public JavaMethod setAbstract(boolean a) {
        this.isAbstract = a;
        return this;
    }

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }
    public JavaMethod setBody(Body body) {
        this.body = body;
        return this;
    }

    @Override
    public String createAccessString() {
        StringBuilder builder = new StringBuilder(getAccessModifier().getJavaName());
        if(isStatic()) {
            builder.append(" static");
        }

        if(isFinal()) {
            builder.append(" final");
        }


        return builder.append(" ")
                .append(type.toJavaCode())
                .append(" ")
                .append(getName())
                .toString();
    }

    @Override
    public String toJavaCode() {
        StringBuilder builder = new StringBuilder(createAccessString());
        generateArguments(builder);
        if(isAbstract) {
            if(source != null && !source.isAbstract()) throw new KrabException(source, "Source class must be an abstract class or an " +
                    "interface to have abstract methods");
            if(body != null && body != Body.empty()) throw new KrabException(source, "Abstract class can't have method body.");
            builder.append(";");
        } else {
            builder.append(body.toJavaCode());
        }
        return builder.toString();
    }

    protected void generateArguments(StringBuilder builder) {
        builder.append("(");
        Iterator<MethodArgument> iterator = arguments.iterator();
        while(iterator.hasNext()) {
            builder.append(iterator.next().toJavaCode());
            if(iterator.hasNext()) {
                builder.append(",");
            }
        }
        builder.append(")");
    }

    public static JavaMethod of(String name, Type returnType) {
        return new JavaMethod(AccessModifier.PACKAGE_PRIVATE, returnType, false, false, name);
    }
}
