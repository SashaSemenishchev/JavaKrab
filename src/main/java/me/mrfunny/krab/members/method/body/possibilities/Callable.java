package me.mrfunny.krab.members.method.body.possibilities;

import me.mrfunny.krab.members.method.JavaMethod;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.MemberPathExpression;
import me.mrfunny.krab.members.method.body.statement.MethodCallStatement;

public interface Callable extends MemberPathExpression, Comparable {
    default MethodCallStatement call(String methodName, Expression... arguments) {
        return Expression.lineUp(new MethodCallStatement(methodName, arguments), (Expression) this);
    }
    default MethodCallStatement call(JavaMethod method, Expression... arguments) {
        return call(method.getName(), arguments);
    }

}
