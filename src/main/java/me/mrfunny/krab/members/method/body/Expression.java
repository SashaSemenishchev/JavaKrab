package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.common.JavaObject;
import me.mrfunny.krab.exception.KrabException;

public abstract class Expression implements JavaObject {
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
}
