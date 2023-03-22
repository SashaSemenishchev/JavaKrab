package me.mrfunny.krab.members.common;

import me.mrfunny.krab.members.Type;

public class UserType implements Type {
    private final String type;

    protected UserType(String type) {
        this.type = type;
    }

    @Override
    public String toJavaCode() {
        return type;
    }

    public static UserType of(String type) {
        return new UserType(type);
    }
}
