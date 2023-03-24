package me.mrfunny.krab.members.common;

public class UserType extends Type {
    private final String type;

    UserType(String type) {
        this.type = type;
    }

    @Override
    public String toJavaCode() {
        return type;
    }
}
