package me.mrfunny.krab.common;

import me.mrfunny.krab.members.method.body.Expression;

public class EnumEntry implements JavaObject {
    private Expression[] initializerArgs;
    private String name;

    public EnumEntry(String name, Expression... initializerArgs) {
        this.name = name;
        this.initializerArgs = initializerArgs;
    }

    public String getName() {
        return name;
    }

    public Expression[] getInitializerArgs() {
        return initializerArgs;
    }

    public EnumEntry setName(String name) {
        this.name = name;

        return this;
    }

    public EnumEntry setInitializerArgs(Expression... initializerArgs) {
        this.initializerArgs = initializerArgs;
        return this;
    }

    @Override
    public String toJavaCode() {
        StringBuilder sb = new StringBuilder(name);
        if(initializerArgs.length != 0) {
            sb.append("(")
                .append(Expression.toArgumentsSequence(initializerArgs))
                .append(")");
        }
        return sb.toString();
    }

    @Override
    public String toPrettyJavaCode() {
        return toJavaCode();
    }

    public static EnumEntry of(String name, Expression... initializerArgs) {
        return new EnumEntry(name, initializerArgs);
    }
}
