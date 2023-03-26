package me.mrfunny.krab.members.method.body.environment;

import me.mrfunny.krab.exception.KrabException;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.Expression;

public class LocalVariable implements MethodBodyPart {
    protected String name;
    protected Type type;
    protected Expression initializer;
    protected boolean isFinal = false;

    public String getName() {
        return name;
    }

    public LocalVariable setName(String name) {
        this.name = name;
        return this;
    }

    public Type getType() {
        return type;
    }

    public LocalVariable setType(Type type) {
        this.type = type;
        return this;
    }

    public Expression getInitializer() {
        return initializer;
    }

    public LocalVariable setInitializer(Expression initializer) {
        this.initializer = initializer;
        return this;
    }

    public LocalVariable setFinal(boolean f) {
        this.isFinal = f;
        return this;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public LocalVariable(String name, Type type, Expression initializer) {
        this.name = name;
        this.type = type;
        this.initializer = initializer;
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder();
        if(isFinal) {
            sb.append("final ");
        }
        sb.append(type.toJavaCode())
                .append(" ")
                .append(name);
        if(initializer != null) {
            sb.append("=").append(Expression.toString(initializer));
        } else if(isFinal) {
            throw new KrabException(null, "Uninitialized final variable");
        }
        sb.append(";");
        return sb.toString();
    }
}
