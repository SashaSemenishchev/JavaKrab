package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.members.method.body.Expression;

public interface MemberPathExpression {
    default <T extends Expression> T lineUp(T first, Expression second) {
        first.previousExpression = second;
        return first;
    }
}
