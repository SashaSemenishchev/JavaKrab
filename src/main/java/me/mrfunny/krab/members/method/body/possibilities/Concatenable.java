package me.mrfunny.krab.members.method.body.possibilities;

import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.expression.ConcatenationExpression;

public interface Concatenable {
    default ConcatenationExpression concat(Expression other) {
        return new ConcatenationExpression((Expression) this, other);
    }
}
