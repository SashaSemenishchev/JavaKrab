package me.mrfunny.krab.members;

import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.Expression;

public class JavaField extends ClassMember<JavaField> {

    protected Expression initializer;

    public JavaField(AccessModifier accessModifier, Type typeOf, boolean isFinal, boolean isStatic, String name) {
        super(accessModifier, typeOf, isFinal, isStatic, name);
    }

    public JavaField setInitializer(Expression initializer) {
        this.initializer = initializer;
        return this;
    }

    public Expression getInitializer() {
        return initializer;
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder(createAccessString());
        if(initializer != null) {
            sb.append("=");
            sb.append(initializer.toJavaCode());
        }
        return sb.append(";").toString();
    }

    @Override
    public String getTypeName() {
        return null;
    }

    @Override
    public Type getType() {
        return null;
    }

    public static JavaField of(String name, Type type) {
        return new JavaField(AccessModifier.PACKAGE_PRIVATE, type, false, false, name);
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
        if(type == null) {
            throw new RuntimeException("Field can't have void type!");
        }

        return builder.append(" ").append(type.toJavaCode()).append(" ").append(getName()).toString();
    }
}
