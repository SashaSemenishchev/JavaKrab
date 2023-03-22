package me.mrfunny.krab.members;

import me.mrfunny.krab.JavaObject;
import me.mrfunny.krab.Krab;

public abstract class ClassMember<T extends ClassMember<T>>
        extends Accessible<T>
        implements JavaObject, Typeable {

    protected Type type;
    protected Krab source = null;
    public ClassMember(AccessModifier accessModifier, Type typeOf, boolean isFinal, boolean isStatic, String name) {
        super(accessModifier, isFinal, isStatic, name);
        this.type = typeOf;
    }

    public void setSource(Krab source) {
        this.source = source;
    }
}
