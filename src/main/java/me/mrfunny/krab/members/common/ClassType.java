package me.mrfunny.krab.members.common;

public class ClassType extends UserType {
    ClassType(Class<?> type) {
        super(type.getName());
    }
}
