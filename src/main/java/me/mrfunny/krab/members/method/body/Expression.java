package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.common.JavaObject;
import me.mrfunny.krab.exception.KrabException;

public abstract class Expression implements JavaObject, Cloneable {
    protected Expression previousExpression = null;

    public static String toString(Expression root) {
        String rootCode = root.toJavaCode();
        if(rootCode == null) {
            throw new KrabException(null, "The expression's result is null. Expression: " + root.getClass().getName());
        }
        StringBuilder builder = new StringBuilder(rootCode);
        Expression next = root.previousExpression;

        while(next != null) {
            if(!(next instanceof MemberPathExpression)) continue;
            builder.insert(0, ".").insert(0, next.toJavaCode());
            next = next.previousExpression;
        }

        return builder.toString();
    }

    public static <T extends Expression> T lineUp(T first, Expression second) {
        first.previousExpression = second;
        return first;
    }

    public <T extends Expression> T lineUp(Expression second) {
        this.previousExpression = second;
        return (T) this;
    }

    public <T extends Expression> T lineDown(T second) {
        second.previousExpression = this;
        return second;
    }

    @Override
    public Expression clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Expression) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
