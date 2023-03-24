package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.JavaObject;
import me.mrfunny.krab.exception.KrabException;

public abstract class Expression implements JavaObject {
    protected Expression previousExpression = null;

    public static String rootExpressionToJavaCode(Expression root) {
        String rootCode = root.toJavaCode();
        if(rootCode == null) {
            throw new KrabException(null, "The expression's result is null. Expression: " + root.getClass().getName());
        }
        StringBuilder builder = new StringBuilder(rootCode);
        Expression next = root.previousExpression;
        boolean first = false;
        while(next != null) {
            if(!(next instanceof MemberPathExpression)) continue;
            builder.insert(0, ".").insert(0, next.toJavaCode());
            next = next.previousExpression;
        }

        return builder.toString();
    }
}
