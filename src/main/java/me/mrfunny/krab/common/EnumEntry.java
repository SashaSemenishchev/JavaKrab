package me.mrfunny.krab.common;

import me.mrfunny.krab.members.method.body.Expression;

import java.util.Arrays;
import java.util.Iterator;

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
            sb.append("(");
            Iterator<Expression> iterator = Arrays.stream(initializerArgs).iterator();
            while(iterator.hasNext()) {
                sb.append(iterator.next());
                if(iterator.hasNext()) {
                    sb.append(",");
                }
            }
            sb.append(")");
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
