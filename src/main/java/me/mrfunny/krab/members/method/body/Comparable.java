package me.mrfunny.krab.members.method.body;

import me.mrfunny.krab.members.method.body.expression.ComparisonExpression;
import me.mrfunny.krab.members.method.body.expression.ComparisonMode;

public interface Comparable {
    default ComparisonExpression compare(Expression another, ComparisonMode comparisonMode) {
//        Expression now = (Expression) this;
//        ComparisonExpression result =
//        result.previousExpression = now;
        return new ComparisonExpression((Expression) this, another, comparisonMode);
    }

    default ComparisonExpression compare(Expression another) {
        return compare(another, ComparisonMode.EQUALS);
    }
}
