package me.mrfunny.krab.members.method.body.possibilities;

import me.mrfunny.krab.members.common.Type;

public interface Typeable {

    default String getTypeName() {
        return getType().toJavaCode();
    }
    Type getType();
}
