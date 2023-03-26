package me.mrfunny.krab.members.method.body.statement;

import me.mrfunny.krab.members.common.Type;
import me.mrfunny.krab.members.method.body.Expression;

public class NewInstanceStatement extends MethodCallStatement {
    public NewInstanceStatement(Type typeOf, Expression... arguments) {
        super(typeOf.toJavaCode(), arguments);
    }

    @Override
    public String toJavaCode() {
        return "new " + super.toJavaCode();
    }
}
