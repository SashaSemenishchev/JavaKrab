package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.members.method.JavaMethod;
import me.mrfunny.krab.members.method.body.statement.MethodCallStatement;

public interface Callable extends MemberPathExpression, Comparable {
    default MethodCallStatement call(String methodName, Expression... arguments) {
        return lineUp(new MethodCallStatement(methodName, arguments), (Expression) this);
    }
    default MethodCallStatement call(JavaMethod method, Expression... arguments) {
        return call(method.getName(), arguments);
    }

}
