package me.mrfunny.krab.members.method.body.expression;

import me.mrfunny.krab.exception.KrabException;
import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.Expression;
import me.mrfunny.krab.members.method.body.possibilities.ResultiveExpression;
import me.mrfunny.krab.members.method.body.statement.NumberOutputType;

public class NumberExpression extends Expression implements ResultiveExpression {
    private Number source;
    private Type numberType = Type.INT;
    private NumberOutputType outputType = NumberOutputType.IMPLICIT;

    public NumberExpression(Number source) {
        this.source = source;
    }

    public NumberExpression setSource(Number source) {
        this.source = source;
        return this;
    }

    public NumberExpression setTypeSuffix(Type numberType) {
        this.numberType = numberType;
        return this;
    }

    public Number getSource() {
        return source;
    }

    public NumberExpression setOutputType(NumberOutputType outputType) {
        this.outputType = outputType;
        return this;
    }

    @Override
    public String toJavaCode() {
        long value = source.longValue();
        switch (outputType) {
            case BINARY:
                return "0b" + Long.toBinaryString(value) + checkInvalidExplicitCast(this.numberType);
            case HEX:
                return "0x" + Long.toHexString(value) + checkInvalidExplicitCast(this.numberType);
            default:
                return value + typeToSuffix(numberType);
        }

//        return String.valueOf(value);
    }

    private String checkInvalidExplicitCast(Type type) {
        if(type.equals(Type.LONG)) {
            return "L";
        } else if(!type.equals(Type.INT)) {
            throw new KrabException(null, "Binary types doesn't support explicit declarations with suffixes");
        }

        return "";
    }

    private String typeToSuffix(Type type) {
        if(type.equals(Type.LONG)) {
            return "L";
        } else if(type.equals(Type.FLOAT)) {
            return "F";
        } else if(type.equals(Type.DOUBLE)) {
            return "D";
        } else {
            return "";
        }
    }

    @Override
    public Class<?> getExpressionResult() {
        return Number.class;
    }
}
