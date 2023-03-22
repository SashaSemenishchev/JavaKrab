package me.mrfunny.krab.members;

public interface Typeable {

    default String getTypeName() {
        return getType().toJavaCode();
    }
    Type getType();
}
