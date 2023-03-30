package me.mrfunny.krab.members.method.body.possibilities;

import me.mrfunny.krab.members.JavaField;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.MemberPathExpression;
import me.mrfunny.krab.members.method.body.expression.FieldAccessExpression;

public interface FieldAccessible extends MemberPathExpression, Comparable {
    default FieldAccessExpression accessField(String name) {
        return Expression.lineUp(new FieldAccessExpression(name), (Expression) this);
    }

    default FieldAccessExpression accessField(JavaField field) {
        return accessField(field.getName());
    }
}
