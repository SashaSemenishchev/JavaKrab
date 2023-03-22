package me.mrfunny.krab.members;

import me.mrfunny.krab.JavaObject;
import me.mrfunny.krab.members.common.UserType;

public interface Type extends JavaObject {
    static Type of(Class<?> clazz) {
        return UserType.of(clazz.getName());
    }

    static Type of(String name) {
        return UserType.of(name);
    }
}
